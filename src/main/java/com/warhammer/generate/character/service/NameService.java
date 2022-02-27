package com.warhammer.generate.character.service;

import com.warhammer.generate.character.model.description.Gender;
import com.warhammer.generate.character.model.description.Race;
import com.warhammer.generate.character.model.name.*;
import com.warhammer.generate.character.repository.hero.name.NameConnectorRepository;
import com.warhammer.generate.character.repository.hero.name.NameRepository;
import com.warhammer.generate.character.repository.hero.name.NicknameRepository;
import com.warhammer.generate.character.repository.hero.name.SecondPartOfNameRepository;
import com.warhammer.generate.character.utils.mechanics.MechanicsUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NameService {
    private static final String DVARF_MALE_NICKNAME_END = "son";
    private static final String DVARF_FEMALE_NICKNAME_END = "dotr";

    private final NameRepository nameRepository;
    private final NicknameRepository nicknameRepository;
    private final SecondPartOfNameRepository secondPartOfNameRepository;
    private final NameConnectorRepository nameConnectorRepository;

    public NameService(
            NameRepository nameRepository,
            NicknameRepository nicknameRepository
            , SecondPartOfNameRepository secondPartOfNameRepository,
            NameConnectorRepository nameConnectorRepository
    ) {
        this.nameRepository = nameRepository;
        this.nicknameRepository = nicknameRepository;
        this.secondPartOfNameRepository = secondPartOfNameRepository;
        this.nameConnectorRepository = nameConnectorRepository;
    }

    public FullName generateName(Race race, Gender gender) {
        Iterable<Name> allNames = nameRepository.findAll();
        Iterable<Nickname> allNicknames = nicknameRepository.findAll();
        Iterable<SecondPartOfName> secondPartOfName = secondPartOfNameRepository.findAll();

        List<Name> filteredNames = getNamesByUserChoice(allNames, gender, race);
        List<Nickname> filteredNicknames = getNicknamesByUserChoice(allNicknames, race);
        List<SecondPartOfName> secondNamePartsForNonHuman = getSecondNamePartsForNonHuman(secondPartOfName, gender, race);

        int drawName = MechanicsUtils.drawFromFiltered(filteredNames);
        int drawNickname = MechanicsUtils.drawFromFiltered(filteredNicknames);

        Name name = filteredNames.get(drawName);
        Nickname nickname = filteredNicknames.get(drawNickname);
        FullName fullName = new FullName(name.getName(), nickname.getNickname(), null);

        if (race != Race.HUMAN) {
            int drawSecondNamePart = MechanicsUtils.drawFromFiltered(secondNamePartsForNonHuman);
            SecondPartOfName name2ndPart = secondNamePartsForNonHuman.get(drawSecondNamePart);
            fullName = createNonHumanName(name, nickname, name2ndPart, race, gender);
        }

        return fullName;
    }

    private FullName createNonHumanName(Name name, Nickname nickname, SecondPartOfName name2ndPart, Race race, Gender gender) {
        String secondPartOfTheName = name2ndPart.getName().toLowerCase(Locale.ROOT);
        String nonHumanName = name.getName() + name2ndPart.getName().toLowerCase(Locale.ROOT);
        FullName fullName = new FullName(nonHumanName, nickname.getNickname(), null);

        if (race == Race.ELF) {
            fullName = getElvishName(name.getName(), secondPartOfTheName, nickname.getNickname());
        }

        if (race == Race.DWARF) {
            fullName = generateNicknameForDwarf(nonHumanName, race, gender);
        }

        return fullName;
    }

    private FullName generateNicknameForDwarf(String name, Race race, Gender gender) {
        String finalAncestorName = "";

        Iterable<Name> allNames = nameRepository.findAll();
        Iterable<SecondPartOfName> secondPartOfName = secondPartOfNameRepository.findAll();
        List<Name> filteredAncestorsNames = getNamesByUserChoice(allNames, gender, race);
        List<SecondPartOfName> secondNamePartsAncestors = getSecondNamePartsForNonHuman(secondPartOfName, gender, race);

        int drawNickname = MechanicsUtils.drawFromFiltered(filteredAncestorsNames);
        int drawSecondPart = MechanicsUtils.drawFromFiltered(secondNamePartsAncestors);

        Name ancestorsName = filteredAncestorsNames.get(drawNickname);
        Name ancestorsNamePartTwo = filteredAncestorsNames.get(drawSecondPart);
        String namesEnding = ancestorsNamePartTwo.getName().toLowerCase(Locale.ROOT);

        if (gender == Gender.MALE) {
            finalAncestorName = ancestorsName.getName() + namesEnding + DVARF_MALE_NICKNAME_END;
        } else {
            finalAncestorName = ancestorsName.getName() + namesEnding + DVARF_FEMALE_NICKNAME_END;
        }

        return new FullName(name, finalAncestorName, null);
    }

    private FullName getElvishName(String name, String secondNamePart, String nickname) {
        Iterable<NameConnector> elfConnector = nameConnectorRepository.findAll();
        List<NameConnector> connectors = StreamSupport.stream(elfConnector.spliterator(), false).collect(Collectors.toList());

        int drawConnector = MechanicsUtils.drawFromFiltered(connectors);
        NameConnector connector = connectors.get(drawConnector);

        return new FullName(name + "-" + connector.getConnector() + "-" + secondNamePart, nickname, connector.getConnector());
    }

    private static List<SecondPartOfName> getSecondNamePartsForNonHuman(Iterable<SecondPartOfName> allNames, Gender gender, Race race) {
        return MechanicsUtils.filterData(allNames, name -> isGivenGender(name, gender), name -> isGivenRace(name, race));
    }

    private static List<Nickname> getNicknamesByUserChoice(Iterable<Nickname> allNicknames, Race race) {
        return StreamSupport.stream(allNicknames.spliterator(), false)
                .filter(name -> isGivenRace(name, race))
                .collect(Collectors.toList());
    }

    private static List<Name> getNamesByUserChoice(Iterable<Name> allNames, Gender gender, Race race) {
        if (race == Race.HUMAN) {
            return MechanicsUtils.filterData(allNames, name -> isGivenGender(name, gender), name -> name.getRace() == Race.HUMAN);
        } else {
            return MechanicsUtils.filterData(allNames, name -> isGivenGender(name, Gender.BOTH), name -> isGivenRace(name, race));
        }
    }

    private static boolean isGivenGender(Name name, Gender gender) {
        return gender.getOption() == name.getGender().getOption();
    }

    private static boolean isGivenRace(Name name, Race race) {
        return race == name.getRace();
    }

    private static boolean isGivenGender(SecondPartOfName name2ndPart, Gender gender) {
        return gender.getOption() == name2ndPart.getGender().getOption();
    }

    private static boolean isGivenRace(SecondPartOfName name2ndPart, Race race) {
        return race == name2ndPart.getRace();
    }

    private static boolean isGivenRace(Nickname nickname, Race race) {
        return race == nickname.getRace();
    }

}

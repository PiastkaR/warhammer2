package com.warhammer.generate.character;

import com.warhammer.generate.character.model.characteristics.MainCharacteristics;
import com.warhammer.generate.character.model.profession.Profession;
import com.warhammer.generate.character.repository.name.MainCharacteristicRepository;
import com.warhammer.generate.character.repository.name.ProfessionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class WarhammerApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WarhammerApp.class, args);
        System.out.println("Entering the main");
        ProfessionRepository professionRepository = context.getBean(ProfessionRepository.class);
        MainCharacteristicRepository mainCharacteristicsRepository = context.getBean(MainCharacteristicRepository.class);
        Optional<Profession> profession1 = professionRepository.findById(1L);
        System.out.println("Profession1: " + profession1.get());
        Optional<MainCharacteristics> charById = mainCharacteristicsRepository.findById(1L);
        System.out.println("1l archery skill : " + charById.get().getArcherySkills());
    }
}

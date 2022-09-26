package com.warhammer.generate.character.model.profession;

import com.warhammer.generate.character.model.characteristics.MainCharacteristics;
import com.warhammer.generate.character.model.description.CharacterClass;

import javax.persistence.*;

@Entity
@Table(name = "profession", schema = "public")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String profession;

    @Enumerated(EnumType.STRING)
    private CharacterClass characterClass;

//    @Column(nullable = false)
//    private Set<Race> racesForProfession = new HashSet<>();

    @OneToOne
//    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "main_characteristics_id")
//    @JoinColumn(name = "main_characteristics_id")
    private MainCharacteristics mainCharacteristics;

//    @OneToOne
//    @JoinColumn(unique = true)
//    private SecondaryCharacteristics secondaryCharacteristics;

//    @OneToMany(mappedBy="equipment", fetch = FetchType.EAGER,
//            cascade = { CascadeType.PERSIST, CascadeType.REMOVE  }, orphanRemoval = true)
//    @JoinColumn(name = "mainCharacteristics_id", referencedColumnName = "id_mainCharacteristics") //do relacji 1 kierunkowej!
//    private List<String> equipment = new ArrayList<>();

//    @OneToMany(mappedBy="skill", fetch = FetchType.EAGER,
//            cascade = { CascadeType.PERSIST, CascadeType.REMOVE  }, orphanRemoval = true)
//    @JoinColumn(name = "profession_id", referencedColumnName = "skill_id")
//    private List<String> skills = new ArrayList<>();
//
//    @OneToMany(mappedBy="ability", fetch = FetchType.LAZY,
//            cascade = { CascadeType.PERSIST, CascadeType.REMOVE  }, orphanRemoval = true)
//    @JoinColumn(name = "profession_id", referencedColumnName = "ability_id")
//    private List<String> abilities = new ArrayList<>();

    @Override
    public String toString() {
        return "Profession{" +
                "profession='" + profession + '\'' +
                ", charactersClass=" + characterClass +
                // ", racesProfession=" + racesForProfession +
//                ", mainCharacteristicsDevelopment=" + mainCharacteristics +
//                ", secondaryCharacteristicsDevelopment=" + secondaryCharacteristics +
                //", equipment=" + equipment +
//                ", skills=" + skills +
//                ", abilities=" + abilities +
                '}';
    }

}

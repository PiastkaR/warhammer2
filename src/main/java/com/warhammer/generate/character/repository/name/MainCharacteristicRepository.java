package com.warhammer.generate.character.repository.name;

import com.warhammer.generate.character.model.characteristics.MainCharacteristics;
import org.springframework.data.repository.CrudRepository;

public interface MainCharacteristicRepository extends CrudRepository<MainCharacteristics, Long> {

//    @Override
//    Optional<MainCharacteristics> findById(Long id);
//
//    @Override
//    Iterable<MainCharacteristics> findAll() {
//    };
}

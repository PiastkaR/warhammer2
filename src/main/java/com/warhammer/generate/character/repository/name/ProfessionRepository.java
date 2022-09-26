package com.warhammer.generate.character.repository.name;

import com.warhammer.generate.character.model.profession.Profession;
import org.springframework.data.repository.CrudRepository;

public interface ProfessionRepository extends CrudRepository<Profession, Long> {
}

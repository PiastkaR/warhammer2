package com.warhammer.generate.character.repository.hero.name;

import com.warhammer.generate.character.model.name.Name;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {

}

package com.warhammer.generate.character.repository.hero.name;

import com.warhammer.generate.character.model.name.NameConnector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameConnectorRepository extends CrudRepository<NameConnector,Long> {
}

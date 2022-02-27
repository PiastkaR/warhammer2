package com.warhammer.generate.character.repository.hero.name;

import com.warhammer.generate.character.model.name.Nickname;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NicknameRepository extends CrudRepository<Nickname, Long> {
}

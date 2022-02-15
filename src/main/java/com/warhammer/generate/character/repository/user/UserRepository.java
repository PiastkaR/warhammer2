package com.warhammer.generate.character.repository.user;

import com.warhammer.generate.character.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
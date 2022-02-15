package com.warhammer.generate.character.repository.user;

import com.warhammer.generate.character.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}
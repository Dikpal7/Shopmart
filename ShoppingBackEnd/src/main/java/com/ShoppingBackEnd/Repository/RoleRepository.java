package com.ShoppingBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.Role;
import com.ShoppingBackEnd.Model.RoleName;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleName roleName);
}

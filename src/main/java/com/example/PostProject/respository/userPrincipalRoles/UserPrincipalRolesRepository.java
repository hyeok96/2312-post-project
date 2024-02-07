package com.example.PostProject.respository.userPrincipalRoles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrincipalRolesRepository extends JpaRepository<UserPrincipalRolesEntity, Integer> {
}

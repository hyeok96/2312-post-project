package com.example.PostProject.respository.userPrincipal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPrincipalRepository extends JpaRepository<UserPrincipalEntity, Integer> {

    @Query("SELECT up FROM UserPrincipalEntity up JOIN FETCH up.userPrincipalRoles upr JOIN FETCH upr.rolesEntity WHERE up.email = :email")
    Optional<UserPrincipalEntity> findByEmailFetchJoin(String email);

    boolean existsByEmail(String email);
}

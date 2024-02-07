package com.example.PostProject.respository.userPrincipalRoles;

import com.example.PostProject.respository.roles.RolesEntity;
import com.example.PostProject.respository.userPrincipal.UserPrincipalEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_principal_roles")
public class UserPrincipalRolesEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_principal_role_id")
    private Integer userPrincipalRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_principal_id")
    private UserPrincipalEntity userPrincipalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RolesEntity rolesEntity;
}

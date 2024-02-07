package com.example.PostProject.service.security;

import com.example.PostProject.config.security.JwtProvider;
import com.example.PostProject.respository.roles.RolesEntity;
import com.example.PostProject.respository.roles.RolesRepository;
import com.example.PostProject.respository.user.UserEntity;
import com.example.PostProject.respository.user.UserRepository;
import com.example.PostProject.respository.userPrincipal.UserPrincipalEntity;
import com.example.PostProject.respository.userPrincipal.UserPrincipalRepository;
import com.example.PostProject.respository.userPrincipalRoles.UserPrincipalRolesEntity;
import com.example.PostProject.respository.userPrincipalRoles.UserPrincipalRolesRepository;
import com.example.PostProject.service.exceptions.NotFoundException;
import com.example.PostProject.web.dto.auth.Login;
import com.example.PostProject.web.dto.auth.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserPrincipalRepository userPrincipalRepository;
    private final UserPrincipalRolesRepository userPrincipalRolesRepository;
    private final RolesRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Transactional(value = "tm")
    public boolean signUp (SignUp sighUpRequest) {
        String email = sighUpRequest.getEmail();
        String password = sighUpRequest.getPassword();
        String username = sighUpRequest.getName();

        if (userPrincipalRepository.existsByEmail(email)) {
            return false;
        }

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseGet(() -> userRepository.save(UserEntity.builder().username(username).build()));

        RolesEntity roles = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new NotFoundException("ROLE_USER를 찾을 수가 없습니다."));

        UserPrincipalEntity userPrincipalEntity = UserPrincipalEntity.builder()
                .email(email)
                .userEntity(userEntity)
                .password(passwordEncoder.encode(password))
                .build();

        userPrincipalRepository.save(userPrincipalEntity);
        userPrincipalRolesRepository.save(
                UserPrincipalRolesEntity.builder()
                        .userPrincipalEntity(userPrincipalEntity)
                        .rolesEntity(roles)
                        .build()
        );

        return true;
    }

    public String login(Login loginRequest) {
        try {
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(auth);

            UserPrincipalEntity userPrincipalEntity = userPrincipalRepository.findByEmailFetchJoin(email)
                    .orElseThrow(() -> new NotFoundException("UserPrincipal을 찾을 수 없습니다."));

            List<String> roles = userPrincipalEntity.getUserPrincipalRoles()
                    .stream().map(UserPrincipalRolesEntity::getRolesEntity).map(RolesEntity::getName).collect(Collectors.toList());

            return jwtProvider.createToken(email, roles);

        } catch (Exception e) {
            throw new NotFoundException("로그인 할 수 없습니다");
        }
    }



}

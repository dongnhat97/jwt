package com.example.demo;

import com.example.demo.entity.AccessToken;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    private final  JwtProvider jwtProvider;

    public AccessToken signinAdmin(LoginRequest loginRequest) throws Exception {
        User user = this.getUserByEmail(loginRequest.getEmail()).orElseThrow(() ->
                new NotFoundException(NotFoundException.ERROR_USER_NOT_FOUND, APIConstants.NOT_FOUND_MESSAGE.replace(APIConstants.REPLACE_CHAR, APIConstants.USER)));

        Authentication authentication = new UsernamePasswordAuthenticationToken(new UserPrincipal().create(user, getAuthorities(user)), null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.createAccessToken(authentication, true, true);
    }

    public Optional<User> getUserByEmail(String email) throws NotFoundException {
        Optional<User> user = this.userRepository.findFirstByEmail(email);
        if (user.isPresent() &&  user.get().getRoles().stream()
                .anyMatch(t -> t.getName().equals("SUPER_ADMIN"))) {
            return user;
        }
        return Optional.empty();
    }

    public static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map(Role::getName)
                .toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
}

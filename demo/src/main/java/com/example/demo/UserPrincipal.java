package com.example.demo;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User details.
 */
@Getter
@NoArgsConstructor
public class UserPrincipal implements UserDetails {

    private Integer userId;
    private String name;
    @JsonIgnore
    private String password;
    //	private String langKey;
    private boolean tfaChecked;
    private List<Role> roles;
    private UserEnum.Status status;
    private Collection<? extends GrantedAuthority> authorities;
    private String publicAddress;
    private boolean viewPrivateProduct;

    public UserPrincipal(Integer id, String password,
                         UserEnum.Status status, List<Role> roles, Collection<? extends GrantedAuthority> authorities,
                         String publicAddress, boolean viewPrivateProduct) {
        this.userId = id;
//        this.name = name;
//		this.langKey = langKey;
        this.password = password;
        this.status = status;
        this.roles = roles;
        this.authorities = authorities;
        this.publicAddress = publicAddress;
        this.viewPrivateProduct = viewPrivateProduct;
    }

    public static UserPrincipal create(User user, Collection<? extends GrantedAuthority> authorities) throws UsernameNotFoundException, Exception {
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("The user is empty");
        }

        return new UserPrincipal(user.getId(), user.getPassword(), user.getStatus(), user.getRoles(), authorities,
                user.getPublicAddress(), user.isViewPrivateProduct());
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        return UserEnum.Status.ACTIVED.equals(status);
    }
}

package com.example.demo.entity;

import com.example.demo.UserEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(columnDefinition = "text")
    @Email
    private String email;

    @Column(columnDefinition = "text")
    @Size(min = 6)
    private String password;

    @Column(nullable = false)
    @NotEmpty
    private String publicAddress;

    private Integer nonce;

    @Column(columnDefinition = "text")
    private String authenMetamask;

    @Enumerated(value = EnumType.STRING)
    private UserEnum.Status status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

    @Column(columnDefinition = "text")
    private String resetToken;

    @Column(name = "expired_time")
    @CreationTimestamp
    private LocalDateTime expiredTime;

    private boolean viewPrivateProduct;

    /** SyTV added this field */
    @Column(name ="information_required_flg")
    private boolean informationRequiredFlg;

    private Integer type;
}
package com.example.individualprojectspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq",allocationSize = 1)
    @GeneratedValue(generator="user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;


    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="password", nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return true;
    }
}

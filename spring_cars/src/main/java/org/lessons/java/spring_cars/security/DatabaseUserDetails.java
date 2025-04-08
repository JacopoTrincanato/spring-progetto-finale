package org.lessons.java.spring_cars.security;

import java.util.HashSet;
import java.util.Set;

import org.lessons.java.spring_cars.models.Role;
import org.lessons.java.spring_cars.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

    // variabili d'istanza
    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    // costruttore
    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = new HashSet<GrantedAuthority>();

        // prendo i ruoli e aggiungo loro un grado di autorità
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
    }

    // metodi
    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

}

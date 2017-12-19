package com.jwt.ex.service;

import static java.util.Collections.emptyList;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwt.ex.repo.AppUserRepo;
import com.jwt.ex.user.AppUser;

public class UserDetailServiceImpl implements UserDetailsService {
	private AppUserRepo appUserRepo;

    public UserDetailServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser applicationUser = appUserRepo.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUser(), applicationUser.getPassword(), (Collection<? extends GrantedAuthority>) emptyList());
    }
}

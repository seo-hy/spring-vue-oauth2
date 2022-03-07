package com.springvueoauth2.server.security;

import com.springvueoauth2.server.model.User;
import com.springvueoauth2.server.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByLoginId(username).get();
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), getAuthorities(user.getRole().getKey()));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
    return Arrays.asList(new SimpleGrantedAuthority(role));
  }

}

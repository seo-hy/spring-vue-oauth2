package com.springvueoauth2.server.service;

import com.springvueoauth2.server.model.Role;
import com.springvueoauth2.server.model.User;
import com.springvueoauth2.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public Long addUser(User user) {

    user.setRole(Role.USER);
    return userRepository.save(user).getId();

  }

  @Transactional
  public Long addAdmin(User user) {

    user.setRole(Role.ADMIN);
    return userRepository.save(user).getId();

  }
}

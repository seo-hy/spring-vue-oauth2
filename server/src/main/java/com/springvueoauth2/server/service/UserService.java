package com.springvueoauth2.server.service;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.formmapper.UserFormMapper;
import com.springvueoauth2.server.model.Role;
import com.springvueoauth2.server.model.User;
import com.springvueoauth2.server.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserFormMapper formMapper;

  @Transactional
  public Long addUser(UserForm.Input.Add in) {
    User user = formMapper.toUser(in);
    user.setRole(Role.USER);
    return userRepository.save(user).getId();
  }

  @Transactional
  public Long addAdmin(User user) {
    user.setRole(Role.ADMIN);
    return userRepository.save(user).getId();
  }

  @Transactional(readOnly = true)
  public List<User> getAll() {
    return userRepository.findAll();
  }
}

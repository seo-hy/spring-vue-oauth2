package com.springvueoauth2.server.service;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.formmapper.UserFormMapper;
import com.springvueoauth2.server.mapper.UserMapper;
import com.springvueoauth2.server.model.Role;
import com.springvueoauth2.server.model.User;
import com.springvueoauth2.server.repository.UserRepository;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserFormMapper formMapper;
  private final UserMapper mapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Long addUser(UserForm.Input.Add in) {

    if (userRepository.findByLoginId(in.getLoginId()).isPresent()) {
      throw new IllegalStateException("중복된 아이디가 존재합니다.");
    }
    User user = formMapper.toUser(in);
    user.setRole(Role.USER);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user).getId();
  }

  @Transactional
  public Long addAdmin(UserForm.Input.Add in) {

    if (userRepository.findByLoginId(in.getLoginId()).isPresent()) {
      throw new IllegalStateException("중복된 아이디가 존재합니다.");
    }

    User user = formMapper.toUser(in);
    user.setRole(Role.ADMIN);
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user).getId();
  }

  @Transactional(readOnly = true)
  public List<UserForm.Output.Get> getAll() {
    return formMapper.toGetList(userRepository.findAll());
  }

  @Transactional(readOnly = true)
  public UserForm.Output.Get getMe(Principal principal) {
    return formMapper.toGet(userRepository.findByLoginId(principal.getName()).get());
  }

  @Transactional
  public UserForm.Output.Get modify(Long userId, UserForm.Input.Modify in) {
    User orgUser = userRepository.getById(userId);
    if (!in.getPassword().isEmpty()) {
      in.setPassword(passwordEncoder.encode(in.getPassword()));
    }
    User out = mapper.modify(in, orgUser);

    return formMapper.toGet(out);
  }
}

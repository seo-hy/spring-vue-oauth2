package com.springvueoauth2.server.mapper;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.model.User;
import org.mapstruct.Mapper;

@Mapper
public abstract class UserMapper {

  public User modify(UserForm.Input.Modify in, User out) {
    if (in == null) {
      return null;
    }

    if (!in.getName().isEmpty()) {
      out.setName(in.getName());
    }
    if (!in.getPassword().isEmpty()) {
      out.setPassword(in.getPassword());
    }

    out.setPhone(in.getPhone());

    return out;
  }
}

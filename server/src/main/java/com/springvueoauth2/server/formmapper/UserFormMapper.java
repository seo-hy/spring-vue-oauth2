package com.springvueoauth2.server.formmapper;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.model.User;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    implementationName = "UserFormMapperImpl"
)
public interface UserFormMapper {

  public abstract User toUser(UserForm.Input.Add in);

  public abstract List<UserForm.Output.GetAll> toGetAll(List<User> in);

}

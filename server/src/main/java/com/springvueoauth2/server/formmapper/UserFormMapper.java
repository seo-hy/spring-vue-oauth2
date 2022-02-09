package com.springvueoauth2.server.formmapper;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.model.User;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    implementationName = "UserFormMapperImpl",
    builder = @Builder(disableBuilder = true)
)
public interface UserFormMapper {

  User toUser(UserForm.Input.Add in);

  List<UserForm.Output.GetAll> toGetAll(List<User> in);

}

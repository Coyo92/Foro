package com.ForoHub.Foro.Api.Domain.Users.Validations;

import com.ForoHub.Foro.Api.Domain.Users.UserData;

public interface InterfValidateUsers {

    public void validateNewUser(UserData userData);
    public void validateUser(UserData userData);
}

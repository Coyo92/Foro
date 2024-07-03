package com.ForoHub.Foro.Api.Domain.Users;

public record ListUserData(
        int iduser,
        String nombre) {

    public ListUserData(UserApi userApi) {
        this (
                userApi.getIduser ( ) ,
                userApi.getNombre ( )
        );
    }
}
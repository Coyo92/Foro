package com.ForoHub.Foro.Api.Infaestructure.Errors;

public class IntegrityValidation extends RuntimeException {

    public IntegrityValidation(String s) {
        super(s);
    }
}

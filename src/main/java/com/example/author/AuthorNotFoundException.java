package com.example.exception;

import javax.persistence.NoResultException;

public class AuthorNotFoundException extends NoResultException {

    public AuthorNotFoundException(Long id) {
        super("Could not find author " + id);
    }

}

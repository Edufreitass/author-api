package com.example.exceptions;

import javax.persistence.NoResultException;

public class AuthorNotFoundException extends NoResultException {

    AuthorNotFoundException(Long id) {
        super("Could not find author " + id);
    }

}

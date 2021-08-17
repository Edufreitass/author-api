package com.example.author;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AuthorTest {

    private static final String AUTHOR_NAME = "Eduardo Freitas";
    private static final String AUTHOR_EMAIL = "eduardo@email.com";
    private static final String AUTHOR_FACEBOOK = "https://www.facebook.com/eduardoteste";
    private static final String AUTHOR_LINKEDIN = "https://www.linkedin.com/in/eduardo-teste-00000000";
    private static final String AUTHOR_TWITTER = "https://twitter.com/eduardot";
    private static final String AUTHOR_SUMMARY = "Summary";

    @Test
    public void emptyConstructor() {
        Assertions.assertDoesNotThrow(Author::new);
    }

    @Test
    public void createNewAuthorByBuilder() {
        var author = Author.builder(AUTHOR_NAME, AUTHOR_EMAIL)
                .faceBook(AUTHOR_FACEBOOK)
                .linkedIn(AUTHOR_LINKEDIN)
                .twitter(AUTHOR_TWITTER)
                .summary(AUTHOR_SUMMARY)
                .build();
        Assertions.assertNull(author.getId());
        Assertions.assertEquals(AUTHOR_NAME, author.getName());
        Assertions.assertEquals(AUTHOR_EMAIL, author.getEmail());
        Assertions.assertEquals(AUTHOR_FACEBOOK, author.getFaceBook());
        Assertions.assertEquals(AUTHOR_LINKEDIN, author.getLinkedIn());
        Assertions.assertEquals(AUTHOR_TWITTER, author.getTwitter());
        Assertions.assertEquals(AUTHOR_SUMMARY, author.getSummary());
    }

    @Test
    public void uniqueByNameAndEmail() {
        var author1 = Author.builder(AUTHOR_NAME, AUTHOR_EMAIL).build();
        var author2 = Author.builder(AUTHOR_NAME, AUTHOR_EMAIL).build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Set.of(author1, author2));
    }

}
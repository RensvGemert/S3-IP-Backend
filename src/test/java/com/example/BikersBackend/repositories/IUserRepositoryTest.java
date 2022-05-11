package com.example.BikersBackend.repositories;

import com.example.BikersBackend.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class IUserRepositoryTest {

    @Autowired
    private IUserRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfUserEmailExists() {
        // given
        String email = "user1@gmail.com";

        User user = new User("user1", email, "password");
        underTest.save(user);

        // when
        boolean result = underTest.selectExistsEmail(email);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void itShouldCheckIfUserEmailNonExisting() {
        // given
        String email = "user1@gmail.com";

        // when
        boolean result = underTest.selectExistsEmail(email);

        // then
        assertThat(result).isFalse();
    }

}
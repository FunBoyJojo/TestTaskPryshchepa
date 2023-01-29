package com.example.TestTaskPryshchepa.services;

import com.example.TestTaskPryshchepa.models.User;
import com.example.TestTaskPryshchepa.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @CsvSource({"1,Oleh,Pryshchepa,22",
            "2,Alex,Pryshchepa,27",
            "3,Max,Pryshchepa,52"})
    void userServiceShouldReturnUserWithId(Long id , String name, String surname, byte age) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);

        User userByID = userService.getUserByID(id);

        assertThat(userByID).isEqualTo(user);
    }
    @Test
    void userServiceShouldReturnExeptionUserWithId(){

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    userService.getUserByID(4L);
                }).withMessageMatching("User with id \\d+ not found");

    }
}
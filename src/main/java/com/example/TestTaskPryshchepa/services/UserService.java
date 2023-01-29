package com.example.TestTaskPryshchepa.services;

import com.example.TestTaskPryshchepa.models.User;
import com.example.TestTaskPryshchepa.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param id is the value of user you need
     * @return user by id or throw InternalException
     */
    public User getUserByID(Long id){

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new IllegalStateException("User with id "+ id + " not found");
        }

        optionalUser.get().setAge(calculateAge(optionalUser.get().getBirthday()));
        return optionalUser.get();
    }
    private byte calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();

        if ((birthDate != null)) {
            return (byte) Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

}


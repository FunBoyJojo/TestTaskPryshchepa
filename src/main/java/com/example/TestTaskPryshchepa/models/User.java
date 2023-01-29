package com.example.TestTaskPryshchepa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @JsonIgnore
    private LocalDate birthday;
    @JsonInclude()
    @Transient
    private byte age;

    public User(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof User other)){
            return false;
        }
        return id.equals(other.id) && name.equals(other.name) && surname.equals(other.surname) && age == other.age;
    }

    @Override
    public int hashCode() {
        return name.length() + surname.length() + birthday.hashCode() + age;
    }
}



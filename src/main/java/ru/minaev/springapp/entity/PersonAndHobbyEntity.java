package ru.minaev.springapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "hobbies_of_person")
public class PersonAndHobbyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @NonNull
    String name;

    @NonNull
    int age;

    @NonNull
    String hobby;

    @NonNull
    boolean state = false;


    public static PersonAndHobbyEntity makeDefault (String name, int age, String hobby) {
        return builder()
                .name(name)
                .age(age)
                .hobby(hobby)
                .build();
    }

}

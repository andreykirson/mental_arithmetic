package com.example.mental_arithmetic.user;

import lombok.*;
/**
 * Stores information to identify the user.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private Long id;
    private String alias;
}

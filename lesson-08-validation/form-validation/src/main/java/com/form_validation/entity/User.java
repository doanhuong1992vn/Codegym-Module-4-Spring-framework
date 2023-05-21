package com.form_validation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank(message = "{notBlank}")
    @Size(min = 2, max = 15, message = "{sizeName}")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{patternName}")
    private String firstName;
    @NotBlank(message = "{notBlank}")
    @Size(min = 2, max = 15, message = "{sizeName}")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{patternName}")
    private String lastName;
    @NotBlank(message = "{notBlank}")
    @Size(min = 10, max = 11)
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$")
    private String phoneNumber;
    @NotNull(message = "{notBlank}")
    @Range(min = 18, max = 110)
    private int age;
    @NotBlank(message = "{notBlank}")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}

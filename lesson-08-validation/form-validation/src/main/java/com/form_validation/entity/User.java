package com.form_validation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank(message = "{NotBlank.user}")
    @Size(min = 2, max = 20, message = "{Size.user.name}")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{Pattern.user.name}")
    private String firstName;
    @NotBlank(message = "{NotBlank.user}")
    @Size(min = 2, max = 20, message = "{Size.user.name}")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "{Pattern.user.name}")
    private String lastName;
    @NotBlank(message = "{NotBlank.user}")
    @Size(min = 10, max = 11)
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$")
    private String phoneNumber;
    @NotNull(message = "{NotBlank.user}")
    @Range(min = 18, max = 110)
    private int age;
    @NotBlank(message = "{NotBlank.user}")
    @Email(message = "{Pattern.user.email}")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}

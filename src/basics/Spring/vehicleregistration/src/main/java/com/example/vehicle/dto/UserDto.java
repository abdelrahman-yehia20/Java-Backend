package com.example.vehicle.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Pattern(
            regexp = "^[0-9]{14}$",
            message = "National ID must be 14 digits"
    )
    private String nationalId;

    @Email(message = "Invalid email")
    private String email;
}

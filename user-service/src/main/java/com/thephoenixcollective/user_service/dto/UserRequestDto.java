    package com.thephoenixcollective.user_service.dto;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Pattern;
    import jakarta.validation.constraints.Size;
    import lombok.*;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserRequestDto {

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100)
        private String name;

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^[+]?[0-9]{10,15}$")
        private String phoneNumber;

        @NotBlank(message = "UserName is required")
        private String userName;

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 10)
        private String password;

        @NotBlank(message = "Role is required")
        private String role;

        private String email;
    }

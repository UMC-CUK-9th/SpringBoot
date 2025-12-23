package com.example.umc9th.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;

@Builder
public class UserReqDTO {

    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String userPassword
    ){}

    public record JoinDTO(
            @NotBlank
            String name,

            @Email
            String email,

            @NotBlank
            String password,

            @NotNull
            LocalDate birth,

            @NotNull
            RabbitConnectionDetails.Address address,

            @NotNull
            String specAddress,

            @NotBlank
            String nickname,

            @NotBlank
            String phoneNumber
    ) {}
}


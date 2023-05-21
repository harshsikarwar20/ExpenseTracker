package com.example.ExpenseTracker.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @Email
    @Column(name = "user_email")
    private String userEmail;
    @NotNull
    @Column(name = "user_password")
    private String userPassword;
}

/*
    {
        "userName":"",
        "userEmail":"",
        "userPassword":
    }
 */
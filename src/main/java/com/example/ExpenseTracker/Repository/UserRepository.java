package com.example.ExpenseTracker.Repository;

import com.example.ExpenseTracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByUserName(String userName);
}
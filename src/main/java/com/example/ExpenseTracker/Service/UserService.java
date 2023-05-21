package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Model.Product;
import com.example.ExpenseTracker.Model.User;
import com.example.ExpenseTracker.Repository.ProductRepository;
import com.example.ExpenseTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    static List<User> loggedInUsers = new ArrayList<>();
    @Autowired
    UserRepository repository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    public User signIn(User user) {
        return repository.save(user);
    }

    public String logIn(String userName, String userPassword) {
        List<User> userList = repository.findAllByUserName(userName);
        if(userList.isEmpty()){
            return "User Doesn't exist!";
        }else{
            for (User user : userList){
                if(user.getUserPassword().equals(userPassword)) {
                    loggedInUsers.add(user);
                    return "User with Username:" + userName + " login success!";
                }
            }
            return "Please Enter correct password";
        }
    }

    public String deleteUser(Integer userId) {
        String response = null;
        if(repository.findById(userId).isPresent()){
            List<Product> products = productService.getProducts(userId);
            for (Product product : products)
                productRepository.delete(product);
            response = "User with username " + repository.findById(userId).get().getUserName();
            repository.deleteById(userId);
        }
        return response;
    }

    public List<User> getUser(Integer userId) {
        List<User> response = new ArrayList<>();
        if(userId == null){
            response = repository.findAll();
        }else{
            if(repository.findById(userId).isPresent()){
                User user = repository.findById(userId).get();
                response.add(user);
            }
        }
        return response;
    }
}
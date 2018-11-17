package com.example.demo.controller;

import com.example.demo.entities.Loginmodel;
import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class api {
    @Autowired
    UserRepository userRepository;
@RequestMapping("/restuser/{id}")
    public User restuser(@PathVariable("id") int id){
    User user = userRepository.findOne(id);
    return user;

    }
@RequestMapping("/restuserpost")
    public User login(@ModelAttribute("modlatr") Loginmodel loginmodel, ModelMap modelMap){
        User user = userRepository.findByEmail(loginmodel.getEmail());
        if(user.getPassword().equals(loginmodel.getPassword())){
            return user;
        }
        else
        return null;

    }
}

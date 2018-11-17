package com.example.demo.controller;

import com.example.demo.entities.Loginmodel;
import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/showReg")
    public String showResgistrationPage(){
        return "login/registration";
    }

    @RequestMapping(value = "/registerUser",method =RequestMethod.POST)
    public String register(@ModelAttribute("user")User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()) );
        userRepository.save(user);
        return "login/login";

    }


    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("Email") String Email, @RequestParam("Password") String Password, ModelMap modelMap){
        User user = userRepository.findByEmail(Email);
        if(user.getPassword().equals(Password)){
            return "findFlights";
        }
        else {
            modelMap.addAttribute("msg","Invalid Password,try again");

        }
        return "login/login";
    }
    */



   /*

   @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute ("modlatr") Loginmodel loginmodel,ModelMap modelMap){

        User user = userRepository.findByEmail(loginmodel.getEmail());

        if(user.getPassword().equals(loginmodel.getPassword())){
            return "findFlights";
        }
         else {
            modelMap.addAttribute("msg","Invalid Password,try again");

        }
        return "login/login";

    }
*/



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute ("modlatr") Loginmodel loginmodel,ModelMap modelMap){

        boolean loginResponse = securityService.login(loginmodel.getEmail(), loginmodel.getPassword());
        if(loginResponse){
            return "findFlights";
        }
        else {
            modelMap.addAttribute("msg","Invalid Username or Password");
        }
        return "login/login";


       /* User user ;

        if(userRepository.findByEmail(loginmodel.getEmail())!=null) {
            user = userRepository.findByEmail(loginmodel.getEmail());
            if (user.getPassword().equals(loginmodel.getPassword())) {
                return "findFlights";
            } else {
                modelMap.addAttribute("msg", "Invalid Password,try again");

            }
            return "login/login";
        }
        modelMap.addAttribute("msg", "Invalid Password,try again");
        return "login/login";*/
    }



    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }
}

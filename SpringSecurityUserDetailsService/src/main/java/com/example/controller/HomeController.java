package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/vocab",method = RequestMethod.GET)
    public ModelAndView vocab(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/vocab");
        return modelAndView;
    }

    @GetMapping(value = "/findbyname/{email}")
    @ResponseBody
    public User findbyname(@PathVariable("email") String email){
        User user = userService.findUserByEmail(email);
        return user;
    }

    @GetMapping(value = "addnewrole/{rolename}")
    @ResponseBody
    public void addrole(@PathVariable("rolename") String rolename){
        userService.saveRole(new Role(rolename));
    }

    @GetMapping(value = "/text",produces = "text/plain")
    @ResponseBody
    public String text(){
        return "Done!";
    }
}

package com.upwardiq.guna.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upwardiq.guna.Entity.User;
import com.upwardiq.guna.Service.UserService;
import com.upwardiq.guna.Service.VoteService;
import com.upwardiq.guna.dto.LoginDto;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

	@Autowired
    private UserService service;
    @Autowired
    private VoteService voteservice;

    @GetMapping("/home")
    public String getHomepage() {
    	
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registerpage";
    }
    
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String, String>> registerUser(@ModelAttribute User user) {
        Map<String, String> response = new HashMap<>();
        try {
            // Save the user (implement your saving logic here)
            service.saveUser(user);
            response.put("status", "success");
        } catch (Exception e) {
            response.put("status", "failure");
        }
        return ResponseEntity.ok(response);  // Return the response as JSON
    }

    @GetMapping("/getLoginpage")
    public String getLoginPage() {
        return "Loginform";
    }
    
    @PostMapping("/login")
    @ResponseBody
    public String checkLoginDetails(@RequestParam String userid, @RequestParam String password, HttpSession session) {
    	Optional<User> userOptional = service.checkUserDetailsByUseridandPassword(new LoginDto(userid, password));
        System.out.println("===========================================================================================");
        if (userOptional.isPresent()) {
            session.setAttribute("isLoggedIn",true); // Corrected to true for logged-in state
            session.setAttribute("loggedInUserId", userOptional.get().getId());
            System.out.println("hi from if ");
            return "loggedIn";
        } else {
            System.out.println("byee from else ");
            return "notloggedIn";
        }
    }
    @GetMapping("/logout")
    public String  logoutmyac(HttpSession session) {
    	session.removeAttribute("isLoggedIn");
    	return "redirect:/";
    }

   
}


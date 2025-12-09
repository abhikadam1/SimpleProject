package com.example.SimpleProject.Controller;

import com.example.SimpleProject.Model.User;
import com.example.SimpleProject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Dependency Injection for Repository and PasswordEncoder
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Handler to display the custom login form (accessible by all users via SecurityConfig)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Handler to display the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Pass a new empty User object to the Thymeleaf form for binding
        model.addAttribute("user", new User());
        return "registration";
    }

    // Handler to process the registration form submission (Sign Up)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String email = user.getEmail();
            String password = user.getPassword();
            System.out.println(firstName + " " + lastName + " " + email + " " + password + " These are details ");

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                model.addAttribute("error", "Please fill all the fields");
                return "registration";
            }

            if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank()) {
                model.addAttribute("error", "Some fields are blank");
                return "registration";
            }

            // 1. Check if user already exists
            if (userRepository.findByEmail(email).isPresent()) {
                model.addAttribute("error", "Email already registered!");
                return "registration"; // Go back to the registration page with an error
            }

            int passLength = password.length();
            if (passLength < 6) {
                model.addAttribute("error", "Password must be at least 6 characters!");
                return "registration";
            }

            // 2. Encode the password before saving!
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // 3. Set default role
            user.setRole("ROLE_USER");

            // 4. Save the user
            userRepository.save(user);

            // 5. Redirect to the login page with a success message flag
            return "redirect:/login?success";
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            model.addAttribute("error", e.getMessage());
            // Optional: Re-add the user object so form fields aren't completely blank
            model.addAttribute("user", user);
            return "registration";
        }
    }
}
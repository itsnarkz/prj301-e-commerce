package com.Shopping.ShoppingApplication.Controller;

import com.Shopping.ShoppingApplication.Model.DTO.UserDTO;
import com.Shopping.ShoppingApplication.Model.Entity.User;
import com.Shopping.ShoppingApplication.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute("user") == null) return "redirect:/login";
        else return "redirect:/home";
    }

    @GetMapping("/login")
    public String getLogin(HttpSession session) {
        if(session.getAttribute("user") == null) return "login";
        else return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
        String message = userService.login(username, password);
        if(message == null) {
            session.setAttribute("user", userService.getUserByUsername(username));
            return "redirect:/home";
        } else {
            model.addAttribute("error", message);
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(HttpSession session) {
        if(session.getAttribute("user") == null) return "register";
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String dob,
            @RequestParam(required = false) String verifyPassword,
            Model model,
            HttpSession session
    ) {
        session.setAttribute("username", username);
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);
        session.setAttribute("address", address);
        session.setAttribute("dob", dob);


        if(!password.equals(verifyPassword)) {
            model.addAttribute("message", "Password does not match!");
            return "register";
        }

        String message = userService.registerNewUser(username, password, name, email, phone, sex, address, dob);
        if(message == null) {
            session.setAttribute("user", userService.getUserByUsername(username));
            return "redirect:/home";
        }
        else {
            model.addAttribute("message", message);
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String dob,
            Model model,
            HttpSession session
    ) {
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);
        session.setAttribute("address", address);
        session.setAttribute("dob", dob);

        String message = userService.updateUser((UserDTO) session.getAttribute("user"), name, email, phone, sex, address, dob);
        if(message != null) model.addAttribute("message", message);
        else model.addAttribute("success", "Update User successfully");

        session.setAttribute("user", userService.getUserByUsername(((UserDTO) session.getAttribute("user")).getUsername()));

        return "updateUser";
    }

    @GetMapping("/update")
    public String getUpdate(HttpSession session) {
        if(session.getAttribute("user") == null) return "redirect:/";

        UserDTO cur = (UserDTO) session.getAttribute("user");
        session.setAttribute("name", cur.getName());
        session.setAttribute("email", cur.getEmail());
        session.setAttribute("phone", cur.getPhone());
        session.setAttribute("address", cur.getAddress());
        session.setAttribute("dob", cur.getDob());
        return "updateUser";
    }

    @PostMapping("/changePassword")
    public String changePassword(
            @RequestParam(required = false) String curPass,
            @RequestParam(required = false) String newPass,
            @RequestParam(required = false) String verifyNewPass,
            HttpSession session,
            Model model
    ) {
        String message = userService.changePassword((UserDTO) session.getAttribute("user"), curPass, newPass, verifyNewPass);

        session.setAttribute("user", userService.getUserByUsername(((UserDTO) session.getAttribute("user")).getUsername()));

        if(message == null) model.addAttribute("success", "Change password successfully!");
        else model.addAttribute("message", message);

        return "changePassword";
    }

    @GetMapping("/changePassword")
    public String getChangePassword(HttpSession session) {
        if(session.getAttribute("user") == null) return "redirect:/";

        return "changePassword";
    }
}

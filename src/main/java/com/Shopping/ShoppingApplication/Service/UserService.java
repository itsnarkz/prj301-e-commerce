package com.Shopping.ShoppingApplication.Service;

import com.Shopping.ShoppingApplication.Model.DTO.UserDTO;
import com.Shopping.ShoppingApplication.Model.Entity.User;
import com.Shopping.ShoppingApplication.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Shopping.ShoppingApplication.utils.Validation.isValidEmailAddress;
import static com.Shopping.ShoppingApplication.utils.Validation.isValidPhoneNumber;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null) return null;

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    public String login(String username, String password) {
        String message = null;

        if(password.equals("") || username.equals("")) {
            message = "Username / Password cannot be blank!";
            return message;
        }

        User user = userRepository.findByUsername(username);
        if(user == null) {
            message = "Account does not exists";
            return message;
        }

        if(!user.getPassword().equals(password)) {
            message = "Wrong username / password";
            return message;
        }

        return message;
    }

    public String registerNewUser(String username, String password, String name, String email, String phone, String sex, String address, String dob) {
        String message = null;
        if(username == null || password == null || name == null || email == null || phone == null || sex == null || address == null || dob == null) {
            message = "Require all fields!";
            return message;
        }

        if(username.length() < 6) {
            message = "Username must have at least 6 characters!";
            return message;
        }

        if(isRepeatUsername(username)) {
            message = "Username has been taken! Please choose another!";
            return message;
        }

        if(password.length() < 6) {
            message = "Password must have at least 6 characters!";
            return message;
        }

        if(!isValidEmailAddress(email)) {
            message = "Invalid email address!";
            return message;
        }

        if(!isValidPhoneNumber(phone)) {
            message = "Invalid phone number!";
            return message;
        }

        User user = User.builder().dob(dob).username(username).password(password).address(address).sex(sex).email(email).phone(phone).name(name).build();
        userRepository.save(user);

        return message;
    }

    public boolean isRepeatUsername(String username) {
        return this.getUserByUsername(username) != null;
    }

    public String updateUser(UserDTO user, String name, String email, String phone, String sex, String address, String dob) {
        String message = null;
        if(name.isBlank() || email.isBlank() || phone.isBlank() || sex == null || address.isBlank() || dob.isBlank()) {
            message = "Require all fields!";
            return message;
        }

        if(!isValidEmailAddress(email)) {
            message = "Invalid email address!";
            return message;
        }

        if(!isValidPhoneNumber(phone)) {
            message = "Invalid phone number!";
            return message;
        }

        User cur = userRepository.findById(user.getId()).get();
        cur.setName(name);
        cur.setPhone(phone);
        cur.setSex(sex);
        cur.setAddress(address);
        cur.setDob(dob);
        cur.setEmail(email);
        userRepository.save(cur);

        return message;
    }

    public String changePassword(UserDTO userDTO, String curPass, String newPass, String verifyNewPass) {
        User user = userRepository.findByUsername(userDTO.getUsername());

        String message = null;
        if(curPass.isBlank() || newPass.isBlank() || verifyNewPass.isBlank()) {
            message = "Require all fields!";
            return message;
        }

        if(!user.getPassword().equals(curPass)) {
            message = "Incorrect Password!";
            return message;
        }

        if(newPass.length() < 6) {
            message = "Password must have at least 6 characters!";
            return message;
        }

        if(!newPass.equals(verifyNewPass)) {
            message = "The passwords are not the same!";
            return message;
        }

        if(curPass.equals(newPass)) {
            message = "New password cannot be the same as old password!";
            return message;
        }

        user.setPassword(newPass);
        userRepository.save(user);

        return message;
    }
}

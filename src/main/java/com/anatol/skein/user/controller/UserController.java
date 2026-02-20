package com.anatol.skein.user.controller;

import com.anatol.skein.user.entities.User;
import com.anatol.skein.user.services.UserService;
import com.anatol.skein.user.utils.UserUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.anatol.skein.utils.ResponseUtil.*;

@RestController()
@RequestMapping(value = "user/")
public class UserController {
    private final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticatedUser() {
        User loggedInUser = UserUtil.getLoggedInUser();
        return success(loggedInUser);
    }

    @GetMapping(value = "all-users")
    public ResponseEntity<?> allUsers() {
        List<User> allUser = userService.getAllUsers();
        return create(allUser);
    }
}

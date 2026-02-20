package com.anatol.skein.user.utils;

import com.anatol.skein.user.entities.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtil {
    public static User getLoggedInUser() throws AccessDeniedException {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null) {
                throw new AccessDeniedException("");
            }

            return (User) authentication.getPrincipal();
        } catch (NullPointerException e) {
            throw new AccessDeniedException("You do not have permission to access this page");
        }
    }
}

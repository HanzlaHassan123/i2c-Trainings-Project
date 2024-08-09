package com.example.myapplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class CacheServlet extends HttpServlet {

    List<UserProfile> profiles = new ArrayList<>();

    public void init() {
        ServletContext context = getServletContext();
        profiles.add(new UserProfile(1, "Alice", "alice@gmail.com", "+345465645654", "Karachi"));
        profiles.add(new UserProfile(2, "Ahmad", "ahmad@gmail.com", "+1234567890", "Islamabad"));
        profiles.add(new UserProfile(3, "Ali", "ali@gmail.com", "+0987654321", "Lahore"));
        profiles.add(new UserProfile(4, "Alina", "alina@gmail.com", "+1122334455", "Karachi"));
        context.setAttribute("userProfiles", profiles);
    }

}

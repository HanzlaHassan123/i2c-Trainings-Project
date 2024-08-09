package com.example.myapplication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterIdParam = request.getParameter("id");

        List<UserProfile> filteredProfiles;

        if (filterIdParam != null && !filterIdParam.isEmpty()) {
            int id = Integer.parseInt(filterIdParam);

            // Filter the profiles based on the ID
            // FROM SERVLET Context


            List<UserProfile> userProfiles = (List<UserProfile>) getServletContext().getAttribute("userProfiles");
            filteredProfiles = userProfiles.stream()
                    .filter(profile -> profile.getId() == id)
                    .collect(Collectors.toList());


        } else {
            // If no ID is provided, use all profiles
            filteredProfiles = (List<UserProfile>) getServletContext().getAttribute("userProfiles");
        }

        // Store the filtered profiles in the request scope
        request.setAttribute("filteredProfiles", filteredProfiles);

        // Forward the request to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
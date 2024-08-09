<%@ page import="java.util.List" %>
<%@ page import="com.example.myapplication.UserProfile" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Profiles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
<h1>User Profiles</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>

    <%
        // Retrieve the filtered profiles from request scope
        List<UserProfile> profiles = (List<UserProfile>) request.getAttribute("filteredProfiles");

        if (profiles != null && !profiles.isEmpty()) {
            for (UserProfile profile : profiles) {
    %>
    <tr>
        <td><%= profile.getId() %></td>
        <td><%= profile.getName() %></td>
        <td><%= profile.getEmail() %></td>
        <td><%= profile.getPhone() %></td>
        <td><%= profile.getAddress() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No profiles available</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

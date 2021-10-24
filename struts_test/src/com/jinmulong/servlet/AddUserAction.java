package com.jinmulong.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserAction implements  Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username= request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//        String sex= request.getParameter("sex");

        UserManager userManager = new UserManager();
        userManager.add(username);
        return "/add_success.jsp";
    }
}

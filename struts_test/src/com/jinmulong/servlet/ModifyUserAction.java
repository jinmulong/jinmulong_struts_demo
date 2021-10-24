package com.jinmulong.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserAction implements  Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username= request.getParameter("username");
        // String userId= request.getParameter("userId");
        // int age = Integer.parseInt(request.getParameter("age"));
        // String sex= request.getParameter("sex");

        UserManager userManager = new UserManager();
        userManager.modify(username);
        return "/modify_success.jsp";
    }
}

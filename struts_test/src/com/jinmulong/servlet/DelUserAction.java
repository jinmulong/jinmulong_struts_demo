package com.jinmulong.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelUserAction implements  Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username= request.getParameter("username");

        UserManager userManager = new UserManager();
        userManager.del(username);
        return "/del_success.jsp";
    }
}

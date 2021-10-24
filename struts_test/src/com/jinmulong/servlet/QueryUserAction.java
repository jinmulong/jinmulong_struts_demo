package com.jinmulong.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class QueryUserAction implements  Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username= request.getParameter("username");

        UserManager userManager = new UserManager();
        List userList = userManager.query(username);
        request.setAttribute("userList",userList);
        userManager.query(username);

        return "/query_success.jsp";
    }
}

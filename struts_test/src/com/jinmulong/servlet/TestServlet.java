package com.jinmulong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println("requestUIR="+requestURI);
        String path = requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf("."));
        System.out.println("path="+path);
        UserManager userManager = new UserManager();
        String username= request.getParameter("username");
        if("/servlet/delUser".equals(path)){
            userManager.del(username);
            request.getRequestDispatcher("/del_success.jsp").forward(request,response);
        }else if("/servlet/addUser".equals(path)){
            userManager.add(username);
            request.getRequestDispatcher("/add_success.jsp").forward(request,response);
        }else if("/servlet/modifyUser".equals(path)){
            userManager.modify(username);
            request.getRequestDispatcher("/modify_success.jsp").forward(request,response);
        }else if("/servlet/queryUser".equals(path)){
            List userList = userManager.query(username);
            request.setAttribute("userList",userList);
            userManager.query(username);
            request.getRequestDispatcher("/query_success.jsp").forward(request,response);
        }else{
            throw  new RuntimeException("请求失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

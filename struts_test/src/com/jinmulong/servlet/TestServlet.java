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
        String path = requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf("."));
        System.out.println("path="+path);
        /*
        UserManager userManager = new UserManager();
        String username= request.getParameter("username");
        String forward="";
        if("/servlet/delUser".equals(path)){
            userManager.del(username);
            forward ="/del_success.jsp";
        }else if("/servlet/addUser".equals(path)){
            userManager.add(username);
            forward ="/add_success.jsp";
        }else if("/servlet/modifyUser".equals(path)){
            userManager.modify(username);
            forward ="/modify_success.jsp";
        }else if("/servlet/queryUser".equals(path)){
            List userList = userManager.query(username);
            request.setAttribute("userList",userList);
            userManager.query(username);
            forward ="/query_success.jsp";
        }else{
            throw  new RuntimeException("请求失败");
        }
        request.getRequestDispatcher(forward).forward(request,response);
        */
        Action action = null;
        if("/servlet/delUser".equals(path)){
            action = new DelUserAction();
        }else if("/servlet/addUser".equals(path)){
            action= new AddUserAction();
        }else if("/servlet/modifyUser".equals(path)){
            action= new ModifyUserAction();
        }else if("/servlet/queryUser".equals(path)){
            action = new QueryUserAction();
        }else{
            throw  new RuntimeException("请求失败");
        }
        String forward = null;
        try{
            forward= action.execute(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher(forward).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

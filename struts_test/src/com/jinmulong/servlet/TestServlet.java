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

        /**
         * <action-config>
         *     <action path="/servlet/delUser" type="com.jinmulong.servlet.DelUserAction">
         *         <forward name="success">/del_success.jsp</forward>
         *         <forward name="error">/del_error.jsp</forward>
         *     </action>
         *     <action path="/servlet/addUser" type="com.jinmulong.servlet.AddUserAction">
         *         <forward name="success">/add_success.jsp</forward>
         *         <forward name="error">/add_error.jsp</forward>
         *     </action>
         *     <action path="/servlet/modifyUser" type="com.jinmulong.servlet.ModifyUserAction">
         *         <forward name="success">/modify_success.jsp</forward>
         *         <forward name="error">/modify_error.jsp</forward>
         *     </action>
         *     <action path="/servlet/queryUser" type="com.jinmulong.servlet.QueryUserAction">
         *         <forward name="success">/query_success.jsp</forward>
         *         <forward name="error">/query_error.jsp</forward>
         *     </action>
         * </action-config>
         *
         * ActionMapping{
         *      private String path;
         *      private String type;
         *      Map forwardMap;         *
         * }
         *
         * forwardMap{
         *  key="success";
         *  value="/add_success.jsp"
         *  key="error";
         *  value="/add_error.jsp"
         * }
         *
         * Map map = new HashMap();
         * map.put("/servlet/delUser",actionMapping);
         * map.put("/servlet/addUser",actionMapping);
         * map.put("/servlet/modifyUser",actionMapping);
         * map.put("/servlet/queryUser",actionMapping);
         *
         *
         * 如果是删除ActionMapping存储如下
         * actionMapping{
         * path="/servlet/delUser";
         * type="com.jinmulong.servlet.DelUserAction";
         * forwardMap{
         *      key="success", value="/del_success.jsp"
         *      key="error",value="/del_error.jsp"
         * }
         * }
         *
         * String path = "/servlet/addUser";         *
         *
         * ActionMapping actionMapping = (ActionMapping)map.get(path);
         * String type = actionMapping.getType();
         *
         * Action action=(Action)class.forName(type).newInstance();
         * String forward = action.execute(request.response);
         *
         * request.getRequestDispatcher(forward).forward(request,response);
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

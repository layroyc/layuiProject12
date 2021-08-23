package com.hp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "CustomerDelServlet",urlPatterns = "/CustomerDelServlet")
public class CustomerDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //单行删除
        //1.解决编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        //2.收参数
        String id = req.getParameter("id");
        System.out.println("id = " + id);

        CustomerService service = new CustomerService();
        Map map = service.delCustomer(Integer.parseInt(id));

        PrintWriter writer = resp.getWriter();
        String s = JSONObject.toJSONString(map);
        writer.println(s);
        writer.close();
    }
}

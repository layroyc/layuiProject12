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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CustomerDelAllServlet",urlPatterns = "/CustomerDelAllServlet")
public class CustomerDelAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.修正编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        //重点，servlet接收 数组
        String[] parameterValues = req.getParameterValues("ids[]");
        System.out.println("parameterValues = " + parameterValues);
        CustomerService customerService = new CustomerService();
        for (String idStr : parameterValues) {
            int i = customerService.delByCustomer(Integer.parseInt(idStr));
            System.out.println("i = " + i);
        }

        Map codeMap = new HashMap<>();
        codeMap.put("code",0);
        codeMap.put("msg","ok");
        PrintWriter writer = resp.getWriter();
        String s = JSONObject.toJSONString(codeMap);
        writer.print(s);
        writer.close();
    }
}

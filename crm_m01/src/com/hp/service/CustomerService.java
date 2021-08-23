package com.hp.service;

import com.hp.bean.Customer;
import com.hp.dao.CustomerDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    //全查
   public Map selectByParam(Map map){
       CustomerDao dao=new CustomerDao();
       List<Map> maps=dao.selectAllByParam(map);
       Map codeMap=new HashMap();
       codeMap.put("code",0);
       codeMap.put("data",maps);
       codeMap.put("msg","ok");
       Map countMap =selectAllParamCount(map);
       int count= (int) countMap.get("data");
       codeMap.put("count",count);

       return codeMap;
   }

   //全查 总条数  多的
    public Map selectAllParamCount(Map map){
       Map codeMap=new HashMap();
       CustomerDao dao=new CustomerDao();
       int i=dao.selectAllByParamCount(map);
       codeMap.put("code",0);
       codeMap.put("data",i);
       codeMap.put("msg","ok");
       return codeMap;
    }

    //增加
    public Map insertCustomer(Customer customer){
        System.out.println("进入到 service 层了---");
        Map map = new HashMap();
        CustomerDao customerDao = new CustomerDao();
        System.out.println("customerDao = " + customerDao);
        int i = customerDao.insertCustomer(customer);
        System.out.println("i = " + i);
        if(i==1){
            map.put("code",0);
            map.put("msg","添加成功");
        }else{
            map.put("code",400);
            map.put("msg","添加不成功");
        }
        return map;
    }

    //批量删除
    public int delByCustomer(Integer id){
        CustomerDao customerDao = new CustomerDao();
        int i = customerDao.delByCustomer(id);
        return i;
    }

    //单行删除
    public Map delCustomer(Integer id){
        Map codeMap = new HashMap();
        CustomerDao dao = new CustomerDao();
        int i = dao.delByCustomer(id);
        codeMap.put("code",0);
        codeMap.put("msg","ok");
        codeMap.put("data",i);
        return codeMap;
    }

}

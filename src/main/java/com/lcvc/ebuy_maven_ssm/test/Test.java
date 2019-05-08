package com.lcvc.ebuy_maven_ssm.test;

import com.lcvc.ebuy_maven_ssm.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //建立一个List集合
        List<Admin> list=new ArrayList<Admin>();
        list.add(new Admin(31));
        list.add(new Admin(111));
        list.add(new Admin(431));
        for(int i=0;i<list.size();i++){
            Admin admin=list.get(i);
            System.out.println(admin.getId());
        }
    }
}

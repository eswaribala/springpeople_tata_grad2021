package com.tata.CDapp.utility;

import com.tata.CDapp.business.CDsorter;
import com.tata.CDapp.dao.CDdao;
import com.tata.CDapp.dao.CDimpl;
import com.tata.CDapp.models.CD;

import java.util.Collections;
import java.util.List;

public class CDappli {
    public static void main(String args[])
    {
        CDdao cdl=new CDimpl();
        CDdao cdDao=new CDimpl();
        List<CD> cdd=cdDao.getAllCD();
        System.out.println("Before Sorting");
        for(CD cd:cdd)
        {
            System.out.println(cd);
        }
        System.out.println("After Sorting");
        Collections.sort(cdd,new CDsorter());
        for(CD cd:cdd)
        {
            System.out.println(cd);
        }
    }
}
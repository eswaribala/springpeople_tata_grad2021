package com.tata.CDapp.dao;

import com.tata.CDapp.models.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.tata.CDapp.models.CD;


public class CDimpl implements CDdao{

    Scanner sc=new Scanner(System.in);
    @Override
    public List<CD> getAllCD() {
        return getdata();
    }

    public List<CD> getdata(){
        List<CD> getCd = new ArrayList<>();
        CD cd = null;
        for(int i=0;i<5;i++)
        {
            cd=new CD();
            System.out.println("Enter the Song Title");
            cd.setTitle(sc.next());
            System.out.println("Enter Singer Name");
            cd.setSinger(sc.next());

            getCd.add(cd);
        }
        return getCd;
    }



}

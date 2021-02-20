package com.tata.musicCD.dao;

import com.tata.musicCD.models.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDimpl implements CDdao{
    Scanner sc=new Scanner(System.in);
    @Override
    public List<CD> getAllCD() {
        return getdata();
    }

    public List<CD> getdata(){
        List<CD> getCd = new ArrayList<>();
        CD cd = null;
        for(int i=0;i<3;i++)
        {
            cd=new CD();
            System.out.println("Enter Song Title "+(i+1));
            cd.setTitle(sc.next());
            System.out.println("Enter Singer Name "+(i+1));
            cd.setSinger(sc.next());

            getCd.add(cd);
        }
        return getCd;
    }
}

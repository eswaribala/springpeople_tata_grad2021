package com.tata.musicCD.utility;

import com.tata.musicCD.business.CDsortBasedonSinger;
import com.tata.musicCD.dao.CDdao;
import com.tata.musicCD.dao.CDimpl;
import com.tata.musicCD.models.CD;

import java.util.Collections;
import java.util.List;

public class MusicCd {
    public static void main(String[] args){
        CDdao cdDao=new CDimpl();
        List<CD> cdd=cdDao.getAllCD();
        System.out.println("Sorting based on Singer name");
        Collections.sort(cdd,new CDsortBasedonSinger());
        for(CD cd:cdd)
        {
            System.out.println(cd.getTitle()+"\t\t"+cd.getSinger());
        }
    }
}

package com.java.songApp.utility;

import com.java.songApp.business.CDSorter;
import com.java.songApp.models.CD;
import com.java.songApp.songs.CDIntr;
import com.java.songApp.songs.CD_Impl;

import java.util.Collections;
import java.util.List;

public class CDApp {
    public static void main(String[] args) {
        CDIntr cdIntr =  new CD_Impl();
        List<CD> cdList = cdIntr.getAllCD();
        System.out.println("\n Before Sorting \n");
        for(CD cd : cdList){
            System.out.println(cd);
        }
        Collections.sort(cdList,new CDSorter());
        System.out.println("\n After Sorting : \n");
        for(CD transaction : cdList){
            System.out.println(transaction);
        }
    }
}

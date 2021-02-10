package com.java.songApp.songs;

import com.java.songApp.models.CD;

import java.time.LocalDate;
import java.util.*;

public class CD_Impl implements CDIntr{
    public List<CD> getAllCD() {
        return getData();
    }

    private List<CD> getData(){
        List<CD> CDList=new ArrayList<CD>();
        Set<Long> CDIdSet = new HashSet<>();

        CD song=null;
        for(int i=0;i<20;i++){
            CDIdSet.add((long) new Random().nextInt(10000));
        }
        Object[] objects = CDIdSet.toArray();
        for(int i=0;i<20;i++){
            song=new CD();
            song.setId((long)objects[i]);
            song.setSinger("Singer"+((long) new Random().nextInt(1000)));
            song.setTitle("Title"+ ((long) new Random().nextInt(1000)));
            CDList.add(song);
        }

        return CDList;
    }
}

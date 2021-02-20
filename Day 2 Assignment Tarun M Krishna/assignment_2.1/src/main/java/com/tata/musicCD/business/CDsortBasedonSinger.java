package com.tata.musicCD.business;

import com.tata.musicCD.models.CD;

import java.util.Comparator;

public class CDsortBasedonSinger implements Comparator<CD>{
    @Override
    public int compare(CD c1, CD c2) {
        return c1.getSinger().compareTo(c2.getSinger());
    }
}

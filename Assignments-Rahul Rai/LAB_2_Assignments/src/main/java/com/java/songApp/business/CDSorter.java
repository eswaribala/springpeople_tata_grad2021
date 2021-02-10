package com.java.songApp.business;

import com.java.songApp.models.CD;

import java.util.Comparator;

public class CDSorter implements Comparator<CD> {
    public int compare(CD song1, CD song2)
    {
        return song1.getSinger().compareTo(song2.getSinger());
    }
}

package com.tata.CDapp.business;


import com.tata.CDapp.models.CD;

import java.util.Comparator;

public class CDsorter implements Comparator<CD> {

    @Override
    public int compare(CD c1, CD c2) {
        return c1.getSinger().compareTo(c2.getSinger());
    }
}
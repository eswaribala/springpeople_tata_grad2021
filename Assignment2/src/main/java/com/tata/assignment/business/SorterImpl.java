package com.tata.assignment.business;

import com.tata.assignment.models.CD;

import java.util.ArrayList;

public class SorterImpl implements Sorter{
    public void SortCD(ArrayList<CD> arr){
        arr.sort(
                (CD1,CD2) -> CD1.getSinger().compareToIgnoreCase(CD2.getSinger())
        );
    }
}

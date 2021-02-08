package com.tata.assignment.utility;

import com.tata.assignment.business.Sorter;
import com.tata.assignment.business.SorterImpl;
import com.tata.assignment.models.CD;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class main {
    public static void GenerateArray(ArrayList<CD> arr){
        for (int i = 0;i < 10;i++) {
            arr.add(new CD(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10)));
        }
    }
    public static void main(String[] args) {
        ArrayList<CD> arr = new ArrayList<CD>(10);
        GenerateArray(arr);
        System.out.println("Before Sorting");
        for (CD cd : arr){
            System.out.println("Title : " + cd.getTitle() + " Singer : " + cd.getSinger());
        }
        Sorter s = new SorterImpl();
        s.SortCD(arr);
        System.out.println("After Sorting");
        for (CD cd : arr){
            System.out.println("Title : " + cd.getTitle() + " Singer : " + cd.getSinger());
        }



    }
}

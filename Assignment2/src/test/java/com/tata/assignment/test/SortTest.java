package com.tata.assignment.test;

import com.tata.assignment.business.Sorter;
import com.tata.assignment.business.SorterImpl;
import com.tata.assignment.models.CD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.HashSet;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {
    private ArrayList<CD> arr;
    @BeforeEach
    public void getInstance(){
        arr = new ArrayList<CD>(10);
        for (int i = 0;i < 10;i++){
            arr.add(new CD(RandomStringUtils.randomAlphabetic(10),RandomStringUtils.randomAlphabetic(10)));
        }
    }

    @Test
    @DisplayName("Sort Check")
    public void checkSort(){
        ArrayList<CD> ar = new ArrayList<CD>(arr);
        ar.sort((o1, o2) -> o1.getSinger().compareToIgnoreCase(o2.getSinger()));
        Sorter s = new SorterImpl();
        s.SortCD(arr);
        assertEquals(ar,arr);
    }
}

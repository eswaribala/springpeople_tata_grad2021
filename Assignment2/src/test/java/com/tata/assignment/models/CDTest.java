package com.tata.assignment.models;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.junit.jupiter.api.Assertions.*;

class CDTest {
    private ArrayList<CD> arr;
    @BeforeEach
    public void getInstance(){
        arr = new ArrayList<CD>(10);
        for (int i = 0;i < 10;i++){
            arr.add(new CD(RandomStringUtils.randomAlphabetic(10),RandomStringUtils.randomAlphabetic(10)));
        }
    }

    @Test
    @DisplayName("Title Must Be Unique")
    public void testTitle(){
        HashSet<CD> ar = new HashSet<CD>(arr);
        assertTrue(ar.size() == arr.size());
    }

    @Test
    @DisplayName("Singer name cannot be alphanumeric")
    public void testSinger(){
        assertTrue(arr.stream().allMatch((CD1)-> isAlpha(CD1.getSinger())));
    }

    @Test
    @DisplayName("Names should not be null")
    public void testName(){
        assertTrue(arr.stream().allMatch((CD1)-> !isEmpty(CD1.getSinger()) && !isEmpty(CD1.getTitle())));
    }

}
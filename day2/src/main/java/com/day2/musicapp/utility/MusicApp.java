package com.day2.musicapp.utility;

import com.day2.musicapp.dao.CdDao;
import com.day2.musicapp.dao.CdDaoImpl;
import com.day2.musicapp.models.CD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MusicApp {
    private static List<CD> cdList;

    public static void main(String[] args) {
        CdDao cdDao = new CdDaoImpl();
        cdList = cdDao.getallCDs();

        System.out.println("---------------------");
        sortCds(cdList).forEach(System.out::println);
    }

    public static List<CD> sortCds(List<CD> cdList) {
        return cdList
                .stream()
                .sorted(((o1, o2) -> o1.getSingerName().compareToIgnoreCase(o2.getSingerName())))
                .collect(Collectors.toList());
    }
}

package com.day2.musicapp.utility;

import com.day2.musicapp.dao.CdDao;
import com.day2.musicapp.dao.CdDaoImpl;
import com.day2.musicapp.models.CD;

import java.util.List;

public class MusicApp {
    public static void main(String[] args) {
        CdDao cdDao = new CdDaoImpl();

        List<CD> cdList = cdDao.getallCDs();
        sortCds(cdList);
        cdList.forEach(System.out::println);
    }

    public static void sortCds(List<CD> cdList) {
        cdList
                .stream()
                .sorted(((o1, o2) -> o1.getSingerName().compareTo(o2.getSingerName())));
    }
}

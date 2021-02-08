package com.day2.musicapp.dao;

import com.day2.musicapp.models.CD;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CdDaoImpl implements CdDao{
    @Override
    public List<CD> getallCDs() {
        return generateData();
    }

    private List<CD> generateData(){
        List<CD> cdList = new ArrayList<>();
        CD cd = null;
        for (int j = 0; j < 10; j++) {
            cd = new CD();

            String title = RandomStringUtils.randomAlphabetic(10);
            String singerName = RandomStringUtils.randomAlphabetic(20);

            cd.setTitle(title);
            cd.setSingerName(singerName);
            cdList.add(cd);
        }
        return cdList;
    }
}

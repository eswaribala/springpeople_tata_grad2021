package com.day2.musicapp.utility;

import com.day2.musicapp.dao.CdDao;
import com.day2.musicapp.dao.CdDaoImpl;
import com.day2.musicapp.models.CD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MusicAppTest {


    @Test
    @DisplayName("Test whether generated CDs are sorted")
    public void testCdTitleUnique() {
        CdDao cdDao = new CdDaoImpl();
        List<CD> cdList = cdDao.getallCDs();

        List<CD> cdList1, cdList2;

        cdList1 = new ArrayList<>(cdList);
        cdList1
                .stream()
                .sorted(((o1, o2) -> o1.getSingerName().compareTo(o2.getSingerName())));

        cdList2 = new ArrayList<>(cdList);
        MusicApp musicApp = new MusicApp();
        musicApp.sortCds(cdList2);

        assertEquals(cdList1, cdList2);
    }
}
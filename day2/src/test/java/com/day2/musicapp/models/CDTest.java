package com.day2.musicapp.models;

import com.day2.musicapp.dao.CdDao;
import com.day2.musicapp.dao.CdDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.junit.jupiter.api.Assertions.*;

class CDTest {
    private List<CD> cdList;

    @BeforeEach
    void setUp() {
        CdDao cdDao = new CdDaoImpl();
        cdList = cdDao.getallCDs();
    }

    @Test
    @DisplayName("Test CD Title uniqueness")
    public void testCdTitleUnique() {
        assertEquals(cdList.stream().distinct().count(), cdList.stream().count());
    }

    @Test
    @DisplayName("Test Singer names are not Alphanumeric")
    public void testSingerNames() {
        assertTrue(
                cdList
                        .stream()
                        .allMatch(cd -> {
                            return isAlpha(cd.getSingerName());
                        })
        );
    }
}
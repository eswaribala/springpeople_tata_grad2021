package com.tata.songApp.test;

import com.java.songApp.models.CD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class CDTest {
    private CD cd1,cd2,cd3;
    @BeforeEach
    public void getInstance()
    {
        cd1 = new CD();
        cd2 = new CD();
        cd1.setId(((long) new Random().nextInt(10000)));
        cd2.setId(((long) new Random().nextInt(10000)));
    }
    @Test
    @DisplayName("Test CD id to be unique")
    public void testCDIdUnique()
    {
        assertNotEquals(cd1.getId(),cd2.getId());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rahul Rai","eoiurbg qoireub","eruigb reg","gg","R","aerg"})
    @DisplayName("Test Singer Name length to be greater than 3")
    public void testSingerNameLength(String strings)
    {
        cd1.setSinger(strings);
        assertTrue(cd1.getSinger().length()>3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Despacito","Alone","Gang-gam style","tt","S","Dilwale"})
    @DisplayName("test Title length to be greater than 3")
    public void testTitleLength(String strings)
    {
        cd1.setTitle(strings);
        assertTrue(cd1.getTitle().length()>3);
    }

    @Test
    public void neagativeTestForCDInstance(){
        assertThrows(NullPointerException.class,
                ()->{
                    cd3.getId();
                });
    }
}

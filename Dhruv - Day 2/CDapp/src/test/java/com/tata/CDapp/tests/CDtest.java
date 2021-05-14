package com.tata.CDapp.tests;

import com.tata.CDapp.business.CDsorter;
import com.tata.CDapp.dao.CDdao;
import com.tata.CDapp.dao.CDimpl;
import com.tata.CDapp.models.CD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDtest {

    private CD cd1,cd2;
    private CDsorter cdsort1,cdsort2;
    private CDdao cdDao1,cdDao2;

    @BeforeEach
    public void getInstance()
    {
        cd1=new CD();
        cd2=new CD();
        cd1.setSinger("Amit Trivedi");
        cd2.setSinger("Ritviz");
        cd1.setTitle("Iktara");
        cd2.setTitle("Udd Gaye");

        cdsort2=new CDsorter();
        cdsort2=new CDsorter();

        cdDao1 =new CDimpl();
        cdDao2=new CDimpl();
    }

    @Test
    @DisplayName("title should be Unique")
    public void testTitleUnique()
    {
        assertNotEquals(cd1.getTitle(),cd2.getTitle());
    }

    @Test
    @DisplayName("singer should be Unique")
    public void testSingerUnique()
    {
        assertNotEquals(cd1.getSinger(),cd2.getSinger());
    }

    @ParameterizedTest
    @ValueSource(strings={"Arijit","Avi","Mamta","Mo","J"})
    public void singerLengthGreaterThan3(String singer)
    {
        cd1.setTitle(singer);
        assertTrue(cd1.getSinger().length()>3);
    }

    @ParameterizedTest
    @ValueSource(strings={"ooo","lalalala","dj","paani","kk"})
    public void titleLengthGreaterThan3(String title)
    {
        cd1.setTitle(title);
        assertTrue(cd1.getTitle().length()>3);
    }

    @Test
    public void singerNotNull()
    {
        assertThrows(NullPointerException.class,()->{cd1.getSinger();
        });
    }

    @Test
    public void titleNotNull()
    {
        assertThrows(NullPointerException.class,()->{cd2.getTitle();
        });
    }


    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void transactionDisplayName(TestInfo testInfo,RepetitionInfo repetitionInfo) {
        assertEquals("Repeat! " + repetitionInfo.getCurrentRepetition()
                + "/" + repetitionInfo.getTotalRepetitions(), testInfo.getDisplayName());
    }


    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
        assertEquals(cdsort1.compare(cd1,cd2),cdsort2.compare(cd1,cd2));

    }

    @Test
    public void NotSame()
    {
        assertEquals(cdDao1.getAllCD(),cdDao2.getAllCD());
    }


    @Test
    public void infoNotSame()
    {
        assertEquals(cdsort1.compare(cd1,cd2),cdsort2.compare(cd1,cd2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "CDdata.csv",numLinesToSkip =1)
    void testwithcsv(String title,String singer){
        assertTrue(title.length()>0);
        assertTrue(singer.length()>0);

    }

    @AfterEach
    public void testUnReferenceInstance(){
        cd1=null;
        cd2=null;
        //cd3=null;
    }

}

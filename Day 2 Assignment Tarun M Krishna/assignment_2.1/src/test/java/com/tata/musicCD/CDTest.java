package com.tata.musicCD;

import com.tata.musicCD.models.CD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CDTest {
    private CD cd1,cd2,cd3;

    @BeforeEach
    public void getInstance(){
        cd1=new CD();
        cd1.setSinger(""+new Random().nextInt(100));
        cd1.setTitle(""+new Random().nextInt(100));

        cd2=new CD();
        cd2.setSinger(""+new Random().nextInt(100));
        cd2.setTitle(""+new Random().nextInt(100));
    }

    @Test
    @DisplayName("Test Singer should not be null")
    public void testSingerNotNull(){
        assertNotEquals("",cd1.getSinger());
    }

    @Test
    @DisplayName("Test Title should not be null")
    public void testTitleNotNull(){

        assertNotEquals("",cd2.getTitle());
    }


    @Test()
    public void negativeTestForCDInstance(){
        assertThrows(NullPointerException.class,
                ()->{
                    cd3.getSinger();
                    cd3.getTitle();
                });
    }

    @AfterEach
    public void testUnReferenceInstance(){
        cd1=null;
        cd2=null;
        cd3=null;
    }
}

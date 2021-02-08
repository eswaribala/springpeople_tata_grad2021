package com.tata.assignment.utility;

import com.tata.assignment.models.CD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.tata.assignment.utility.main;
import java.util.ArrayList;

import static com.tata.assignment.utility.main.GenerateArray;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    @DisplayName("Check generate function")
    public void chkGenerate(){
        ArrayList<CD> arr = new ArrayList<CD>(10);
        main m = new main();
        m.GenerateArray(arr);
        assertTrue(arr.size() == 10);
    }
}

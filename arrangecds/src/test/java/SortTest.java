import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {
    private CD cd1,cd2,cd3;

    @BeforeEach
    public void getCD(){
        cd1=new CD();
        cd1.setSinger("s1");
        cd1.setTitle("t"+ Integer.toString(new Random().nextInt(10000)));
        cd2=new CD();
        cd2.setSinger("s2");
        cd2.setTitle("t"+Integer.toString(new Random().nextInt(10000)));
        cd3=new CD();
        cd3.setSinger("s3");
        cd3.setTitle("t"+Integer.toString(new Random().nextInt(10000)));
    }

    @Test
    @DisplayName("title should be diff")
    public void checkTitleUnique(){
        assertNotEquals(cd1.getTitle(), cd2.getTitle());
    }

    //title not null
    @ParameterizedTest
    @DisplayName("title should not be null")
    @ValueSource(strings = {"s1","s2","","s3"})
    public void noNullTitle(String data){
        cd3.setTitle(data);
        assertTrue(!cd3.getTitle().equals(""));
    }

    //singer not null
    @ParameterizedTest
    @DisplayName("singer should not be null")
    @ValueSource(strings = {"s1","s2","","s3"})
    public void noNullSinger(String data){
        cd3.setSinger(data);
        assertTrue(!cd3.getTitle().equals(""));
    }

    @Test
    @DisplayName("Sorter Test")
    public  void checkSorter(){
        List<CD> testList = new ArrayList<CD>();
        testList.add(cd1);
        testList.add(cd2);
        testList.add(cd3);
        SorterImpl sorter = new SorterImpl();
        List<CD>  sortedListTest = sorter.getSortedList(testList);
        for(int i=1;i<sortedListTest.size();i++){
            String s_1=sortedListTest.get(i-1).getSinger();
            String s_2=sortedListTest.get(i).getSinger();
            int retval = s_1.compareTo(s_2);
            assertTrue(retval<0);
        }
    }
}

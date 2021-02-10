import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        List<CD> curList = new ArrayList<CD>();
        for(int i=0;i<1000;i++){
            //get and set singers and add into array list
        }
        SorterImpl sorter = new SorterImpl();
        List<CD>  sortedList = sorter.getSortedList(curList);
        for(CD cd:sortedList){
            System.out.println(cd);
        }
    }
}

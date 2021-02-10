import java.util.Collections;
import java.util.List;

public class SorterImpl {
    public List<CD> getSortedList(List<CD> curList){
        int size = curList.size();
        Collections.sort(curList,new CdSorter());
        return curList;
    }
}

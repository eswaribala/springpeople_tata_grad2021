import java.util.Comparator;

public class CdSorter implements Comparator<CD> {

    @Override
    public int compare(CD o1, CD o2) {
            return o1.getSinger().compareTo(o2.getSinger());
    }
}

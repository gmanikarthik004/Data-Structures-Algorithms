import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class ColClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        list.add(34);
        list.add(12);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(5);
        list.add(9);
        
        System.out.println(list);
        
        // M-1 MinElement & MaxElement
        System.out.println("MinElement: "+ Collections.min(list));
        System.out.println("MaxElement: "+ Collections.max(list));
        
        // M-2 Freq of an element
        System.out.println("Freq of an element: " + Collections.frequency(list, 12)); 
        
        // M-3 Sorting -- Ascending & Descending
        Collections.sort(list);
        System.out.println("Ascending Order: " + list);
        
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Descending Order: " + list);
    }
}
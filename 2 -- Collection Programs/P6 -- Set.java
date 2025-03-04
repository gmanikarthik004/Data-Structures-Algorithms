import java.util.Set;
// import java.util.HashSet;
// import java.util.LinkedHashSet;
import java.util.TreeSet;

class Set1
{
    public static void main(String args[])
    {
        
        // Set<Integer> set = new HashSet<>(); // Unordered
        // Set<Integer> set = new LinkedHashSet<>(); // Ordered
        Set<Integer> set = new TreeSet<>();// Sorted(in Ascending)
        
        // M-1 Add
        set.add(10);
        set.add(14);
        set.add(60);
        set.add(40);
        set.add(64);
        
        System.out.println("Set: "+set);
        
        // M-2 Remove
        set.remove(60);
        System.out.println("After removing: "+set);
        
        // M-3 Contains
        System.out.println("Contains: "+set.contains(40));
        
        // M-4 Size
        System.out.println("Size: "+set.size());
        
        // M-5 isEmpty
        System.out.println("isEmpty: "+set.isEmpty());
        
        // M-6 clear
        set.clear();
    }
}
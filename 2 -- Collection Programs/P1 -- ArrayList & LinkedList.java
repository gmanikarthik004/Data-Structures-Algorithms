import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

class List1
{
    public static void main(String args[])
    {
        // Create Integer LinkedList
        List<Integer> list = new LinkedList<>();
        list.add(10);
        
        // Create Integer ArrayList
        List<Integer> newL = new ArrayList<>();

        // M-1 Add elements(at end)
        newL.add(10);
        newL.add(20);
        newL.add(30);
        
        System.out.println("Add at End: " + newL);
        
        // M-2 Add at particular idx
        newL.add(0, 40);
        System.out.println("Add at an Idx: " + newL);
        
        // M-3 Add another list elements
        List<Integer> newL2 = new ArrayList<>();
        newL2.add(50);
        newL2.add(60);
        newL2.add(40);
        
        newL.addAll(newL2);
        System.out.println("New List: " + newL);
        
        // M-4 Get an element
        System.out.println("Get: " + newL.get(3));
        
        // M-5 Remove an element
        newL.remove(1);
        System.out.println("After removed: " + newL);
        
        // M-6 Remove particular element
        newL.remove(Integer.valueOf(40));
        System.out.println("After removing 40: " + newL);
        
        // M-7 Clear entire list
        // newL.clear();
        // System.out.println(newL);
        
        // M-7 Set an particular element
        newL.set(0, 10);
        System.out.println("After updating: " + newL);
        
        // M-8 Contains
        System.out.println("Contains: " + newL.contains(60));
        
        // M-9 Iterate one-by-one
        // 1st-way
        /*for(int i = 0; i < newL.size(); i++) {
            System.out.print(newL.get(i) + " ");
        }*/
        
        // 2nd-way Best Way
        /*for(Integer ele : newL) {
            System.out.print(ele + " ");
        }*/
        
        // 3rd-way
        Iterator<Integer> it = newL.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
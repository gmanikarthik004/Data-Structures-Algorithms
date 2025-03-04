import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class Map1
{
    public static void main(String args[])
    {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new TreeMap<>();
        
        // M-1 Put
        map1.put("one", 1);
        map.put("two", 21);
        map.put("three", 32);
        map.put("four", 52);
        map.put("five", 42);
        
        System.out.println("Map: "+map);
        
        // M-2 To avoid overriding if same key's present
        // Way-1
        // if(!map.containsKey("Two")) {
        //     map.put("two", 22);
        // }
        // Way-2
        // map.putIfAbsent("Two", 23);
        
        // System.out.println("Map: "+map);
        
        // M-3 Iterate over map
        // Way-1
        // for(Map.Entry<String, Integer> ele : map.entrySet()) {
        //     System.out.print(ele.getKey() + " ");
        //     System.out.print(ele.getValue() + " ");
        // }
        
        // Way-2
        // Only key reqd
        for(String key : map.keySet()) {
            System.out.print(key+ " ");
        }
        System.out.println();
        // Only values reqd
        for(Integer val : map.values()) {
            System.out.print(val+" ");
        }
        
        // M-4 containsKey & containsValue
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue(34));
        
        // M-5 get
        System.out.println(map.get("two"));
        
        // M-6 remove
        map.remove("two");
        System.out.println("Map: "+map);
    }
}
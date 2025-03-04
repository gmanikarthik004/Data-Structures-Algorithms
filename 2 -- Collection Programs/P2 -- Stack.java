import java.util.Stack;

class List2
{
    public static void main(String args[])
    {
        Stack<String> animals = new Stack<>();
        
        // M-1 Push
        animals.push("Lion");
        animals.push("Zebra");
        animals.push("Deer");
        animals.push("Tiger");
        
        System.out.println("Stack: "+animals);
        
        // M-2 Peek
        System.out.println("Stack TopE: "+animals.peek());
        
        // M-3 Pop
        animals.pop();
        System.out.println("Stack after pop: "+animals);
    }
}
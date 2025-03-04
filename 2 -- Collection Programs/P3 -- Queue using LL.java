// Queue can be implemented using LinkedList or ArrayList
import java.util.LinkedList;
import java.util.Queue;

class Queue1
{
    public static void main(String args[])
    {
        Queue<Integer> q = new LinkedList<>();
        
        // M-1 Offer & Add(but throws exception)
        q.offer(10);
        q.offer(20);
        q.offer(30);
        
        System.out.println("Queue: "+q);
        
        // // M-2 Peek & Element(but throws exception)
        System.out.println("Queue TopE: "+q.peek());
        
        // // M-3 Poll & Remove(but throws exception)
        q.poll();
        System.out.println("Queue after poll: "+q);
    }
}
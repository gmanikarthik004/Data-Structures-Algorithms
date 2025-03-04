// Min & Max Heap can be implemented using PriorityQueue
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Queue2
{
    public static void main(String args[])
    {
        // Queue<Integer> pq = new PriorityQueue<>(); // By-default min-heap
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // To max-heap
        
        // M-1 Offer
        pq2.offer(10);
        pq2.offer(5);
        pq2.offer(20);
        pq2.offer(50);
        pq2.offer(70);
        
        System.out.println("PriorityQueue: "+pq2);
        
        // M-2 Peek
        System.out.println("PriorityQueue TopE: "+pq2.peek());
        
        // // // // M-3 Poll
        pq2.poll();
        System.out.println("PriorityQueue after poll: "+pq2);
    }
}
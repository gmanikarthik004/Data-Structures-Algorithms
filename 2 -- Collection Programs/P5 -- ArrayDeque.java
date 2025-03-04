import java.util.ArrayDeque;

class Queue3
{
    public static void main(String args[])
    {
        ArrayDeque<Integer> aDq = new ArrayDeque<>();
        
        // M-1 Offer, OfferFirst & OfferLast
        aDq.offer(10);
        aDq.offerFirst(20);
        aDq.offerLast(30);
        
        System.out.println("ArrayDeque: "+aDq);
        
        // M-2 Peek, PeekFirst & PeekLast
        System.out.println("ArrayDeque Peek: "+aDq.peek());
        System.out.println("ArrayDeque PeekFirst: "+aDq.peekFirst());
        System.out.println("ArrayDeque PeekLast: "+aDq.peekLast());
        
        // // // // // M-3 Poll, PollFirst & PollLast
        // aDq.poll();
        // aDq.pollFirst();
        aDq.pollLast();
        System.out.println("ArrayDeque after polling: "+aDq);
    }
}
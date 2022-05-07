package Question2;

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

//The main brain of the program is that we divide the head and tail by the capacity and take the reminder to make it a circular queue


public class CyclicQueue implements NumberQueue {
    /**
     * The Capacity of the list
     */
    int capacity;

    /**
     * The Head is the position where all the elements are dequeued from
     */
    int head;

    /**
     * The Tail is the position where all the elements are enqueued from
     */
    int tail;

    /**
     * The Array which acts like a circular Queue
     */
    int[] elements;

    /**
     * Keeps track of the previous operation (Enqueue or Dequeue)
     */
    private Boolean previousOperation = false;
    // True -> Enqueue
    //False -> Dequeue

    /**
     * The Constructor of the circular queue
     * @param capacity The size of the circular  queue
     */
    public CyclicQueue (int capacity){
        this.capacity = capacity;
        this.elements =  new int[capacity];
    }

    /**
     * The method to add elements to the circular queue
     * @param element The number which is being pushed into the circular array
     * @throws IndexOutOfBoundsException If the queue is full and no more elements can be added, it will throw an exception
     */
    @Override
    public void enqueue(int element) throws IndexOutOfBoundsException {
            if (tail%capacity == head%capacity && previousOperation){
                throw new IndexOutOfBoundsException("Full!!");
            }else{
                elements[tail% capacity] = element;
                tail++;
                previousOperation = true;
            }
    }

    /**
     * The Method to Pop out elements from the queue
     * @return The element at which the head is pointing
     * @throws IndexOutOfBoundsException if the queue is empty it will throw an exception
     */
    @Override
    public int dequeue() throws IndexOutOfBoundsException{

            if(isEmpty()){
                System.out.println("Its Empty");
                throw new IndexOutOfBoundsException("Empty!!!");
            }else {

                var a = elements[head%capacity];
                head++;
                previousOperation = false;
                return a;


            }

    }

    /**
     * The Method to check if the queue is Empty of not
     * @return  A Boolean value according to the situation if the queue is Empty or not
     * Returns true if empty and the other way around as well
     */
    @Override
    public boolean isEmpty() {
        if(head%capacity == tail%capacity && !previousOperation ){
            return true;
        }else{
            return false;
        }
    }

    /**
     * A method to check if the queue is full or not
     * @return A Boolean value according to the situation of the queue
     */
    public boolean isFull(){
        if(head%capacity == tail%capacity && previousOperation){
            return true;
        }else{
            return false;
        }
    }

    /**
     * A Custom Made method to see the elements in the queue
     */
    public void show(){
        for(int a:elements){
            System.out.println(a);
        }
    }

    /**
     * Another Custom made method to print the head and tail position
     */
    public void headAndTail(){
        System.out.println(head);
        System.out.println(tail);
    }
}

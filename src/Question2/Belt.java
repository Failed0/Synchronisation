package Question2;

public class Belt extends  CyclicQueue{
    /**
     * The Constructor of the circular queue
     *
     * @param capacity The size of the circular  queue
     */
    public Belt(int capacity) {
        super(capacity);
    }


    /**
     * A Synchronized method that adds numbers to the belt
     * @param element The number which is being pushed into the circular array
     * @throws IndexOutOfBoundsException Throws exception when The Belt is already full
     */
    @Override
    public synchronized void enqueue(int element) throws IndexOutOfBoundsException {

        //Waiting for the 
        if (isFull()){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Number Added: " + element);
        super.enqueue(element);

        // Sending the notification when the element is added
        synchronized (this){
            this.notify();
        }




    }

    /**
     * A Synchronized Method to Remove numbers from the Belt
     * @return The Element Removed
     * @throws IndexOutOfBoundsException Throws Exception if the
     */
    @Override
    public synchronized int dequeue() throws IndexOutOfBoundsException {

        // Waiting for some elements to be added to the belt
        if(isEmpty()){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        int number = super.dequeue();

        System.out.println("Number removed: " + number);

        //Sending out notification when the element is removed
        synchronized (this){
            this.notify();
        }

        return number;
    }
}

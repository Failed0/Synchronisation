package Question1;

import Question1.Counter;

public class Gate implements  Runnable{

    int numberOfGuests;
    Counter counter;


    public Gate(Counter counter, int numberOfGuests){
        this.numberOfGuests = numberOfGuests;
        this.counter = counter;
    }

    @Override
    public void run() {

        for(int i = 0; i < numberOfGuests; i++) {
            counter.addOne();
        }
    }
}

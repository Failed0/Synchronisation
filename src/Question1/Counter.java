package Question1;

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.UnitCounter;

public class Counter implements UnitCounter {


    int counter;

    @Override
    public synchronized void addOne() {

        counter++;

    }

    @Override
    public int getCounter() {
        return counter;
    }
}

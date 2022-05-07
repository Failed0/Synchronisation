package Question3;

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class Seat1 implements Seat {


    private ReentrantLock f1;
    private ReentrantLock f2;



    @Override
    public void askFork1() {

        f1.lock();
    }

    @Override
    public void askFork2() {

        f2.lock();

    }

    @Override
    public void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {

        f1 = reentrantLock;
        f2 = reentrantLock1;

    }
}

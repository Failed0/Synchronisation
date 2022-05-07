package Question2;

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;


import java.util.Random;

public class Producer extends FactoryWorker{
    public Producer(int id, NumberQueue belt) {
        super("Producer", id, belt);
    }

    @Override
    public void message(int i) {

        System.out.println(jobType +" "+ id +" picked " + i + " from the Belt");

    }

    @Override
    public int action() {

        Random rand = new Random();
        var a =rand.nextInt();
        belt.enqueue(a);

        return a;

    }

    @Override
    public void run() {
        try{
            var i =0;
            while(Thread.currentThread().isInterrupted()){
                message(i);
                i++;
            }
        }catch (Exception e){
            messageError();
        }
    }
}

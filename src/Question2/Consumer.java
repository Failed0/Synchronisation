package Question2;

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {
    public Consumer(int id, NumberQueue belt) {
        super("Consumer", id, belt);
    }

    @Override
    public void message(int i) {

        System.out.println(jobType +" "+ id +" picked " + i + " from the Belt");
    }

    @Override
    public int action(){
        return belt.dequeue();
    }

    @Override
    public void run() {

        try{
            var i =0;
            while (Thread.currentThread().isInterrupted()){
                message(i);
                i++;
            }
        }catch (Exception e){
            messageError();
        }
    }
}

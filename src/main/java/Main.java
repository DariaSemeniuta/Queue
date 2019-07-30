package main.java;

import main.java.queue.Queue;
import main.java.threads.PutThread;

public class Main {

    public static void main(String[] args) throws Exception{
        final Queue firstQueue =  new Queue();
        Thread firstThread = new PutThread();
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; ++i){
                firstQueue.putObject("secondThread"+i);
                }
                //System.out.println("sec thread!!!");
            }
        });
        secondThread.start();
        Integer a = 123;
        Boolean b = true;
        firstQueue.putObject(a);

        firstQueue.putObject(b);
        //firstThread.start();
        firstQueue.printQueue();




        System.out.println("Get object => " + firstQueue.getObject().toString());
        for(int i=0; i<100; ++i) {
            firstQueue.printQueue();
        }




	// write your code here
    }
}

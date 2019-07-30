package main.java.queue;

import java.util.LinkedList;
import java.util.List;

public class Queue {

    private List<Object> queueList;

    public Queue() {
        this.queueList = new LinkedList<Object>();
    }

    public synchronized Object getObject() throws InterruptedException {
        //wait();
        int lastIndex = queueList.size()-1;
        Object last = queueList.get(lastIndex);

        queueList.remove(lastIndex);
        //notify();
        return last;
    }

    public synchronized void putObject(Object object){
        queueList.add(object);
    }

    public synchronized void printQueue() throws InterruptedException{
        //wait();
        System.out.println(this.toString());
        //notify();
    }

    @Override
    public String toString() {
        String stringView = "";
        for (Object object: queueList) {
            stringView +="\n"+ object.toString();
        }
        return "Queue:" + stringView;
    }
}

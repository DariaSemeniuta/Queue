package main.java.queue;

import java.util.LinkedList;
import java.util.List;

public class Queue {

    private List<Object> queueList;

    public Queue() {
        this.queueList = new LinkedList<Object>();
    }

    public synchronized Object getObject() throws InterruptedException {
        queueList.wait();
        int lastIndex = queueList.size()-1;
        Object last = queueList.get(lastIndex);

        queueList.remove(lastIndex);
        queueList.notify();
        return last;
    }

    public synchronized void putObject(Object object){
        queueList.add(object);
    }

    public void printQueue(){
        System.out.println(this.toString());
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

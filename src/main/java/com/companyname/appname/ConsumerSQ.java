package com.companyname.appname;

import java.util.concurrent.SynchronousQueue;

public class ConsumerSQ implements Runnable {
    SynchronousQueue<Integer> syncQueue;
    ConsumerSQ(SynchronousQueue<Integer> syncQueue){
        this.syncQueue = syncQueue;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {

            try {
                System.out.println("Consumer "+i+" wants to read");
                int element = syncQueue.take();
                System.out.println(element);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Consumer thread Interrupted");
            }
            System.out.println("Consumer thread "+i+" exiting.");
        }
    }
}
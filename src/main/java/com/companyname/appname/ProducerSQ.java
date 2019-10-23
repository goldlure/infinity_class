package com.companyname.appname;

import java.util.concurrent.SynchronousQueue;

public class ProducerSQ implements Runnable {
    SynchronousQueue<Integer> syncQueue;
    ProducerSQ(SynchronousQueue<Integer> syncQueue){
        this.syncQueue = syncQueue;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Producer "+i+" wants to put");
                syncQueue.put(i * 13);
            } catch (InterruptedException e) {
                System.out.println("Producer thread Interrupted");
            }
            System.out.println("Producer thread "+i+" exiting.");
        }
    }
}

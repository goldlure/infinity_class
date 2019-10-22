package com.companyname.appname;

import java.util.*;
import java.util.concurrent.*;

public class ListJava {
    List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());
    List<Integer> list2 = new CopyOnWriteArrayList<>();

    ListJava(List<Integer> list1, List<Integer> list2){
        this.list1 = list1;
        this.list2 = list2;
    }
    
    public static void checkList(List<Integer> list) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(
            new ListRunner(0,50,list,latch)
        );
        Future<Long> f2 = ex.submit(
            new ListRunner(50,100,list,latch)
        );

        latch.countDown();
        System.out.println("Thread 1: "+f1.get()/1000); //get is a blocking method
        System.out.println("Thread 2: "+f2.get()/1000);
    }

    static class ListRunner implements Callable<Long> {
        private int start;
        private int end;
        private List<Integer> list;
        private CountDownLatch latch;

        ListRunner(int start,int end,List<Integer> list,CountDownLatch latch){
            this.start = start;
            this.end = end;
            this.list = list;
            this.latch = latch;
        }
        @Override
        public Long call() throws Exception {
            latch.await();
            
            long startTime = System.nanoTime();
            for (int i = start; i <end; i++){
                list.get(i);
                if (i%10 == 0){
                    list.add(5);
                }
            }
            return System.nanoTime() - startTime;
        }
        
    }
}
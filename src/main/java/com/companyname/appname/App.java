package com.companyname.appname;

import java.util.*;
import java.util.concurrent.ExecutionException;
//import java.util.concurrent.SynchronousQueue;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException, InsufficientFundsException {
        System.out.println("Hello World!");
        EnumExample enumExample = new EnumExample(Planet.EARTH);
        enumExample.isItHabitable();
        for (Planet planet : Planet.values()) {
            System.out.println(Planet.valueOf(planet.toString()));
            System.out.println("I can live on " + planet.name().toLowerCase() + " and it's " + planet.canLiveHere());
            planet.sayMyName();
        }
        Calculator calculator = new Calculator();
        System.out.println("2 + 3 = " + calculator.add(2, 3));
        Calculator.CalcFalse calcFalse = calculator.new CalcFalse();
        System.out.println("2 + 3 = " + calcFalse.add(2, 3));
        Calculator calc2 = new Calculator() {
            public int add(int a, int b) {
                System.out.println("in anonymous class " + calculator.a + " " + calculator.bb + " " + addNew());
                return a + b;
            }
        };
        System.out.println(calc2.add(100, 100));

        NavigableSet<Integer> ns = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            ns.add(i);
        }
        System.out.println(ns);
        System.out.println(ns.lower(4));
        System.out.println(ns.higher(4));
        System.out.println(ns.tailSet(4));

        Integer[] nums = { 1, 2, 3, 4 };
        List<Integer> numList = new ArrayList<>(Arrays.asList(nums));
        numList.add(9);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list1.add(i);
            list2.add(i);
        }

        // ListJava.checkList(list1);
        // ListJava.checkList(list2);

        // SynchronousQueue<Integer> syncQueue = new SynchronousQueue<>();
        // Thread t1 = new Thread(new ProducerSQ(syncQueue));
        // Thread t2 = new Thread(new ConsumerSQ(syncQueue));
        // try {
        // t1.start();

        // t2.start();
        // t1.join();
        // t2.join();
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (InsufficientFundsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }).start();
        transfer( b, a, 300);

        
    }
    static void transfer(Account a1, Account a2, int amount) throws InsufficientFundsException{
        if (a1.getBalance() < amount){
            throw new InsufficientFundsException();
        }
        a1.withdraw(amount);
        a2.deposit(amount);
        System.out.println(a1.getBalance());
        System.out.println(a2.getBalance());
    }
}

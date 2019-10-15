package com.companyname.appname;

public class Calculator{
    int a = 0;
    final int bb = 700000;
    int add(int a, int b){
        return a + b;
    }
    int addNew(){
        return 101010;
    }
    class CalcFalse{
        //static int x = 1;
        int a = 1;
        int add(int a, int b){
            System.out.println(Calculator.this.a + " "+ this.a + " " + a + bb);
            Calculator.this.addNew();
            return 2*a +b;
        }
        int z = Calculator.this.addNew();
    }
    static class Calc2{
        static final int x = 56;
        static void method1(){
            System.out.println(x);
        }
        static class Calc3{
            static int x = 65;
        }
    }
}
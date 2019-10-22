package com.companyname.appname;

import java.util.ArrayList;
import java.util.List;


public class Calculator {
    int a = 0;
    final int bb = 700000;
    
    List rawList;
    List<?> listOfAnyType;
    List<Object> listObject = new ArrayList<>();
    List<String> listString = new ArrayList<>();
    List<Integer> listInteger = new ArrayList<>();

    private void generic(){
        rawList = listOfAnyType;
        rawList = listString;
        rawList = listInteger;

        listOfAnyType = listString;
        listOfAnyType = listInteger;
        // Cannot cast from List<String> to List<Object>
        // listObject = (List<Object>)listString;
    }

    int add(int a, int b){
        generic();
        return a + b;
    }
    public static int sum(int...numbers) {

        int result = 0;
 
        for(int i : numbers) {
 
            result += i;
        }
 
        return result;
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
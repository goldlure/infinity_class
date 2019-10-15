package com.companyname.appname;

import org.junit.*;

public class TestShortArray{
    static int[] arr = {1,2,3};
    int position;
    static ShortArray shortArray;
    @BeforeClass
    public static void createArray(){
        shortArray = new ShortArray(arr);
    }

    @Before
    public void onlyOnce() {
        position = 0;
    }

    @Test
    public void getElemnts(){
        while (position < shortArray.getSize()){
            System.out.println(shortArray.getElementByPosition(position));
            position++;
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void two() {
        while (position <= shortArray.getSize()){
            System.out.println(shortArray.getElementByPosition(position));
            position++;
        }
    }

    @Test(timeout = 500) //500 milliseconds = 0.5 seconds
    public void three(){
        while (position <= shortArray.getSize()){
            System.out.println(shortArray.getElementByPosition(position));
        }
    }

}

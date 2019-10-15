package com.companyname.appname;

public class ShortArray{
    private int[] arr;
    private int size;
    ShortArray(int[] arr){
        this.arr = arr;
        this.size = arr.length;
    }
    public int getSize(){
        return this.size;
    }
    public int getElementByPosition(int position){
        return this.arr[position];
    }
}
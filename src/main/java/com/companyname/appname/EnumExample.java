package com.companyname.appname;

public class EnumExample {
    Planet planet;

    public EnumExample(Planet planet){
        this.planet = planet;
    }

    public void isItHabitable(){
        switch (this.planet){
            case EARTH:
                System.out.println("you can live here");
                break;
            default:
                System.out.println("you can't live here");
                break;

        }
    }
}
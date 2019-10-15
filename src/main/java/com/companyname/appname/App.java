package com.companyname.appname;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EnumExample enumExample = new EnumExample(Planet.EARTH);
        enumExample.isItHabitable();
        for (Planet planet: Planet.values()){
            System.out.println(Planet.valueOf(planet.toString()));
            System.out.println("I can live on " + planet.name().toLowerCase() +" and it's " + planet.canLiveHere());
            planet.sayMyName();
        }
        Calculator calculator = new Calculator();
        System.out.println("2 + 3 = " +calculator.add(2, 3));
        Calculator.CalcFalse calcFalse = calculator.new CalcFalse();
        System.out.println("2 + 3 = " + calcFalse.add(2, 3));
        Calculator calc2 = new Calculator(){
            public int add(int a, int b){
                System.out.println("in anonymous class " + calculator.a + " " +calculator.bb + " " + addNew());
                return a +b;
            }
        };
        System.out.println(calc2.add(100,100));
    }
}

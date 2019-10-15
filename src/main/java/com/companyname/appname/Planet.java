package com.companyname.appname;

public enum Planet implements InterfaceExample{
    EARTH(true){
        public void sayMyName() {
            System.out.println("I'm the Earth");
        }
    }, 
    SUN(false) {
        @Override
        public void sayMyName() {
            System.out.println("I'm the Sun");
        }
    },
    MOON(false) {
        @Override
        public void sayMyName() {
            System.out.println("I'm the Moon");
        }
    },
    SATURN(false) {
        @Override
        public void sayMyName() {
            // TODO Auto-generated method stub

        }
    },
    MARS(false) {
        @Override
        public void sayMyName() {
            // TODO Auto-generated method stub

        }
    },
    NEPTUN(false) {
        @Override
        public void sayMyName() {
            // TODO Auto-generated method stub

        }
    };
    private final boolean isHabitable;

    Planet(boolean isHabitable){
        this.isHabitable = isHabitable;
    }

    public abstract void sayMyName();
    boolean canLiveHere(){
        return isHabitable;
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
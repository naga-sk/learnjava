package com.learn.naga.L1_Access_Modifiers;

public class AccessMod {
    
    private int a = 1;

    static void staticMethod () {
        System.out.println("This is a static method");
    }

    private void privMethod() {
        System.out.println("This method has private access");
    }

    void packMethod() {
        System.out.println("This method has package level access");
    }
    
    public void publicMethod(int a) {
        System.out.println("This method has public access");
        this.localMethod();
        this.a = this.a+a+5;
        System.out.println(this.a);
    }

    private void localMethod() {
        System.out.println("I'm calling a local method");
    }
    
    public static void main (String args[]) {
        // staticMethod();
        AccessMod obj = new AccessMod();
        // AccessMod obj1 = new AccessMod();
        // AccessMod abc = new AccessMod();
        obj.privMethod();
        obj.packMethod();
        obj.publicMethod(6);
    }

}

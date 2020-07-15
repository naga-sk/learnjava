package com.learn.naga.L1_Access_Modifiers;

public class TestAccess {

public static void main(String[] args) {
    // AccessMod.
    final AccessMod obj = new AccessMod();
    obj.packMethod();
    obj.publicMethod(4);
}

}
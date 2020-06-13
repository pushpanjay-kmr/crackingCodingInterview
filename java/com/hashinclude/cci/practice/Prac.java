package com.hashinclude.cci.practice;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
public class Prac {
    public static void main(String[] args) {
        System.out.println("Integers:  ");
        System.out.println(Integer.valueOf(1).compareTo(Integer.valueOf(2)));
        System.out.println(Integer.valueOf(1).compareTo(Integer.valueOf(1)));
        System.out.println(Integer.valueOf(2).compareTo(Integer.valueOf(1)));

        System.out.println("Character:  ");
        System.out.println(Character.valueOf('a').compareTo(Character.valueOf('b')));
        System.out.println(Character.valueOf('a').compareTo(Character.valueOf('a')));
        System.out.println(Character.valueOf('b').compareTo(Character.valueOf('a')));

        System.out.println("Strings:  ");
        System.out.println("a".compareTo("b"));
        System.out.println("a".compareTo("a"));
        System.out.println("b".compareTo("a"));
    }
}

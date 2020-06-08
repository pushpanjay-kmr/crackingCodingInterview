package com.hashinclude.cci.arrayandstring;

import java.util.Arrays;

/**
 * @author pushpanjay.kumar created on 7/6/20
 */
public class CheckPermutation {

    /**
     * Count of each character is compared in string s1 and s2
     * TC: O(n)
     * AS: O(1) array of size 128 (ascii length) is used
     * @param s1 string one
     * @param s2 string two
     * @return true if string s1 is permutation of string s2
     */
    private static boolean checkPermutation1(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1!=n2){
            return false;
        }
        int []counter = new int[128];
        for(int i=0;i<n1;i++){
            int v1 = s1.charAt(i);
            int v2 = s2.charAt(i);
            counter[v1]++;
            counter[v2]--;
        }

        for(int i=0;i<128;i++){
            if(counter[i]!=0){
                return false;
            }
        }
        return true;
    }

    private static String sortString(String s){
        char[] charString = s.toCharArray();
        Arrays.sort(charString);
        return new String(charString);
    }

    /**
     * Both strings are sorted and then compared
     * TC: O(nlogn)
     * AS: O(1)
     * @param s1 string one
     * @param s2 string two
     * @return true if string s1 is permutation of string s2
     */
    private static boolean checkPermutation2(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        return sortString(s1).equals(sortString(s2));
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation1("abcde", "abc"));
        System.out.println(checkPermutation1("abcde", "eabdc"));
        System.out.println(checkPermutation1("", ""));

        System.out.println(checkPermutation2("abcde", "abc"));
        System.out.println(checkPermutation2("abcde", "eabdc"));
        System.out.println(checkPermutation2("", ""));
    }
}

package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 7/6/20
 */
public class IsUnique {

    /**
     * Using array of size 128 to keep track of visited character
     * TC; O(n)
     * AS: O(1) => array of size 128
     * @param s input string
     * @return true if input string has all unique character
     */
    private static boolean isUnique1(String s){
        if(s.length()>128){
            return false;
        }
        boolean[] visited = new boolean[128];
        for(int i=0;i<s.length();i++){
            int v = s.charAt(i);
            if(visited[v]){
                return false;
            }
            visited[v] = true;
        }
        return true;
    }

    /**
     * Assumption : all the character of string s is present in small font(i.e. a-z)
     * Better than approach1, further space complexity is reduced to a size of single int variable
     * Using bit vector checker to keep track of visited character
     * TC: O(n)
     * AS:: O(1)
     * @param s input string
     * @return true if input string has all unique character
     */
    private static boolean isUnique2(String s){
        // using each bit of variable checker as a flag for character a(0th bit) to z
        int checker = 0;
        for(int i=0;i<s.length();i++){
            int v = s.charAt(i) - 'a';
            if((checker & (1 << v)) > 0){
                return false;
            }
            checker |= (1 << v);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique1("abcde"));
        System.out.println(isUnique1("aba"));
        System.out.println(isUnique2("a"));
        System.out.println(isUnique2("aba"));
    }
}

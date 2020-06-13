package com.hashinclude.cci.arrayandstring;

import javax.annotation.PostConstruct;

/**
 * @author pushpanjay.kumar created on 9/6/20
 */
public class OneAway {

    private static int min(int x, int y, int z){
        if(x<=y && x<=z)
            return x;
        else if(y<=x && y<=z)
            return y;
        else
            return z;
    }

    /**
     * TC: O(m*n)
     * AS: O(m*n)
     * @param s1
     * @param s2
     * @return
     */
    private static int editDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                else if(j==0){
                    dp[i][j] = i;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    private static boolean isEditDistanceOne1(String s1, String s2){
        int editDistance = editDistance(s1, s2);
        System.out.println("editDistance : " + editDistance);
        return editDistance == 0 || editDistance == 1;
    }

    private static boolean isReplaceByOneDistance(String s1, String s2){
        boolean isReplaced = false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if (isReplaced)
                    return false;
                isReplaced = true;
            }
        }
        return true;
    }

    private static boolean isInsertByOneDistance(String s1, String s2){
        boolean isInserted = false;
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                if (isInserted)
                    return false;
                isInserted = true;
                j++;
            } else{
                i++;
                j++;
            }
        }
        return true;
    }

    private static boolean isEditDistanceOne2(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(m == n){
            return isReplaceByOneDistance(s1, s2);
        } else if(m+1 == n){
            return isInsertByOneDistance(s1, s2);
        } else if(n+1 == m){
            return isInsertByOneDistance(s2, s1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEditDistanceOne1("pale", "ple"));
        System.out.println(isEditDistanceOne1("hello", "hello"));
        System.out.println(isEditDistanceOne1("hello", "hallo"));
        System.out.println(isEditDistanceOne1("sunday", "saturday"));
        System.out.println(isEditDistanceOne1("sunday", "sundaya"));
        System.out.println(isEditDistanceOne1("sunday", "sunda"));
        System.out.println(isEditDistanceOne1("sunday", "sun"));
        System.out.println();
        System.out.println(isEditDistanceOne2("pale", "ple"));
        System.out.println(isEditDistanceOne2("hello", "hello"));
        System.out.println(isEditDistanceOne2("hello", "hallo"));
        System.out.println(isEditDistanceOne2("sunday", "saturday"));
        System.out.println(isEditDistanceOne2("sunday", "sundaya"));
        System.out.println(isEditDistanceOne2("sunday", "sunda"));
        System.out.println(isEditDistanceOne2("sunday", "sun"));
    }
}

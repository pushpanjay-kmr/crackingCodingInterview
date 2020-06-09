package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 9/6/20
 */
public class PalindromePermutation {

    private static int getCharacterNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(val>=a && val<=z){
            return val-a;
        }
        return -1;
    }

    private static int[] buildFrequencyTable(String s){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')+1];
        for(char c: s.toCharArray()){
            int v = getCharacterNumber(c);
            if(v != -1) {
                table[v]++;
            }

        }
        return table;
    }

    private static boolean checkMaxOneOdd(int[] freqTable){
        boolean oddCountFound = false;
        for(int f: freqTable){
            if(f%2!=0){
                if(oddCountFound){
                    return false;
                }
                oddCountFound = true;
            }
        }
        return true;
    }

    /**
     *
     * @param s
     * @return
     */
    private static boolean checkIfPermutationPalindrome1(String s){
        int[] freqTable = buildFrequencyTable(s);
        return checkMaxOneOdd(freqTable);
    }

    private static int buildBitVector(String s){
        int bitVector=0;
        for(char c: s.toCharArray()){
            int v = getCharacterNumber(c);
            if(v<0)
                continue;

            int x = 1<<v;
            if((bitVector & x) == 0){
                bitVector |= x;
            } else{
                bitVector &= ~x;
            }
        }
        return bitVector;
    }

    /**
     *
     * @param s
     * @return
     */
    private static boolean checkIfPermutationPalindrome2(String s){
        int bitVector = buildBitVector(s);
        return ((bitVector == 0) || (bitVector & bitVector-1) == 0);
    }

    public static void main(String[] args) {
        System.out.println(checkIfPermutationPalindrome1("aabbdccdd"));
        System.out.println(checkIfPermutationPalindrome2("aabcdd"));
    }
}

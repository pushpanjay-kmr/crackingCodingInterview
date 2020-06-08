package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 8/6/20
 */
public class URLify {

    private static void urlify(char[] charString, int trueLength){
        int spaceCount = 0;
        for(int i=0;i<trueLength;i++){
            if(' ' == charString[i]){
                spaceCount++;
            }
        }

        int last = trueLength - 1 + (spaceCount*2);

        for(int i=trueLength-1;i>=0;i--){
            if(' ' == charString[i]){
                charString[last--] = '0';
                charString[last--] = '2';
                charString[last--] = '%';
                continue;
            }
            charString[last--] = charString[i];
        }
    }

    public static void main(String[] args) {
        char[] charString = "Mr John Smith    ".toCharArray();
        System.out.println(charString);
        urlify(charString, 13);
        System.out.println(charString);
    }
}

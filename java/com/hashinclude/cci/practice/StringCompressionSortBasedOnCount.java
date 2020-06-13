package com.hashinclude.cci.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
// compress string and sort based on count of character in decreasing order
public class StringCompressionSortBasedOnCount {

    private static String compressString(String s){
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character v = s.charAt(i);
            countMap.put(v, countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(countMap.entrySet());
        Collections.sort(list, (a, b) ->{
            if(a.getValue()>b.getValue()){
                return -1;
            } else{
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list){
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaabbcACccadd"));
    }
}

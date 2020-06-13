package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
public class StringCompression {

    /**
     *
     * @param s
     * @return
     */
    private static String stringCompression1(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int count =0;
        for(int i=0;i<n;i++){
            if(i+1 <n && s.charAt(i+1)!=s.charAt(i)){
                sb.append(s.charAt(i)).append(count+1);
                count=0;
                continue;
            }
            count++;
        }
        if(count!=0){
            sb.append(s.charAt(n-1)).append(count);
        }
        if(s.length() <= sb.length()){
            return s;
        } else{
            return sb.toString();
        }
    }

    /**
     * Note: if it is case ki many character won't repeat, then its better to calculate length of compressed string first,
     * as when compressed length is greater ot equal then original string, we won't have to calculated the entire compressed
     * string
     */
    public static void main(String[] args) {
        System.out.println(stringCompression1("aabcccccaaaA"));
    }
}

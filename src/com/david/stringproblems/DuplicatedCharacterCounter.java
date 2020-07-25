package com.david.stringproblems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DuplicatedCharacterCounter {
    /**
     * Write a program that counts duplicate characters from a given string
     * */
    public  static  int countDuplicateCharactersV1(String str){

        String [] a = str.split("");
        HashMap<String, Integer> charMap= new HashMap<>();
        for(String i :  a){
            if(charMap.containsKey(i)){
                charMap.put(i, charMap.get(i) +1);
            }else{
                charMap.put(i, 1);
            }
        }
        System.out.println("HashMap :"+charMap);
        int counter = 0;
        for(String j: charMap.keySet()){
            if(charMap.get(j) >= 2) counter++;
        }
        System.out.println("Duplicated :"+counter);
        return counter;

    }
    public  static Map<Character, Integer> countDuplicateCharactersV2(String str){
        if(str == null || str.isEmpty()){
            return  Collections.emptyMap();
        }
        HashMap<Character, Integer>result= new HashMap<>();
        for(int i =0; i <  str.length();i++){
            char ch =  str.charAt(i);
            result.compute(ch, (k,v) -> (v==null)? 1: ++v);// compute(Key, BiFunction)
        }

        int counter = 0;
        for(char j: result.keySet()){
            if(result.get(j) >= 2) counter++;
        }
        System.out.println("Counter :"+counter);
        return result;

    }

}

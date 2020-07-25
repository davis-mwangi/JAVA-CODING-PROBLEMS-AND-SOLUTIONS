package com.david;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblems {

    /**
     * Write a program that counts duplicate characters from a given string
     * */
    public  static  int countDuplicateCharactersV1(String str){

       String [] a = str.split("");
       HashMap<String, Integer>charMap= new HashMap<>();
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


    /** Finding the first non-repeated character
     *  Write a program that returns the first non-repeated character from a given string.
     */
    public static Character findFirstNonRepeatedCharacterV1(String str){
        if(str ==  null || str.isEmpty()){
            return Character.MIN_VALUE;
        }
        Map<Character, Long>charMap =  new LinkedHashMap<>();
        for (Character ch:  str.toCharArray()){
            charMap.compute(ch, (k,v) -> (v ==null)? 1: ++v);
        }
        System.out.println("Char Map :"+charMap);
        Character  result = null;
        for(Character ch: charMap.keySet()){
            if(charMap.get(ch) ==1){
               return  ch;
            }
        }
        System.out.println("Result :"+result);
        return  Character.MIN_VALUE;
    }
        public static char findFirstNonRepeatedCharacterV2(String str) {

            if (str == null || str.isBlank()) {
                // or throw IllegalArgumentException
                return Character.MIN_VALUE;
            }

            Map<Integer, Long> chs = str.chars()
                    .mapToObj(cp -> cp)
                    .collect(Collectors.groupingBy(Function.identity(),
                            LinkedHashMap::new, Collectors.counting()));

            return (char) (int) chs.entrySet().stream()
                    .filter(e -> e.getValue() == 1L)
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse(Integer.valueOf(Character.MIN_VALUE));

    }
}

package com.david.stringproblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedStringCharacter {
    /** Finding the first non-repeated character
     *  Write a program that returns the first non-repeated character from a given string.
     */
    public static Character findFirstNonRepeatedCharacterV1(String str){
        if(str ==  null || str.isEmpty()){
            return Character.MIN_VALUE;
        }
        Map<Character, Long> charMap =  new LinkedHashMap<>();
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

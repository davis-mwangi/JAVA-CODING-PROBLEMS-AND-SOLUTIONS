package com.david.stringproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/** Write a program that reverses the letters of each word and a program that reverses the letters of
 * each word and the words themselves.
 */
public class ReverseLettersAndWords {
    private static final Pattern PATTERN = Pattern.compile(" +");
    private static final String WHITESPACE = " ";

    public static   String reverseWordLetters(String str){
        if(str ==  null || str.isEmpty()){
            return "";
        }
        String [] words =  str.split(" ");
        List<String> results = new ArrayList<>();

        for (int k = 0; k < words.length; k++){
           String reversedWord = swap(words[k]);
           results.add(reversedWord);
        }
        System.out.println("Strings :"+ results);
        return String.join(" ",results);
    }

    public static   String reverseLettersOfWordAndWordsV1(String str){
        if(str ==  null || str.isEmpty()){
            return "";
        }
        String [] words =  str.split(" ");
        String[]results =  new String[words.length];

        for (int k = 0; k < words.length; k++){
            String reveredWord = swap(words[k]);
            System.out.println("Reversed Word :"+reveredWord);
            results[k] = reveredWord;
        }
        System.out.println("Reversed letter words :"+ Arrays.asList(results));
        int len =  results.length;
        for(int i =0; i < len /2 ; i++){
            String temp =  results[i];
             results[i] = results[len - 1 -i ];
             results[len -1 -i] =  temp;
        }
        System.out.println("Reversed words :"+Arrays.toString(results));
        return String.join(" ",results);
    }

    public static String swap(String word){
        char []  charArr = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = charArr.length;
        //reverse chars of word
        for(int i = 0; i < len/2; i++){
            char temp = charArr[i];
            charArr[i] = charArr[len- 1 -i];
            charArr[len -1 -i] = temp;
        }
        return  sb.append(charArr).toString();
    }

    public static String reverseLettersOfWordAndWordsV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reversedString.append(reverseWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }
    public static String reverseLettersOfWordAndWordsV3(String str) {
        // or throw IllegalArgumentException
        if (str == null || str.isBlank()) {
            return "";
        }

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }




}

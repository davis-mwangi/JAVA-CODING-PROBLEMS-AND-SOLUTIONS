package com.david;

import com.david.stringproblems.DuplicatedCharacterCounter;
import com.david.stringproblems.FirstNonRepeatedStringCharacter;
import com.david.stringproblems.ReverseLettersAndWords;

public class Main {

    public static void main(String[] args) {
        //Counting duplicate characters
        String TEXT = "Be strong, be fearless, be beautiful. "
                + "And believe that anything is possible when you have the right "
                + "people there to support you. ";
        // Ӝ -> Unicode: \u04DC, Code Point: 1244
        // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
        // 🎼 -> \uD83C\uDFBC, Code Point: 127932
        // 😍 ->\uD83D\uDE0D, Code Point: 128525
        String TEXT_CP = TEXT +  "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";
//        System.out.println(DuplicatedCharacterCounter.countDuplicateCharactersV1(TEXT_CP));


        /** Finding the first non-repeated character*/
       String TEXT2 = "My high school, the Illinois Mathematics and Science Academy, "
                + "showed me that anything is possible and that you're never too young to think big. "
                + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
                + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
                + "computer science.";
//        System.out.println(FirstNonRepeatedStringCharacter.findFirstNonRepeatedCharacterV1(TEXT2));


        /** Reversing letters and words*/
        String TEXT3 = "mufia kamau call";
        System.out.println(ReverseLettersAndWords.reverseWordLetters(TEXT3));
    }
}

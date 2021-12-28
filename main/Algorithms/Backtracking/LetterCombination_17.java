package Backtracking;

import java.util.*;

public class LetterCombination_17 {
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        else{
            List<String> result = new ArrayList<>();
            char digit = digits.charAt(0);
            digits = digits.substring(1);
            List<String> tempResult = letterCombinations(digits);
            String letter_1, letter_2, letter_3, letter_4 = "";
            if(digit != 55 && digit != 56 && digit != 57){
                letter_1 = Character.toString((char)(digit * 3 -53));
                letter_2 = Character.toString((char)(digit * 3 -52));
                letter_3 = Character.toString((char)(digit * 3 -51));
            }
            else if(digit == 55){
                letter_1 = "p";
                letter_2 = "q";
                letter_3 = "r";
                letter_4 = "s";
            }else if(digit == 56){
                letter_1 = "t";
                letter_2 = "u";
                letter_3 = "v";
            }else{
                letter_1 = "w";
                letter_2 = "x";
                letter_3 = "y";
                letter_4 = "z";
            }

            if(!tempResult.isEmpty()){
                if(!letter_4.isEmpty()){
                    for(String s: tempResult){
                        result.add(letter_1 + s);
                        result.add(letter_2 + s);
                        result.add(letter_3 + s);
                        result.add(letter_4 + s);
                    }
                }else{
                    for(String s: tempResult){
                        result.add(letter_1 + s);
                        result.add(letter_2 + s);
                        result.add(letter_3 + s);

                    }
                }

            }else{
                result.add(letter_1);
                result.add(letter_2);
                result.add(letter_3);
                if(!letter_4.isEmpty()) result.add(letter_4);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("7"));
    }
}

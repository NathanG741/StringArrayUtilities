package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String word: array ){
            if (word.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseArray = new String[array.length];

        int reverseArrayIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[reverseArrayIndex] = array[i];
            reverseArrayIndex++;
        }

        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        // THIS WORKS GLADGE
        return Arrays.equals(array, reverse(array));

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabetArray = alphabet.split("");

        String string = String.join("", array).replaceAll("\\s", "");
        String[] stringArray = string.split("");

        for (String letter : alphabetArray) {
            if (!contains(stringArray, letter)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (String one : array) {
            if (one.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArray = new ArrayList<>();
        for (String one : array) {
            if (!one.equals(valueToRemove)) {
                newArray.add(one);
            }
        }
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>();
        newArray.add(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(newArray.get(newArray.size() - 1))) {
                // go to the next one
            } else if (i == array.length - 1) {
                newArray.add(array[i]);
            } else if (array[i].equals(array[i+1])) {
                newArray.add(array[i]);
                i++;
            }  else {
                newArray.add(array[i]);
            }
        }
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            StringBuilder dupes = new StringBuilder();
            dupes.append(array[i]);
            for (int i2 = i + 1; i2 < array.length; i2++) {
                if (array[i].equals(array[i2])) {
                    dupes.append(array[i2]);
                    if (i2 == array.length - 1) {
                        i = i2;
                        break;
                    }
                } else {
                    i = i2 - 1;
                    break;
                }
            }
            newArray.add(String.valueOf(dupes));
        }

        return newArray.toArray(new String[0]);
    }

// IM SORRY, THERES PROBABLY AN EASIER WAY. PLS DONT HATE.
}

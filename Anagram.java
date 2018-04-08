import java.util.HashMap;

public class Anagram {
    public static boolean checkAnagram (String s1, String s2) {
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        if (s1.length() != s2.length()) {
            return false;
        }
        int i;

        // make a hashmap out of chars in s1
        for (i = 0; i < s1.length(); i++) {
            Character curChar = s1.charAt(i);
            Integer curVal = charMap.get(curChar);
            if (curVal == null) {
                charMap.put(curChar, 1);
            } else {
                charMap.put(curChar, curVal + 1);
            }
        }

        // decrement values by the chars in s2
        for (i = 0; i < s1.length(); i++) {
            Character curChar = s2.charAt(i);
            Integer curVal = charMap.get(curChar);
            if (curVal == null) {
                // This means there's a letter in s2 that's not in s1. Return false immediately.
                return false;
            } else {
                charMap.put(curChar, curVal - 1);
            }
        }

        // All values of the hashmap must be zero
        for (char key : charMap.keySet()) {
            if (charMap.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main (String[] args) {
        String s1 = "aadabdbbdbc";
        String s2 = "ddabbaacbdb";
        String s3 = "adbbacbbbdd";
        System.out.println("The strings " + s1 + " and " + s2 + " are anagrams? " + checkAnagram(s1, s2));
        System.out.println("The strings " + s1 + " and " + s3 + " are anagrams? " + checkAnagram(s1, s3));
    }
}
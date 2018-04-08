package chapter_leetcode.hashtable;

import java.util.HashMap;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 *
 * @author yuanhao
 * @date 2018/4/8 20:58
 */
public class JewelsandStones771 {

    public static void main(String[] args) {
//        numJewelsInStones("aA", "aAAbbbb");
//        numJewelsInStones("z", "ZZ");
//        numJewelsInStones("z", "zZZ");

        numJewelsInStones2("aA", "aAAbbbb");
        numJewelsInStones2("z", "ZZ");
        numJewelsInStones2("z", "zZZ");
    }

    /**
     * 使用hashmap的时间复杂度为21ms
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character ch : S.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        for (Character ch : J.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                count += hashMap.get(ch);
            }
        }
        System.out.println(count);
        return count;
    }

    /**
     * 两个循环的时间复杂度为20ms或19ms
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones2(String J, String S) {
        int count = 0;
        for (Character cs : S.toCharArray()) {
            for (Character cj : J.toCharArray()) {
                if (cs == cj) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

}

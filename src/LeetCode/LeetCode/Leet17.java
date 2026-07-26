package LeetCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet17 {

    static void main() {
        System.out.println(new Solution().letterCombinations("43"));
    }

}

class Solution {
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(digits, 0, res, sb);
        return res;

    }

    public void backTrack(String digits, int i, List<String> res, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backTrack(digits, i + 1, res, sb);
            sb.deleteCharAt(i);
        }

    }
}

class Solution2 {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }

        numPad("", digits);
        return list;
    }

    String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public void numPad(String p, String up) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            numPad(p + ch, up.substring(1));
        }
    }
}
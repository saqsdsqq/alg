package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    //保持前几题一贯的格式， initialization
    static List<List<String>> res = new ArrayList<>();
    static List<String> cur = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return res;
    }
    private static void backtracking(String s, int start, StringBuilder sb){
        //因为是起始位置一个一个加的，所以结束时start一定等于s.length,因为进入backtracking时一定末尾也是回文，所以cur是满足条件的
        if (start == s.length()){
            //注意创建一个新的copy
            res.add(new ArrayList<>(cur));
            return;
        }
        //像前两题一样从前往后搜索，如果发现回文，进入backtracking,起始位置后移一位，循环结束照例移除cur的末位
        for (int i = start; i < s.length(); i++){
            sb.append(s.charAt(i));
                cur.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                cur.remove(cur.size() -1 );

        }
    }
//[[a, b, c, d], [a, b, cd], [a, bc, d], [a, bcd], [ab, c, d], [ab, cd], [abc, d], [abcd]]
//    [a, b, c, d, cd, bc, d, bcd, ab, c, d, cd, abc, d, abcd]
    public static void main(String[] args) {
        String s = "abcd";
        HashMap<Character,Integer> map=new HashMap<>();
        char[] charArray = s.toCharArray();
//        s.substring()
        List<List<String>> substrings = partition(s);
        System.out.println(substrings);  // 输出所有子串
    }

}
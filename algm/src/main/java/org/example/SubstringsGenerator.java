package org.example;

import java.util.ArrayList;
import java.util.List;

public class SubstringsGenerator {

    // 生成所有子串的函数
    public static List<String> generateSubstrings(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    // 回溯函数
    private static void backtrack(String s, int current, StringBuilder path, List<String> result) {
        // 如果当前路径非空，将其加入结果
        if (current == s.length()){


            return;
        }

        // 从当前字符开始扩展
        for (int i = current; i < s.length(); i++) {
           result.add(String.valueOf(path.append(s.charAt(i))));  // 做选择（添加当前字符到子串）
            backtrack(s, i + 1 , new StringBuilder(), result);  // 递归扩展下一字符
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> substrings = generateSubstrings(s);
        System.out.println(substrings);  // 输出所有子串
    }
}

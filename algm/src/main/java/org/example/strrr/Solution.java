package org.example.strrr;

class Solution {

    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        s = new String(reverseString(sb.toString().toCharArray(), 0, sb.length() - 1));
        System.out.println(s);
        // 3.反转各个单词
        int j = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                reverseString(charArray, j, i - 1);
                System.out.println(s);
                j = i + 1;
            }
            if (i == charArray.length - 1) {
                reverseString(charArray, j, charArray.length-1);
                j = i + 1;
            }
        }
        return charArray.toString();
    }

    private StringBuilder removeSpace(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ')
            start++;
        while (s.charAt(end) == ' ')
            end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || (c == ' ' && s.charAt(start - 1) != ' ' && start > 0)) {
                sb.append(c);
            }

            start++;
        }
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public char[] reverseString(char[] ch, int start, int end) {
        while (start < end) {

            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;
        }
        return ch;
    }

    public static void main(String[] args) {

        String a="the sky is blue";
        String s = new Solution().reverseWords(a);
    }

}
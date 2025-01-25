package org.example.window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

class minWindow {
    Map<Character, Integer> map = new HashMap();
    Map<Character, Integer> cnt = new HashMap();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            cnt.put(t.charAt(i), 0);
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                cnt.put(s.charAt(i), cnt.get(s.charAt(i) )+ 1);
            }
            while (check() && left <= i) {
                if(min>i-left+1){
                    min = Math.min(min, i - left + 1);
                    res = s.substring(left, i+1);
                }
                if (map.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left),cnt.get(s.charAt(left)) - 1);
                }
                left = left + 1;
            }

        }
        return res;
    }

    public boolean check() {
        Iterator it = cnt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value<map.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new minWindow().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
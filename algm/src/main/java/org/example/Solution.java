package org.example;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result; // 存放符合条件结果的集合
    private List<Integer> path; // 用来存放符合条件结果
    private int n=5;
    public void backtracking( int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 处理节点
            backtracking(k, i + 1); // 递归
            path.remove(path.size() - 1); // 回溯，撤销处理的节点
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(k, 1);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combinations = solution.combine(5, 3);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

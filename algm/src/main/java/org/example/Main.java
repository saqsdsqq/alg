package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        List<int[]> results = new ArrayList<>();



        /*
        1. 改为递归,只需要两个条件，层数，起始,从而得出递归样子
        backtracking(层数，起始){
            最里面的处理

        }
        2. 如果是一个链表的递归不用写for 树和图都是需要for的
        backtracking(层数，起始){
            每层for都会进行的处理哦
            for (){ //就是for的样子
                backtracking(层数，起始);
            }
        }
        3. 还有一些需要回溯的比如路径，因为递归不知道上一个方法的信息，不想循环处于一个调用栈方便，所以需要一个push，pop的操作
        backtracking(层数，起始){
            最里面的处理
            for (){ //就是for的样子
                处理
                backtracking(层数，起始);
                回溯
            }
        }
        * */
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int u = j + 1; u <= n; u++) {
                    results.add(new int[]{i, j, u});
                }
            }
        }

        for (int[] result : results) {
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
    }
}

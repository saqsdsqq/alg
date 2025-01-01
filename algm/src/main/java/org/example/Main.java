package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        List<int[]> results = new ArrayList<>();

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

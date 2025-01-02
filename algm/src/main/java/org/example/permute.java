package org.example;

import java.util.*;

public class permute {


    public static void main(String[] args) {
        int n = 5;
        List<int[]> results = new ArrayList<>();
        Set<Integer> add = new HashSet<>();

//        candidates.add(7);
        int[] candidates = new int[]{1, 1, 2};
        int len = candidates.length - 1;
        int[] used = new int[]{0, 0, 0};
        int target = 8;

        Arrays.sort(candidates);

        int sum = 0;
        for (int i = 0; i <= len; i++) {
            if (used[i] == 1 || (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0)) {
                continue;
            }
            used[i] = 1;
            for (int j = 0; j <= len; j++) {
                if (used[j] == 1 || (j > 0 && candidates[j] == candidates[j - 1] && used[j - 1] == 0)) {
                    continue;
                }
                used[j] = 1;
                for (int u = 0; u <= len; u++) {
                    if (used[u] == 1 || (u > 0 && candidates[u] == candidates[u - 1] && used[u - 1] == 0)) {
                        continue;
                    }
                    used[u] = 1;
                    results.add(new int[]{candidates[i], candidates[j], candidates[u]});
                    used[u] = 0;

                }
                used[j] = 0;

            }
            used[i] = 0;

        }
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}

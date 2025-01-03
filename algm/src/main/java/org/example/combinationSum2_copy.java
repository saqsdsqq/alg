package org.example;

import java.util.*;

public class combinationSum2_copy {


    public static void main(String[] args) {
        int n = 5;
        List<int[]> results = new ArrayList<>();
        Set<Integer> add = new HashSet<>();

//        candidates.add(7);
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int len = candidates.length - 1;

        int target = 8;

        Arrays.sort(candidates);

        int sum = 0;
        for (int i = 0; i <= len; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            if (sum == target) {
                results.add(new int[]{candidates[i]});
            }
            for (int j = i + 1; j <= len; j++) {
                if (j > i + 1 && candidates[j] == candidates[j - 1]) {
                    continue;
                }
                sum += candidates[j];
                if (sum == target) {
                    results.add(new int[]{candidates[i], candidates[j]});
                }
                for (int u = j + 1; u <= len; u++) {
                    if (u > j + 1 && candidates[u] == candidates[u - 1]) {
                        continue;
                    }
                    sum += candidates[u];
                    if (sum == target) {
                        results.add(new int[]{candidates[i], candidates[j], candidates[u]});
                    }
                    for (int k = u + 1; k <= len; k++) {
                        if (k > u + 1 && candidates[k] == candidates[k - 1]) {
                            continue;
                        }
                        sum += candidates[k];
                        if (sum == target) {
                            results.add(new int[]{candidates[i], candidates[j], candidates[u], candidates[k]});
                        }
                        sum -= candidates[k];
                    }
                    sum -= candidates[u];
                }
                sum -= candidates[j];
            }
            sum -= candidates[i];
        }
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}

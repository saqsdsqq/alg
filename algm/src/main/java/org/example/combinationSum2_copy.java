package org.example;

import java.util.*;

public class combinationSum2_copy {


    public static void main(String[] args) {
        int n = 5;
        List<int[]> results = new ArrayList<>();
        Set<Integer> add=new HashSet<>();
        List<Integer>  candidates = new ArrayList<>();
        candidates.add(10);
        candidates.add(1);
        candidates.add(2);
        candidates.add(7);
        candidates.add(6);
        candidates.add(1);
        candidates.add(5);
//        candidates.add(7);
        int len =candidates.size()-1;

        int  target=8;

        int sum=0;
        for (int i =0; i <= len; i++) {
            if (add.contains(candidates.get(i))){
                continue;
            }
            sum += candidates.get(i);
            add.add(candidates.get(i));
            if (sum == target) {
                results.add(new int[]{candidates.get(i)});
            }

            for (int j = i+1 ; j <= len; j++) {
                if (add.contains(candidates.get(j))){
                    continue;
                }
                sum += candidates.get(j);
                add.add(candidates.get(j));

                if (sum == target) {
                    results.add(new int[]{candidates.get(i), candidates.get(j)});
                }
                for (int u = j+1; u <= len; u++) {
                    if (add.contains(candidates.get(u))){
                        continue;
                    }
                    sum +=  candidates.get(u);
                    add.add(candidates.get(u));

                    if (sum == target) {
                        results.add(new int[]{candidates.get(i), candidates.get(j), candidates.get(u)});
                    }
                    for (int k = u+1; k <= len; k++) {
                        if (add.contains(candidates.get(k))){
                            continue;
                        }
                        sum +=  candidates.get(k);
                        add.add(candidates.get(k));
                        if (sum == target) {
                            results.add(new int[]{candidates.get(i), candidates.get(j),  candidates.get(u), candidates.get(k)});
                        }
                        add.remove(candidates.get(k));
                        sum -=  candidates.get(k);

                    }
                    add.remove(candidates.get(u));

                    sum -=  candidates.get(u);

                }
                add.remove(candidates.get(j));

                sum -= candidates.get(j);


            }
            add.remove(candidates.get(i));

            sum -= candidates.get(i);
        }
        for (int[] result : results) {
            // 使用 Arrays.toString() 方法将数组转换为字符串
            System.out.println(Arrays.toString(result));
        }
    }
}

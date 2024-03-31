package org.example.lab2;

public class SolutionWithDP implements Solution {
    @Override
    public int findLargestProduct(int m) {
        int[] dp = new int[m + 1];
        dp[1] = 1; // 边界情况

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }

        return dp[m];
    }
}

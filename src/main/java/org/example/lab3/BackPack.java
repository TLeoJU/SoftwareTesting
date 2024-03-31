package org.example.lab3;
public class BackPack {
    public int backPack(int W, int[] wt, int[] val) {
        int n = wt.length;
        if (W <= 0 || n < 1) {
            return 0;
        }
        int offset = 1000;
        int[][] K = new int[n + 1][2 * offset + W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = offset; w <= W + offset; w++) {
                if (i == 0 || w == offset)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w - offset)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W + offset];
    }
    public int max(int a, int b){
        return (a > b) ? a : b;
    }
}

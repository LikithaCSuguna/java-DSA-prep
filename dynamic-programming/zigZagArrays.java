/*

 Problem: ZigZag Arrays
 Platform: LeetCode
 Approach: Matrix Exponentiation + DP

 Time Complexity: O(m^3 * log n) 
 Space Complexity: O(m^2) 

 */


class Solution {
    static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = m * 2;
        long[][] trans = new long[size][size];
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < m; u++) {
                if (u == v) continue;
                if (u < v) {
                    trans[u * 2 + 1][v * 2 + 0] = 1;
                }
                if (u > v) {
                    trans[u * 2 + 0][v * 2 + 1] = 1;
                }
            }
        }
        long[] state = new long[size];
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < m; u++) {
                if (u == v) continue;
                if (u > v) state[u * 2 + 0]++;
                else       state[u * 2 + 1]++;
            }
        }
        long[][] poweredMatrix = matPow(trans, n - 2, size);
        long[] result = multiply(poweredMatrix, state, size);

        long ans = 0;
        for (long x : result) ans = (ans + x) % MOD;
        return (int) ans;
    }
    long[][] matMul(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++)
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }
    long[][] matPow(long[][] mat, long p, int size) {
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1; // identity
        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, mat, size);
            mat = matMul(mat, mat, size);
            p >>= 1;
        }
        return result;
    }
    long[] multiply(long[][] mat, long[] vec, int size) {
        long[] res = new long[size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                res[i] = (res[i] + mat[i][j] * vec[j]) % MOD;
        return res;
    }
}

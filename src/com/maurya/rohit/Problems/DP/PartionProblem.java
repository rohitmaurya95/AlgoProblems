package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class PartionProblem {

    public static boolean partition(int[] arr){
        final int N = arr.length;
        int sum = 0;
        for(int i=0; i<N; i++)
            sum+=arr[i];
        final int K = sum/2;
        if(sum%2==1)
            return false;

        boolean[][] dp = new boolean[N+1][K+1];

        // fill base cases.

        for (int i=0; i<=N; i++) dp[i][0] = false;

        for (int i=0; i<=K; i++) dp[0][i] = false;

        // empty array case
        dp[0][0] = true;

        for(int i=1; i<=N; i++){
            for (int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];                    // ignore last element.

                //check if feasible to use last element.
                if(j-arr[i-1]>=0)
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];    // use last element.
            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
//        int[] arr = {1, 5, 11, 5};
//        System.out.println(partition(arr));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = scanner.nextInt();
            if(partition(arr))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}

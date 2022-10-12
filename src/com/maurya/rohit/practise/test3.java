package com.maurya.rohit.practise;

public class test3 {

    public static int getCount(int[] num, int target){
        final int N = num.length;
        int[][] dp = new int[N+1][target+1];
        for (int i=0; i<=target; i++){
            dp[0][i] = 0;
        }

        for (int i=0; i<=N; i++){
            dp[i][0] = 1;
        }
        dp[0][0] = 1;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=target; j++){
                if(num[i-1]<=j){
                    dp[i][j] += dp[i-1][j-num[i-1]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[N][target];
    }


    /**
     * [      ...nth]
     *
     * sum  = n
     * sum-n
     * fun(n, sum) = fun(n-1, sum-n)  + fun(n-1, sum)
     *
     * 2^n
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 3};
        int sum = 6;
        System.out.println(getCount(num, sum));

    }

    public static int fun(int[] num,int n, int sum){
        if (n==0 && sum==0){
            return 1;
        } else if(n==0){
            return 0;
        } else if(sum==0){
            return 1;
        }
        int count = 0;
        if(num[n-1]<=sum){
            count += fun(num, n-1, sum-num[n-1]);
        }
        count+= fun(num, n-1, sum);
        return count;
    }
}

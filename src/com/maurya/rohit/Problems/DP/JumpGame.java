package com.maurya.rohit.Problems.DP;

public class JumpGame {
    /**
     *        1 ..........n-1, n
     *        f(n) = if i + c[i] && f[i]
     *        [2,3,1,1,4]
     *        dp[1, 1
     *        n=2
     */
//    public static boolean canJump(int[] nums) {
//        final int N = nums.length;
//        boolean[] dp = new boolean [N+1];
//        dp[0] = true;
//        dp[1] = true;
//        for (int n=2; n<=N; n++){
//            for (int i=1; i<n; i++){
//                if(dp[i] && (i + nums[i-1] >= n)){
//                    dp[n] = true;
//                    break;
//                }
//            }
//        }
//        return dp[N];
//    }

    // this can be solved greedily, try to go maximum distance from current, if blocked(reached 0), go to next best so on and so forth

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int last=n-1;
        int i;
        for(i=n-2;i>=0;i--){
            if(i+nums[i]>=last) last=i;
        }
        return last<=0;
    }

}

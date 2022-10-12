package com.maurya.rohit.Problems.DP;

public class CountLIS {
    /**
     * Its better to store state in multiple arrays than using a 2D dp array for code clarity.
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        final int N = nums.length;
        int[] len = new int[N];
        int[] count = new int[N];
        int maxCount = 0;
        int maxLength = 0;
        for (int i=0; i<N; i++){
            len[i] = 1;
            count[i] = 1;
            for (int j=0; j<i; j++){
                if(nums[i]>nums[j]) {
                    if(len[i] == len[j] + 1) count[i]+=count[j];
                    if(len[i] < len[j]+1){
                        len[i] = len[j]+1;
                        count[i] = count[j];
                    }
                }
            }
            if(len[i]==maxLength) maxCount+=count[i];
            if(len[i]>maxLength) {
                maxLength = len[i];
                maxCount = count[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] num = {1, 1};
        System.out.println(findNumberOfLIS(num));
    }
}

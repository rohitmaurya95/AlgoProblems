package com.maurya.rohit.Problems.Misc;

import java.util.Random;

public class ParadeInHackerLand {
    public static int fun(String s){
        char[] chars = s.toCharArray();
        final int N = chars.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        if(N>=2){
            if(chars[0]=='0' && chars[1]=='1'){
                dp[2] = 1;
            } else {
                dp[2] = 0;
            }
        }

        for (int i=3; i<=N; i++){
            if(chars[i-1]=='1'){
                int n = i-2;
                int count = 0;
                while (n > 0 && chars[n]=='0'){
                    count++;
                    n--;
                }
                dp[i] = dp[i-1] + (count>0 ? count:1);
            } else {
                dp[i] = dp[i-1];
            }
        }

        return dp[N];
    }
    private static void fun2(String s, int[] count) {
        String s1 = s.replaceAll("01", "10");
        if (!s1.equals(s)) {
            int c = count[0];
            count[0] = ++c;
            fun2(s1, count);
        }

    }

    public static int getSwapTime(String s) {

        /*
         * Array is easier to process.
         */
        char arr[] = s.toCharArray();

        int iterations = 0;
        boolean replacementDone = false;

        while(true) {

            replacementDone = false;

            for(int i = 0; i < s.length() - 1; i++) {

                if((arr[i] == '0') && (arr[i + 1] == '1')) {

                    replacementDone = true;
                    /*
                     * We make the replacement
                     */
                    arr[i] = '1';
                    arr[i + 1] = '0';

                    /*
                     * Also, we do an additional increment to the index.
                     */
                    i++;
                }
            }

            if(replacementDone == true) {
                iterations++;
            } else {

                /*
                 * We are done.
                 */
                return iterations;
            }
        }
    }

    public static void main(String[] args) {
        int N = 200;
        Random random = new Random();
        for (int i=0; i<N; i++){
            int n = random.nextInt(100);
           String s = Integer.toBinaryString(n);
           int[] count = new int[1];
           fun2(s, count);
            int a = getSwapTime(s);
            int b = count[0];
            if(a!=b) {
                System.out.println("String: " + s + "   fun: " + a + " fun2: " + b);
            }
           // System.out.println( "fun: " + fun(s) + " fun2: " + count[0]);
        }
    }
}

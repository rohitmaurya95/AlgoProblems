package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MaxPathSum {

    private static int maxPathSumHelper(TreeNode A) {
        if (A == null)
            return 0;

        int sumL = Math.max(maxPathSumHelper(A.left), 0);
        int sumR = Math.max(maxPathSumHelper(A.right), 0);
        return A.val + Math.max(sumL, sumR);
    }

    public static int maxPathSum(TreeNode A) {
        if (A == null)
            return Integer.MIN_VALUE;
        int sumL = maxPathSum(A.left);
        int sumR = maxPathSum(A.right);
        int lLeg = Math.max(maxPathSumHelper(A.left), 0);
        int rLeg = Math.max(maxPathSumHelper(A.right), 0);
        return Math.max( A.val + lLeg + rLeg,
                Math.max(sumL, sumR));
    }

    public static String getHash(){
       String input = "hello moto";
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String udrs = "disbursed";
        int offset = 1000;
        int limit = 100;
        String sql = String.format("select c.* from\n" +
                "\t(select `loan_application_no` from loan_application where user_data_review_status='%s' and partner_bank_id_ref=8 limit %d, %d) AS la\n" +
                "\tjoin clix_application c on la.`loan_application_no` = c.`loan_application_no`;", udrs, offset, limit);
        System.out.println(sql);

    }

}


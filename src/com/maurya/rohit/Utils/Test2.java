package com.maurya.rohit.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
You have Rs100 in your pocket and you are in a grocery store.
There are following products to choose from
20rs apple
80rs apple
10rs banana
90rs mango
10rs mango
70rs orange
80rs kiwi

Find all combinations of products that you can buy for money exactly in your pocket without duplicating any product in a single combination.
 */
public class Test2 {
    public static List<List<String>> getCombination(String[] product, int[] price, int amount){
        Set<List<String>> comb = new HashSet<>();
        Set<String> basket = new HashSet<>();
        dfs(0, amount, product, price, basket, comb);
        return new ArrayList<>(comb);
    }

    public static void dfs(int idx, int amount, String[] product, int[] price, Set<String> basket, Set<List<String>> comb){
        if(amount==0){
            comb.add(new ArrayList<>(basket));
            return;
        }
        if(idx>price.length-1){
            return;
        }
        if(!basket.contains(product[idx]) && amount>=price[idx]){
            basket.add(product[idx]);
            dfs(idx+1, amount-price[idx], product, price, basket, comb);
            basket.remove(product[idx]);
        }
        dfs(idx+1, amount, product, price, basket, comb);
    }

    public static void main(String[] args) {
        String[] product = {"Apple", "Apple", "banana", "mango", "mango", "orange", "kiwi" };
        int[] price = {20, 80, 10, 90, 10, 70, 80};
        int amount = 100;
        List<List<String>> comb = getCombination(product, price, amount);
        System.out.println(comb);
    }


}

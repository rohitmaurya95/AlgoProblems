package com.maurya.rohit.Problems.BinarySearch;

public class FindRange {
//    public static int[] searchRange(final int[] arr, int k) {
//
//        int low = binarySearch(arr, k);
//        if(low==-1){
//            int[] res = {-1,-1};
//            return res;
//        }
//        int high = low;
//
//        while (high <arr.length  && arr[high]==k){
//            high++;
//        }
//        int[] res = {low, high-1};
//        return res;
//    }
//
//    public static int binarySearch(int[] arr, int k){
//        int low = 0;
//        int high = arr.length -1;
//        while (low<high){
//            int mid = low + (high-low)/2;
//            if(arr[mid] >= k){
//                high = mid;
//            }else {
//                low = mid + 1;
//            }
//        }
//        return arr[low] == k ? low:-1;
//    }

        public static int[] searchRange(final int[] arr, int k) {

        int[] res = {getFirstIndex(arr, k), getLastIndex(arr, k)};
        return res;
    }

    public static  int getFirstIndex(int[] arr, int k){
        int low = 0;
        int high = arr.length -1;
        while (low<high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= k){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return arr[low] == k ? low:-1;


    }

    public static int getLastIndex(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        if( k >= arr[high]) return high;
        if( k < arr[low]) return -1;

        while (low < high) {
            int mid = low + (high - low+1) / 2;
            if (arr[mid] > k) {
                high = mid-1;
            } else {
                low = mid;
            }
        }
        return arr[low] == k ? low : -1;

    }



    public static void main(String[] args) {
        int[] arr = {4, 7, 7, 7, 8, 10, 10};

        System.out.println(getLastIndex(arr, 7));
    }
}

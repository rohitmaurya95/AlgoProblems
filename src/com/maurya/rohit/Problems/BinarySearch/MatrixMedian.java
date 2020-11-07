package com.maurya.rohit.Problems.BinarySearch;

import java.util.Arrays;

public class MatrixMedian {
    public static int findMedian(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int low = 1;// Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;// Integer.MIN_VALUE;

//        for(int i=0; i<M ; i++)
//        {
//
//            // Finding the minimum element
//            if(matrix[i][0] < low)
//                low = matrix[i][0];
//
//            // Finding the maximum element
//            if(matrix[i][N-1] > high)
//                high = matrix[i][N-1];
//        }

        int k = (M*N)/2;

        while (low < high){
            int mid = low + (high- low)/2;
            int positionInOrder = getPosition(matrix,  M, N, mid);
            if(positionInOrder > k){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    static int getPosition(int[][] matrix ,int M, int N, int number){
        int k = 0;
        for (int i=0; i<M; i++){
            k = k + getPosition(matrix[i], N, number);
        }
        return k;
    }

    /**
     * Predicate: minimum index of element greater or equal than k
     */
    static int getPosition(int[] arr, int N, int k){
        int low = 0;
        int high = N-1;
        if(arr[high] <= k) return N;
        while (low<high){
            int mid = low + (high-low)/2;
            if(arr[mid] > k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;  // return number of elements less than k in the array.
    }

    static int binaryMedian(int m[][],int r, int c)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<r ; i++)
        {

            // Finding the minimum element
            if(m[i][0] < min)
                min = m[i][0];

            // Finding the maximum element
            if(m[i][c-1] > max)
                max = m[i][c-1];
        }

        int desired = (r * c + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            // Find count of elements smaller than mid
            for(int i = 0; i < r; ++i)
            {

                get = Arrays.binarySearch(m[i],mid);

                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;

                    // If element is found in the array it returns
                    // the index(any index in case of duplicate). So we go to last
                    // index of element which will give  the number of
                    // elements smaller than the number including
                    // the searched element.
                else
                {
                    while(get < m[i].length && m[i][get] == mid)
                        get += 1;
                }

                place = place + get;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void main(String[] args) {
        int [][] arr = {{1 ,2 ,3 ,3 ,3 ,5 ,6 ,9 ,9 ,9 ,9}};
        System.out.println(findMedian(arr));
       // System.out.println( binaryMedian(arr, 3, 3));
    }
}

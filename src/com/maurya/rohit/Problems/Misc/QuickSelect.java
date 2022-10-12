class Solution {
    public static int findKthLargest(int[] nums, int k) {
        int l=0;
        int idx = nums.length-k;
        int r=nums.length-1;
        while (l<r){
            int p = partion(nums, l, r);
            if(p==idx){
                return nums[p];
            } else if(p>idx){
                r = p-1;
            } else {
                l = p+1;
            }
        }
        return nums[l];
    }

    static int partion(int[] nums, int l, int r){
        int pivot = r;
        int m = l;
        for (int i=l; i<r; i++){
            if(nums[i]<=nums[r]){
                swap(nums, i, m);
                m++;
            }
        }
        swap(nums, m, pivot);
        return m;
    }
    public static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
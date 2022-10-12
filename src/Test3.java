public class Test3 {



    // [2,1,3,5,6,2,8]
    public static int getProfit(int[] prices){
        int hold = prices[0];
        int profit = 0;
        for (int i=0; i<prices.length-1; i++){
            if(prices[i+1]<prices[i]){
                profit+= prices[i]-hold;
                hold = prices[i+1];
                //System.out.println(hold);
            }
        }
        if(hold>=0){
            profit+= prices[prices.length-1]-hold;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,0,1};
        System.out.println(getProfit(arr));
    }


}

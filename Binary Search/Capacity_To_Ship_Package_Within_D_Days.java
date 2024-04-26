
// Capacity to ship package within 'D' days

/*
Given an array of weights and no. of days
We have to ship all the weights within 'D' days.
Find the least weight capacity using which we can ship all the weight within 'D' days

Example -

Input -> weights = [1,2,3,4,5,6,7,8,9,10] & days = 5
Output -> 15
Explanation -

1st day: 1,2,3,4,5
2nd day: 6,7
3rd day: 8
4th day: 9
5th day: 10

A ship capacity of '15' is the minimum to ship all the packages in 5 days.
*/

/*
Approach -

We'll apply binary search on answer concept b/c we know the range of the answer and question is asking for smallest
divisor

What will be the Range - [max(arr),sum(arr)]

Min capacity will be the max element of the array so that we can ship it. Example -

Weights = [1,2,3,1,1]. If capacity will be 2 then we won't be able to ship weight '3'

Max capacity will be that we can ship all the weights in one day


Now, apply BS on this range and find the smallest divisor.
*/

class Capacity_To_Ship_Package_Within_D_Days {

    public static int shipWithinDays(int[] weights, int days) {

        /*Minimum weight capacity of ship will be max(weights) & max can be all weight shipped in one day*/
        int start = max(weights);
        int end = sumWeights(weights);

        int res = 0;

        while(start <= end){

               int mid = start + ((end-start)/2);

            if(reqDaysWithThisCapacity(weights,mid,days) == 1){
                res = mid;
                end = mid-1; // We've to find minimum capacity so continue finding on left
            }

            else if(reqDaysWithThisCapacity(weights,mid,days) == 2){
                start = mid+1; // Increase the Capacity
            }

            else if(reqDaysWithThisCapacity(weights,mid,days) == 3){
                res = mid;
                end = mid-1; // We've to find minimum capacity so continue finding on left
            }
        }
      return res;
    }
    // This function will find the max in the given weight
    public static int max(int weights[]){

        int maximum = Integer.MIN_VALUE;

        for(int i=0; i<weights.length; i++)
          maximum = Math.max(maximum,weights[i]);

       return maximum;
    }
    // This function will find the sum of all elements
    public static int sumWeights(int weights[]){

        int sum = 0;

        for(int i=0; i<weights.length; i++)
          sum += weights[i];

       return sum;   
    }

    public static int reqDaysWithThisCapacity(int weights[], int mid, int days){

        /* If Required Days == Given Days -> Return 1
           If Required Days > Given Days -> Return 2
           If Required Days < Given Days -> Return 3
        */

        int reqDay = 1;
        int capacity = mid;
        int load = 0;

        for(int i=0; i<weights.length; i++){

            if(load + weights[i] > capacity){
                reqDay += 1;
                load = weights[i]; // New day, new load   
            }
            else{
                load += weights[i];    
            }

            // At any case is req. day > the target day return 
            if(reqDay > days)
              return 2;
        }

        if(reqDay == days)
          return 1;
        if(reqDay < days)
          return 3;

       return -1;   
    }

    public static void main(String[] args) {
        int weights[] = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    } 
}
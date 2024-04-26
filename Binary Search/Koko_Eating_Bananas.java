
// Koko Eating Bananas

/*
Given an array of piles of bananas and a time in which Koko has to finish all the piles of bananas.
Return the minimum speed of Koko eating bananas, so that she can complete all the piles of bananas within given time

Note - 

(1) Koko will have to finish the current pile first, then move f/w
(2) For an example, if Koko finished eating one pile of bananas in 1.5 hours , it will be considered as '2' hours

Example - 

Input -> [3,6,7,11] & time = 8 hours
Output -> 4
Explanation -

If the speed is 4 bananas/hr then -

piles[0] -> 3/4 = 1
piles[1] -> 6/4 = 2
piles[2] -> 7/4 = 1
piles[3] -> 11/4 = 3

Sum of the total time taken is '8'.
*/

/*
Approach -

We'll apply binary search on answer concept b/c we know the range of the answer and question is asking for min speed
*/

class Koko_Eating_Bananas {

    public static int minEatingSpeed(int[] piles, int h) {

        /* The maximum bananas that koko can eat in one hour is the max bananas
        in all of the piles and min is 1 banana per hour*/

        int start = 1;
        int end = max(piles); 
        int ans = 1;

        while(start <= end){

               int mid = start + ((end-start)/2);

            if(calculateHour(piles,mid) == h){
                ans = mid;
                end = mid - 1; // We've to find minimum so continue finding on left
            }

            else if(calculateHour(piles,mid) > h){ 
                start = mid + 1; // Have to increase the speed. Eat more bananas
            }

            else if(calculateHour(piles,mid) < h){
                ans = mid;
                end = mid - 1; // We've to find minimum so continue finding on left
            }
        }

      return ans;  
    }

    // Function will return the max bananas in all of the piles
    public static int max(int piles[]){

        int maximum = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++){
            maximum = Math.max(maximum,piles[i]);
        }
       return maximum; 
    }

    // This function will calculate time taken in hr, if the speed if mid bananas/hr
    public static int calculateHour(int piles[], int mid){

        int time = 0;

        for(int i=0; i<piles.length; i++){
            double t = (double) piles[i] / (double) mid;
            time += Math.ceil(t);
        }
       return time; 
    }

    public static void main(String[] args) {
        
        int piles[] = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
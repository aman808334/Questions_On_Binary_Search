
// Aggressive Cows


/*
Given an unsorted array of stalls & no. of cows
We have to place all the cows such that minimum distance b/w any two cows is the maximum

Example -

Input -> stalls = [1 2 4 8 9] & cows = 3
Output -> 3
*/

/*
Approach -

(1) We need to find Max(Min) so apply BS.
(2) If we sort the given array then minimum distance b/w any two cows will be b/w any two neighbours.
(3) What will the range -

Minimum distance b/w cows can be '1'
Maximum distance b/w cows can be maximum dis b/w any two cows & if array is sorted then in will be b/w 
two extreme positions
        
So, range = [1,(arr[length-1]-arr[0])]
*/

import java.util.Arrays;

class Aggressive_Cows {

     public static int solve(int stalls[], int k) {
        
        // Sort the given array
        Arrays.sort(stalls);
        
        int start = 1;
        int end = stalls[stalls.length-1]-stalls[0];
        
        int max = -1; // If we can't place then, will return '-1'
        
        while(start <= end){
            
               int mid = start + ((end-start)/2);
               
            if(canPlace(stalls,mid,k)){
                max = mid;
                start = mid+1; // We are searching for maximum, so continue on right
            }
            
            else if(!canPlace(stalls,mid,k))
                end = mid-1;      
        }
        
      return max;    
    }
    
    // This function will say that can be place all the cows keeping minimum distance as "mid"
    public static boolean canPlace(int stalls[], int mid,int k) {
         
        // First cow will always be placed at 1st position
        int cowsplaced = 1;
        int lastposition = stalls[0];
        
        for(int i=0; i<stalls.length; i++){
            
            if(stalls[i]-lastposition >= mid){ // Place a cow
              cowsplaced++;
              lastposition = stalls[i];
            }
            
            if(cowsplaced == k) // If be the placed all the given cows, then return true
              return true;
        }
        
      return false;
    }

    public static void main(String[] args) {
        int stalls[] = {1,2,4,8,9};
        int k = 3; // Number of Cows
        System.out.println(solve(stalls, k));
    } 
}
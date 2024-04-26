
// Minimum number of Days to Make 'M' Bouquets

/*
Given an array of blooming times of the flowers(in days).
Given size of each bouquets 'k'
Given required number of bouquets 'm'

Note -> To make a bouquet, we need to use 'k' adjacent flowers.
*/

/*
Example -

Input -> bloomDay = [7,7,7,7,12,7,7], m = 2 & k = 3
Output -> 12
*/

/*
Approach -

We'll apply binary search on answer concept b/c we know the range of the answer and question is asking for min days

What will be the Range -

Our answer will be in the range from the day in which at least one of the flowers will bloom to the day in which all
of the flowers will bloom.

So, will find min & max from given array

Now, apply BS on this range and find the min days.
*/

class Min_Days_To_Make_M_Bouquets {

public static int minDays(int[] bloomDay, int m, int k) {

    // If total flower is less that the no. of flower required to make 'm' bouquet
    long totalflowerreq = (long) m*k; // "long", to prevent "Not in Range" error (m*k can we too big to store in int)
    if(bloomDay.length < totalflowerreq)
      return -1;

    int arr[] = minMax(bloomDay); // Min will be arr[0] & Max will be arr[1]

    int start = arr[0]; // Day in which at least one of the flowers will bloom
    int end = arr[1]; // Day in which all of the flowers will bloom

    int res = 0;

    while(start <= end){

        int mid = start + ((end-start)/2);

        if(noOfBouquetsPossible(bloomDay,mid,k) == m){ // k = size of each bouquet
           res = mid;
           end = mid-1; // We've to find minimum so continue finding on left
        }

        else if(noOfBouquetsPossible(bloomDay,mid,k) < m) { // No. of bouquets formed is less than req
           start = mid+1;
        }

        else if(noOfBouquetsPossible(bloomDay,mid,k) > m) { 
           res = mid;
           end = mid-1; // We've to find minimum so continue finding on left
        }
    }

  return res;
}

// This function will return min & max in the bloomDay array
public static int[] minMax(int bloomDay[]){

    int res[] = new int[2];

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for(int i=0; i<bloomDay.length; i++){
        max = Math.max(max,bloomDay[i]);
        min = Math.min(min,bloomDay[i]);
    }

    res[0] = min;
    res[1] = max;

  return res;
}

 // This function will return number of bouquets(of size 'k') that make be formed on midth day
 public static int noOfBouquetsPossible(int bloomDay[], int mid, int k){

    int bouquets = 0;
    int count = 0;

    for(int i=0; i<bloomDay.length; i++){

        if(bloomDay[i] <= mid){
          count++;
        }
        else{
          bouquets += count/k; 
          count = 0;
          // B/c we want 'k' adjacent flowers
        }  
    }
    // At last count can be > 0
    bouquets += count/k;

   return bouquets;
}

public static void main(String[] args) {
    int bloomDay[] = {7,7,7,7,12,7,7};
    int k = 3;
    int m = 2;
    System.out.println(minDays(bloomDay, m, k));
}   
}
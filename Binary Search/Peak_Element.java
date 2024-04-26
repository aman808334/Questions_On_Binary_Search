
// Peak Element in an array

/*
Given an unsorted array which can contain one or multiple peak elements. Return any one of the peak elements.

An element is said to be a peak element if it is greater than both of its neighbours.

Note - 

(1) For extreme elements there will only be one neighbour.
(2) arr [i] != arr[i-1] i.e two neighbours can't be same
*/

/*
Example - 

Input -> [5,10,20,15]
Output -> 20
*/

/*
Approach -

Given array is unsorted but we can use BS b/c it is sorted in parts.

Example - 

Array = [5,10,20,15,10,24,19]

The part (5,10,20) is sorted in asc. order
The part (20,15,10) is sorted in des. order.
The part (10,24) is sorted in asc. order.
The part (24,19) is sorted in des. order
*/

class Peak_Element {

    public static int findPeak(int arr[]){

        // If array has only one elements then that one element will be peak
        if(arr.length == 0)
          return arr[0];

        // Checking that extreme elements are peak or not
        if(arr[0]>arr[1])
          return arr[0];

        if(arr[arr.length-1]>arr[arr.length-2])
          return arr[arr.length-1];

        // Now will apply BS on arr[1] to arr[arr.length-2]. B/c we have checked for extreme elements
        int start = 0;
        int end = arr.length - 2;
        
        while (start <= end) {

            int mid = start + ((end-start)/2);

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
              return arr[mid];

            else if(arr[mid] > arr[mid-1])
              start = mid + 1;

            else if(arr[mid] > arr[mid+1])
              end = mid - 1;

            else  // To handle [1,5,1,2,1] type of TC
              end = mid - 1; // We could write start = mid+1. In both directions we will get the peak. 


            /* 
             We have written the code considering that given array has only one peak element this code will work for
             the array which has multiple peak elements but we have to handle one edge case.

             Example -

             Array = [1,5,1,2,1].

             In this case our code will get into an infinite loop. So, add one "else" condition.
            */    
        }

       return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,5,1,2,1};
        System.out.println(findPeak(arr));
    } 
}

// Kth Missing Positive Number

/*
Given an sorted array of monotonically increasing +ve no. & a number 'k'
Find the kth +ve number that is missing from the array.

Example - 

Input -> Array = [2,3,4,7,11] & k = 5
Output -> 9
Explanation - 

Correct Sequence(Without missing any element) = [1,2,3,4,5,6,7,8,9,10]
1st missing element -> 1
2nd missing element -> 5
3rd missing element -> 6
4th missing element -> 9
5th missing element -> 9
*/

// Approach - Given array is sorted. So apply BS

class Kth_Missing_Positive_Number {

    public static int findKthPositive(int[] arr, int k) {

        int start = 0;
        int end = arr.length-1;

        while(start <= end){

              int mid = start + ((end-start)/2);

            if((arr[mid]-mid-1) == k)
               end = mid-1; // Continue on the left

               /*
               Example [11,12,12,14,16,17,18,19,20,----] & k = 11

               Currently mid = 8(on 20). So, ((arr[mid]-mid-1) == k) till 20 '11' nos. are missing
               But how to find that '15' is missing. We can't develop any formula. We've to iterate
               a loop & find. So better continue finding on the left and at last start & end will point
               to the neighbours.
               */

            else if((arr[mid]-mid-1) < k)
               start = mid+1;

            else if((arr[mid]-mid-1) > k)
               end = mid-1;        
        }

        /*
        If (arr[mid]-mid-1 == k) isn't found thenat last start & end will point to neighbours of answer.

        Example - 

        Input -> Array = [2,3,4,7,11] & k = 5
        Output -> 9

        Couldn't find (arr[mid]-mid-1 == k) so at last start & end will point to neighbour of '9'
        (start will point to '11' & end will point to '7')
        
        So answer will be (end+k+1) or (start+k)
        */

      return start+k;     
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }  
}

// Find the smallest divisor given a threshold

/*
Given an array of integers and a threshold.
Find the smallest divisor such that the result is less than or equal to threshold.

Note - For an example, if num/divisor in 1.5 , it will be considered as '2'
*/

/*
Example - 

Input -> array = [1,2,5,9] & threshold = 6
Output -> 5
Explanation - 

arr[0] -> 1/5 = 1
arr[1] -> 2/5 = 1
arr[2] -> 5/5 = 1
arr[3] -> 9/5 = 2

The sum of all this will be '5' & this is the smallest divisor by which (sum<=threshold)
*/

/*
Approach -

We'll apply binary search on answer concept b/c we know the range of the answer and question is asking for smallest
divisor

What will be the Range - [1, max(arr)] 

Now, apply BS on this range and find the smallest divisor.
*/

class Find_Smallest_Divisor_Given_Threshold {

    public static int smallestDivisor(int[] arr, int threshold) {

        int start = 0;
        int end = max(arr);

        int ans = 0;

        while(start <= end){

            int mid = start + ((end-start)/2);

            if(calculate(arr,mid) == threshold){
                ans = mid;
                end = mid-1; // We've to find smallest so continue finding on left
            }

            else if(calculate(arr,mid) > threshold){
                start = mid+1;
            }

            else if(calculate(arr,mid) < threshold){
                ans = mid;
                end = mid-1; // We've to find smallest so continue finding on left
            }
        }
      return ans; 
    }

    // This function will return the maximum in the given array
    public static int max(int arr[]) {
        
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++)
            max = Math.max(max,arr[i]);

      return max;
    }
    /*  This function will divide all the numbers of array with the mid and return the sum of result of all these
    divide operation */
    public static int calculate(int arr[], int mid){

        int sum = 0;

        for(int i=0; i<arr.length; i++){
            double d = (double) arr[i] / (double) mid;
            sum += Math.ceil(d);
        }
       return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(arr, threshold));
    } 
}
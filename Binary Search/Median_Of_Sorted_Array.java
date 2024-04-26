
// Median of Two Sorted Array

/*
Example - 

Input -> arr1 = [1,2] & arr2 = [3,4]
Output -> 2.5
*/

/*
Approach - 

Sorted arrays are given. So apply BS
We'll apply BS on smaller array for better TC
*/

class Median_Of_Sorted_Array {

    public static double median(int arr1[], int arr2[]) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1>n2)
          return median(arr2,arr1); // Want arr1 to be smaller in size

        int n = n1 + n2;
        int left = (n+1)/2; // Number of elements in left part

        // Range will be [0 elements of arr1 in left part, all the elements of all arr1 in left part]
        int start = 0; 
        int end = n1;

        while(start <= end){

            int mid1 = start + ((end-start)/2); 
            int mid2 = left - mid1;

            // Now assign l1,l2,r1 & r2
            int l1 = Integer.MIN_VALUE; // B/c if l1 isn't there than no problem in comparison
            int l2 = Integer.MIN_VALUE; // B/c if l2 isn't there than no problem in comparison
            int r1 = Integer.MAX_VALUE; // B/c if r1 isn't there than no problem in comparison
            int r2 = Integer.MAX_VALUE; // B/c if r2 isn't there than no problem in comparison
            
            // If position is present then only assign

            if(mid1 < n1)
              r1 = arr1[mid1];

            if(mid2 < n2)
              r2 = arr2[mid2];

            if(mid1-1 >= 0)
              l1 = arr1[mid1-1];

            if(mid2-1 >= 0)
              l2 = arr2[mid2-1];

            // Now Checking

            if(l1<=r2 && l2<=r1){ // Median condition
              
              if((n&1) == 0) // Even
                return (double) (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
              else // Odd
                return  (double) Math.max(l1,l2);  
            }

            else if(l1>r2)
              end = mid1-1;

            else if(l2>r1)
              start = mid1+1;
        }
       return 0;    
    }

    public static void main(String[] args) {
        int arr1[] = {1,2};
        int arr2[] = {3,4};
        System.out.println(median(arr1, arr2));
    }  
}
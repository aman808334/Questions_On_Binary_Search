
// Kth Element of two Sorted Arrays

/*
Example - 

Input -> arr1 = [10,20], arr2= [15,30,40,50,60] & k = 6
Output -> 50 ([10,15,20,30,40,50,60])
*/

/*
Approach - 

. Will apply the same concept as the median of two sorted arrays
. The number of elements on left part will be equal to 'k' & required kth element will be max(left part)
. What will be the Range -

Example - arr1 = [a,b], arr2 = [c,d,e,f] & k = 5

So, we need to take at least one element from arr1 to make 'k' elements on the left.
Therefore, start = max(0,k-arr2.length)

Example - arr1 = [a,b,c], arr2 = [d,e,f,g] & k = 2

So, we can take at most two elements from arr1
Therefore, end = min(arr1.length,k) 
*/

class Kth_Element_Of_Two_Sorted_Arrays {

    public static long kthElement(int arr1[], int arr2[], int n1, int n2, int k) {

        if(n1>n2)
          return kthElement(arr2,arr1,n2,n1,k); // Want arr1 to be smaller in size

        int left = k; // Number of elements in left part

        // Range will be [0 elements of arr1 in left part, all the elements of all arr1 in left part]
        int start = Math.max(0,k-n2); 
        int end = Math.min(n1,k);

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

            if(l1<=r2 && l2<=r1) // Kth Element Condition
              return (long) Math.max(l1,l2);  
            
            else if(l1>r2)
              end = mid1-1;

            else if(l2>r1)
              start = mid1+1;
        }
       return 0L;      
    }

    public static void main(String[] args) {
        int arr1[] = {10,20,24,28,33,37};
        int arr2[] = {15,30,40,50,60};
        int k = 6;
        System.out.println(kthElement(arr1, arr2, k, k, k));
    }
}
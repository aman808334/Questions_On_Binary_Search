
// Minimum difference element in sorted an array

/*
Example - 

Input -> [1,3,8,10,15] & target = 12
Output -> 10
Explanation - 

Math.abs(1-12) = 11
Math.abs(3-12) = 9
Math.abs(8-12) = 4
Math.abs(10-12) = 2
Math.abs(5-12) = 3

Minimum is '2' & which is for '10'. So, o/p = 10
*/

/*
Approach - 

(1) If target is present in the given array then the absolute difference will be '0' & o/p will be target.
(2) As we move away from the actual position of target the absolute difference will increase.
(3) So, if target isn't present the two neighbours will have minimum absolute difference.
(4) When we apply BS & target isn't found then start & end pointers will point to the two neighbours of the target.
    and mid will pointer to one of the neighbour.
*/

class Minimum_Difference_Element_In_Sorted_Array {

    public static int minDifferenceElement(int arr[], int target){

        int start = 0;
        int end = arr.length -1;

        while(start <= end){

            int mid = start + ((end-start)/2);

            if(arr[mid] == target)
              return target;

            else if(arr[mid] < target)
              start = mid + 1;

            else if(arr[mid] > target)
              end = mid - 1;  
        }

        /* If target isn't found then two neighbours will have minimum A.D and start and end pointer will point to
        these two neighbours */

        int a = Math.abs(arr[start] - target);
        int b = Math.abs(arr[end] - target);

        int min = Math.min(a, b);

        if(Math.abs(arr[start] - target) == min)
          return arr[start];
        else 
          return arr[end];  
    }

    public static void main(String[] args) {
        int arr[] = {1,3,8,10,15};
        int target = 12;
        System.out.println(minDifferenceElement(arr, target));
    }
    
}

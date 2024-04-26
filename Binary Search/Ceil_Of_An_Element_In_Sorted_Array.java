 
 // Ceil of an Element in Sorted Array

/*
If the target element exists in the given array then the target element will be the ceil but if the target element
doesn't exist then the smallest element greater than the target will be the ceil.

Note - Return the index of the ceil & if not present return -1

Example -

Input -> [1,2,8,10,11,12,19] and target = 5
Output -> 2 (Element - 8)
*/

class Ceil_Of_An_Element_In_Sorted_Array {

    public static int findCeil(int arr[], int target){

        int start = 0;
        int end = arr.length-1;
        
        int ceil = -1;
        
        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            if(arr[mid] == target){
                return mid;
            }
            
            else if(arr[mid] > target){
                ceil = mid;
                end = mid-1; // We've to find the smallest value greater than the target. So, now search on the left side.
            }
            
            else if(arr[mid] < target){
               start = mid+1; 
            }
        }
        
      return ceil;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,8,10,11,12,19};
        int target = 5;
        System.out.println(findCeil(arr, target));
    }
}
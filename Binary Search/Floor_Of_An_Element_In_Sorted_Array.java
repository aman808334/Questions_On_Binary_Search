
// Floor of an Element in Sorted Array

/*
If the target element exists in the given array then the target element will be the floor but if the target element
doesn't exist then the largest element smaller than target will be the floor.

Note - Return the index of the floor & if not present return -1

Example -

Input -> [1,2,8,10,11,12,19] and target = 5
Output -> 1 (Element - 2)
*/

class Floor_Of_An_Element_In_Sorted_Array {

    public static int findFloor(int arr[], int target) {

        int start = 0;
        int end = arr.length-1;
        
        int floor = -1;
        
        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            if(arr[mid] == target){
                return mid;
            }
            
            else if(arr[mid] > target){
                end = mid-1;
            }
            
            else if(arr[mid] < target){
               floor = mid;
               start = mid+1; // We've to find the largest value smaller than the target. So, now search on right side.
            }
        }
        
      return floor;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,8,10,11,12,19};
        int target = 5;
        System.out.println(findFloor(arr, target));
    }
}
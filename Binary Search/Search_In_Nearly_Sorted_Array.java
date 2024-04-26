
// Search in Nearly Sorted Array

/*
Nearly sorted means the element which has to be in ith position can be at ith position, (i-1)th position
or (i+1)th position.

Example - 

Input -> [5,7,10,30,20,40] and target = 40
Output -> 5
*/

class Search_In_Nearly_Sorted_Array {

    public static int search(int arr[], int target){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + ((end-start)/2);

            if(arr[mid] == target){
                return mid;
            }

            if(mid-1 >= start && arr[mid-1] == target){ 
                return mid-1;
            }

            if(mid+1 <= end && arr[mid+1] == target){
                return mid+1;
            }

            else if(arr[mid] > target){
                end = mid-2;
            }

            else if(arr[mid] < target){
                start = mid+2;
            }
        }


       return -1;  
    }

    public static void main(String[] args) {
        int arr[] = {5,7,10,30,20,40};
        int target = 40;
        System.out.println(search(arr, target));
    }
}
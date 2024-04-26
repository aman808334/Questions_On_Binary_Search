
// Search in rotated sorted array

class Search_In_Rotated_Sorted_Array {

    public static int search(int arr[],int target){

        // First find index of minimum element
        int indexminimum = findMinimum(arr);

        /*
        Now divide the given array into two sorted parts - 

        (1) 0 to index of minimum element -1
        (2) Index of minimum element to last element 
        */

        int a = searchInFirstHalf(arr, 0, indexminimum-1,target);
        int b = searchInSecondHalf(arr, indexminimum, arr.length-1,target);

       return Math.max(a, b);
    }

    public static int findMinimum(int arr[]){

        if(arr[0] <= arr[arr.length-1]){ // Given array is sorted then return 0th index
            return 0;
        }

        int start = 0;
        int end = arr.length-1;

        while(start<=end){

            int mid = start + ((end-start)/2);
            int next = (mid+1) % arr.length;
            int previous = (mid+arr.length-1) % arr.length;

            if(arr[mid] < arr[previous]){ // Minimum element is less then it's previous element
                return mid;
            }

            else if(arr[mid] > arr[next]){ // Previous element is greater then the minimum element
                return next;
            }

            else if(arr[start] <= arr[mid]){ // Left part is sorted
                start = mid +1;
            }

            else if(arr[mid] <= arr[end]){ // Right part is sorted
                end = mid-1;
            }
        }

       return -1; 
    }

    public static int searchInFirstHalf(int arr[], int start, int end, int target){

        while(start <= end){

            int mid = start + ((end-start)/2); // Same as start+end/2. Will prevent outofrange error.

            if(arr[mid] == target){
                return mid;
            }

            else if(arr[mid] > target){
                end = mid-1;
            }

            else if(arr[mid] < target){
                start = mid+1;
            }
        }

       return -1;
    }

    public static int searchInSecondHalf(int arr[], int start, int end, int target){
        while(start <= end){

            int mid = start + ((end-start)/2); // Same as start+end/2. Will prevent outofrange error.

            if(arr[mid] == target){
                return mid;
            }

            else if(arr[mid] > target){
                end = mid-1;
            }

            else if(arr[mid] < target){
                start = mid+1;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,6,7,10,1,2};
        int target = 1;
        System.out.println(search(arr,target));
    } 
}
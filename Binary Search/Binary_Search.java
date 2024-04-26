
// Binary Search

// Note - To apply binary search array should be sorted

class Binary_Search {

    public static int search(int arr[], int target){

        int start = 0;
        int end = arr.length-1;
        

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
        int arr[] = {60,70,80,80,90,100,110,120};
        int target = 100;
        System.out.println(search(arr, target));
    } 
}
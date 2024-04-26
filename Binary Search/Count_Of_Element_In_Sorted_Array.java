
// Count of an element in a sorted array

class Count_Of_Element_In_Sorted_Array {

    public static int count(int arr[],int target){

        int ans = 0;
        ans = lastOccurrence(arr, target) - firstOccurrence(arr, target) + 1;

       return ans;
    }

    public static int firstOccurrence(int arr[],int target){

        int start = 0;
        int end = arr.length-1;

        int firstindex = -1;
        
        while(start <= end){

            int mid = start + ((end-start)/2); // Same as start+end/2. Will prevent outofrange error.

            if(arr[mid] == target){
                firstindex = mid; // It can be 1st occurrence or not. So continue finding
                end = mid -1; 
            }

            else if(arr[mid] > target){
                end = mid-1;
            }

            else if(arr[mid] < target){
                start = mid+1;
            }
        }
       return firstindex; 
    }

    public static int lastOccurrence(int arr[],int target){

        int start = 0;
        int end = arr.length-1;

        int lastindex = -1;
        
        while(start <= end){

            int mid = start + ((end-start)/2); // Same as start+end/2. Will prevent outofrange error.

            if(arr[mid] == target){
                lastindex = mid; // It can be last occurrence or not. So continue finding
                start = mid+1; 
            }

            else if(arr[mid] > target){
                end = mid-1;
            }

            else if(arr[mid] < target){
                start = mid+1;
            }
        }
       return lastindex; 
    }

    public static void main(String[] args) {
        int arr[] = {2,4,10,10,10,18,20};
        int target = 10;
        System.out.println(count(arr, target));
    }  
}
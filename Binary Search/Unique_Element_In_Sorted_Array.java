
// Unique Element in Sorted Array

/*
Example -

Input -> [[3,3,7,7,10,11,11]
Output -> 10
*/

// Approach - Size of the given array will always be odd.

class Unique_Element_In_Sorted_Array {

    public static int findUnique(int[] arr) {

        if(arr.length == 1){
            return arr[0];
        }

        int start = 0;
        int end = arr.length-1;
        
        while(start <= end){

            int mid = start + ((end-start)/2);
            int next = (mid+1) % arr.length;
            int previous = (mid+arr.length-1)% arr.length;

            if(arr[mid] != arr[previous] && arr[mid] != arr[next]){
                return arr[mid];
            }

            else if(arr[mid] == arr[previous]){ 

                int lc = mid-start+1;

                if((lc & 1) == 0){ // Size is even then single element will be on other side
                   start = mid+1;
                }
                else{
                    end = mid-2;
                }
            }

            else if(arr[mid] == arr[next]){ 

                int rc = end-mid+1;

                if((rc & 1) == 0){ // Size is even then single element will be on other side
                   end = mid-1;
                }
                else{
                    start = mid+2;
                }
            }
        }

       return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,3,7,7,10,11,11};
        System.out.println(findUnique(arr));
    }   
}
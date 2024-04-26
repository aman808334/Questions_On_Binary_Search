
// Find Rotation count

// By what value array is rotated

/*
Example -

Input -> [11,12,15,18,2,5,6,8]
Output ->  4 (Index of minimum element)
*/

/*
Approach -

In sorted array, [2,5,6,8,11,12,15,18] -> Index of minimum element = 0. So, it is rotated 0 times
In sorted rotated array, [11,12,15,18,2,5,6,8] -> Index of minimum element = 4. So, it is rotated 4 times

Therefore, we can say that No. of times sorted array is rotated = Index of minimum element
*/

class Find_Rotation_Count {

    public static int countRotated(int arr[]){

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

    public static void main(String[] args) {
        int arr[] = {11,12,15,18,2,5,6,8};
        System.out.println(countRotated(arr));
    }
}
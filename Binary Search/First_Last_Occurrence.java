
// Find first and last occurrence of an element


class First_Last_Occurrence {

    public static int[] find(int arr[],int target){

        int result[] = new int[2];
        result[0] = firstOccurrence(arr,target);
        result[1] = lastOccurrence(arr,target);

       return result;
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
        int result[] = find(arr,target);
        for(int i=0; i<result.length; i++){
            System.out.print(arr[i] + " ");
        }
    } 
}
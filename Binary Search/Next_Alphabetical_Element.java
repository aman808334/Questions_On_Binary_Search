
// Next Alphabetical Element

/*
If the target character exists or doesn't exist, in both case be have to return then the smallest character greater
than the target character

Note - Return the next alphabetical element  & if not present return '0'

Example -

Input -> ['D', 'J', 'K'] and target = 'B'
Output -> 'D'
*/

class Next_Alphabetical_Element {

    public static char find(char arr[], char target){

        char res = '@';

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            if(arr[mid] == target){
                start = mid+1; // We have to return next greater alphabet. We can't return arr[mid+1] b/c array can contain duplicate. So it will be same as arr[mid]
            }
            
            else if(arr[mid] > target){
                res = arr[mid];
                end = mid-1; // We've to find the smallest character greater than the target. So, now search on the left side.
            }
            
            else if(arr[mid] < target){
               start = mid+1; 
            }
        }

       if(res == '@')
         return '0';
        else 
         return res;
    }

    public static void main(String[] args) {
        char arr[] = {'h', 'n', 's'};
        char target = 'g';
        System.out.println(find(arr, target));
    } 
}
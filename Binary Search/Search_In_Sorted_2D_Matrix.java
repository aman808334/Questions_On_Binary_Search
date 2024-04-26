
// Search in Sorted 2D Matrix

/*
Given a sorted matrix
The first integer of each row is greater than the last integer of the previous row.

Example - 

Input -> [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output -> true
*/

class Search_In_Sorted_2D_Matrix {

    public static boolean search(int[][] arr, int target) {
        
        int start = 0;
        int end = arr.length*arr[0].length-1;
        
        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            int row = mid / arr[0].length;
            int col = mid % arr[0].length;
            
            if(arr[row][col] == target)
              return true;
              
            else if(arr[row][col] < target)
              start = mid+1;
              
            else if(arr[row][col] > target)
              end = mid-1;  
        }
        
      return false;    
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(search(arr, target));
    }
}
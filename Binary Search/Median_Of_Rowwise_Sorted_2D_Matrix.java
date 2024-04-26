
// Median of Row Wise Sorted 2D Matrix

/*
Given a row wise sorted 2D matrix of of odd size. Find the median of this matrix

Example - 

Input -> [[2,5,6],[1,3,5],[5,10,15]]
Output -> 5
Explanation -> [1,2,3,5,5,5,6,10,15] and median = 5
*/

class Median_Of_Rowwise_Sorted_2D_Matrix {

    public static int median(int matrix[][]) {
        
        int start = min(matrix);
        int end = max(matrix);
        
        int req = (matrix.length*matrix[0].length)/2;
        int res = 0;
        
        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            if(countLessOrEqual(matrix,mid) == req){
                start = mid+1;
            }
            
            else if(countLessOrEqual(matrix,mid) < req){
                start = mid+1;
            }
            
             else if(countLessOrEqual(matrix,mid) > req){
                res = mid; 
                end = mid-1; // Can be answer but 1st element which will satisfy this comdition will be the median
            }
        }
      return res;    
    }

    // This function will return minimum in the given matrix
    public static int min(int matrix[][]){
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<matrix.length; i++)
          min = Math.min(min,matrix[i][0]);
          
      return min;      
    }
    
    // This function will return maximum in the given matrix
    public static int max(int matrix[][]){
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<matrix.length; i++)
          max = Math.max(max,matrix[i][matrix[0].length-1]);
          
      return max;      
    }

    // This function will return that how many elements are <= mid, in the given matrix
    public static int countLessOrEqual(int matrix[][], int mid){
        
        int count = 0;
        
        for(int i=0; i<matrix.length; i++){
           count += helper(matrix[i],mid);
        }
        
      return count;    
    }
    
    public static int helper(int arr[], int x){
        
        int start = 0;
        int end = arr.length-1;
        
        int ans = arr.length;
        
        while(start <= end){
            
            int mid = start + ((end-start)/2);
            
            if(arr[mid] == x){
                start = mid+1; // We want greater than 'x'. So, search on right
            }
            
            else if(arr[mid] > x){
                ans = mid;
                end = mid-1; // We want the smallest number greater than 'x'. So continue on left
            }
            
            else if(arr[mid] < x){
                start = mid+1; 
            }
        }
      return ans;    
    }

    public static void main(String[] args) {
        int matrix[][] = {{2,5,6},{1,3,5},{5,10,15}};
        System.out.println(median(matrix));
    } 
}
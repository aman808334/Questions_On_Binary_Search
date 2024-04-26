
// Peak Element in 2D Array

/*
Given a 2D array which can contain one or multiple peak elements. Return any one of the peak elements.

An element is said to be a peak element if it is greater than all its four neighbours.(Top,Down,Left,Right)

Note - 

(1) For extreme elements there will only be neighbours which are in the given 2D matrix.
(2) Neighbours can't be same
*/

/*
Approach - 

. Will apply BS on columns (can apply on row also) & find maximum in that column.
. We have a max element of a column that means it is greater than top & bottom elements(if exists). So we need to just check for
  left and right (if it exists). 
*/

import java.util.Arrays;

class Peak_Element_In_2D_Array {

     public static int[] findPeakGrid(int[][] arr) {

        int res[] = new int[2];
        Arrays.fill(res,-1);
        
        // BS on column
        int start = 0;
        int end = arr[0].length-1; 

        while(start <= end){

            int mid = start + ((end-start)/2); // midth column

            int rowOfmax = rowIndexOfMaxElement(arr,mid);

            // Now find left & right elements
            int left = -1;
            int right = -1;

            if(mid-1>=0)
                left = arr[rowOfmax][mid-1];
            
            if(mid+1 < arr[0].length)
                right = arr[rowOfmax][mid+1];
            
            // Now Check
            if(arr[rowOfmax][mid] > left && arr[rowOfmax][mid] > right){
                res[0] = rowOfmax;
                res[1] = mid;
                break;
            }

            else if(arr[rowOfmax][mid] < left){
                end = mid-1;
            }

            else if(arr[rowOfmax][mid] < right){
                start = mid+1;
            }
        }
       return res;   
    }

    // This function will return row index of maximum element in midyh column
    public static int rowIndexOfMaxElement(int arr[][], int mid){

        int max = Integer.MIN_VALUE;
        int row = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i][mid] > max){
                max = arr[i][mid];
                row = i;
            }
        }
      return row; 
    }

    public static void main(String[] args) {
        int arr[][] = {{10,20,15},{21,30,14},{7,16,32}};
        int res[] = findPeakGrid(arr);
        System.out.println(res[0] + " " + res[1]);
    }
}
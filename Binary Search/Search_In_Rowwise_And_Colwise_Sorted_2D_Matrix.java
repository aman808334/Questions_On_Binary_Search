
// Search in Row Wise & Column Wise sorted 2D Matrix

/*
Example - 

Input -> [[10,20,30,40],[15,21,39,51],[25,27,42,60],[35,37,50,70]] & target = 25
Output -> [2,1]
*/

import java.util.Arrays;

class Search_In_Rowwise_And_Colwise_Sorted_2D_Matrix {

    public static int[] search(int arr[][], int target) {
        
        int i = 0;
        int j = arr[0].length-1;

        int res[] = new int[2];
        Arrays.fill(res, -1);
        
        while(i<arr.length && j>=0){
            
            if(arr[i][j] == target){
                res[0] = i;
                res[1] = j;
                break;
            }
            
            else if(arr[i][j] > target)
              j--;
              
            else if(arr[i][j] < target)
              i++;  
        }
        
      return res;       
    }

    public static void main(String[] args) {
        int arr[][] =  {{10,20,30,40}, {15,25,35,45}, {27,29,37,48},{32,33,39,50}};
        int target = 100;
        int res[] = search(arr,target);
        System.out.println(res[0] + " " + res[1]);
    }   
}
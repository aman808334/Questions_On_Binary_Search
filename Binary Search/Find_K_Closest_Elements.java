 
 // Find K Closest Elements

/*
Example -


Input -> [1,2,3,4,5], k = 5 and x = 3
Output -> [1,2,3,4]

Explanation - 

Math.abs(1-3) = 2
Math.abs(2-3) = 1
Math.abs(3-3) = 0
Math.abs(4-3) = 1
Math.abs(5-3) = 2

So, 'k' element with minimum absolute difference = 2,2,4,1
*/ 

/*
Approach -

(1) 'K' closest elements will be 'K' elements with minimum absolute difference with 'x'.
(2) As we move away from the actual position of 'x' the absolute difference will increase.
(3) When we apply BS & 'target' isn't found then start & end pointers will point to the two neighbours of the target.
    and the target it found mid will point to the target.

We'll use these concept for solving the problem    
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Find_K_Closest_Elements {

    public static List<Integer> findClosestElements(int arr[], int k, int x) {

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = arr.length-1;

        int mid = 0; // Declared mid outside the loop so that we can use mid outside the loop

        boolean flag = false; // To know that 'x' is found or not

        while(start <= end){

              mid = start + ((end-start)/2);

          if(arr[mid] == x){
              flag = true;
              break;
          }

          else if(arr[mid] < x){
              start = mid + 1;
          }

          else if(arr[mid] > x){
              end = mid - 1;
          }

        }

        if(flag == true){ // 'x' is found. Now we'll use the mid to find 'k' elements
         result = find1(arr,k,x,mid);
        }
        else{ // Now will use the concept that start and end will point to two neighbours
         result = find2(arr,k,x,start,end);
        }

       Collections.sort(result);

      return result;

    }

    public static List<Integer> find1(int arr[], int k, int x, int mid){

        List<Integer> res = new ArrayList<>();

        int low = mid-1;
        int high = mid;

        while(k > 0){

            if(low >= 0 && high < arr.length){

                int min = Math.min(Math.abs(arr[low]-x), Math.abs(arr[high]-x));

                if(min == Math.abs(arr[low]-x)){
                  res.add(arr[low]);
                  low--;
                }
                else{
                  res.add(arr[high]);
                  high++;  
                }
               k--; 
            }

            else if( low < 0){
                res.add(arr[high]);
                high++;
                k--;
            }

            else if( high >= arr.length){
                res.add(arr[low]);
                low--;
                k--;
            }
        }

       return res;
    }

    public static List<Integer> find2(int arr[], int k, int x, int start, int end) {

        /* We have to find high and low from start and end b/c we know both are
        neighbours, but which is high and which is low we aren't aware about it */

        // Declare high and low
        int low = end;
        int high = start;

        List<Integer> res = new ArrayList<>();

        while(k > 0){

            if(low >= 0 && high < arr.length){

                int min = Math.min(Math.abs(arr[low]-x), Math.abs(arr[high]-x));

                if(min == Math.abs(arr[low]-x)){
                  res.add(arr[low]);
                  low--;
                }
                else{
                  res.add(arr[high]);
                  high++;  
                }
               k--; 
            }

            else if(low < 0){
                res.add(arr[high]);
                high++;
                k--;
            }

            else if(high >= arr.length){
                res.add(arr[low]);
                low--;
                k--;
            }
        }
       return res; 
    }

    public static void main(String[] args) {
        int arr[] = {1,5,10};
        int k = 1;
        int x = 4;
        System.out.println(findClosestElements(arr, k, x));
    }
}
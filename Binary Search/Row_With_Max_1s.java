
// Row with Maximum 1s

/*
Given a sorted 2D array of 0s & 1s
Find the first row which has maximum number of 1s

Return -1 if no such row

Example -

Input -> {{0,1,1,1},
         {0,0,1,1},
         {1,1,1,1},
         {0,0,0,0}}

Output -> 2         
*/

class Row_With_Max_1s {

    public static int rowWithMax1s(int arr[][]) {
        
        int max = 0;
        int row = -1; 
        
        for(int i=0; i<arr.length; i++){

           int fo = firstOccurrence(arr[i],1);
           int count1 = arr[0].length - fo; // Column length - firstOccurrence of '1'
           
           if(count1 > max){
               max = count1;
               row = i;
           }
        }
      
      return row;         
    }

    // This function will find 1st occurrence of 1
    public static int firstOccurrence(int arr[], int target) {
        
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end) {
            int mid = start + ((end-start)/2);
            
            if(arr[mid] == 1)
                end = mid-1; // We've to find the 1st occurrence. so continue on left
            
             else if(arr[mid] == 0)
                start = mid+1;
            
        }
      return start; // Opposite Polarity 
    }

    public static void main(String[] args) {
        int arr[][] = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        System.out.println(rowWithMax1s(arr));
    } 
}
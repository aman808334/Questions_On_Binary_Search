
// Find the Nth Root of a number

/*
Given a number. Find the nth root to the number. If the nth root of a number doesn't exist, return -1.

Example - 

Input -> Number = 27 & n = 3
Output -> 3 (3^n = 27)

Input -> Number = 69 & n = 4
Output -> 4
*/

// Approach - We'll apply binary search on answer concept b/c we know the range of the answer


class Find_Nth_Root {

    public static int find(int num, int n){

        // "long", to prevent "Not in Range" error
        long start = 0; 
        long end = num; // We now the range of the answer that it can be greater than 'n'

        
        while(start <= end){
            
            long mid = start + ((end-start)/2);
            
            if(midPowerN(num,n,mid) == 1)
              return (int) mid; // Typecast to int
              
            else if(midPowerN(num,n,mid) == 2)
              end = mid - 1;
              
            else if(midPowerN(num,n,mid) == 3)
              start = mid + 1;
        }

      return -1;    
    }

    // Function will calculate (mid^n)
    public static int midPowerN(int num, int n, long mid) {
        
        /* If mid^n == m -> Return 1
           If mid^n > m -> Return 2
           If mid^n < m -> Return 3
        */
        
        /* We can't use the power function b/c it will do all power *than say the output. What if the number is
        very large then we can't store it.
        
        Example -
        
        mid = 10^5 * n = 10. The power result of this will be 10^50.(Can't be stored)
        
        So we will find (mid^n) with the help of a loop and when the value will become > m. We will return
        */
        
        long ans = 1;
        
        while(n > 0){
            
            ans = ans * mid;
            n--;
            
            if(ans > num)
              return 2;
            
        }
        
        if(ans == num)
          return 1;

        if(ans < num)
          return 3;
          
      return -1;   
    }

    public static void main(String[] args) {
        int num = 243;
        int n = 5;
        System.out.println(find(num, n));
    }
}
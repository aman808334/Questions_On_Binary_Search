
// Find Square Root of a number

/*
Given a number. Find the sqrt to the number. If sqrt is in decimal take the floor value.

Example - 

Input -> 30
Output -> 5 (Sqrt(30) == 5._ _ (Floor = 5))
*/

// Approach - We'll apply binary search on answer concept b/c we know the range of the answer

class Find_Sqrt {

    public static int findSquareRoot(int n){

        int res = 0;

        // "long", to prevent "Not in Range" error
        long start = 1;
        long end = n; // We now the range of the answer that it can be greater than 'n'

        while(start <= end){

            long mid = start + ((end-start)/2);

            if(mid * mid == n)
              return (int) mid; // Typecast to int

            else if(mid * mid > n)
              end = mid - 1;

            else if(mid * mid < n){
                res = (int) mid; // Typecast to int
                start = mid + 1;

                // Updating the answer b/c if n = 8 & we are on 2. (2*2) is 4 and 3*3 = 9. So answer will be 2.
            } 
        }

       return res;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(findSquareRoot(n));
    }
}
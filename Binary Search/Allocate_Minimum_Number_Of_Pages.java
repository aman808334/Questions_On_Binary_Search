
// Allocate Minimum Number of pages

/*
Given an array of the number of pages in ith book.
Allocate books in such a way that the sum of maximum number of pages in a book allotted to a student should be minimum.

Rules to Allocate - 

(1) Every students should get at least one book
(2) Students need to be allocated contiguous books

If allocation of books isn't possible then return -1

Example - 

Input -> [12,34,67,90] & students = 2
Output -> 113
Explanation -

Allocation can be done in following ways:
{12} & {34, 67, 90} Maximum Pages = 191
{12, 34} & {67, 90} Maximum Pages = 157
{12, 34, 67} & {90} Maximum Pages =113.

Therefore, the minimum of these cases is 113.
*/

/*
Approach -

(1) We need to find Max(Min) so apply BS.
(2) What will the range -
        
. Minimum pages that we can allocate per student should be the max pages in a book, so that student can get a book
with the most no of pages.
. Maximum pages that we can allocate to a student is that we will give all the books to 1 student, if there is
only one student.
          
So, Range = [max(arr),sum(arr)]
*/

class Allocate_Minimum_Number_Of_Pages {

    public static int findPages(int[]arr,int m) {
        
        if(arr.length<m) // If the number of students is greater than the books.
          return -1;
        
        int start = max(arr);
        int end = sum(arr);
        
        while(start <= end){
            
               int mid = start + ((end-start)/2);
               
            if(canDistribute(arr,mid) == m){
                end = mid-1; // We want minimum pages, so continue on left
            }
            
            else if(canDistribute(arr,mid) > m){
                start = mid+1;
            }
            
            else if(canDistribute(arr,mid) < m){
                end = mid-1;
            }
        }
      return start; // Opp. polarity
    }
    
    // This function will return the maximum pages in a book
    public static int max(int arr[]){
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++)
          max = Math.max(max,arr[i]);
          
      return max;      
    }
    
    // This function will return the sum of pages of all the books
    public static int sum(int arr[]) {
        
        int sum = 0;
        
        for(int i=0; i<arr.length; i++)
          sum += arr[i];
          
      return sum;  
    }
    
    /* This function will return that if the maximum pages per students is "mid" pages
    then to how many student can be distribute the books */
    public static int canDistribute(int arr[], int mid) {
        
        int student = 1;
        int studentpages = 0;
        
        for(int i=0; i<arr.length; i++){
            
            if(studentpages + arr[i] <= mid){
                studentpages += arr[i];
            }
            else{
                student++;
                studentpages = arr[i]; // New student, new student pages count
            }  
        }
      return student;    
    }

    public static void main(String[] args) {
        int arr[] = {12,34,67,90};
        int m = 2;
        System.out.println(findPages(arr, m));
    }  
}
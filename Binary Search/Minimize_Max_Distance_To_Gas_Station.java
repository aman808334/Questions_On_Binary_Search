
// Minimize Maximum Distance to Gas Station

/*
Given an sorted array of Gas Stations &  the number of GS to be place
Place all the GS such that maximum distance b/w two GS in minimum

Example -

Input -> [1,2,3,4,5,6,7,8,9,10] & k = 9
Output -> 0.5
Explanation - Each of the 9 stations can be added mid way between all the existing adjacent stations.
*/

/*
Approach -

(1) We need to find Max(Min) so apply BS.
(2) The answer is of double type so, every variable should be of double type
(2) The answer is of double type so, we need to do some changes in format of BS

Format of BS where double will be the answer - 

 while((end-start) > Math.pow(10.0,-x.0)){
         
        double mid = start + ((end-start)/2.0);
           
        if(function(stations,mid) == k){
            end = mid; // We have to find the minimum so continue on left
                or
            start = mid; // We have to find the maximum so continue on right
        }
        
        else if(function(stations,mid) > k){
            start = mid;
        }
        
        else if(function(stations,mid) < k){
            end = mid;
        }

      return end; // End will have the last answer  
    }

(4) What will the range -

Minimum distance b/w GS can be '0'
Maximum distance b/w GS can be maximum dis b/w any two consecutive GS
        
So, range = [0,maxDistanceBetweenConsecutive(arr)]    
*/

class Minimize_Max_Distance_To_Gas_Station {

    public static double findSmallestMaxDist(int stations[],int k) {
        
        double start = 0;
        double end = maxDistanceBetweenConsecutive(stations);
        
        while((end-start) > Math.pow(10.0,-6.0)){
             
               double mid = start + ((end-start)/2.0);
               
            if(numberOfGasStation(stations,mid) == k){
                end = mid; // We have to find the minimum distance so continue on left
            }
            
            // We can place more than given GS. So increase the distance
            else if(numberOfGasStation(stations,mid) > k){
                start = mid;
            }
            
            else if(numberOfGasStation(stations,mid) < k){
                end = mid;
            }
        }
        
      return end; // End will have the last answer
    }
      
    // This function will return the maximum distance b/w two consecutive gas stations
    public static double maxDistanceBetweenConsecutive(int stations[]) {
          
        double maxDistance = 0;
          
        for(int i=1; i<stations.length; i++)
          maxDistance = Math.max(maxDistance,(double)(stations[i]-stations[i-1]));
          
        return maxDistance; 
    }

    // This function will return the number of gas stations that can be place keeping the distance as mid
    public static int numberOfGasStation(int stations[],double mid){
          
        int totalGS = 0;
          
        for(int i=1; i<stations.length; i++){

            /*
            Example 1 - [1,2] & mid = 0.4
            noOfGsInBetween = (2-1)/0.4 = 2.5 (2)
            Therefore, two GS can be placed in b/w

            Example 2 - [1,2] & mid = 0.5
            noOfGsInBetween = (2-1)/0.5 = 2
            But, only 1 GS can be placed in b/w
            */
              
            int noOfGsInBetween = (int) ((stations[i]-stations[i-1]) / mid); 
              if((stations[i]-stations[i-1]) == noOfGsInBetween * mid)
                noOfGsInBetween--;
                
            totalGS += noOfGsInBetween;      
        }
        return totalGS; 
    }

    public static void main(String[] args) {
        
        int stations[] ={1,2,3,4,5,6,7,8,9,10};
        int k = 9;
        System.out.println(findSmallestMaxDist(stations,k));
    } 
}
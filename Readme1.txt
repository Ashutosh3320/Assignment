Backend Assignment-1

=> "Main" class is used for taking inputs and calling "getVaccine" function which is in "classplus" class for final answer.

   Algorithms used
=> Dijkstra shortest path (modified) algorithm.

   Variables and Class defination
1. "cp"-> instance of "classplus" class.
2. "vertes"-> a class which holds 2 integer variable(time->time to reach current planet via direct portal from parent portal, val-> indicates current planet name)
3. "adjList"-> a HashMap(key:Integer, value:Set of directly connected vertex(planet)) forms adjacency list for graph algorithms.
4. "demonTime"-> a HashMap(key:Integer,value:HashMap<Integer,Integer>) indicates time-stamp of demons on each planet for getting index of current time in time-stamp array in O(1) time.
5. "demonArray"-> a HashMap(key:Integer,value:an array[]), array for each integer key holds the sorted time-stamp for getting next time-stamp (easy access).
6. "min"-> integer variable which will store minimum time to reach last planet.
7. "pq"-> Minimum PriorityQueue on the basis of "dist[]" array.
8. "dTime"-> time upto which SpiderMan waits in the presence of DEMON.  
   


   Code Run Steps
1. Creating instance of "classpplus" class named "cp".
2. inctance of "classplus" initialises adjList, demonTime, demonArray and min.
3. calling "getVaccine(int n)" from "Main" class.
4. "getVaccine" function calls "midifiedDijkstra" which takes 2 arguments.
5. Creating "dist[]" array of size = no. of planets+1 because on 1 indexing.
6.  "dist[]" array holds the minimum time to go to any planet.
7. "modifiedDijkstra" implements "Dijkstra algo." using "Min. PriorityQueue" data structure.
8. In the implementation of Dijkstra algo. "getTime()" function is called which return the waiting time required by "SpiderMan" when "DEMON" is present at that instance of time.
9. dist[destination] indicates minumum time to reach last planet or destination, therefore min=dist[dest] at the and fo modifiedDijkstra() to hold minimum time to reach last planet.
10. Returning value from "getVaccine()" according to "min" value.
11. Printing the desired result returned by "getVaccine()".




Time Complexity->
                 getVaccine(int dest)               =>  O(number of portals * log(number of planets) )
                 modifiedDijkstra(int src,int dest) =>  O(number of portals * log(number of planets) )
                 getTime(int idx, int[] arr)        =>  O(1) 

Space Complexity->
                 getVaccine(int dest)               =>  O(number of planets)
                 modifiedDijkstra(int src,int dest) =>  O(number of planets)
                 getTime(int idx, int[] arr)        =>  O(1)  
   

Overall Time Complexity -> O(number of portals * log(number of planets) ) (excluding many factors like time taken by inputs) 
 
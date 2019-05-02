# comsharonorlycredorax
This porgram is Credorax - java exercise. (home) 
 
Task: 
Assume you have a file with all the phone calls in the last year from millisecond 0 to the end of the year.
What we want to do is find the time in the year from ms X to ms Y where we had the highest amount of open calls
Example for input (phone calls)
0-1
0-4
1-9
1-12
…
700G
·         Find the busiest time in the network
·         find a simple solution
·         do not scan the file twice
·         you are limited to 8GB heap


solution: 
1. I read the file and insert each line as HMap entry. If the entry exsits,this means that  2 or more calls started / ended   in the same millisec, I
 add/ subtract one (accordingly).
2. after filling in the Hmap, I move all the data (key, value) to arrayList in order to sort it by time.  
3. sort the array list. 
4. find max in the array. (busiest time) 
5. go over the array, and find all time periods where number of open calls is max. 
6. return array of max time. 

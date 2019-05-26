# holidu_code
Task to get aggregate names

step 1:  API url  http://localhost:8080/getAggregateName

step 2:  input parameters
      eg:
      latitude :40.77020969
      longitude: -73.84421522
      radius : 160934 meters( considered 1 mile for test case)
      
step 3: use browser   URL:http://localhost:8080/getAggregateName?latitude=40.77020969&longitude=-73.84421522&radius=160934
       or post man  to test 
       
       
       
 Code Description :
 
 class :  GetAggregateName   contains RESTController to expose API as a service which gives aggregate spc_common names
 
 
 Class :  Circle contains logic to calculate polygon circle with given inputs X and Y as latitude and longitude along with radius
 
 class : Aggregation finds aggregated spc names derived from the API response
      


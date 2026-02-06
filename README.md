Feature toggling was implemented using a separate JAVA class that has static methods that returns the value for the toggle. On a typical Guidewire implementation, this can be replaced with RuntimeProperties. 

To run the application, run the ThreadpilotApplication in Threadpilot.java. 
Sample data are created and can be found in VehicleData.java and PersonData.java. 

Endpoints are: 
- /vehicle/{registrationNumber}
- /insurance/{idNumber}

The challenge of this project is mainly due to the way of implementation. Since this is an integration sort of implementaion, it requires Spring Boot, both domains in which I am not familiar with. So I had to learn the Spring Boot framework to be able to complete this assessment.
Given the time, I would probably  explore on different aspects of feature toggling other than Guidewire's own way which is the way done here. 
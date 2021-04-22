# olt-boot-cloud-aws
Getting Started with Spring Boot, Cloud and AWS - online Live Training at https://safaribooksonline.comC

## Setup/Prerequisites
The following tools/frameworks are expected to be setup as part of this course. 

* AWS Account: We need to create an AWS account for consuming the services. We can surely use Free Tier for our training  
* IDE for development: I work on IntelliJ IDEA but any Java IDE should be okay)
* AWS CLI: We need to use the Command Line Interface to configure our AWS access

### AWS Account
Visit [Amazon's AWS](https://aws.amazon.com/) and register. You can use Free Tier for most/all of the training sessions. Once you;ve completed the registration, visit [AWS Console Home] (https://console.aws.amazon.com) to log in. Once you are logged in, next step is to create keys for programmatic access using AWS's Identity and Access Management(IAM) service, described in the next section.

#### AWS Keys for programmatic access

Our programs interact with the AWS services programmatically. We need to create a user/group with appropriate access controls. Head over to [IAM](https://console.aws.amazon.com/iam/) service and follow the instructions to create a user, group and permissions. 
- Click on Users -> Add User (see Image below)
![Adding a New User](https://user-images.githubusercontent.com/1698230/115702928-6bc28f00-a361-11eb-9ebd-67fbbc4129fc.png)
- Select Prgorammatic Acess and navigate to next page to create a group.
- Click on the Create Group ![image](https://user-images.githubusercontent.com/1698230/115703310-e4295000-a361-11eb-9647-0e4e1121f6da.png)
- Provide the group name and add as Administrator (be aware - this will grant the full access to all of the services - make sure you make granular level access instead)
![Administrative Group](https://user-images.githubusercontent.com/1698230/115703586-35394400-a362-11eb-8bc7-ea56c771f853.png)
- 







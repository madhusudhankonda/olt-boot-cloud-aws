# Getting Started with Spring Boot, Cloud and AWS
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
- Provide the group name and add as Administrator (be aware - this will grant the full access to all of the services - make sure you make granular level access instead). Navigate to next page, which enables the Tags. We can ignore tags for these exercises.
![Administrative Group](https://user-images.githubusercontent.com/1698230/115703586-35394400-a362-11eb-8bc7-ea56c771f853.png)
- Ignore Tags and go to Review page. Once satisfied, click on the Create User button, which will create the user and outputs the keys to the console as shown below:
![New User](https://user-images.githubusercontent.com/1698230/115704052-c7414c80-a362-11eb-8aab-78155e97773e.png)

- As you can see this page outputs the access and secret keys. Copy them to your running notes. These key are only shown once - you cannot retive them once you navigate away from this page. Of coruse, you can re-create them which will generate a brand new set of keys anyway. It is a good idea to save, download or email them to yourself. Click on the Download as CSV button to download or follow instructions to receive them by email.

### AWS CLI (Command Line Utility)

Now that we have our AWS Account created and keys generated, it's time to configure them on my machine for development. 

The AWS SDK for Java expects us to provide few properties - access key, secret key and region. There are multitude ways of configuring our SDK to pick up these keys, one way being asking AWS CLI to configure us with credentials file as pofiles in our local home directory. Let's follow the steps to get the AWS CLI downloaded and installed. Once it's ready, we use it to configure our environment.

#### Download and install AWS CLI
Depending OS, download your CLI binary from here [AWS CLI](https://aws.amazon.com/cli/). 

Once downloaded, follow the instructions to get it installed. Issue `aws s3 ls` command - you may see a list (or none) of S3 buckets as shown here in the image:![S3 buckets list](https://user-images.githubusercontent.com/1698230/115707485-c14d6a80-a366-11eb-87f5-adc2813162eb.png)








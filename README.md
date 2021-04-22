# Getting Started with Spring Boot, Cloud and AWS
Getting Started with Spring Boot, Cloud and AWS - online Live Training at https://safaribooksonline.com

* This project is based on Spring Cloud AWS 2.3.1, Spring Boot 2.4.5 and AWS SDK 1.X
* For AWS SDK 2.x (no Spring Cloud AWS support yet), visit my [second repository] (https://github.com/madhusudhankonda/olt-boot-cloud-aws-v2)

## Course Schedule:
* [22 April 2021](https://learning.oreilly.com/attend/getting-started-with-spring-boot-spring-cloud-and-aws/0636920053451/0636920053450/)

* [25 June 2021](https://learning.oreilly.com/attend/getting-started-with-spring-boot-spring-cloud-and-aws/0636920053451/0636920054381/)

## Setup/Prerequisites
The following tools/frameworks are expected to be setup as part of this course. 

* AWS Account: We need to create an AWS account for consuming the services. We can surely use Free Tier for our training  
* AWS CLI: We need to use the Command Line Interface to configure our AWS access
* IDE for development: I work on IntelliJ IDEA but any Java IDE should be okay)

Let's look at these steps in the next few sections.

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

### Configure the Environment 

It's time to configure our environment to start developing projects to consume AWS.

At your command prompt/terminal, issue the `aws configure` command and follow the instructions. 

It asks for your access key and secret key - enter them at the command prompt.

It will also ask for Region - input yoru appropriate region. The regions are provided in the form of EU-WEST-2, US-EAST-1, etc., as shown in the image here:
![image](https://user-images.githubusercontent.com/1698230/115708122-826be480-a367-11eb-86f5-fb1568d030e0.png). 

CLI will create a `.aws` folder in your home directory.

Once the configuration is done, you should see two files in the user's home directory `~/.aws` created by CLI - the `credentials` and `config` file - keys and region documented in those files respectively. If you are not sure where these are, you can visit <your_home_directory>/.aws folder


## IDE for development

All the source code is available on GitHub, so using your favourite IDE, you can clone the repository. I've used IntelliJ IDE for the development purposes but there's no reason why you can't use any other IDE. The projects are maven based. 

## Versions

There are two variants of the projects that I had developed `olt-boot-cloud-aws` and `olt-boot-cloud-aws-v2`. The fundamental difference is the AWS SDK's version. 

The `olt-boot-cloud-aws` project uses AWS SDK 1.x version with Spring Cloud AWS 2.3.1 and Spring Boot 2.4.5 (there's a new variat of Spring cloud - awspring - see details below)

On the other hand [`olt-boot-cloud-aws-v2`](https://github.com/madhusudhankonda/olt-boot-cloud-aws-v2) uses AWS SDK 2.x version with Spring Boot 2.4.5 (no Cloud AWS support yet for AWS SDK 2.x). My intention is to provide a mechanism to work with AWS SDK 2.x version within Spring Applications untill the Spring Cloud AWS new release comes along.

## Resources

### Spring
- [Spring Cloud AWS New Home (awspring.io)](https://docs.awspring.io/spring-cloud-aws/docs/2.3.1/reference/html/index.html)
- [Spring Cloud AWS Old Home](https://spring.io/projects/spring-cloud-aws)

### AWS
- [AWS Home Console](https://aws.amazon.com/)
- [AWS SDK for Java Home](https://docs.aws.amazon.com/sdk-for-java/index.html)

### AWS SDK 1.x
- [AWS SDK for Java 1.x Developer Guide](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/welcome.html)
- [AWS SDK for Java 1.x JavaDoc/API Reference](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/)

### AWS SDK 2.x
- [AWS SDK for Java 2.x Developer Guide](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html)
- [AWS SDK for Java 2.x JavaDoc/API Reference](https://sdk.amazonaws.com/java/api/latest/)

## Training Code
| AWS Service | GitHub Code |
[Simple Queue Service](https://aws.amazon.com/sqs)|[SQS Code](https://github.com/madhusudhankonda/olt-boot-cloud-aws/tree/main/sqs)

### AWS Services
- [Identity and Access Management](https://aws.amazon.com/iam)
- [Simple Queue Service](https://aws.amazon.com/sqs)
- [Simple Notification Service](https://aws.amazon.com/sns)
- [Relational Database Service](https://aws.amazon.com/rds)
- [Simple Storage Service](https://aws.amazon.com/s3)


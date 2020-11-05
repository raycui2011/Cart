# Cart Calculator
This is a command line Java application that calculate a shopping cart.
## Getting Started
### Dependencies

1. JDK 8
2. Apache Maven 3.5.0

### Installing
#### Install JDK on Mac OS . 
* Check if JDK has been Pre-installed<br />
  - Open a terminal and run the below command
    ```
    javac -version
    ```
  - If a JDK version number is returned, then JDK has been pre-installed, please skip next step.
  
* Downloading JDK <br />
  - Goto Java SE download site @ http://www.oracle.com/technetwork/java/javase/downloads/index.html.<br />
  - Choose the operationg platform and Downloaing the installer.<br />
  
* Install and verify your installation <br />
  - Double-click the downloaded Disk Image (DMG) file. Follow the screen instructions to install JDK/JRE <br />
  - To verify your installation, open a "Terminal" and issue these commands.<br />
  ```
  // Display the JDK version
  javac -version
  javac 1.x.x_xx
       
  // Display the JRE version
  java -version
  java version "1.x.x_xx"
  Java(TM) SE Runtime Environment (build 1.x.x_xx-xxx)
  Java HotSpot(TM) Client VM (build 22.1-b02, mixed mode, sharing)

  // Display the location of Java Compiler
  which javac
  /usr/bin/javac

  // Display the location of Java Runtime
  which java
  /usr/bin/java
  ```

#### Install Apache Maven
On mac<br/>
Please open a terminal and run the below commands.
```
brew install maven
```
On Ubuntu<br/>
```
 sudo apt-get install maven
```

#### Verification

Run command `mvn -version` to verify installatioin
```
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T05:39:06+10:00)
Maven home: /usr/local/Cellar/maven/3.5.0/libexec
Java version: 1.8.0_112, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre
Default locale: en_AU, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.4", arch: "x86_64", family: "mac"
```
Ensure JAVA_HOME environment variable is set and points to your JDK installation
* Check environment variable value

```
1. echo $JAVA_HOME
2. /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home
```
* Adding to PATH

```
export PATH=/opt/apache-maven-3.5.0/bin:$PATH
```

## Description

- The application is a price calculator command-line program.
  The application should take two command-line arguments
    - a JSON file representing a cart, and
    - a JSON file representing a list of base prices.

 
The application that can read in commands of the following form

    SET cart-11356.json|cart-9363.json|cart-4560.json|cart-9500.json,base-prices.json
    CALCULATE
    EXIT

- SET will let application to initial the cart and list of base price.
- CALCULATE will calculate the cart's price and print it.
- The first valid command to the application is a SET command, after that,
  any sequence of commands may be issued, in any order, including another
  SET command. The application should discard all commands in the
  sequence until a valid SET command has been executed.


## Example Input and Output:
    
a)

	SET cart-11356.json
    CALCULATE
    

	************************** 
    -------------------------- 
    Product Type is hoodie
    Quantity is 2
    Size is xl
    Colour is dark
    Print Location is back
    Total price is $11.356
    -------------------------- 
    ************************** 
    **********Total is ************* $11.356

b)

	SET cart-9363.json,base-prices.json
	CALCULATE

    ************************** 
    -------------------------- 
    Product Type is hoodie
    Quantity is 2
    Size is xl
    Colour is dark
    Print Location is back
    Total price is $11.356
    -------------------------- 
    ************************** 
    **********Total is ************* $11.356

## How to run and test the application.
### For compiling the applicatioin
 - Chagne directory to Cart folder then run this command
 ```
 mvn compile
 ```
 ### For running the application
 - Run this command
 ```
  mvn exec:java
 ```
 ### For running the tests
 - Tests require JUnit and Mockito <br />
 - Run this command to test the application
 ```
 mvn test
 ```

<a href="http://billie.io"><img src="https://spryker.com/wp-content/uploads/2018/11/BILLIE_Logo_02.png" title="FVCproductions" alt="FVCproductions" height="200" width="420"></a>


# QA Automation Engineer Technical task 

> Here you can find small description about the test framework presented in the repository

## Table of Contents

- [Technologies overview](#technologies-overview)
- [Installation](#installation)
- [Run Test scenarios](#run-test-scenarios)
- [Comments](#comments)


---
## Technologies overview

- <a href="https://java.com/en/download/faq/whatis_java.xml"/>Java</a> is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere! 
- <a href="http://rest-assured.io/"/>Rest Assured</a> was selected as a communicator between resource and client side of the application. Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy. REST Assured brings the simplicity of using these languages into the Java domain.
- There are many building tools on the market, but we decided to go with <a href="https://maven.apache.org/"/>Apache Maven</a> as it is easy to use in a small to medium scale projects, it's proven itself as a reliable and well known project management tool.
- Test runner - <a href="https://cucumber.io/"/>Cucumber</a>. Cucumber is a tool that supports <a href="https://cucumber.io/docs/bdd/"/>Behaviour-Driven Development(BDD)</a> and in pair with <a href="https://cucumber.io/docs/gherkin/"/>Gerkin</a> syntax provides excellent readability and could provide great supportability if structured properly



## Installation
- Java 8 is required to run the scenarios. You can download Java using the <a href="https://www.java.com/en/download/"/>link</a>. Once Java is installed you can verify its version by running `java -version` command in your terminal window.
- Apache Maven could be downloaded from <a href="https://maven.apache.org/download.cgi"/>here</a> or, if you are using OSX, you can download it with <a href="https://brew.sh/"/>brew</a> package manager. Once `brew` is in place, just run 

```shell
$ brew install maven
```
Once `brew` has finished you can check the Maven state by running `mvn -v` command in your terminal window. 

## Run Test scenarios
- First of all you need to have the framework on you local machine, so go ahead and clone the project.
- Using your terminal window navigate to project folder and run `mvn test` command to run all scenarios
![Recordit GIF](http://g.recordit.co/t2dwlGrkBg.gif)

- Or you can run specific scenarios by calling cucumber options like `mvn test -Dcucumber.options=”–tags @Smoke”` 
![Recordit GIF](http://g.recordit.co/7LGcFw8HHs.gif)

---
## Comments

- There are many ways to improve the tests and scenarios, refactor methods to use the cucumber variables, data tables and test examples, a good test reporter and such and such.   

1-Spring Projent structure
src/main/java : contains application source code
src/main/resources : Contains non-java resources
src/test/java : Contains test code


mvnm and mwnw.cmd : these are maven wrapper script.
You can use these scripts to build your project, even if you 
do not have Maven installed on your machine.

pom.xml : this is the Maven build specification.

CydeoApplication.java : this is the Spring boot main
class that bootstrapts the project.

application, properties : This file initially
empty but offers a place where you can specify
configuration properties.

static folder : Contains any static content
(images, css, js, etc)

templates : Contains teplate files that will be used
to the browser(Thymeleaf)

CydeoApplicationTessts : This is a simple test
class that ensures that the Spring appplication 
content loads succesfully You will add more tests
to the mix as you develop application

Build Specification : 
<parent> : This specifies that your project has spring -boot-started-parent as its parent POM.
This parent POM provides dependency management for several libraries commonly used in Spring
project. For those libraries covered by the parent POM, you wont have to specify a version,
because it is inherited from the parent.

All dependencies have the work starter in their artifact ID.
Your build file will be significatly smaller and easier to manage because you wont neeed to declare
dependency on every library you might need.

You are able to think of yur dependencies in terms of what capabilities they provide, rather 
than their library names (web starter dependency)

You are free from the burden of worrying about library version. You only need to worry about which
version of Spring Boot you are using.

Spring Boot plugin:
--It provides a Maven goal that ebables you to run the application using maven
--It ensures that all dependensy libraries are included within the executable JAR file.



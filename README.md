# Spring & Hibernate Notes

Spring Hibernate Notes Heavy commented codes and notes for reference purposes.



Spring:

using Java code instead of XML configuration to create Beans

Java Class annotates as @Configuration

optional component scanning support @ComponentScan(optional)

Read Spring Java configure class and retrieve bean from Spring Container.



## Configuring and running Spring MVC with Tomcat

Use the web.xml and spring-mvc-demo-servlet.xml int this repo for future MVC projects.

Go into Tomcat /conf directory and change the follow files:

context.xml

```xml
<Context reloadable="true"> <-- add
...
</Context>
```


web.xml
```xml
  <servlet>
...
            <param-value>true</param-value>  <-- change from false to true
...
    </servlet>
```



MVC Project:

web.xml file:

Copy header file from web.xml in tomcat /conf to project's web.xml header

Web sites that helped:

https://www.pegaxchange.com/2018/01/24/java-web-project-with-spring-framework/

https://www.ntu.edu.sg/home/ehchua/programming/howto/Tomcat_HowTo.html
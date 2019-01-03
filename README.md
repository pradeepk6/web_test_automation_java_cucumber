##### About:
Java Cucumber selenium-webdriver demo

built with:
* Serenity BDD framework 1.8.21
* cucumber
* Java 8
* Selenium WebDriver 3.9.1
* Maven 3.5


##### Highlights
* Serenity BDD has many advantages : fully scalable, very configurable, 
  many many convenience methods to deal with Ajax and webdriver quirks, excellent reports
  serve as living documentation, Cucumber for BDD etc
* [Cucumber feature files](/src/test/resources/features)

##### how to run:
* need Java8 and maven to run.
* download a latest driver binary into project home directory or add to system path 
* Run mvn command : mvn verify
* browser can be changed in pom.xml(webdriver.driver) or via maven-commandline
* headless option can be commented out in serenity.properties file
* for Serenity reports go to target/site/serenity and click index.html

##### tested on:
* os : windows 10 and latest chrome webdriver 2.45

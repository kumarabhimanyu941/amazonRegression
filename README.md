This repository contains an automated regression testing suite for the user interface of Amazon.co.in, built using Selenium WebDriver with Java.

Features
Automated Tests: Comprehensive suite of automated regression tests for critical UI functionalities of Amazon.co.in.
Framework: Built using Selenium WebDriver, ensuring scalability, maintainability, and reliability.
Test Coverage: Covers various aspects of Amazon.co.in UI.
Customizable: Easily customizable for adding new tests or modifying existing ones as per evolving UI changes.
Prerequisites:
  Language :Java
  Browsers: Chrome and Firefox

Getting Started
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/kumarabhimanyu941/amazonRegression
cd amazonRegression

Execute the tests:

mvn clean install -Denv="envName"
Test Structure
src/main/java:Contains all the components of the framework (utils,configuration etc) except the test cases.
src/test/java: Contains all the test cases organized logically.




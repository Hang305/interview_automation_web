# interview_automation_web
Interview automation web

## Table of Contents

- [Table of Contents](#table-of-contents)
  - [Project structure](#project-structure)
  - [Testing](#testing)
      - [Scenario](#scenario)



## Project structure

- `data` directory contains all files that are needed to run the project.
    - `apps` directory contains all the apps that are used in the project (mostly for mobile automation).
    - `drivers` directory contains all the selenium drivers for web automation.
    - `test` directory contains all the test data file (like json, csv, xlsx...).
- `src/main/java`
    - Package `com.interview.automation` contains all the based commands for web automation, like init driver, loading configuration, BasePage, BaseTesst, etc. You can change the package name as the project needs.
- `src/test/java`
    - Package `com.interview.automation.web.test` contains all the classes for testing, like test, cucumber, page object,
      etc. You can change the package name as the project needs.
- `src/test/resources` directory contain mainly cucumber feature file, properties file for configuration, etc.
- `pom.xml` is the main maven project file. It contains all the dependencies and the configuration of the project.
- `testng.xml` is the testng project file that contains all configuration for test suites. The name is not fixed, you
  can freely change it and create many files as you want.


## Testing
- `pages` is the package that contain all page object class.
- `testng` is the package that contain all test class using [testng](https://testng.org/doc/).


### Scenario

1. Login and go to the task page
2. Create a general task
3. Update the general task
4. Delete the general task
5. Create a general task without a task name
6. Create a body metric task without selecting a metric

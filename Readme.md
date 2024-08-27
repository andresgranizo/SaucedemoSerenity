[![CI](https://github.com/andresgranizo/SaucedemoSerenity/actions/workflows/ci.yml/badge.svg)](https://github.com/andresgranizo/SaucedemoSerenity/actions/workflows/ci.yml)

# SaucedemoSerenity

This project is an end-to-end (E2E) automated test for the SauceDemo web application, using Serenity BDD with the Screenplay pattern and Gradle.

## Prerequisites

- **JDK 17** or higher.
- **IntelliJ IDEA** (or any other preferred IDE).
- **Gradle 7.6.1** (optional if using the included wrapper).
- **Git** (for cloning the repository).
- **Google Chrome** browser.

## Environment Setup

### 1. Clone the Repository

```bash
git clone  https://github.com/andresgranizo/SaucedemoSerenity
cd SaucedemoSerenity
```
## Import the Project into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select Open on the welcome screen or go to File > Open.
3. Navigate to the folder where you cloned the repository and select the project folder.
4. IntelliJ IDEA should automatically detect the build.gradle file and begin configuring the project.

## Configure Dependencies
IntelliJ IDEA will automatically download and configure the dependencies specified in the build.gradle file. Ensure that the project is set up with the Java 17 SDK:

Go to File > Project Structure > Project.
Ensure that Project SDK is set to 17.

## Configure Serenity
In the serenity.conf file, ensure that the browser configuration is correct:

```bash
webdriver {
  driver = chrome
  autodownload = true
  capabilities {
    "goog:chromeOptions": {
      args = ["--remote-allow-origins=*"]
    }
  }
}

serenity {
  project.name = "SaucedemoSerenity"
}
```
##  Running the Tests
Via Command Line
You can run the tests with the following command from the project root:
```bash
./gradlew clean test

```
## Via IntelliJ IDEA
1. Navigate to the CheckoutTest class in src/test/java/com/saucedemo/features.
2. Right-click on the class and select Run 'CheckoutTest'.

##  Generating Reports
Serenity automatically generates a report in target/site/serenity/index.html. You can open this file in your browser to view the test results.

## Conclusions
This project demonstrates how E2E tests can be automated using Serenity BDD with the Screenplay pattern. Follow the steps mentioned to set up and execute the tests from scratch in IntelliJ IDEA.

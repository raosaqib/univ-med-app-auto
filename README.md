# univmediaappauto
# appium-pageobjectmodel

Appium mobile test automation framework with Page Object Model design using Java + Maven + TestNG
This POC has two case[One is positive Case & one is negative case]-This framewok is being integrated with Allure reports
PRE REQUISITE:-
Step 1: Install Appium using NPM
=================================
- Commands to check if node and NPM are installed:
node -v
npm -v
- Install node.js and NPM from link - https://nodejs.org/en/
- Command to install Appium using npm: npm install -g appium
- Command to start Appium: appium
- Command to uninstall Appium: npm uninstall -g appium


Step 2: Install Appium using Appium Desktop
===========================================
- Download and install Appium Desktop from https://appium.io


Step 3: Install JAVA JDK and configure environment variable
===========================================================
- Command to check if JAVA is already installed: java -version
- JAVA JDK download link: https://www.oracle.com/technetwork/ja...
- JAVA 8 Installation instructions on Windows:
https://docs.oracle.com/javase/8/docs...
- Create JAVA_HOME system environment variable and set it to JDK path (without bin folder). 
- Edit PATH system environment variable and add %JAVA_HOME%\bin


Step 4: Install Android Studio and configure environment variable
=================================================================
- Android Sutdio download link: https://developer.android.com/studio
- Create ANDROID_HOME system environment variable and set it to SDK path. 
- Edit PATH system environment variable and add below,
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin
Technologies/Tools used in building the framework
=================================================
- Eclipse - IDE
- Appium - Mobile Automation library
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- Log4J - Logging framework
Allure Reports


Framework/POC implements below best practices
=========================================
- Code reusability/readability
- Scalable automation (demonstrated using multiple test classes)
- Uses explicit waits
- Abstraction layer for UI commands like click, wait, etc.
- Parameterization using TestNG XML and config.properties
- Use of inheritence
- Abstraction layer for test data
- Supports iOS and Android
-----------------------------------
How to Generate Allure Reports
===============================
download https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.13.0/ for mac or windows
allure --version
Navigate to project directory & run allure serve allure-results

In order to generate a report, we should install Allure command-line interpreter.

Download the latest version as a zip archive from bintray.
Then, click the Files tab and then download the .zip file for windows. For Linux, you can download .tgz file. For Mac use brew to install allure.
Unpack the archive to allure-commandline directory.[C:\automationsoftware\allure-2.13.0\bin]

Navigate to bin directory.
Add allure to system PATH.

NOTE:-After importing the project you may see the error- Cannot switch on a value of type String for source level below 1.7. Only convertible int values or enum variables are permitted- please select the quickfix.(jre 1.7 & above]
-


This is a sample project demonstrates appium demo for native applcation and live reporting. It covers example of bean, component and test page.
To change/modify dependencies check ivy.xml

Pre Conditions:
1. Appium server
   To install and setting up appium server please follow this link : http://appium.io/slate/en/master/?java#
2. Appium Server Configuration
   In Appium set Application Path to ContactManager application
3. Project Configuration
   application.properties file settings for Appium:
   		driver.name=appiumDriver
   Appium server capabilities: 
		appium.additional.capabilities= {'browser_name':'','deviceName':'emulator-5554','platformName':'Android','automationName':'Appium','driver.class':'io.appium.java_client.android.AndroidDriver'}
   User need to set additional capabilities as per application environment. Detailed list of appium capabilities you can find here: http://appium.io/slate/en/master/?java#appium-server-capabilities
4. Add appium java-client dependency in ivy.xml file
   <dependency org="io.appium" name="java-client" rev="2.2.0"/>
5. Make sure appium server is started 

To change/modify dependencies check ivy.xml

To run the project, from command prompt go to project home and run ant. Open dashboard.htm to view results.

Please refer https://qmetry.github.io/qaf/ 

Notes:
Contact Manager application requires google account to add contacts. 
Create google account to access target account in  application.
e.x. qasdemo@gmail.com
  
Thanks,
QAS Team
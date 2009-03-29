rem *******************************************
rem * This batch file runs the HAPI test panel
rem *
rem * For more info, see: http://hl7api.sourceforge.net/testpanel.html
rem ******************************************* 

setlocal ENABLEDELAYEDEXPANSION
for %%I IN (..\lib\*.jar) DO SET CP=!CP!;%%I

SET HAPI_HOME=.

set PORT=8888

echo HAPI_HOME is set to %HAPI_HOME%
echo Running ca.uhn.hl7v2.app.TestPanel with HL7Service on port %PORT%

java -cp %CP% -Dhapi.home=%HAPI_HOME% ca.uhn.hl7v2.app.TestPanel %PORT%

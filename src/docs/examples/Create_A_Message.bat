rem *******************************************
rem * This batch file runs example code
rem *
rem * For more info, see: https://hapifhir.github.io/hapi-hl7v2/devbyexample.html
rem ******************************************* 

setlocal ENABLEDELAYEDEXPANSION
for %%I IN (..\lib\*.jar) DO SET CP=!CP!;%%I

java -cp %CP% ca.uhn.hl7v2.examples.CreateAMessage


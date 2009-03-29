rem *******************************************
rem * This batch file runs example code
rem *
rem * For more info, see: http://hl7api.sourceforge.net/devbyexample.html
rem ******************************************* 

setlocal ENABLEDELAYEDEXPANSION
for %%I IN (..\lib\*.jar) DO SET CP=!CP!;%%I

java -cp %CP% ca.uhn.hl7v2.examples.CreateAMessage


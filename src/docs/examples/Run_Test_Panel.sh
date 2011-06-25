# *******************************************
# * This batch file runs the HAPI test panel
# *
# * For more info, see: http://hl7api.sourceforge.net/testpanel.html
# ******************************************* 

CP="."
for i in ../lib/*.jar;
do
	CP=$i:$CP;
done

HAPI_HOME="."
PORT="8888"

echo HAPI_HOME is set to $HAPI_HOME
echo Running ca.uhn.hl7v2.app.TestPanel with HL7Service on port $PORT

java -cp $CP -Dhapi.home=$HAPI_HOME ca.uhn.hl7v2.app.TestPanel $PORT


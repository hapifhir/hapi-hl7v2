# *******************************************
# * This batch file runs example code
# *
# * For more info, see: https://hapifhir.github.io/hapi-hl7v2/devbyexample.html
# ******************************************* 

CP="."
for i in ../lib/*.jar;
do
		  CP=$i:$CP;
done

java -cp $CP ca.uhn.hl7v2.examples.CreateAMessage


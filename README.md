# Comrad fork of HAPI HL7v2

### Changes for Comrad Integration
* Use Gradle instead of Maven to build the code.
* Disabled classes relating to the HAPI custom ConfGen Maven plugin. 
As we are using the officially generated structures libraries from other sources we do not use ConfGen.
* The build uses gradlew under jdk1.8 with a commandline similar to this:

```$ ./gradlew  -Dorg.gradle.java.home=/c/Program\ Files/AdoptOpenJDK/jdk-8.0.242.08-hotspot build```

---
_original readme below:_
# hapi-hl7v2

This is the GitHub home for HAPI HL7v2.

Project Website: https://hapifhir.github.io/hapi-hl7v2/

HAPI FHIR (our sister project): http://hapifhir.io

Looking to get started? [These articles](https://saravanansubramanian.com/hl7tutorials/) are a great resource.

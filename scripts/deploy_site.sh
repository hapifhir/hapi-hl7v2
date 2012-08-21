#!/bin/sh

cd target/site
rm ../site.tgz
tar zcvf ../site.tgz *
cd ..
#ssh -t jamesagnew,hl7api@shell.sourceforge.net create
scp site.tgz jamesagnew,hl7api@shell.sourceforge.net:/home/project-web/hl7api/htdocs/
echo site is at /home/project-web/hl7api/htdocs/
#ssh -t jamesagnew,hl7api@shell.sourceforge.net


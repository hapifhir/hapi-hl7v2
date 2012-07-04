
VERSION="2.0-beta3"

rm scripts/staging/*
cp -v hapi-testpanel/target/hapi-testpanel-$VERSION-mac.dmg scripts/staging/
cp -v hapi-testpanel/target/hapi-testpanel-$VERSION-linux.tar.bz2 scripts/staging/
cp -v hapi-testpanel/target/hapi-testpanel-$VERSION-windows.zip scripts/staging/
cp -v scripts/readme_testpanel.txt scripts/staging/

cd scripts/staging/
pwd

rsync --progress --verbose * jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hapi-testpanel/$VERSION/

cd ../..

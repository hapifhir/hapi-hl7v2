
VERSION="2.0.1"

mkdir scripts/staging
rm scripts/staging/*
cp -vp target/hapi-testpanel-$VERSION-windows.zip scripts/staging
cp -vp target/hapi-testpanel-$VERSION-linux.tar.bz2 scripts/staging
cp -vp target/hapi-testpanel-$VERSION-mac.dmg scripts/staging

echo Using RSync to upload...
rsync --progress --verbose scripts/staging/* jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hapi-testpanel/$VERSION/

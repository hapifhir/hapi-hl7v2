
VERSION="2.0"

mkdir scripts/staging
rm scripts/staging/*
cp -vp hapi-dist/target/hapi-dist-$VERSION-all.zip scripts/staging
cp -vp hapi-dist/target/hapi-dist-$VERSION-all.tar.bz2 scripts/staging
cp -vp hapi-dist/target/hapi-dist-$VERSION-javadoc.zip scripts/staging
cp -vp hapi-dist/target/hapi-dist-$VERSION-javadoc.zip scripts/staging
cp -vp hapi-dist/target/hapi-dist-$VERSION-sources.tar.bz2 scripts/staging
cp -vp hapi-dist/target/hapi-dist-$VERSION-sources.tar.bz2 scripts/staging

echo Using RSync to upload...
#rsync --progress --verbose hapi-$VERSION-*.zip jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hl7api/$VERSION/
rsync --progress --verbose scripts/staging/* jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hl7api/$VERSION/

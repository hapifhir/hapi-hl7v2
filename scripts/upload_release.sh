
VERSION="2.2"

rm -fvR scripts/staging/*
mkdir scripts/staging
mkdir scripts/staging/hl7api
mkdir scripts/staging/hl7api/$VERSION
mkdir scripts/staging/hl7api-hl7overhttp
mkdir scripts/staging/hl7api-hl7overhttp/$VERSION

cp -vp hapi-dist/target/hapi-dist-$VERSION-all.zip scripts/staging/hl7api/$VERSION
cp -vp hapi-dist/target/hapi-dist-$VERSION-all.tar.bz2 scripts/staging/hl7api/$VERSION
cp -vp hapi-dist/target/hapi-dist-$VERSION-javadoc.zip scripts/staging/hl7api/$VERSION
cp -vp hapi-dist/target/hapi-dist-$VERSION-javadoc.tar.bz2 scripts/staging/hl7api/$VERSION
cp -vp hapi-dist/target/hapi-dist-$VERSION-sources.zip scripts/staging/hl7api/$VERSION
cp -vp hapi-dist/target/hapi-dist-$VERSION-sources.tar.bz2 scripts/staging/hl7api/$VERSION
cp -vp hapi-hl7overhttp/target/*.tar.bz2 scripts/staging/hl7api-hl7overhttp/$VERSION
cp -vp hapi-hl7overhttp/target/*.zip scripts/staging/hl7api-hl7overhttp/$VERSION

echo Using RSync to upload...
cd scripts/staging
rsync -r --progress --verbose * jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/

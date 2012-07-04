
VERSION="2.0-beta1"

cd hapi-dist/target

rsync --progress --verbose hapi-*-$VERSION-*.zip jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hl7api-unstable/$VERSION/
rsync --progress --verbose hapi-*-$VERSION-*.tar.bz2 jamesagnew,hl7api@shell.sourceforge.net:/home/frs/project/h/hl/hl7api/hl7api-unstable/$VERSION/

cd ../..

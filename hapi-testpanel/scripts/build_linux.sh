. ../scripts/passwords.properties

mvn -Dmaven.test.skip -Dstorepass=$STORE_PASS -P BUNDLE install

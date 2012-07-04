. ./passwords.properties

mvn -P DIST -Dgpg.passphrase=$GPG_PASS  deploy

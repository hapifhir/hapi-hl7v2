. scripts/passwords.properties

mvn -Dmaven.test.skip -P MINIDIST -Dgpg.passphrase=$GPG_PASS  deploy

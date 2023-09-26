#!/bin/bash

set -o xtrace
set -e

mvn -P ALLMODULES,ACCESS clean

cd hapi-base
mvn -e -P ALLMODULES,ACCESS clean install
cd ..

cd hapi-sourcegen
mvn -P ALLMODULES,ACCESS clean install
cd ..

cd hapi-structures-v21
mvn -P ALLMODULES,ACCESS clean install
cd ..

cd hapi-structures-v22
mvn -P ALLMODULES,ACCESS clean install
cd ..

cd hapi-structures-v23
mvn -P ALLMODULES,ACCESS clean install
cd ..

cd hapi-structures-v231
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
cd ..

cd hapi-structures-v24
pwd
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
pwd
cd ..

cd hapi-structures-v25
pwd
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
pwd
cd ..

cd hapi-structures-v251
pwd
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
pwd
cd ..

cd hapi-structures-v26
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
cd ..

cd hapi-structures-v27
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
cd ..

#cd hapi-structures-v271
#set +e
#mvn -P ALLMODULES,ACCESS clean install
#set -e
#cd ..

cd hapi-structures-v28
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
cd ..

cd hapi-structures-v281
set +e
mvn -P ALLMODULES,ACCESS clean install
set -e
cd ..


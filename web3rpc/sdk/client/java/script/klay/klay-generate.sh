#!/usr/bin/env bash

CURRENT_FILE_DIR=$1
PROJECT_DIR=$(cd "$CURRENT_FILE_DIR" && cd ../../../ && pwd )

# generate openapi yaml
#cd "${PROJECT_DIR}"/api/redocly
#yarn build

# generate openapi codes
cd "${CURRENT_FILE_DIR}"
rm -rf "${CURRENT_FILE_DIR}/openapi/klay"
mkdir "${CURRENT_FILE_DIR}/openapi/klay"
cp .openapi-generator-ignore "${CURRENT_FILE_DIR}/openapi/klay"
"${PROJECT_DIR}"/bin/web3rpc-openapi-generator-cli generate -c "${CURRENT_FILE_DIR}/script/klay/klay-config.yaml"

# generate openapi jar library
cd "${CURRENT_FILE_DIR}/openapi/klay"
sh gradlew clean build publishToMavenLocal

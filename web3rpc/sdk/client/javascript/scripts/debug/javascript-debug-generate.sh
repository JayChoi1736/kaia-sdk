#!/usr/bin/env bash

CURRENT_FILE_DIR=$1
PROJECT_DIR=$(cd "$CURRENT_FILE_DIR" && cd ../../.. && pwd )

cd "${CURRENT_FILE_DIR}"



mkdir "${CURRENT_FILE_DIR}/openapi/debug"

cp .openapi-generator-ignore "${CURRENT_FILE_DIR}/openapi/debug"

"${PROJECT_DIR}"/bin/caver-openapi-generator-cli generate -c "${CURRENT_FILE_DIR}/scripts/debug/debug-config.yaml"

cd "${CURRENT_FILE_DIR}/openapi/debug"
yarn install
yarn link 
echo "${CURRENT_FILE_DIR}/openapi/debug"

cd "${CURRENT_FILE_DIR}"/opensdk
yarn link opensdk-javascript-debug


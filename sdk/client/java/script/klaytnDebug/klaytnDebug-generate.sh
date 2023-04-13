#!/usr/bin/env bash

CURRENT_FILE_DIR=$(cd "$( dirname "${BASH_SOURCE[0]}" )" && cd ../.. && pwd)
PROJECT_DIR=$(cd "$CURRENT_FILE_DIR" && cd ../../.. && pwd )

# generate openapi yaml
#cd "${PROJECT_DIR}"/api/redocly
#yarn build

# generate openapi codes
cd "${CURRENT_FILE_DIR}"
rm -rf "${CURRENT_FILE_DIR}/openapi/klaytnDebug"
mkdir "${CURRENT_FILE_DIR}/openapi/klaytnDebug"
cp .openapi-generator-ignore "${CURRENT_FILE_DIR}/openapi/klaytnDebug"
"${PROJECT_DIR}"/bin/caver-openapi-generator-cli generate -c "${CURRENT_FILE_DIR}/script/klaytnDebug/klaytnDebug-config.yaml"

# generate openapi jar library
cd "${CURRENT_FILE_DIR}/openapi/klaytnDebug"
sh gradlew clean build publishToMavenLocal

#!/usr/bin/env bash

CURRENT_FILE_DIR=$1
PROJECT_DIR=$(cd "$CURRENT_FILE_DIR" && cd ../../../ && pwd )

cd "${CURRENT_FILE_DIR}"
rm -rf "${CURRENT_FILE_DIR}/openapi/debug"
mkdir "${CURRENT_FILE_DIR}/openapi/debug"
cp .openapi-generator-ignore "${CURRENT_FILE_DIR}/openapi/debug"

"${PROJECT_DIR}"/bin/caver-openapi-generator-cli generate -c "${CURRENT_FILE_DIR}/scripts/debug/debug-config.yaml"

cd "${CURRENT_FILE_DIR}/openapi/debug"

pip uninstall opensdk-python-debug -y
pip install .
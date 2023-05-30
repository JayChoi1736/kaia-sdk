#!/usr/bin/env bash

CURRENT_FILE_DIR=$1
PROJECT_DIR=$(cd "$CURRENT_FILE_DIR" && cd ../../../ && pwd )

cd "${CURRENT_FILE_DIR}"
rm -rf "${CURRENT_FILE_DIR}/openapi/admin"
mkdir "${CURRENT_FILE_DIR}/openapi/admin"
cp .openapi-generator-ignore "${CURRENT_FILE_DIR}/openapi/admin"

"${PROJECT_DIR}"/bin/web3rpc-openapi-generator-cli generate -c "${CURRENT_FILE_DIR}/scripts/admin/admin-config.yaml"

cd "${CURRENT_FILE_DIR}/openapi/admin"

pip uninstall opensdk-python-admin -y
pip install .
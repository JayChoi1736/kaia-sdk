

CURRENT_FILE_DIR=$1
cd "${CURRENT_FILE_DIR}"
sh gradle clean build publishToMavenLocal

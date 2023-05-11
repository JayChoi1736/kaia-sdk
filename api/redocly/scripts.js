const fs = require('fs');

const regex = /parameters:[\n\s.\-\w:,"$'#\/()\\<>`’]*requestBody:/g;
const filePath = '../../site/klaytn-openapi.yaml';

// Read the file contents
let fileContents = fs.readFileSync(filePath, 'utf8');

// Replace the matching text
let newFileContents = fileContents.replace(regex, 'requestBody:');

// Write the updated contents back to the file
fs.writeFileSync(filePath, newFileContents);

console.log('Done!');
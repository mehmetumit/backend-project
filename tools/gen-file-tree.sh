#!/bin/sh

printf '# File Tree\n\n```sh\n' > ./docs/file-tree.md && tree --gitignore >> ./docs/file-tree.md && sed -i -e '$d' ./docs/file-tree.md && echo '```' >> ./docs/file-tree.md;

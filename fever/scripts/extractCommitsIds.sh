#!/bin/sh

#extract commits touching Kconfig files from the Linux repository.

REPO_PATH="/Users/Dante/Documents/workspace/git/linux/linux"
TAG_1="v3.0"
TAG_2="v3.14"

cd $REPO_PATH

git log  -G "^(\s)*(config|menu|menuconfig)" --no-merges --format=format:%H $TAG_1...$TAG_2 -- \*Kconfig\* > output_3.0_3.14.csv

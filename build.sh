#!/bin/bash
set -e

cd ping && ./build.sh
cd ..
cd mvc && ./build.sh
cd ..
cd webflux && ./build.sh
cd ..
cd prometheus && ./build.sh
cd ..

#!/usr/bin/env bash
################################################################################
#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
# limitations under the License.
################################################################################

# Detect Operating System
OS="Linux"
[[ "$OSTYPE" == "darwin"* ]] && OS="Mac"

HUGO_VERSION=0.110.0
# Setup Hugo based on OS
if [ "$OS" = "Mac" ]; then
    HUGO_ARTIFACT="hugo_extended_${HUGO_VERSION}_darwin-universal.tar.gz"
else
    HUGO_ARTIFACT="hugo_extended_${HUGO_VERSION}0_Linux-64bit.tar.gz"
fi

HUGO_REPO="https://github.com/gohugoio/hugo/releases/download/v${HUGO_VERSION}/${HUGO_ARTIFACT}"
if ! curl --fail -OL $HUGO_REPO ; then
	echo "Failed to download Hugo binary"
	exit 1
fi
tar -zxvf $HUGO_ARTIFACT -C /usr/local/bin

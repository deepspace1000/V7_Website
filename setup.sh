#!/bin/bash

handle_error() {
  local exit_code="$?"
  exit "$exit_code"
}

trap 'handle_error' ERR

echo : "
██    ██ ███████     ██     ██ ███████ ██████  ███████ ██ ████████ ███████ 
██    ██      ██     ██     ██ ██      ██   ██ ██      ██    ██    ██      
██    ██     ██      ██  █  ██ █████   ██████  ███████ ██    ██    █████ 
 ██  ██     ██       ██ ███ ██ ██      ██   ██      ██ ██    ██    ██    
  ████      ██        ███ ███  ███████ ██████  ███████ ██    ██    ███████ 
                                                                           

"

echo "Hi there! This script will set up your development environment for V7 Website."
read -p "◆ Press Enter to continue..."
echo

echo "➤ Configuring git hooks path (tools/git-hooks)"
git config core.hooksPath tools/git-hooks
echo

pushd ./frontend > /dev/null || exit

echo "➤ Enabling Corepack (for Yarn)"
corepack enable
echo

echo "➤ Installing Yarn dependencies"
yarn install
echo

popd > /dev/null || exit

echo "✓ Setup complete, happy hacking!"
echo

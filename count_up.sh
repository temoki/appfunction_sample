#!/bin/bash

# CountApp の countUp AppFunction を実行するスクリプト
adb shell cmd app_function execute-app-function \
  --package space.hiraku.countapp \
  --function "space.hiraku.countapp.CountAppFunctions#countUp" \
  --parameters '{}'

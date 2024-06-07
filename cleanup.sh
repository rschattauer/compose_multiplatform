#!/bin/sh
rm -rf .idea
./gradlew clean
rm -rf .gradle
rm -rf build
rm -rf */build
rm -rf ios/ios.xcworkspace
rm -rf ios/ios.xcodeproj/project.xcworkspace
rm -rf ios/ios.xcodeproj/xcuserdata

#!/bin/sh
SBT_LAUNCH="$(dirname $0)/sbt-launch.jar"
SBT_URL="https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.13.9/sbt-launch.jar"
curl -sSL -o "${SBT_LAUNCH}" "${SBT_URL}"
java $SBT_OPTS -jar "${SBT_LAUNCH}" "$@"

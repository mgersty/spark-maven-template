#!/bin/bash

spark-submit \
  --class org.gersty.example.WordCount \
  --master local[1] \
  target/spark-maven-template-1.0-SNAPSHOT.jar

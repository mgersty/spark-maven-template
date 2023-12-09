package org.gersty.example

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]):Unit = {
    val conf = new SparkConf().setAppName("Spark Count").setMaster("local[1]")
    val sc = new SparkContext(conf);
    val text = sc.textFile("input.txt")
    val counts = text.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.collect
    println("Count Response: " + counts.count)
  }
}

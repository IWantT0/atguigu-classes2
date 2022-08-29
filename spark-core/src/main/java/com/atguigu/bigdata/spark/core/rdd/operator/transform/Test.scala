package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Test")
    val text = new SparkContext(conf)

    val rdd1: RDD[Int] = text.makeRDD(List(1,2,3,4),2)
    val rdd2: RDD[Array[Int]] = rdd1.glom()

    text.stop()
  }

}

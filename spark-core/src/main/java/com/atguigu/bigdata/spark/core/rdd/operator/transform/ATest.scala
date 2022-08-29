package com.atguigu.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ATest {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("Test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    var rdd = sc.makeRDD(List(1,2,3,4,5,6,7,8),2)
    val value: RDD[Array[Int]] = rdd.glom()
    value.collect().foreach(data=> println(data.mkString(",")))

    sc.stop();

  }
}

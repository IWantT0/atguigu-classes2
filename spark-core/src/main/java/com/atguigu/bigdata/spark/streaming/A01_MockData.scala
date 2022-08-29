package com.atguigu.bigdata.spark.streaming

import java.util.{Properties, Random}

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import scala.collection.mutable.ListBuffer

object A01_MockData {
  def main(args: Array[String]): Unit = {
    val properties = new Properties()
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.85.130:9092")
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")

    val kafkaProducer: KafkaProducer[String, String] = new KafkaProducer[String,String](properties)
    while (true){
      mockdata().foreach(
        data => {
          kafkaProducer.send(new ProducerRecord("first",data));
        }

      )
      Thread.sleep(2000)
    }

  }


  def mockdata() = {
    val list = ListBuffer[String]()
    val areaList = ListBuffer[String]("华北", "华东", "华南")
    val cityList = ListBuffer[String]("北京", "上海", "深圳")

    for ( i <- 1 to new Random().nextInt(50) ) {

      val area = areaList(new Random().nextInt(3))
      val city = cityList(new Random().nextInt(3))
      var userid = new Random().nextInt(6) + 1
      var adid = new Random().nextInt(6) + 1

      list.append(s"${System.currentTimeMillis()} ${area} ${city} ${userid} ${adid}")
    }

    list
  }
}

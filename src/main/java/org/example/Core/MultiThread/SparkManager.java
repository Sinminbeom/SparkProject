package org.example.Core.MultiThread;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Row;
import static org.apache.spark.sql.functions.*;

public class SparkManager {
    private SparkSession spark = null;

    public SparkManager() {
        Init();
    }
    public void Init() {
        spark = SparkSession.builder()
                .appName("Spark Hive Integration")
                .master("local")
                .config("spark.sql.warehouse.dir", "/opt/hive/data/warehouse/")
                .config("spark.hadoop.io.native.lib.available", "false")
                .enableHiveSupport()
                .getOrCreate();

        spark.sql("SET hive.exec.dynamic.partition.mode=nonstrict");
    }
    public void Start(String filePath) {
        try {

            Dataset<Row> csvData = spark.read()
                    .option("header", "true")
                    .option("inferSchema", "true")
                    .csv(filePath);

            Dataset<Row> processedData = csvData.withColumn("partition_date", date_format(expr("event_time + interval 9 hours").cast("timestamp"), "yyyy-MM-dd"));

            processedData.write()
                    .mode("append")
                    .partitionBy("partition_date")
                    .format("hive")
                    .saveAsTable("ecommerce_behavior_data");

            // TODO move to the configuration file
            spark.sql("SELECT * FROM ecommerce_behavior_data").show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // spark.close();
        }
    }

    public void ReStart(String filePath) {
        try {

            String[] filePathList = filePath.split("/");
            String fileName = filePathList[filePathList.length - 1];

            Dataset<Row> rawData = spark.read().format("csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .load(filePath);

            // TODO move to the configuration file
            rawData.write()
                .format("parquet")
                .option("compression", "snappy")
                .save(String.join("", "/data1/ecommerce_behavior_data/error/", fileName, ".parquet"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // spark.close();
        }
    }
}

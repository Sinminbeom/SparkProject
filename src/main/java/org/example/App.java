package org.example;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Row;
import org.example.Core.MultiThread.AppManager;
import static org.apache.spark.sql.functions.*;

public class App {
    public static void main(String[] args)  throws InterruptedException {
        AppManager appManager = new AppManager();
    }
}

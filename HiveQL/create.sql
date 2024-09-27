CREATE EXTERNAL TABLE IF NOT EXISTS ecommerce_behavior_data (
    event_time TIMESTAMP,
    event_type STRING,
    product_id INT,
    category_id BIGINT,
    category_code STRING,
    brand STRING,
    price FLOAT,
    user_id BIGINT,
    user_session STRING
)
PARTITIONED BY (partition_date STRING)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/opt/hive/data/warehouse/';
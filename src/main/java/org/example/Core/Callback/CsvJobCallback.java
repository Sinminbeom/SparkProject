package org.example.Core.Callback;

import org.example.Core.Job.CsvJob;
import org.example.Core.MultiThread.SparkManager;
import org.example.Core.MultiThread.DTO.DTO;

public class CsvJobCallback {
    public CsvJobCallback() {

    }

    public void Invoke(DTO dto) {
        SparkManager sparkManager = dto.getSparkManager();
        CsvJob csvJob = (CsvJob) dto.getJob();
        sparkManager.Start(csvJob.GetCsvPath());
    }
}

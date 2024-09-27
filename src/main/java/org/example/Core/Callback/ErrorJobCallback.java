package org.example.Core.Callback;

import org.example.Core.MultiThread.DTO.DTO;
import org.example.Core.Job.ErrorJob;
import org.example.Core.MultiThread.SparkManager;

public class ErrorJobCallback {
    public ErrorJobCallback() {

    }

    public void Invoke(DTO dto) {
        SparkManager sparkManager = dto.getSparkManager();
        ErrorJob csvJob = (ErrorJob) dto.getJob();
        sparkManager.ReStart(csvJob.GetCsvPath());
    }
}

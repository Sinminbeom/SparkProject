package org.example.Core.MultiThread.DTO;

import org.example.Core.Job.IJob;
import org.example.Core.MultiThread.SparkManager;

public class DTO {
    private SparkManager sparkManager;
    private IJob job;

    public DTO() {
    }

    public DTO(SparkManager sparkManager, IJob job) {
        this.sparkManager = sparkManager;
        this.job = job;
    }

    public SparkManager getSparkManager() {
        return sparkManager;
    }

    public void setSparkManager(SparkManager sparkManager) {
        this.sparkManager = sparkManager;
    }

    public IJob getJob() {
        return job;
    }

    public void setJob(IJob job) {
        this.job = job;
    }
}

package org.example.Core.MultiThread;

import org.example.Core.Job.IJob;
import org.example.Core.JobQueue.IJobQueue;
import org.example.Core.JobQueue.JobQueue;
import org.example.Core.MultiThread.SparkManager;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadManager {
    private final SparkManager sparkManager;
    private final IJobQueue jobQueue;
    private final List<Thread> threads;
    private final int threadCount;

    public MultiThreadManager(int threadCount) {
        this.sparkManager = new SparkManager();
        this.jobQueue = new JobQueue();
        this.threads = new ArrayList<>();
        this.threadCount = threadCount;
    }

    public void Start() throws InterruptedException {
        for (int i = 0; i < threadCount; i++) {
            Thread worker = new Thread(new WorkerThread(sparkManager, jobQueue));
            threads.add(worker);
            worker.start();
            worker.join();
        }
    }

    public void AddJob(IJob job) {
        try {
            jobQueue.Push(job);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
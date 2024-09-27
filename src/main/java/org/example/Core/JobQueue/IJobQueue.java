package org.example.Core.JobQueue;

import org.example.Core.Job.IJob;

public interface IJobQueue {
    void Push(IJob job) throws InterruptedException;
    IJob Pop() throws InterruptedException;
    boolean IsEmpty();
}

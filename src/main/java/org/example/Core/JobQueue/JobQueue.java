package org.example.Core.JobQueue;

import org.example.Core.Job.IJob;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class JobQueue implements IJobQueue {
    private final BlockingQueue<IJob> queue;

    public JobQueue() {
        this.queue = new LinkedBlockingQueue<>();
    }

    public void Push(IJob job) throws InterruptedException {
        queue.put(job);
    }

    public IJob Pop() throws InterruptedException {
        return queue.poll();
    }

    public boolean IsEmpty() {
        return queue.isEmpty();
    }
}
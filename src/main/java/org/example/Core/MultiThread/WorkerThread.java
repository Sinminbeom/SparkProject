package org.example.Core.MultiThread;

import org.example.Core.Handler.NetworkEventHandler;
import org.example.Core.Job.*;
import org.example.Core.JobQueue.IJobQueue;
import org.example.Core.Protocol.ProtocolMeta;
import org.example.Core.MultiThread.DTO.DTO;

public class WorkerThread implements Runnable {
    private final SparkManager sparkManager;
    private final IJobQueue jobQueue;

    public WorkerThread(SparkManager sparkManager, IJobQueue jobQueue) {
        this.sparkManager = sparkManager;
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (true) {

            IJob job = null;

            try {
                job = jobQueue.Pop();

                if (job == null) {
                        System.out.println(Thread.currentThread().getName() + " - No jobs left, terminating.");
                        break;
                }

                ProtocolMeta.E_PROTOCOL_ID protocolId = job.GetProtocol();
                NetworkEventHandler.Execute(protocolId, new DTO(sparkManager, job));

                Thread.yield();

                // Thread.sleep(1000);

            } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
                try {
                    jobQueue.Push(new ErrorJob(ProtocolMeta.E_PROTOCOL_ID.ERROR_JOB, job.GetCsvPath()));
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
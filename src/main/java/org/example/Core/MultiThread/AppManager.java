package org.example.Core.MultiThread;

import java.io.File;

// import org.example.Core.MultiThread.SparkManager;
import org.example.Core.MultiThread.MultiThreadManager;
import org.example.Core.Protocol.ProtocolMeta;
import org.example.Core.Job.CsvJob;
import org.example.Core.Job.ErrorJob;

public class AppManager {
    private MultiThreadManager multiThreadManager; // final

    public AppManager() throws InterruptedException {
        multiThreadManager = new MultiThreadManager(3);
        LoadCsvFile();
        multiThreadManager.Start();
    }

    private void LoadCsvFile() {
        String folderPath = System.getProperty("user.dir") + "/data";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] csvFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

            if (csvFiles != null && csvFiles.length > 0) {
                for (File csvFile : csvFiles) {
                    multiThreadManager.AddJob(new CsvJob(ProtocolMeta.E_PROTOCOL_ID.CSV_JOB, csvFile.getAbsolutePath()));
                    multiThreadManager.AddJob(new ErrorJob(ProtocolMeta.E_PROTOCOL_ID.ERROR_JOB, csvFile.getAbsolutePath()));
                }
            } else {
                System.out.println("not exists csv file.");
            }
        } else {
            System.out.println("not exists csv file.");
        }
    }
}

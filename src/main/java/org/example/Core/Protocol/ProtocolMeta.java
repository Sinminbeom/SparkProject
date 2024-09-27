package org.example.Core.Protocol;

import org.example.Core.Callback.CsvJobCallback;
import org.example.Core.Callback.ErrorJobCallback;
import org.example.Core.MultiThread.DTO.DTO;
import org.example.Core.MultiThread.SparkManager;

import java.util.Arrays;

public class ProtocolMeta extends abProtocolMeta {
    public enum E_PROTOCOL_ID {
        CSV_JOB,
        ERROR_JOB
    }
    private static final ProtocolMeta instance = new ProtocolMeta();

    private ProtocolMeta() {}

    public static ProtocolMeta getInstance() {
        return instance;
    }

    public void Init() {
        Register(ProtocolMeta.E_PROTOCOL_ID.CSV_JOB, Arrays.asList(
                (dto) -> new CsvJobCallback().Invoke((DTO) dto),
                (dto) -> System.out.println("bbbbb")
        ));
        Register(ProtocolMeta.E_PROTOCOL_ID.ERROR_JOB, Arrays.asList(
                (dto) -> new ErrorJobCallback().Invoke((DTO) dto),
                (dto) -> System.out.println("ddddd")
        ));
    }
}

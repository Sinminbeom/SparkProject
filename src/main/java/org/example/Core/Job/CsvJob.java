package org.example.Core.Job;

import org.example.Core.Protocol.ProtocolMeta;

public class CsvJob extends abJob {

    public CsvJob(ProtocolMeta.E_PROTOCOL_ID protocolId, String csvPath) {
        super(protocolId, csvPath);
    }

}
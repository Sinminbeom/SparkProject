package org.example.Core.Job;

import org.example.Core.Protocol.ProtocolMeta;

public class ErrorJob extends abJob {

    public ErrorJob(ProtocolMeta.E_PROTOCOL_ID protocolId, String csvPath) {
        super(protocolId, csvPath);
    }

}

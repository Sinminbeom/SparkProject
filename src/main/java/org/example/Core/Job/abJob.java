package org.example.Core.Job;

import org.example.Core.Protocol.ProtocolMeta;

public abstract class abJob implements IJob {
    public final ProtocolMeta.E_PROTOCOL_ID protocolId;
    private final String csvPath;

    public abJob(ProtocolMeta.E_PROTOCOL_ID protocolId, String csvPath) {
        this.protocolId = protocolId;
        this.csvPath = csvPath;
    }

    @Override
    public ProtocolMeta.E_PROTOCOL_ID GetProtocol() {
        return protocolId;
    }

    @Override
    public String GetCsvPath() {
        return csvPath;
    }
}

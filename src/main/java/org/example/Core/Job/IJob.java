package org.example.Core.Job;

import org.example.Core.Protocol.ProtocolMeta;

public interface IJob {
    ProtocolMeta.E_PROTOCOL_ID GetProtocol();
    String GetCsvPath();
}

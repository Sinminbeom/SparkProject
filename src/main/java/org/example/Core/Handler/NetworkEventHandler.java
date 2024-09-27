package org.example.Core.Handler;

import org.example.Core.MultiThread.DTO.DTO;
import org.example.Core.Protocol.ProtocolMeta;
import org.example.Core.MultiThread.SparkManager;

public class NetworkEventHandler {
    public static void Execute(ProtocolMeta.E_PROTOCOL_ID protocolId, DTO dto) {
        ProtocolMeta.getInstance().Execute(protocolId, dto);
    }
}

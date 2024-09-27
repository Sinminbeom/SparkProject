package org.example.Core.Protocol;

import org.example.Core.MultiThread.DTO.DTO;
import org.example.Core.MultiThread.SparkManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class abProtocolMeta {
    public enum E_PROTOCOL_META {
        CALLBACK,
        FROM_JSON
    }

    private final Map<ProtocolMeta.E_PROTOCOL_ID, List<Consumer>> protocolMeta;

    public abProtocolMeta() {
        this.protocolMeta = new HashMap<>();
        Init();
    }

    public abstract void Init();

    public void Register(ProtocolMeta.E_PROTOCOL_ID protocolId, List<Consumer> callbacks) {
        if (protocolMeta.containsKey(protocolId)) {
            throw new RuntimeException("not exists key");
        }

        protocolMeta.put(protocolId, callbacks);
    }

    public Consumer GetCallback(ProtocolMeta.E_PROTOCOL_ID protocolId){
        return protocolMeta.get(protocolId).get(E_PROTOCOL_META.CALLBACK.ordinal());
    }

    public void Execute(ProtocolMeta.E_PROTOCOL_ID protocolId, DTO dto) {
        Consumer consumer = GetCallback(protocolId);
        consumer.accept(dto);
    }
    
}

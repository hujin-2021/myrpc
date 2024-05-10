package com.hj.myrpc.protocol.serializer.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.hj.myrpc.protocol.entity.MyRPCRequest;
import com.hj.myrpc.protocol.entity.MyRPCResponse;
import com.hj.myrpc.protocol.serializer.ISerializer;

/**
 * @author hujin
 */
public class KryoSerializer implements ISerializer {
    private static ThreadLocal<Kryo> threadLocal=ThreadLocal.withInitial(()->{
        Kryo kryo=new Kryo();
        kryo.setDefaultSerializer(new KryoFieldSerializerFactory());
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.register(Class.class);
        kryo.register(Class[].class);
        kryo.register(Object[].class);
        kryo.register(MyRPCRequest.class);
        kryo.register(MyRPCResponse.class);
        return kryo;
    });
    @Override
    public void serializer(Object object, byte[] bytes) {

    }

    @Override
    public void serializer(Object object, byte[] bytes, int offset, int count) {

    }

    @Override
    public <T> T deserializer(byte[] bytes) {
        return null;
    }

    @Override
    public <T> T deserializer(byte[] bytes, int offset, int count) {
        return null;
    }
}

package com.hj.myrpc.protocol.serializer.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.hj.myrpc.protocol.entity.MyRPCRequest;
import com.hj.myrpc.protocol.entity.MyRPCResponse;
import com.hj.myrpc.protocol.serializer.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author hujin
 */
public class KryoSerializer implements ISerializer {
    private static ThreadLocal<Kryo> kryothreadLocal=ThreadLocal.withInitial(()->{
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
    public byte[] serializer(Object object, byte[] bytes) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Output output=new Output(byteArrayOutputStream);
        kryothreadLocal.get().writeObject(output,object);
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserializer(byte[] bytes,Class<T> clazz) {
       ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        Input input=new Input(byteArrayInputStream);
        T object=kryothreadLocal.get().readObject(input,clazz);
        input.close();
        return object;
    }

}

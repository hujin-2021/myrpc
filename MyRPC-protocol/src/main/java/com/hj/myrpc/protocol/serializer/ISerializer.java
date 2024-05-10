package com.hj.myrpc.protocol.serializer;

/**
 * @author hujin
 */
public interface ISerializer {
    byte[] serializer(Object object,byte[] bytes);

    <T> T deserializer(byte[] bytes,Class<T> clazz);

}

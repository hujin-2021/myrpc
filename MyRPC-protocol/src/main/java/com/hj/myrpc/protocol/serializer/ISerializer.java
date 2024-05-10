package com.hj.myrpc.protocol.serializer;

/**
 * @author hujin
 */
public interface ISerializer {
    void serializer(Object object,byte[] bytes);

    void serializer(Object object,byte[] bytes,int offset,int count);

    <T> T deserializer(byte[] bytes);

    <T> T deserializer(byte[] bytes,int offset,int count);
}

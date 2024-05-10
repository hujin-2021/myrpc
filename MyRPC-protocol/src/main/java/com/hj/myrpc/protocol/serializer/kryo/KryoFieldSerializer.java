package com.hj.myrpc.protocol.serializer.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer;

/**
 *  基于TaggedFieldSerializer做序列化
 *  使用自定义注解 @ShadowField 标记序列化的字段，能解决增加字段或者缺失字段另一端反序列化的问题
 *  同时性能也比CompatibleFieldSerializer高
 *
 * @author hujin*/
public class KryoFieldSerializer<T> extends TaggedFieldSerializer<T> {

    public KryoFieldSerializer(Kryo kryo,Class type,TaggedFieldSerializerConfig config){super(kryo,type,config);}


}

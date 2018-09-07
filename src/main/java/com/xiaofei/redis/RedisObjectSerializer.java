package com.xiaofei.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午1:55 2018/9/6
 **/
public class RedisObjectSerializer implements RedisSerializer<Object> {


    private Converter<Object, byte[]> serializer = new SerializingConverter();

    private Converter<byte[], Object> deserializer = new DeserializingConverter();


    static final byte[] EMPTY_ARRAY = new byte[0];

    /**
     * 序列化
     * @param o
     * @return
     * @throws SerializationException
     */
    @Nullable
    @Override
    public byte[] serialize(@Nullable Object o) throws SerializationException {
        if (o == null){
            return EMPTY_ARRAY;
        }
        return serializer.convert(o);
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Nullable
    @Override
    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0 ){
            return null;
        }
        Object convert = deserializer.convert(bytes);
        return convert;
    }
}

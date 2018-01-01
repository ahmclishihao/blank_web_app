package com.lshao.demo.dto;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 带初始值的链式map
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class ParamsMap extends LinkedHashMap<String,Object> {

    /**
     * 长度： 1
     */
    private static int SIZE_ONE = 1;

    /**
     * 长度： 2
     */
    private static int SIZE_THIN = 1 << 1;

    /**
     * 长度： 8
     */
    private static int SIZE_MEDIUM = 1 << 3;

    /**
     * 长度： 16
     */
    private static int SIZE_NORMAL = 1 << 4;

    public ParamsMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ParamsMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ParamsMap() {
    }

    public ParamsMap(Map<? extends String, ?> m) {
        super(m);
    }

    public ParamsMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    //-----------带初始值的 ParamsMap--------------

    public static ParamsMap one(){
        return new ParamsMap(SIZE_ONE);
    }

    public static ParamsMap thin(){
        return new ParamsMap(SIZE_THIN);
    }

    public static ParamsMap medium(){
        return new ParamsMap(SIZE_MEDIUM);
    }

    public static ParamsMap normal(){
        return new ParamsMap(SIZE_NORMAL);
    }


    /**
     * 链式 put
     * @param key
     * @param value
     * @return
     */
    public ParamsMap put1(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

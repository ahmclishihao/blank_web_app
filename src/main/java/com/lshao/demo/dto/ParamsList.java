package com.lshao.demo.dto;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 链式参数集合
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class ParamsList<T> extends LinkedList<T> {

    public ParamsList() {
        super();
    }

    public ParamsList(Collection<? extends T> c) {
        super(c);
    }

    /**
     * 链式
     * @param t
     * @return
     */
    public ParamsList<T> add1(T t) {
        super.add(t);
        return this;
    }

}

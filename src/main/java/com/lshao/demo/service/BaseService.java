package com.lshao.demo.service;

import com.lshao.demo.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author lish [254174981@qq.com]
 * @description
 * @date 17-12-3
 */
public interface BaseService<T,DAO extends BaseRepository<T>> {

    /**
     * 获取dao
     * @return
     */
    DAO getDao();

    /**
     * 向数据库插入一个{@link T}
     * @param t
     * @return
     */
    T add(T t);

    /**
     * 修改数据库插入一个{@link T}
     * @param t
     * @return
     */
    T modify(T t);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T getById(Serializable id);

    /**
     * 获取所有列表
     * @return
     */
    List<T> getList();

    /**
     * qbe式 查询对象
     * @param t
     * @return
     */
    T qbeGetOne(T t);

    /**
     * qbe式 获取集合
     * @param t
     * @return
     */
    List<T> qbeGetList(T t);


}

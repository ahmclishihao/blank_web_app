package com.lshao.demo.service.impl;

import com.lshao.demo.repository.BaseRepository;
import com.lshao.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * 服务实现 -- 基本增删改
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
public class BaseServiceImpl<T,DAO extends BaseRepository<T>> implements BaseService<T,DAO> {

    @Autowired
    private DAO dao;

    @Override
    public DAO getDao(){
        return this.dao;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public T add(T t) {
        return dao.save(t);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public T modify(T t) {
        return dao.save(t);
    }

    @Override
    public T getById(Serializable id) {
        return dao.findOne(id);
    }

    @Override
    public List<T> getList() {
        return dao.findAll();
    }

    @Override
    public T qbeGetOne(T t) {
        return dao.findOne(Example.of(t));
    }

    @Override
    public List<T> qbeGetList(T t) {
        return dao.findAll(Example.of(t));
    }
}

package com.lshao.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * dao基类,支持自定义sql
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Serializable>,JpaSpecificationExecutor<T>{
}

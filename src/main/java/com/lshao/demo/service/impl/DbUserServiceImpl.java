package com.lshao.demo.service.impl;

import com.lshao.demo.domain.DbUser;
import com.lshao.demo.repository.DbUserRepository;
import com.lshao.demo.service.DbUserService;
import org.springframework.stereotype.Service;

/**
 * 服务实现 -- DbUser
 * @author lish [254174981@qq.com]
 * @date 17-12-3
 */
@Service
public class DbUserServiceImpl extends BaseServiceImpl<DbUser,DbUserRepository> implements DbUserService {
}

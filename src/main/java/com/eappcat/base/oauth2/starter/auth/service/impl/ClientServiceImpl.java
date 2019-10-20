package com.eappcat.base.oauth2.starter.auth.service.impl;

import com.eappcat.base.oauth2.starter.auth.entity.Client;
import com.eappcat.base.oauth2.starter.auth.mapper.ClientMapper;
import com.eappcat.base.oauth2.starter.auth.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuebo
 * @since 2019-10-20
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {

}

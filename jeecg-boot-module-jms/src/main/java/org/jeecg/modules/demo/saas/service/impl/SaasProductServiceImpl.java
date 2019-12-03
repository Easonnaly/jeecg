package org.jeecg.modules.demo.saas.service.impl;

import org.jeecg.modules.demo.saas.entity.SaasProduct;
import org.jeecg.modules.demo.saas.mapper.SaasProductMapper;
import org.jeecg.modules.demo.saas.service.ISaasProductService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: saas服务产品表
 * @Author: jeecg-boot
 * @Date:   2019-12-03
 * @Version: V1.0
 */
@Service
public class SaasProductServiceImpl extends ServiceImpl<SaasProductMapper, SaasProduct> implements ISaasProductService {

}

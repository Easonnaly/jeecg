package org.jeecg.modules.demo.module.service.impl;

import org.jeecg.modules.demo.module.entity.Contract;
import org.jeecg.modules.demo.module.mapper.ContractMapper;
import org.jeecg.modules.demo.module.service.IContractService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 合同管理
 * @Author: jeecg-boot
 * @Date:   2019-11-25
 * @Version: V1.0
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

}

package org.jeecg.module.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2019-2025, xingyun information technology wuxi Co., Ltd.
 *
 * @author Eason
 * @version 1.00
 * @date 2019/11/26 11:20
 */
@Slf4j
@Api(tags = "新建module--jms")
@RequestMapping("/hello")
@RestController
public class IndexController {

    @ApiOperation("测试hello方法")
    @GetMapping(value="/")
    public Result<String> hello(){
        Result<String> result = new Result<String>();
        result.setResult("hello word!");
        result.setSuccess(true);
        return result;
    }
}

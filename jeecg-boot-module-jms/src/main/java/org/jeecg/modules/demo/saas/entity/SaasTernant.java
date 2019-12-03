package org.jeecg.modules.demo.saas.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: saas服务租户表
 * @Author: jeecg-boot
 * @Date:   2019-12-03
 * @Version: V1.0
 */
@Data
@TableName("saas_ternant")
public class SaasTernant implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.ID_WORKER_STR)
    private java.lang.String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    private java.lang.String createBy;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
    private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    private java.lang.String sysOrgCode;
	/**租户编号*/
	@Excel(name = "租户编号", width = 15)
    private java.lang.String ternantCode;
	/**租户名称*/
	@Excel(name = "租户名称", width = 15)
    private java.lang.String ternantName;
	/**备注一*/
	@Excel(name = "备注一", width = 15)
    private java.lang.String remark1;
	/**备注二*/
	@Excel(name = "备注二", width = 15)
    private java.lang.String remark2;
	/**备注三*/
	@Excel(name = "备注三", width = 15)
    private java.lang.String remark3;
}

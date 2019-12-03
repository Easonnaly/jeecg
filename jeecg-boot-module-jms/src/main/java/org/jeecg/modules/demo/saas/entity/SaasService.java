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
 * @Description: saas服务业务表
 * @Author: jeecg-boot
 * @Date:   2019-12-03
 * @Version: V1.0
 */
@Data
@TableName("saas_service")
public class SaasService implements Serializable {
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
	/**产品名称*/
	@Excel(name = "产品名称", width = 15)
    private java.lang.String product;
	/**购买方式*/
	@Excel(name = "购买方式", width = 15)
    private java.lang.String purchaseType;
	/**购买者*/
	@Excel(name = "购买者", width = 15)
    private java.lang.String purchaser;
	/**服务开始时间*/
	@Excel(name = "服务开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date startTime;
	/**服务结束时间*/
	@Excel(name = "服务结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date endTime;
	/**企业编码*/
	@Excel(name = "企业编码", width = 15)
    private java.lang.String enterpriseCode;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    private java.lang.String enterpriseName;
	/**服务状态*/
	@Excel(name = "服务状态", width = 15)
    private java.lang.String serviceState;
	/**二级域名*/
	@Excel(name = "二级域名", width = 15)
    private java.lang.String subDomain;
	/**备注一*/
	@Excel(name = "备注一", width = 15)
    private java.lang.String remark1;
	/**备注二*/
	@Excel(name = "备注二", width = 15)
    private java.lang.String remark2;
	/**备注三*/
	@Excel(name = "备注三", width = 15)
    private java.lang.String remark3;
	/**备注四*/
	@Excel(name = "备注四", width = 15)
    private java.lang.String remark4;
	/**备注五*/
	@Excel(name = "备注五", width = 15)
    private java.lang.String remark5;
	/**备注六*/
	@Excel(name = "备注六", width = 15)
    private java.lang.String remark6;
	/**备注七*/
	@Excel(name = "备注七", width = 15)
    private java.lang.String remark7;
	/**备注八*/
	@Excel(name = "备注八", width = 15)
    private java.lang.String remark8;
	/**备注九*/
	@Excel(name = "备注九", width = 15)
    private java.lang.String remark9;
	/**备注十*/
	@Excel(name = "备注十", width = 15)
    private java.lang.String remark10;
	/**备注十一*/
	@Excel(name = "备注十一", width = 15)
    private java.lang.String remark11;
	/**备注十二*/
	@Excel(name = "备注十二", width = 15)
    private java.lang.String remark12;
	/**备注十三*/
	@Excel(name = "备注十三", width = 15)
    private java.lang.String remark13;
	/**备注十四*/
	@Excel(name = "备注十四", width = 15)
    private java.lang.String remark14;
	/**备注十五*/
	@Excel(name = "备注十五", width = 15)
    private java.lang.String remark15;
}

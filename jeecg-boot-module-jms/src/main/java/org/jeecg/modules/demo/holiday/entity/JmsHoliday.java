package org.jeecg.modules.demo.holiday.entity;

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
 * @Description: 请假表
 * @Author: jeecg-boot
 * @Date:   2019-11-27
 * @Version: V1.0
 */
@Data
@TableName("jms_holiday")
public class JmsHoliday implements Serializable {
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
	/**请假人*/
	@Excel(name = "请假人", width = 15)
    private java.lang.String holPerson;
	/**请假类型*/
	@Excel(name = "请假类型", width = 15)
    private java.lang.String holType;
	/**请假开始时间*/
	@Excel(name = "请假开始时间", width = 15)
    private java.lang.String holStart;
	/**请假结束时间*/
	@Excel(name = "请假结束时间", width = 15)
    private java.lang.String holEnd;
	/**请假事由*/
	@Excel(name = "请假事由", width = 15)
    private java.lang.String holReason;
}

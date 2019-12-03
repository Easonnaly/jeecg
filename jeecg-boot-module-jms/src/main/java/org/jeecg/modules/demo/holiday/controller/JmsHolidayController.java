package org.jeecg.modules.demo.holiday.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.holiday.entity.JmsHoliday;
import org.jeecg.modules.demo.holiday.service.IJmsHolidayService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

 /**
 * @Description: 请假表
 * @Author: jeecg-boot
 * @Date:   2019-11-27
 * @Version: V1.0
 */
@RestController
@RequestMapping("/holiday/jmsHoliday")
@Slf4j
public class JmsHolidayController extends JeecgController<JmsHoliday, IJmsHolidayService> {
	@Autowired
	private IJmsHolidayService jmsHolidayService;
	
	/**
	 * 分页列表查询
	 *
	 * @param jmsHoliday
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<?> queryPageList(JmsHoliday jmsHoliday,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<JmsHoliday> queryWrapper = QueryGenerator.initQueryWrapper(jmsHoliday, req.getParameterMap());
		Page<JmsHoliday> page = new Page<JmsHoliday>(pageNo, pageSize);
		IPage<JmsHoliday> pageList = jmsHolidayService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param jmsHoliday
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody JmsHoliday jmsHoliday) {
		jmsHolidayService.save(jmsHoliday);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param jmsHoliday
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody JmsHoliday jmsHoliday) {
		jmsHolidayService.updateById(jmsHoliday);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		jmsHolidayService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.jmsHolidayService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		JmsHoliday jmsHoliday = jmsHolidayService.getById(id);
		if(jmsHoliday==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(jmsHoliday);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param jmsHoliday
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, JmsHoliday jmsHoliday) {
        return super.exportXls(request, jmsHoliday, JmsHoliday.class, "请假表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, JmsHoliday.class);
    }

}

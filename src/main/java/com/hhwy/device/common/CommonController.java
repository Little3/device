package com.hhwy.device.common;



import com.hhhwy.common.property.$;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共工具类，静态资源地址，监控信息等
 */
@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 静态资源地址
	 * @param request
	 * @return
	 */
	@RequestMapping("/staticpath")
    public String commonVariables(HttpServletRequest request) {
	   String staticPath="http://yth.365grid.cn/static/product/";
       return $.get("fweb.iot.data.server.static",staticPath);
    }

}

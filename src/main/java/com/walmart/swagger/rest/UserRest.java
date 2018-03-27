package com.walmart.swagger.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.swagger.model.User;
import com.walmart.swagger.resp.Resp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API - VehiclesController")
@RestController
@RequestMapping("/test")
public class UserRest {
	static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

	@ApiOperation(value = "获取用户列表", notes = "")
	 @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = true, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful — 请求已完成",response=Resp.class),
			@ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"), @ApiResponse(code = 401, message = "未授权客户机访问数据"),
			@ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"), @ApiResponse(code = 500, message = "服务器不能完成请求") })
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<User> getUserList(String name) {
		List<User> r = new ArrayList<User>(users.values());
		User u1 = new User();
		u1.setAge(20);
		u1.setId("1");
		u1.setName("test1");
		User u2 = new User();
		u2.setAge(18);
		u2.setId("2");
		u2.setName("test2");
		r.add(u1);
		r.add(u2);

		return r;
	}

}

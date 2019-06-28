package com.atguigu.scw.common.vo.resp;

import com.atguigu.scw.common.enums.ResponseCodeEnume;

import lombok.Data;

/**
 * 应用统一返回
 */
@Data
public class AppResponse<T> {

	private Integer code;
	private String msg;
	private T data;
	

	/**
	 * 快速响应成功
	 * @param data
	 * @return
	 */
	public static<T> AppResponse<T> ok(T data){
		AppResponse<T> resp = new AppResponse<>();
		resp.setCode(ResponseCodeEnume.SUCCESS.getCode());
		resp.setMsg(ResponseCodeEnume.SUCCESS.getMsg());
		resp.setData(data);
		return resp;
	}
	
	/**
	 * 快速响应失败
	 */
	public static<T> AppResponse<T> fail(T data){
		AppResponse<T> resp = new AppResponse<>();
		resp.setCode(ResponseCodeEnume.FAIL.getCode());
		resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
		resp.setData(data);
		return resp;
	}
}

package com.jcstool.util;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jcstool.vo.WebUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 管理Session的工具类
 */
public class SessionUtil {

	private final static SessionUtil INSTANCE = new SessionUtil();
	public Set<WebUser> users=new HashSet<>();
	
	private SessionUtil(){};
	public static SessionUtil getInstance(){
		if(INSTANCE == null){
			return new SessionUtil();
		}
		return INSTANCE;
	}
	
	
	public void setAttribute(String name ,Object value){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		session.setAttribute(name, value);
	}
	
	public void setAttribute(HttpServletRequest request,String name ,Object value){
		HttpSession session = request.getSession(false);
		session.setAttribute(name, value);
	}
	
	
	public Object getAttribute(String name){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession(false);
		return session.getAttribute(name);
	}

	public WebUser getUser(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return (WebUser)request.getAttribute("user");
	}

	public boolean isLogin(){
		return getUser()!=null;
	}

	public boolean isNotLogin(){
		return !isLogin();
	}
	/**
	 * 设置用户Session失效
	 * @param request
	 */
	public void setUserSessionInvalidate(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null){
			WebUser user = (WebUser) session.getAttribute("user");
			if(user != null){
				//onLineUsers.remove(user.getAccount());
				session.removeAttribute("user");
				session.invalidate();
			}
		}
	}
	
	/**
	 * 检验用户信息是否存在于在线人员中
	 * @param request
	 * @return true 在 否则不在
	 */
//	public boolean checkSessionIsValid(HttpServletRequest request){
//		SysUser user = this.getUserFromSession(request);
//		if(user != null){
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 *  //给当前用户的资源建立索引
//	 */
//	public void indexUserResource() {
//		// TODO Auto-generated method stub
//		SysUser user = this.getUserFromSession();
//		Set<SysResource> res=user.getRole().getResources();
//		Map<String,SysResource> index=new HashMap<String,SysResource>();
//		for(SysResource x:res){
//			index.put(x.getUrl(), x);
//		}
//		
//		setAttribute("resourceIndex", index);
//	}
//	/**
//	 *  //给当前用户的资源建立索引
//	 */
//	public void indexUserResource(HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		SysUser user = this.getUserFromSession(request);
//		Set<SysResource> res=user.getRole().getResources();
//		Map<String,SysResource> index=new HashMap<String,SysResource>();
//		for(SysResource x:res){
//			index.put(x.getUrl(), x);
//		}
//		setAttribute(request,"resourceIndex", index);
//	}
//	
//	
//	/**
//	 *  获取当前资源索引
//	 */
//	@SuppressWarnings("unchecked")
//	public Map<String,SysResource> getUserResourceIndex() {
//		return (Map<String, SysResource>) getAttribute("resourceIndex");
//	}
}

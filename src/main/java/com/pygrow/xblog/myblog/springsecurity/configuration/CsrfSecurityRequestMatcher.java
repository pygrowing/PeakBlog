package com.pygrow.xblog.myblog.springsecurity.configuration;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

/**
* @author E先生
* @version 创建时间：2018年9月13日 下午5:33:21
* @ClassName CsrfSecurityRequestMatcher
* @Description 防攻击策略
*/
public class CsrfSecurityRequestMatcher implements RequestMatcher {
	
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
	
	//需要排除的url
	private List<String> execludeUrls; 

	@Override
	public boolean matches(HttpServletRequest request) {
		if(execludeUrls != null && execludeUrls.size()>0) {
			String servletPath = request.getServletPath();
			for(String url:execludeUrls) {
				if (servletPath.contains(url)) {
					return false;
				}
			}
		}
		return !allowedMethods.matcher(request.getMethod()).matches();
	}

	public List<String> getExecludeUrls() {
		return execludeUrls;
	}

	public void setExecludeUrls(List<String> execludeUrls) {
		this.execludeUrls = execludeUrls;
	}

}

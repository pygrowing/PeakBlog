package com.pygrow.xblog.myblog.springsecurity.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* @author E先生
* @version 创建时间：2018年7月3日 下午3:04:11
* @ClassName SecurityConfig
* @Description 安全配置类，用来负责应用程序内所有安全
*/
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 配置SpringSecurity拦截策略
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**","/admin/markdown/**", "/admin/img/**","/fonts/**", "/index").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/login").failureUrl("/login-error")
				.and().csrf().requireCsrfProtectionMatcher(csrfSecurityRequestMatcher());
	}

	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 * inMemoryAuthentication 将认证信息存储于内存中
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("py")
				.password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");

	}
	
	/*
	 * 加入需要排除阻止CSRF攻击的链表链接，链接地址中包含/admin字符串的，对其忽略CSRF保护策略
	 */
	private CsrfSecurityRequestMatcher csrfSecurityRequestMatcher() {
		CsrfSecurityRequestMatcher csrfSecurityRequestMatcher = new CsrfSecurityRequestMatcher();
		List<String> list = new ArrayList<String>();
//		list.add("/admins/saveblog");
		list.add("/admins/showBlog");
		list.add("/admins/conditionBlog");
		list.add("/admins/showType");
        csrfSecurityRequestMatcher.setExecludeUrls(list);
        return csrfSecurityRequestMatcher;
	}
}

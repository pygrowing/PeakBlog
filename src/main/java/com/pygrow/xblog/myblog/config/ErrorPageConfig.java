package com.pygrow.xblog.myblog.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
* @author E先生
* @version 创建时间：2018年10月22日 下午5:49:44
* @ClassName ErrorPageConfig
* @Description 错误页配置
*/
@Configuration
public class ErrorPageConfig {
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
		return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
			@Override
			public void customize(ConfigurableWebServerFactory factory) {
				factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/errorpage/error-400.html"));
				factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/errorpage/error-400.html"));
				factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/errorpage/error-500.html"));
			}
		};
	}
}

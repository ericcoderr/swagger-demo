package com.walmart.swagger;

import java.time.Duration;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.Http2;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory = webServerFactory();
	}
	
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		factory.setPort(9000);
		Session session = new Session();
		session.setTimeout(Duration.ofMinutes(10));
		factory.setSession(session);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index.html"));
		Http2 http2 = new Http2();
		http2.setEnabled(true);
		factory.setHttp2(http2);
		return factory;
	}

}

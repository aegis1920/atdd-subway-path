package wooteco.subway.admin.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

public class ETagHeaderFilter {
	@Bean
	public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter(){
		FilterRegistrationBean<ShallowEtagHeaderFilter> filter =
			new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
		filter.addUrlPatterns("/api/*");
		filter.setName("etagFilter");

		return filter;
	}
}

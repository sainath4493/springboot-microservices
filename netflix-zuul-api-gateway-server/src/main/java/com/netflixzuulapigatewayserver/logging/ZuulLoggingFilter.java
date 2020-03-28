package com.netflixzuulapigatewayserver.logging;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * should this filter be executed or not.
	 */
	@Override
	public boolean shouldFilter() {

		return true;
	}

	/*
	 * real logic of the interception goes.
	 * 
	 * log the content of the request
	 */
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} Request uri -> {}", request, request.getRequestURI());
		return null;
	}

	/*
	 * Should filter be happening before the request is executed or after the
	 * request has executed. Or do you want to filter only error
	 */
	@Override
	public String filterType() {
		return "pre"; // pre, post, error
	}

	/*
	 * If you have multiple filters so lets say you have a Zuul logging filter Zuul
	 * security filter and a lot of other filters you can set a priority order
	 * between them.
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}

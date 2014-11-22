package adfilter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import utils.WebADFilterTools;

public class WebADFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getParameter("url");
		List<String> list = WebADFilterTools.doRequest(url, false);
		request.setAttribute("urls", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	public void destroy() {
	}
	
}

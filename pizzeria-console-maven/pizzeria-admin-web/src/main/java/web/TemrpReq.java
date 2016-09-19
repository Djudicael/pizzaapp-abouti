package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.stylesheets.LinkStyle;

@WebFilter(urlPatterns = { "/*" }, description = "Request timer filter")
public class TemrpReq implements Filter {
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* Cast des objets request et response */
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();
		config.getServletContext().log(path + " : " + (after - before));
		
		Map<String, List<Long>> mapPerf = (Map<String, List<Long>>) request.getServletContext().getAttribute("time");
		
		if(mapPerf == null) {
			mapPerf =  new HashMap<>();
		}
		
		List<Long> listTempsExec = mapPerf.get(path);
		
		if(listTempsExec == null) {
			listTempsExec = new ArrayList<>();
			mapPerf.put(path, listTempsExec);
		}
		
		listTempsExec.add((after - before));
		
		request.getServletContext().setAttribute("time",mapPerf);
		//((HttpServletResponse) response).sendRedirect("/techn");

		// request.getRequestDispatcher("/techn").forward(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

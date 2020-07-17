package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	private String encoding;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getCharacterEncoding()==null) {
			
		request.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);

	}
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// web.xml 문서에 있는 내용을 읽어서 필드에 저장한다.
		encoding = filterConfig.getInitParameter("encoding"); 
		
	}

}


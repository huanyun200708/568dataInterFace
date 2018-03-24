package cn.com.hq.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter{
	private static Logger log = Logger.getLogger(SessionFilter.class);
	/** 要检查的 session 的名称 */
    private String sessionKey;
     
    public SessionFilter(){
	}
     
    /**
     * 过滤方法
     * 
     * @param request
     *            request 对象
     * @param response
     *            response 对象
     * @param arg2
     *            字符过滤
     * @throws IOException
     *             io 异常
     * @throws ServletException
     *             servlet 异常
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        Object sessionObj = req.getSession().getAttribute(sessionKey);
        String servletPath = req.getServletPath();
        if(servletPath.equals("/page/login.jsp") && sessionObj == null){
        	arg2.doFilter(req, res);
        }
        else if (!servletPath.equals("/page/login.jsp") &&sessionObj == null) {
            String contextPath = req.getContextPath();
            PrintWriter out = res.getWriter();  
            out.println("<html>");      
            out.println("<script>");      
            out.println("window.open ('"+contextPath+"/page/login.jsp','_top')");      
            out.println("</script>");      
            out.println("</html>");
        }else {
        	arg2.doFilter(req, res);
		}
    }
    /**
     * 初始化方法
     * 
     * @param filterConfig
     *            过滤配置对象
     * @throws ServletException
     *             servlet 异常
     */
    public void init(FilterConfig filterConfig)throws ServletException
    {
    	sessionKey = filterConfig.getInitParameter("sessionKey");
        filterConfig.getInitParameter("redirectUrl");
    	
    }
    /**
     * 销毁方法
     */
    public void destroy()
    {
    }   
}

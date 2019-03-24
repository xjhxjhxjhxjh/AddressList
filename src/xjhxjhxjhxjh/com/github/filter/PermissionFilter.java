package xjhxjhxjhxjh.com.github.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter
 */
public class PermissionFilter implements javax.servlet.Filter {
    
    /**
     * Default constructor. 
     */
    public PermissionFilter() {
    }
    
    /**
     * @see PermissionFilter#destroy()
     */
    public void destroy() {
    }
    
    /**
     * @see PermissionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取session
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        // 从session中获取用户
        String username = (String)session.getAttribute("username");
        if (null == username) {
            request.setAttribute("msg","对不起，请没有访问权限!!!");
            request.getRequestDispatcher("/error").forward(request, response);
            return;
        }
        // 如果存在放行
        chain.doFilter(request, response);
    }
    
    /**
     * @see PermissionFilter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }
    
}

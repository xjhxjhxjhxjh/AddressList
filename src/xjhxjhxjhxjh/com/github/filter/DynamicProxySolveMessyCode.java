package xjhxjhxjhxjh.com.github.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filter
 */
public class DynamicProxySolveMessyCode implements javax.servlet.Filter {

    /**
     * Default constructor.
     */
    public DynamicProxySolveMessyCode() {
    }

    /**
     * @see DynamicProxySolveMessyCode#destroy()
     */
    public void destroy() {
    }

    /**
     * @see DynamicProxySolveMessyCode#doFilter(ServletRequest, ServletResponse,
     *      FilterChain)
     */
    public void doFilter(ServletRequest r, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 要增强的方法:request.getParameter
        // 被代理的对象: request

        final HttpServletRequest request = (HttpServletRequest) r;
        // 动态代理
        HttpServletRequest hsr = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 判断是否是需要增强的方法
                        if ("getParameter".equals(method.getName())) {
                            // 判断getParameter提交的方式
                            String method1 = request.getMethod();
                            if ("get".equalsIgnoreCase(method1)) {
                                // 解决乱码
                                String string = (String) method.invoke(request, args);
                                return new String(string.getBytes("iso8859-1"), "utf-8");
                            } else if ("post".equalsIgnoreCase(method1)) {
                                request.setCharacterEncoding("utf-8");
                            }
                        }
                        return method.invoke(request, args);
                    }
                });

        chain.doFilter(hsr, response);
    }

    /**
     * @see DynamicProxySolveMessyCode#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}

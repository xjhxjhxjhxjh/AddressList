package xjhxjhxjhxjh.com.github.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 通过字节码对象获取到类指定的方法
            Class<? extends BaseServlet> class1 = this.getClass();
            // 从Session中获取用户名
            String username = (String) request.getSession().getAttribute("username");
            // 获取方法并执行
            Method method = class1.getMethod(request.getParameter("method"), HttpServletRequest.class,HttpServletResponse.class,String.class);
            String value = (String) method.invoke(class1.newInstance(), request, response,username);
            // 请求转发
            if (null != value) {
                request.getRequestDispatcher(value).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
}

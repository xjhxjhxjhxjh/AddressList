package xjhxjhxjhxjh.com.github.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xjhxjhxjhxjh.com.github.domain.User;
import xjhxjhxjhxjh.com.github.service.LogInService;

/**
  * 登陆servlet
 * @author xjhxjhxjh
 *
 */
public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取前台录入的验证码
        String verificationCode = request.getParameter("verificationCode");
        //从Session中获取验证码
        String sessionVerificationCode = (String)request.getSession().getAttribute("sessionVerificationCode");
        //清空session保证点击登录的时候验证码是最新的
        request.getSession().removeAttribute("sessionVerificationCode");
        //创建LogInService
        LogInService logInService = new LogInService();
        try {
            //校验验证码
            if(null == verificationCode || verificationCode==""||verificationCode.trim().length()==0){
                //把错误信息放入request域中
                request.setAttribute("msg", "请输入验证码");
                //请求转发
                request.getRequestDispatcher("/LogInError.jsp").forward(request, response);
                return;
            }else{
                //如果两个验证不一样  需要给出提示
                if(!verificationCode.equalsIgnoreCase(sessionVerificationCode)){
                    //把错误信息放入request域中
                    request.setAttribute("msg", "请输入正确的验证码");
                    //请求转发
                    request.getRequestDispatcher("/LogInError.jsp").forward(request, response);
                    return;
                }
            }
            //调用service中的方法
            User user=logInService.getUserByUsernameAndPwd(username,password);
            //根据返回的对象，判断提示信息的内容
            if(null == user){
                //把错误信息放入request域对象中
                request.setAttribute("msg", "登录失败,请输入正确的用户名和密码");
                //使用请求转发跳转到error.jsp
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }else{
                request.getSession().setAttribute("username", username);
                request.getRequestDispatcher("/homePage.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
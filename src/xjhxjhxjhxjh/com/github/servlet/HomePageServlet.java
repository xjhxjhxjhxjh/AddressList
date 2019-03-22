package xjhxjhxjhxjh.com.github.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import xjhxjhxjhxjh.com.github.domain.Contact;
import xjhxjhxjhxjh.com.github.domain.Page;
import xjhxjhxjhxjh.com.github.service.HomePageService;
import xjhxjhxjhxjh.com.github.utils.BaseServlet;

public class HomePageServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // 解决乱码
////        request.setCharacterEncoding("utf-8");
//        // 从Session中获取用户名
////        String username = (String) request.getSession().getAttribute("username");
////        // 获取method
////        String method = request.getParameter("method");
////        // 根据method判断执行
////        if ("findAll".equals(method)) {
////            findAll(request, response, username);
////        } else if ("addUI".equals(method)) {
////            addUI(request, response);
////        } else if ("add".equals(method)) {
////            add(request, response, username);
////        } else if ("delete".equals(method)) {
////            delete(request, response, username);
////        } else if ("batchDelete".equals(method)) {
////            batchDelete(request, response, username);
////        } else if ("edit".equals(method)) {
////            edit(request, response, username);
////        } else if ("update".equals(method)) {
////            update(request, response, username);
////        } else if ("search".equals(method)) {
////            search(request, response, username);
////        }
//    }

    /**
     * 关键词搜索
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String search(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取前台录入的关键字
            String name = request.getParameter("name");
            String ugroup = request.getParameter("ugroup");
            // 调用方法
            HomePageService homePageService = new HomePageService();
            List<Contact> list = homePageService.search(name, ugroup, username);
            // 把list集合放入request域对象中
            request.setAttribute("list", list);
            // 请求转发到查询所有商品的链接上
            return "/homePage.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询失败");
            return "/error.jsp";
        }
    }

    /**
     * 更新联系人的信息
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String update(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取前台录入的信息
            Map<String, String[]> map = request.getParameterMap();
            // 创建bean
            Contact contact = new Contact();
            // 把map中的数据拷贝到bean中
            BeanUtils.populate(contact, map);
            // 调用service完成数据更新
            HomePageService homePageService = new HomePageService();
            homePageService.update(contact, username);
            // 请求转发到查询所有商品的链接上
            return "/homePage?method=findAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "编辑失败");
            return "/error.jsp";
        }
    }

    /**
     * 
     * 修改联系人信息,根据id查询联系人，跳转到edit.jsp
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String edit(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取id
            String id = request.getParameter("id");
            // 调用方法查询联系人
            HomePageService homePageService = new HomePageService();
            Contact contact = homePageService.findContactByID(id, username);
            // 把联系人放入request中
            request.setAttribute("contact", contact);
            // 请求转发到edit.jsp
            return "/edit.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "编辑失败");
            return "/error.jsp";
        }
    }

    /**
     * 批量删除
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String batchDelete(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取ids
            String[] ids = request.getParameterValues("id");
            // 调用service完成批量删除商品操作
            HomePageService homePageService = new HomePageService();
            homePageService.batchDelete(ids, username);
            // 请求转发到查询所有的链接上
            return "/homePage?method=findAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "批量删除联系人出现错误");
            return "/HomePageError.jsp";
        }
    }

    /**
     * 根据id删除联系人
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String delete(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取id
            String id = request.getParameter("id");
            // 调用service完成删除商品操作
            HomePageService homePageService = new HomePageService();
            homePageService.delete(id, username);
            // 请求转发到查询所有的链接上
            return "/homePage?method=findAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "删除联系人出现错误");
            return "/HomePageError.jsp";
        }
    }

    /**
     * 添加联系人
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String add(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 获取前台数据
            Map<String, String[]> parameterMap = request.getParameterMap();
            // 创建bean
            Contact contact = new Contact();
            // 把map中的数据拷贝到bean中
            BeanUtils.populate(contact, parameterMap);
            // 调用service完成保存操作
            HomePageService homePageService = new HomePageService();
            homePageService.add(contact, username);
            // 请求转发到查询链接
            return "/homePage?method=findAll";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "添加联系人出现错误");
            return "/HomePageError.jsp";
        }
    }

    /**
     * 防止具体的资源暴露在地址栏后面
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public String addUI(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException {
        return "/add.jsp";
    }

    /**
     * 查询所有联系人
     * 
     * @param request
     * @param response
     * @param username
     * @throws IOException
     * @throws ServletException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response, String username)
            throws ServletException, IOException {
        try {
            // 封装Page
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int pageSize = 4;
            // 创建并调用方法
            HomePageService homePageService = new HomePageService();
            Page<Contact> page = homePageService.getPage(pageNumber, pageSize, username);
            // 将0和1转换为男女
            for (Contact contact : page.getList()) {
                if (contact.getSex().equals("0")) {
                    contact.setSex("男");
                } else {
                    contact.setSex("女");
                }
            }
            // 请求转发到homePage.jsp
            request.setAttribute("page", page);
            return "/homePage.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询联系人出现错误");
            return "/HomePageError.jsp";
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

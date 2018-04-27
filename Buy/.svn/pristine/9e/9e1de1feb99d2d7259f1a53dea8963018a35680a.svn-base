package edu.tzl.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.tzl.web.dao.MproductDaoImp;
import edu.tzl.web.dao.UserDaoImp;
import edu.tzl.web.entity.Comment;
import edu.tzl.web.entity.PaperHelp;
import edu.tzl.web.entity.ProductClass;
import edu.tzl.web.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImp dao = new UserDaoImp();
	MproductDaoImp dao1=new MproductDaoImp();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//在用户登录之后就初始化商品的大分类和小分类（直接新增分类时，下拉框需要动态显示，也可以用脚本来写）
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		List<ProductClass> list=dao1.selectProductclass();
		ServletContext s = this.getServletContext();
		s.setAttribute("ProductClass", list);
		
	
		
		List<ProductClass> list_=dao1.selectProductclass_();
		s.setAttribute("ProductClass_", list_);
		
		
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//注册
		if ("zhuce".equals(action)) {
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String veryCode = request.getParameter("veryCode");
			// 得到验证码的session作用域
			HttpSession session = request.getSession();
			String sessioncode = (String) session.getAttribute("safecode");
			//判断是否和session作用域的验证码是否一样
			if (!(veryCode.equals(sessioncode))) {
				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("zhuce.jsp").forward(request,
						response);
			} else {
				dao.zhuce(userName, passWord);
				request.getRequestDispatcher("dozhuce.jsp").forward(request,
						response);
			}
			
		//登录
		} else if ("login".equals(action)) {
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String veryCode = request.getParameter("veryCode");
			// 得到验证码的session作用域
			HttpSession session = request.getSession();
			String sessioncode = (String) session.getAttribute("safecode");
			if (!(veryCode.equals(sessioncode))) {
				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				User u = dao.login(userName, passWord);
				if (u != null) {
					int statues = 1;
					//更新登录状态
					dao.UpdateStatues(statues, u.getId());
					HttpSession sessionid = request.getSession();
					sessionid.setAttribute("user", u);
					
					//判断是否为管理员
					if(u.getStatus().equals("管理员")){
						Date date=new Date();
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
						String date1=sf.format(date);
						request.setAttribute("mlogin", "管理员"+u.getName()+"您好,今天是"+date1+",欢迎回到管理后台。");
						request.getRequestDispatcher("mindex.jsp").forward(request,response);
					
					//普通用户
					}else{
						ServletContext s=this.getServletContext();
						s.setAttribute("login", u.getName()
								+ ",您好<a href='UserServlet?action=zhuxiao'>注销</a>");
						request.getRequestDispatcher("index.jsp").forward(request,
								response);
					}
				
				//登录失败
				} else {
					request.setAttribute("logf", "用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				}
			}
		
		//注销
		} else if ("zhuxiao".equals(action)) {
			int statues = 0;
			HttpSession s = request.getSession();
			User u = (User) s.getAttribute("user");
			dao.UpdateStatues(statues, u.getId());
			s.removeAttribute("user");
			
			//清除提示语
			ServletContext s1=this.getServletContext();
			s1.setAttribute("login", "");
			response.sendRedirect("index.jsp");
		}

	}

}

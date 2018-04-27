package edu.tzl.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tzl.web.dao.MproductDaoImp;
import edu.tzl.web.entity.PaperHelp;
import edu.tzl.web.entity.Product;
import edu.tzl.web.entity.ProductClass;
import edu.tzl.web.entity.User;

/**
 * Servlet implementation class MproductServlet
 */
@WebServlet("/MproductServlet")
public class MproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MproductDaoImp dao=new MproductDaoImp();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MproductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String action=request.getParameter("action");
		
		//查询商品大分类
		if("selectAll-productClass".equals(action)){
			ServletContext s1 = this.getServletContext();
			
			List<ProductClass> list=dao.selectProductclass();
			s1.setAttribute("ProductClass", list);
			
			List<ProductClass> list_=dao.selectProductclass_();
			s1.setAttribute("ProductClass_", list_);
			request.getRequestDispatcher("MproductClass.jsp").forward(request, response);
		
		//增加大小分类
		}else if("add".equals(action)){
			int id=Integer.valueOf(request.getParameter("parentId"));
			String name=request.getParameter("className");
			
			if(id==0){
				//增加父分类
				dao.add(id, name);
			}else{
				//增加小分类
				dao.add(id,name);
			}
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//删除大小分类
		}else if("delete".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			dao.delete(id);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//查询小分类（修改）
		}else if("get".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			ProductClass pc=dao.querryByid(id);
			request.setAttribute("Pclass", pc);
			request.getRequestDispatcher("MproductClass-update.jsp").forward(request, response);
		
		//修改小分类
		}else if("update".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			int parentId=Integer.valueOf(request.getParameter("parentId"));
			String className=request.getParameter("className");
			dao.update(id, className, parentId);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//查询所有商品
		}else if("selectAll-product".equals(action)){
			int pageRow=5;
			String nowPage=request.getParameter("nowPage");
			if(nowPage==null){
				nowPage="1";
			}
			int totalRow=dao.querryCount();
			List<Product> list=dao.selectAll(pageRow,Integer.valueOf(nowPage));
			//实例化分页对象
			PaperHelp ph=new PaperHelp( pageRow, totalRow, Integer.valueOf(nowPage),  list);
			request.setAttribute("plist", ph);
			request.getRequestDispatcher("Mproduct.jsp").forward(request, response);
		
		//根据id查询商品（修改）
		}else if("getProduct".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			Product p=dao.querryProductByid(id);
			request.setAttribute("Productp", p);
			request.getRequestDispatcher("Mproduct-update.jsp").forward(request, response);
		
		//删除商品
		}else if("deleteProduct".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			dao.deleteProduct(id);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//前台首页面，点击商品，显示商品的所有信息页面
		}else if("getproductIndex".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			Product p=dao.querryProductByid(id);
			request.setAttribute("Productviews", p);
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
		}
	}
}

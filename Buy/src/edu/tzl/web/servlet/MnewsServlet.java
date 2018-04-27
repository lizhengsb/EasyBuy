package edu.tzl.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tzl.web.dao.MnewsDaoImp;
import edu.tzl.web.dao.MproductDaoImp;
import edu.tzl.web.entity.News;
import edu.tzl.web.entity.PaperHelp;
import edu.tzl.web.entity.Product;

/**
 * Servlet implementation class MnewsServlet
 */
@WebServlet("/MnewsServlet")
public class MnewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MnewsDaoImp dao=new MnewsDaoImp(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MnewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action =request.getParameter("action");
		
		//增加新闻
		if("addnews".equals(action)){
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			System.out.println(title+content);
			dao.addnew(title, content);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//分页查询
		}else if("selectAll-news".equals(action)){
			String nowPage=request.getParameter("nowPage");
			if(nowPage==null){
				nowPage="1";
			}
			int pageRow=5;
			int totalRow=dao.querryCount();
			List<News> list=dao.selectall(pageRow,Integer.valueOf(nowPage));
			PaperHelp ph=new PaperHelp(pageRow, totalRow, Integer.valueOf(nowPage), list);
			request.setAttribute("Mnews",ph);
			request.getRequestDispatcher("Mnews.jsp").forward(request, response);
		
		//id查询新闻（修改）
		}else if("get".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			News n=dao.querryByid(id);
			request.setAttribute("news", n);
			request.getRequestDispatcher("Mnews-update.jsp").forward(request, response);
		
		//修改新闻
		}else if("updatenews".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			dao.updatenews(id,title,content);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//删除新闻
		}else if("delete".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			dao.delete(id);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//前台展示新闻
		}else if("getnew".equals(action)){
			List<News> list=dao.selectall();
			request.setAttribute("newview", list);
			
			int id=Integer.valueOf(request.getParameter("id"));
			News n=dao.querryByid(id);
			request.setAttribute("newss", n);
			request.getRequestDispatcher("News-view.jsp").forward(request, response);
		
		//首页展示商品和新闻
		}else if("select-new".equals(action)){
			MnewsDaoImp dao = new MnewsDaoImp();
			List<News> list = dao.selectall();
			request.setAttribute("nlist", list);
			
		
			MproductDaoImp dao1=new MproductDaoImp();
			List<Product> listP = dao1.selectAll();
			request.setAttribute("plist", listP);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}

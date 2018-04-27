package edu.tzl.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tzl.web.dao.MorderDaoImp;
import edu.tzl.web.entity.Order;
import edu.tzl.web.entity.PaperHelp;

/**
 * Servlet implementation class MorderServlet
 */
@WebServlet("/MorderServlet")
public class MorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MorderDaoImp dao=new MorderDaoImp();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		
		//管理员查询所有订单
		if("selectAll-order".equals(action)){
			String  nowPage=request.getParameter("nowPage");
			if(nowPage==null){
				nowPage="1";
			}
			int pageRow=5;
			int totalRow=dao.qurryCount();
			List<Order> list=dao.selectAll(pageRow, Integer.valueOf(nowPage));
			PaperHelp ph=new PaperHelp(pageRow, totalRow, Integer.valueOf(nowPage), list);
			request.setAttribute("orderlist", ph);
			request.getRequestDispatcher("Morder.jsp").forward(request, response);
	
		//根据订单id查询订单
		}else if("get".equals(action)){
			int oid=Integer.valueOf(request.getParameter("oid"));
			Order o=dao.qurryOreder(oid);
			request.setAttribute("o", o);
			request.getRequestDispatcher("Morder-update.jsp").forward(request, response);
		
		//修改订单
		}else if("update".equals(action)){
			int oid=Integer.valueOf(request.getParameter("oid"));
			String status=request.getParameter("sel");
			dao.update(oid,status);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//删除订单
		}else if("delete".equals(action)){
			int oid=Integer.valueOf(request.getParameter("oid"));
			dao.delete(oid);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		}
	}

}

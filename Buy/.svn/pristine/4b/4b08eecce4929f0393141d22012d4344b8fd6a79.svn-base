package edu.tzl.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tzl.web.dao.McommentDaoImp;
import edu.tzl.web.entity.Comment;
import edu.tzl.web.entity.PaperHelp;

/**
 * Servlet implementation class McommentServlet
 */
@WebServlet("/McommentServlet")
public class McommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    McommentDaoImp dao=new McommentDaoImp();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public McommentServlet() {
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
		
		//增加一条留言
		if("add".equals(action)){
			String comment=request.getParameter("guestContent");
			String name=request.getParameter("guestName");
			dao.addGuest(comment, name);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//分页查询所有留言
		}else if("selectAll-guest".equals(action)){
			int pageRow=5;
			String nowPage=request.getParameter("nowPage");
			if(nowPage==null){
				nowPage="1";
			}
			List<Comment> list=dao.selectguest(pageRow, Integer.valueOf(nowPage));
			int totalRow=dao.querryCount();
			PaperHelp ph=new PaperHelp(pageRow, totalRow, Integer.valueOf(nowPage), list);
			request.setAttribute("Guestlist", ph);
			request.getRequestDispatcher("Mguest.jsp").forward(request, response);
		
		//id查询留言
		}else if("get".equals(action)){
			String id=request.getParameter("id");
			System.out.println(id);
			Comment c=dao.selectCommentId(Integer.valueOf(id));
			request.setAttribute("guest", c);
			request.getRequestDispatcher("Mguest-reply.jsp").forward(request, response);
		
		//管理员回复
		}else if("reply".equals(action)){
			String orderId=request.getParameter("orderId");
			String replyContent=request.getParameter("replyContent");
			dao.reply(Integer.valueOf(orderId),replyContent);
			String status="已回复";
			//修改留言状态
			dao.updateStatus(Integer.valueOf(orderId), status);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//删除留言
		}else if("delete".equals(action)){
			int id=Integer.valueOf(request.getParameter("id"));
			dao.delete(id);
			request.getRequestDispatcher("doManage.jsp").forward(request, response);
		
		//首页留言的分页
		}else if("index-fenye".equals(action)){
			int pageRow=5;
			String nowPage=request.getParameter("nowPage");
			if(nowPage==null){
				nowPage="1";
			}
			List<Comment> list=dao.selectguest(pageRow, Integer.valueOf(nowPage));
			int totalRow=dao.querryCount();
			PaperHelp ph=new PaperHelp(pageRow, totalRow, Integer.valueOf(nowPage), list);
			request.setAttribute("Guestindex", ph);
			
			//回复
			List<Comment> list1=dao.selectReply();
			request.setAttribute("Replyindex", list1);
			request.getRequestDispatcher("guest-add.jsp").forward(request, response);
		}
	}

	

}

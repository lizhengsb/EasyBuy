package edu.tzl.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tzl.web.dao.ManageDaoImp;
import edu.tzl.web.dao.MproductDaoImp;
import edu.tzl.web.dao.ShoppingDaoImp;
import edu.tzl.web.entity.Cart;
import edu.tzl.web.entity.Product;
import edu.tzl.web.entity.User;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShoppingDaoImp dao = new ShoppingDaoImp();
	MproductDaoImp daop=new MproductDaoImp();
	ManageDaoImp daou=new ManageDaoImp();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingServlet() {
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
		String action = request.getParameter("action");
		
		//放入购物车
		if ("buy".equals(action)) {
			int uid = Integer.valueOf(request.getParameter("uid"));
			int pid = Integer.valueOf(request.getParameter("pid"));
			int numl = 1;
			float price = Float.valueOf(request.getParameter("price"));
			// 判断购物车中是否存在此商品
			Cart c = dao.selectCart(pid,uid);
			if (c == null) {
				// 放入购物车
				float total = numl * price;
				dao.insert(uid, pid, numl, total);
				
			//如果没有，则更新原来购物车商品的数量和总价格
			} else {
				int numl1 = c.getNuml() + 1;
				float total = numl1 * price;
				dao.update(pid, numl1, total,uid);
			}
			request.getRequestDispatcher("Ushopping.jsp").forward(request,
					response);
			
		//进入购物车，查看购物车里面的商品
		}else if("cart".equals(action)){
			cartQuerry(request, response);
			
		//增加购物车商品的数量（可以用脚本写,但是不利于数量的保存，没有传到数据库）
		}else if("jia".equals(action)){
			int uid=Integer.valueOf(request.getParameter("uid"));
			int pid=Integer.valueOf(request.getParameter("pid"));
			//根据商品id查出商品的单价
			Product p=daop.querryProductByid(pid);
			float price=p.getPrice();
			Cart c=dao.selectCart(pid, uid);
			//数量增加，总价格增加
			int numl=c.getNuml();
			numl+=1;
			float total=numl*price;
			dao.update(pid, numl, total, uid);
			cartQuerry(request, response);
			
		//减少购物车商品的数量
		}else if("jian".equals(action)){
			int uid=Integer.valueOf(request.getParameter("uid"));
			int pid=Integer.valueOf(request.getParameter("pid"));
			Product p=daop.querryProductByid(pid);
			float price=p.getPrice();
			Cart c=dao.selectCart(pid, uid);
			int numl=c.getNuml();
			//如果购物车中商品的数量为一，减少数量，就从购物车中删除此商品
			if(numl==1){
				dao.deletecart(uid, pid);
			}else{
				numl-=1;
				float total=numl*price;
				dao.update(pid, numl, total, uid);
			}
			cartQuerry(request, response);
			
		//删除购物车
		}else if("delete".equals(action)){
			int uid=Integer.valueOf(request.getParameter("uid"));
			int pid=Integer.valueOf(request.getParameter("pid"));
			dao.deletecart(uid,pid);
			cartQuerry(request, response);
			
		//生成订单
		}else if("order".equals(action)){
			int uid=Integer.valueOf(request.getParameter("uid"));
			User u=daou.querryByid(uid);
			//购物车结算，获得复选框勾选的购物车id
			String [] c=request.getParameterValues("check");
			float totals=Float.valueOf(request.getParameter("totals"));
			//生成订单
			dao.insertOrder(u,totals);
			int orderid=dao.qurryOreder(u);
			for (int i = 0; i < c.length; i++) {
				Cart cart = dao.qurryCartByCid(Integer.valueOf(c[i]));
				//生成订单详情表
				dao.addOrderDetail(orderid, cart);
				//订单生成后删除购物车
				dao.deleteCart(Integer.parseInt(c[i]));
			}
			request.getRequestDispatcher("Ushopping.jsp").forward(request,
					response);
		}
	}

	//展示购物车
	private void cartQuerry(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.valueOf(request.getParameter("uid"));
		List<Cart> list=dao.qurryCart(uid);
		Product p=null;
		List<Product> listurl=new ArrayList<Product>();
		//购物车中要展示商品的图片，而用户把商品加入购物车时只加入了商品的id，没有图片路径
		for(Cart c:list){
			p=daop.querryProductByid(c.getProductid());
			listurl.add(p);
		}
		request.setAttribute("carturl", listurl);
		request.setAttribute("cartlist", list);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
	}
	
}

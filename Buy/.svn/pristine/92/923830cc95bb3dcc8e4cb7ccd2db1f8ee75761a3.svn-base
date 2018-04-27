package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.Cart;
import edu.tzl.web.entity.User;

public class ShoppingDaoImp extends BaseDao {

	// 查询购物车中有没有此商品
	public Cart selectCart(int pid ,int uid) {
		Connection conn = getconn();
		String sql = "select * from easybuy_cart where Shop_id=? and eo_user_id=?";
		Cart c = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				c = new Cart();
				c.setId(rst.getInt(1));
				c.setUserid(rst.getInt(2));
				c.setProductid(rst.getInt(3));
				c.setTotal(rst.getFloat(5));
				c.setNuml(rst.getInt(4));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	//在购物车中增加一个商品
	public void insert(int uid, int pid, int numl, float total) {
		Connection conn = getconn();
		String sql = "insert into easybuy_cart values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, pid);
			ps.setInt(3, numl);
			ps.setFloat(4, total);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//根据用户id和商品id更新购物车
	public void update(int pid, int numl1, float total,int uid) {
		Connection conn = getconn();
		String sql = "update easybuy_cart  set Buy_count=?,eo_cost=? where Shop_id=? and eo_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numl1);
			ps.setFloat(2, total);
			ps.setInt(3, pid);
			ps.setInt(4, uid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//根据用户id查询用户的购物车
	public List<Cart> qurryCart(int uid) {
		Connection conn = getconn();
		String sql = "select * from easybuy_cart where eo_user_id=?";
		Cart c=null;
		List<Cart> list=new ArrayList<Cart>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rst=ps.executeQuery();
			while(rst.next()){
				c=new Cart();
				c.setId(rst.getInt(1));
				c.setUserid(rst.getInt(2));
				c.setProductid(rst.getInt(3));
				c.setNuml(rst.getInt(4));
				c.setTotal(rst.getFloat(5));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//根据用户id和商品id删除此购物车
	public int deletecart(int uid, int pid) {
		Connection conn = getconn();
		String sql = "delete from easybuy_cart where Shop_id=? and eo_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	
	//生成订单表
	public int insertOrder(User u, float totals) {
		Connection conn = getconn();
		String sql = "insert into easybuy_order values(?,?,default,default,?,default)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setFloat(3, totals);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	//根据用户id查询订单
	public int qurryOreder(User u) {
		Connection conn = getconn();
		String sql = "select * from easybuy_order where eo_user_id=?";
		int oid=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet rst=ps.executeQuery();
			if(rst.next()){
				oid=rst.getInt(1);
			}
			return oid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	//添加订单明细
	public int addOrderDetail(int orderid, Cart cart) {
		Connection conn = getconn();
		String sql = "insert into easybuy_order_detail values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			ps.setInt(2, cart.getProductid());
			ps.setInt(3, cart.getNuml());
			ps.setFloat(4, cart.getTotal());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	//根据购物车id查询购物车
	public Cart qurryCartByCid(int cid) {
		Connection conn = getconn();
		String sql = "select * from easybuy_cart where cart_id=?";
		Cart c=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rst=ps.executeQuery();
			if(rst.next()){
				c=new Cart();
				c.setId(rst.getInt(1));
				c.setUserid(rst.getInt(2));
				c.setProductid(rst.getInt(3));
				c.setNuml(rst.getInt(4));
				c.setTotal(rst.getFloat(5));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	//根据购物车id删除购物车
	public int deleteCart(int cid) {
		Connection conn = getconn();
		String sql = "delete from easybuy_cart where cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
}

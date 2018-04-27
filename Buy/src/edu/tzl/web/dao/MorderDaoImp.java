package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.Order;
import edu.tzl.web.entity.User;

public class MorderDaoImp extends BaseDao {
	
	//分页查询所有订单
	public List<Order> selectAll(int pageRow, int nowPage) {
		Connection conn = getconn();
		String sql = "select top (?) * from easybuy_order where eo_id not in(select  top((?-1)*?) eo_id from easybuy_order) ";
		Order o = null;
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pageRow);
			ps.setInt(2, nowPage);
			ps.setInt(3, pageRow);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				o = new Order();
				o.setOid(rst.getInt(1));
				o.setUid(rst.getInt(2));
				o.setUname(rst.getString(3));
				o.setAdress(rst.getString(4));
				o.setDate(rst.getString(5));
				o.setTotal(rst.getFloat(6));
				o.setStatus(rst.getString(7));
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeconn();
		}

	}

	// 查询总行数
	public int qurryCount() {
		Connection conn = getconn();
		String sql = "select count(*) from easybuy_order";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				count = rst.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeconn();
		}
	}

	// 根据订单编号查询订单
	public Order qurryOreder(int oid) {
		Connection conn = getconn();
		String sql = "select * from easybuy_order where eo_id=?";
		Order o = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				o = new Order();
				o.setOid(rst.getInt(1));
				o.setUid(rst.getInt(2));
				o.setUname(rst.getString(3));
				o.setAdress(rst.getString(4));
				o.setDate(rst.getString(5));
				o.setTotal(rst.getFloat(6));
				o.setStatus(rst.getString(7));
			}
			return o;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeconn();
		}
	}

	// 更改订单状态
	public int update(int oid, String status) {
		Connection conn = getconn();
		String sql = "update  easybuy_order set eo_status=? where eo_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, oid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeconn();
		}

	}

	//删除订单
	public int delete(int oid) {
		Connection conn = getconn();
		String sql = "delete from  easybuy_order where eo_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeconn();
		}

	}

}

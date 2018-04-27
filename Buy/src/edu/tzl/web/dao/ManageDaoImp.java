﻿package edu.tzl.web.dao;
//
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.User;

public class ManageDaoImp extends BaseDao {

	//查询总行数
	public int querryCount() {
		Connection conn = getconn();
		String sql = "select count(*) from easybuy_user";
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

	//分页查询
	public List<User> selectAll(int pageRow, int nowPage) {
		Connection conn = this.getconn();
		String sql = "select top (?) * from easybuy_user where eu_user_id not in(select  top((?-1)*?) eu_user_id from easybuy_user)";
		User u = null;
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pageRow);
			ps.setInt(2, nowPage);
			ps.setInt(3, pageRow);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				u = new User();
				u.setId(rst.getInt(1));
				u.setName(rst.getString(2));
				u.setStatus(rst.getString(5));
				list.add(u);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.closeconn();
		}
	}

	// 增加用户
	public int add(String userName, String passWord, String status) {
		Connection conn = this.getconn();
		String sql = "insert into easybuy_user values(?,?,default,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ps.setString(3, status);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}
	}

	// 根据id查询用户
	public User querryByid(int id) {
		Connection conn = this.getconn();
		String sql = "select * from easybuy_user where eu_user_id=?";
		User u = null;
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				u = new User();
				u.setId(rst.getInt(1));
				u.setName(rst.getString(2));
				u.setPwd(rst.getString(3));
				u.setStatus(rst.getString(5));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.closeconn();
		}
	}

	// 修改用户
	public int update(int id, String userName, String passWord, String status) {
		Connection conn = this.getconn();
		String sql = "update easybuy_user set eu_user_name=?,eu_user_password=?,eu_user_status=? where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ps.setString(3, status);
			ps.setInt(4, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}

	}

	//删除用户
	public int delete(int id) {
		Connection conn = this.getconn();
		String sql = "delete from easybuy_user where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}
	}
}

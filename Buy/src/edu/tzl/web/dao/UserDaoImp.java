package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.tzl.web.entity.User;

public class UserDaoImp extends BaseDao {

	// 注册用户
	public int zhuce(String name, String pwd) {
		Connection conn = this.getconn();
		String sql = "insert into easybuy_user values(?,?,default,default)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}
	}

	// 用户登录
	public User login(String name, String pwd) {
		Connection conn = getconn();
		String sql = "select * from easybuy_user where eu_user_name=? and eu_user_password=?";
		User u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				u = new User();
				u.setId(rst.getInt(1));
				u.setName(rst.getString(2));
				u.setPwd(rst.getString(3));
				u.setIslogin(rst.getInt(4));
				u.setStatus(rst.getString(5));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeconn();
		}
	}

	// 登录、注销之后更新用户登录状态
	public void UpdateStatues(int statues, int id) {
		Connection conn = getconn();
		String sql = "update easybuy_user set eu_login=? where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statues);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.News;
import edu.tzl.web.entity.ProductClass;

public class MnewsDaoImp extends BaseDao {

	// 增加一条新闻
	public int addnew(String title, String content) {
		Connection conn = getconn();
		String sql = "insert into easybuy_news(en_title,en_content) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	// 分页查询所有新闻
	public List<News> selectall(int pageRow, int nowPage) {
		Connection conn = getconn();
		String sql = "select top (?) * from easybuy_news where en_id not in(select  top((?-1)*?) en_id from easybuy_news) ";
		News n = null;
		List<News> list = new ArrayList<News>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pageRow);
			ps.setInt(2, nowPage);
			ps.setInt(3, pageRow);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				n = new News();
				n.setId(rst.getInt(1));
				n.setTitle(rst.getString(2));
				n.setBody(rst.getString(3));
				n.setDate(rst.getString(4));
				list.add(n);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// 查询所有新闻
	public List<News> selectall() {
		Connection conn = getconn();
		String sql = "select  * from easybuy_news ";
		News n = null;
		List<News> list = new ArrayList<News>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				n = new News();
				n.setId(rst.getInt(1));
				n.setTitle(rst.getString(2));
				n.setBody(rst.getString(3));
				n.setDate(rst.getString(4));
				list.add(n);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 查询总行数
	public int querryCount() {
		Connection conn = getconn();
		String sql = "select count(*) from easybuy_news";
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

	// 根据id查询新闻(修改)
	public News querryByid(int id) {
		Connection conn = this.getconn();
		String sql = "select * from easybuy_news where en_id=?";
		News n = null;
		List<News> list = new ArrayList<News>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				n = new News();
				n.setId(rst.getInt(1));
				n.setTitle(rst.getString(2));
				n.setBody(rst.getString(3));
				n.setDate(rst.getString(4));
			}
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.closeconn();
		}
	}

	
	//修改新闻
	public int updatenews(int id, String title, String content) {
		Connection conn = this.getconn();
		String sql = "update easybuy_news set en_title=?,en_content=? where en_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}
		
	}

	
	//删除一条新闻
	public int delete(int id) {
		Connection conn = this.getconn();
		String sql = "delete from easybuy_news where en_id=?";
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

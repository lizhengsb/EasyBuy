package edu.tzl.web.dao;
//
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.Comment;

public class McommentDaoImp extends BaseDao {

	// 插入一条留言
	public int addGuest(String comment, String name) {
		Connection conn = getconn();
		String sql = "insert into easybuy_comment values(?,default,default,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comment);
			ps.setString(2, name);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	// 分页查询
	public List<Comment> selectguest(int pageRow, int nowPage) {
		Connection conn = getconn();
		String sql = "select top (?) * from easybuy_comment where ec_id not in(select  top((?-1)*?) ec_id from easybuy_comment) ";
		Comment c = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pageRow);
			ps.setInt(2, nowPage);
			ps.setInt(3, pageRow);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				c = new Comment();
				c.setId(rst.getInt(1));
				c.setContent(rst.getString(2));
				c.setContentdate(rst.getString(3));
				c.setStatus(rst.getString(4));
				c.setName(rst.getString(5));
				list.add(c);
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
		String sql = "select count(*) from easybuy_comment";
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

	// 根据id查询(回复)
	public Comment selectCommentId(int id) {
		Connection conn = getconn();
		String sql = "select * from easybuy_comment where ec_id=?";
		Comment c = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				c = new Comment();
				c.setId(rst.getInt(1));
				c.setName(rst.getString(5));
				c.setContent(rst.getString(2));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return c;
		}
	}

	// 回复留言
	public int reply(int orderId, String replyContent) {
		Connection conn = getconn();
		String sql = "insert into easybuy_reply values(?,default,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, replyContent);
			ps.setInt(2, orderId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	// 更新留言的状态
	public int updateStatus(int orderId, String status) {
		Connection conn = getconn();
		String sql = "update easybuy_comment set ec_status=? where ec_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, orderId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	// 删除一条留言
	public int delete(int id) {
		Connection conn = this.getconn();
		String sql = "delete from easybuy_comment where ec_id=?";
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
	
	//查询回复表
	public List<Comment> selectReply() {
		Connection conn = getconn();
		String sql = "select * from easybuy_reply";
		Comment c=null;
		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while(rst.next()) {
				c=new Comment();
				c.setReplyid(rst.getInt(1));
				c.setReply(rst.getString(2));
				c.setReplydate(rst.getString(3));
				c.setId(rst.getInt(4));
				list.add(c);
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
}

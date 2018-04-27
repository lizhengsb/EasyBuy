package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tzl.web.entity.Product;
import edu.tzl.web.entity.ProductClass;

public class MproductDaoImp extends BaseDao {
	
	// 查询大分类
	public List<ProductClass> selectProductclass() {
		Connection conn = getconn();
		String sql = "select * from easybuy_product_category where epc_parent_id=0";
		ProductClass pc = null;
		List<ProductClass> list = new ArrayList<ProductClass>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				pc = new ProductClass();
				pc.setParentId(rst.getInt(1));
				pc.setName(rst.getString(2));
				pc.setChildId(rst.getInt(3));
				list.add(pc);
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

	// 查询小分类
	public List<ProductClass> selectProductclass_() {
		Connection conn = getconn();
		String sql = "select * from easybuy_product_category where epc_parent_id !=0";
		ProductClass pc = null;
		List<ProductClass> list = new ArrayList<ProductClass>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				pc = new ProductClass();
				pc.setParentId(rst.getInt(1));
				pc.setName(rst.getString(2));
				pc.setChildId(rst.getInt(3));
				list.add(pc);
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

	// 增加小分类
	public int add(int id, String name) {
		Connection conn = this.getconn();
		String sql = "insert into easybuy_product_category values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.closeconn();
		}
	}

	// 删除一个小分类
	public int delete(int id) {
		Connection conn = this.getconn();
		String sql = "delete from easybuy_product_category where epc_id=?";
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

	//查询小分类
	public ProductClass querryByid(int id) {
		Connection conn = this.getconn();
		String sql = "select * from easybuy_product_category where epc_id=?";
		ProductClass p = null;
		List<ProductClass> list = new ArrayList<ProductClass>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				p = new ProductClass();
				p.setParentId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setChildId(rst.getInt(3));
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.closeconn();
		}
	}

	// 更新小分类
	public int update(int id, String name, int pid) {
		Connection conn = this.getconn();
		String sql = "update easybuy_product_category set epc_name=?,epc_parent_id=? where epc_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, pid);
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

	// 增加一件商品
	public int add(String productName, String productMiaoshu,
			float productPrice, int productNuml, int sid, int id, String photo) {
		Connection conn = getconn();
		String sql = "insert into easybuy_product values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productName);
			ps.setString(2, productMiaoshu);
			ps.setFloat(3, productPrice);
			ps.setInt(4, productNuml);
			ps.setInt(5, id);
			ps.setInt(6, sid);
			ps.setString(7, photo);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	//分页查询所有商品
	public List<Product> selectAll(int pageRow,int nowPage) {
		Connection conn = getconn();
		String sql = "select top (?) * from easybuy_product where ep_id not in(select  top((?-1)*?) ep_id from easybuy_product)";
		List<Product> list = new ArrayList<Product>();
		Product p = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageRow);
			ps.setInt(2, nowPage);
			ps.setInt(3, pageRow);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				p = new Product();
				p.setId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setDescription(rst.getString(3));
				p.setPrice(rst.getFloat(4));
				p.setNuml(rst.getInt(5));
				p.setPid(rst.getInt(6));
				p.setCid(rst.getInt(7));
				p.setUrl(rst.getString(8));
				list.add(p);
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
	
	//查询所有商品
	public List<Product> selectAll() {
		Connection conn = getconn();
		String sql = "select * from easybuy_product ";
		List<Product> list = new ArrayList<Product>();
		Product p = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				p = new Product();
				p.setId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setDescription(rst.getString(3));
				p.setPrice(rst.getFloat(4));
				p.setNuml(rst.getInt(5));
				p.setPid(rst.getInt(6));
				p.setCid(rst.getInt(7));
				p.setUrl(rst.getString(8));
				list.add(p);
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

	// 根据id查询商品
	public Product querryProductByid(int id) {
		Connection conn = getconn();
		String sql = "select * from easybuy_product where ep_id=?";
		Product p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				p = new Product();
				p.setId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setDescription(rst.getString(3));
				p.setPrice(rst.getFloat(4));
				p.setNuml((rst.getInt(5)));
				p.setPid(rst.getInt(6));
				p.setCid(rst.getInt(7));
				p.setUrl(rst.getString(8));
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	//根据id删除商品
	public int deleteProduct(int id) {
		Connection conn = this.getconn();
		String sql = "delete from easybuy_product where ep_id=?";
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
	
	//查询商品的总行数
	public int querryCount() {
		Connection conn = getconn();
		String sql = "select count(*) from easybuy_product";
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

}

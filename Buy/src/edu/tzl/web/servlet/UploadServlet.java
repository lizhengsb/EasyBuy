package edu.tzl.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;






import edu.tzl.web.dao.MproductDaoImp;
import edu.tzl.web.entity.ProductClass;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String SavePath="d://img/";
    MproductDaoImp dao = new MproductDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");*/
		
		String action=request.getParameter("action");
		
		//增加商品实现上传图片
		if("add".equals(action)){
			try {
				upload(request,response);
				request.getRequestDispatcher("doManage.jsp").forward(request, response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SmartUploadException {
		
		String picture=""; 
		//实例化jspUpload组件中的SmartUpload对象，实现上传
		SmartUpload smartUpload=new SmartUpload();
		//初始化上传对象
		smartUpload.initialize(this.getServletConfig(),request,response);
		//调用上传方法
		smartUpload.upload();
		//返回被封装后的request对象
		Request req=smartUpload.getRequest();
		
		//获取容器中表单提交的上传所有文件的容器
		Files files=smartUpload.getFiles();
		for(int i=0;i<files.getCount();i++){
			//返回jspSmartUpload组件中File类每一个file对象代表一条form表单的文件域
			File file=files.getFile(i);
			//给上传的文件创建新的文件名String filename=file.getFieldName();
			picture=createfilename();
			//将上传的文件保存到指定的地址
			file.saveAs(SavePath+picture);
		
		}
		String productName = req.getParameter("productName");
		
		//构造字符串
		//productName=new String(productName.getBytes("GBK"),"UTF-8");
		
		int id = Integer.parseInt(req.getParameter("sel"));
		String photo =req.getParameter("photo");
		float productPrice = Float.valueOf(req.getParameter("productPrice"));
		
		String productMiaoshu = req.getParameter("productMiaoshu");
		//productMiaoshu=new String(productMiaoshu.getBytes("GBK"),"UTF-8");
		
		
		int productNuml = Integer.valueOf(req.getParameter("productNuml"));
		ProductClass p = dao.querryByid(id);
		int sid = p.getChildId();
		dao.add(productName, productMiaoshu, productPrice, productNuml, id, sid, picture);
	}

	
	//重新命名文件
	private String createfilename() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date())+".png";
	}

}

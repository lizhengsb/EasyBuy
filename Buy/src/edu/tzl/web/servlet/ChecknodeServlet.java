package edu.tzl.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChecknodeServlet
 */
@WebServlet("/ChecknodeServlet")
public class ChecknodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChecknodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    //�������������
    public Font getFont() {
		Random random = new Random();
		Font font[] = new Font[5];
		font[0] = new Font("Ravie", Font.PLAIN, 24);
		font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);
		font[2] = new Font("Forte", Font.PLAIN, 24);
		font[3] = new Font("Wide Latin", Font.PLAIN, 24);
		font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
		return font[random.nextInt(5)];
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ������ӦͷContent-type����
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		int width = 83, height = 30;
		// ����ָ�����ߺ�BufferedImage����
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// �û��ʻ���image ��
		Graphics g = image.getGraphics();
		// ���浱ǰ���ʵ���ɫ
		Color c = g.getColor();
		// ������
		g.fillRect(0, 0, width, height);
		// ����������ַ�
		char[] ch = "abcdefghijkmnpqrstuvwxyz23456789".toCharArray();
		// ��������ַ��ĳ���
		int length = ch.length;
		// ��������������ַ���
		String sRand = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			// ��������
			g.setFont(getFont());
			String rand = new Character(ch[random.nextInt(length)]).toString();
			sRand += rand;
			// ���������ɫ
			g.setColor(new Color(random.nextInt(255), random.nextInt(255),
					random.nextInt(255)));
			g.drawString(rand, 20 * i + 6, 25);
		}
		// ����������ŵ�
		for (int i = 0; i < 55; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		// �����ʵ���ɫ�����û�ȥ
		g.setColor(c);
		// �ͷŴ�ͼ�ε��������Լ������õ�����ϵͳ��Դ
		g.dispose();
		// ����֤���¼��session
		request.getSession().setAttribute("safecode", sRand);
		// ���ͼ��ҳ��
		ImageIO.write(image, "JPEG", os);
	}

}
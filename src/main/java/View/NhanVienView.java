package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.github.sarxos.webcam.util.ImageUtils;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import View.PlaceholderTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class NhanVienView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PlaceholderTextField txt_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienView frame = new NhanVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienView() {
		setTitle("Bán Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 718);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1320, 718);
		contentPane.add(layeredPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 410, 669);
		layeredPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(createGrayBorder());
		
		JPanel panel_SP_6 = new JPanel();
		panel_SP_6.setLayout(null);
		panel_SP_6.setBorder(createGrayBorder());
		panel_SP_6.setBounds(0, 84, 316, 94);
		panel.add(panel_SP_6);
		
		JLabel lb_anhSP1_6 = new JLabel("");
		lb_anhSP1_6.setBounds(10, 11, 56, 72);
		panel_SP_6.add(lb_anhSP1_6);
		   setScaledImage(lb_anhSP1_6, "C:\\javvaa\\DuAn1.2\\src\\main\\resources\\Cà phê đen.jpg");
		JLabel lbl_tenSP1_6 = new JLabel("Cafe Đen");
		lbl_tenSP1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_6.setBounds(75, 11, 190, 22);
		panel_SP_6.add(lbl_tenSP1_6);
		
		JLabel lbl_giaSP1_6 = new JLabel("25000");
		lbl_giaSP1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_6.setBounds(76, 61, 66, 22);
		panel_SP_6.add(lbl_giaSP1_6);
		
		JLabel lblNewLabel_2 = new JLabel("Số Lượng: 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(196, 61, 100, 20);
		panel_SP_6.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\ThungRac.png"));
		btnNewButton.setBounds(318, 84, 92, 94);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Cộng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 502, 97, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Khuyến Mãi");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 539, 97, 26);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Tổng Tiền");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(10, 576, 97, 26);
		panel.add(lblNewLabel_3_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 526, 390, 2);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 565, 390, 2);
		panel.add(separator_1_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("25000");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(303, 502, 97, 26);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("-5000");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3_1.setBounds(303, 539, 97, 26);
		panel.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("20000");
		lblNewLabel_3_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3_2.setBounds(303, 576, 97, 26);
		panel.add(lblNewLabel_3_3_2);
		
		JButton btnXutHan = new JButton("Xuát Hóa Đơn");
		btnXutHan.setForeground(new Color(255, 255, 255));
		btnXutHan.setBackground(new Color(0, 0, 160));
		btnXutHan.setBounds(204, 613, 196, 46);
		panel.add(btnXutHan);
		
		JButton btnThanhTon_1_1 = new JButton("Thanh Toán");
		btnThanhTon_1_1.setForeground(new Color(255, 255, 255));
		btnThanhTon_1_1.setBackground(new Color(0, 0, 160));
		btnThanhTon_1_1.setBounds(10, 613, 184, 46);
		panel.add(btnThanhTon_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 160));
		panel_3.setBounds(0, 0, 410, 81);
		panel.add(panel_3);
		panel_3.setLayout(null);
		JLabel lblNewLabel = new JLabel("Chi Tiết Đặt Hàng");
		lblNewLabel.setBounds(10, 11, 182, 20);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBounds(430, 11, 864, 41);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(createGrayBorder());
		
		txt_timKiem = new PlaceholderTextField("Tìm Kiếm");
		txt_timKiem.setBorder(new CompoundBorder());
		txt_timKiem.setBounds(10, 10, 844, 27);
		panel_1.add(txt_timKiem);
		txt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(430, 63, 864, 608);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thể Loại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 82, 20);
		panel_2.add(lblNewLabel_1);

		JButton btn_tatCa = new JButton("Tất Cả");
		btn_tatCa.setBorder(new CompoundBorder());
		btn_tatCa.setForeground(new Color(255, 255, 255));
		btn_tatCa.setBackground(new Color(0, 0, 160));
		btn_tatCa.setBounds(10, 42, 102, 29);
		panel_2.add(btn_tatCa);

		JButton btn_nuocNgot = new JButton("Nước Ngọt");
		btn_nuocNgot.setForeground(Color.WHITE);
		btn_nuocNgot.setBorder(new CompoundBorder());
		btn_nuocNgot.setBackground(new Color(0, 0, 160));
		btn_nuocNgot.setBounds(122, 42, 102, 29);
		panel_2.add(btn_nuocNgot);

		JButton btn_nuocTraiCay = new JButton("Nước Trái Cây");
		btn_nuocTraiCay.setForeground(Color.WHITE);
		btn_nuocTraiCay.setBorder(new CompoundBorder());
		btn_nuocTraiCay.setBackground(new Color(0, 0, 160));
		btn_nuocTraiCay.setBounds(234, 42, 102, 29);
		panel_2.add(btn_nuocTraiCay);

		JButton btn_cafe = new JButton("Cafe");
		btn_cafe.setForeground(Color.WHITE);
		btn_cafe.setBorder(new CompoundBorder());
		btn_cafe.setBackground(new Color(0, 0, 160));
		btn_cafe.setBounds(346, 42, 102, 29);
		panel_2.add(btn_cafe);

		JLabel lblNewLabel_1_1 = new JLabel("Phổ Biến");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 82, 82, 20);
		panel_2.add(lblNewLabel_1_1);
		panel_2.setBorder(createGrayBorder());

		JPanel panel_SP = new JPanel();
		panel_SP.setBounds(10, 113, 276, 94);
		panel_2.add(panel_SP);
		panel_SP.setLayout(null);
		panel_SP.setBorder(createGrayBorder());

		JLabel lb_anhSP1 = new JLabel("");
		lb_anhSP1.setBounds(10, 11, 56, 72);
		panel_SP.add(lb_anhSP1);
		// ảnh
          setScaledImage(lb_anhSP1, "C:\\javvaa\\DuAn1.2\\src\\main\\resources\\Cà phê đen.jpg");
		
		JLabel lbl_tenSP1 = new JLabel("Cafe Đen");
		lbl_tenSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1.setBounds(76, 11, 190, 22);
		panel_SP.add(lbl_tenSP1);

		JLabel lbl_giaSP1 = new JLabel("25000");
		lbl_giaSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1.setBounds(76, 61, 66, 22);
		panel_SP.add(lbl_giaSP1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setBounds(236, 63, 30, 20);
		panel_SP.add(spinner);
		

		
		JPanel panel_SP_1 = new JPanel();
		panel_SP_1.setLayout(null);
		panel_SP_1.setBorder(createGrayBorder());
		panel_SP_1.setBounds(296, 113, 276, 94);
		panel_2.add(panel_SP_1);
		
		JLabel lb_anhSP1_1 = new JLabel("");
		lb_anhSP1_1.setBounds(10, 11, 56, 72);
		panel_SP_1.add(lb_anhSP1_1);
		
		JLabel lbl_tenSP1_1 = new JLabel("Cafe Đen");
		lbl_tenSP1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_1.setBounds(76, 11, 190, 22);
		panel_SP_1.add(lbl_tenSP1_1);
		
		JLabel lbl_giaSP1_1 = new JLabel("25000");
		lbl_giaSP1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_1.setBounds(76, 61, 66, 22);
		panel_SP_1.add(lbl_giaSP1_1);
		
		JPanel panel_SP_2 = new JPanel();
		panel_SP_2.setLayout(null);
		panel_SP_2.setBorder(createGrayBorder());
		panel_SP_2.setBounds(582, 113, 276, 94);
		panel_2.add(panel_SP_2);
		
		JLabel lb_anhSP1_2 = new JLabel("");
		lb_anhSP1_2.setBounds(10, 11, 56, 72);
		panel_SP_2.add(lb_anhSP1_2);
		
		JLabel lbl_tenSP1_2 = new JLabel("Cafe Đen");
		lbl_tenSP1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_2.setBounds(76, 11, 190, 22);
		panel_SP_2.add(lbl_tenSP1_2);
		
		JLabel lbl_giaSP1_2 = new JLabel("25000");
		lbl_giaSP1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_2.setBounds(76, 61, 66, 22);
		panel_SP_2.add(lbl_giaSP1_2);
		
		JPanel panel_SP_3 = new JPanel();
		panel_SP_3.setLayout(null);
		panel_SP_3.setBorder(createGrayBorder());
		panel_SP_3.setBounds(10, 218, 276, 94);
		panel_2.add(panel_SP_3);
		
		JLabel lb_anhSP1_3 = new JLabel("");
		lb_anhSP1_3.setBounds(10, 11, 56, 72);
		panel_SP_3.add(lb_anhSP1_3);
		
		JLabel lbl_tenSP1_3 = new JLabel("Cafe Đen");
		lbl_tenSP1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_3.setBounds(76, 11, 190, 22);
		panel_SP_3.add(lbl_tenSP1_3);
		
		JLabel lbl_giaSP1_3 = new JLabel("25000");
		lbl_giaSP1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_3.setBounds(76, 61, 66, 22);
		panel_SP_3.add(lbl_giaSP1_3);
		
		JPanel panel_SP_4 = new JPanel();
		panel_SP_4.setLayout(null);
		panel_SP_4.setBorder(createGrayBorder());
		panel_SP_4.setBounds(296, 218, 276, 94);
		panel_2.add(panel_SP_4);
		
		JLabel lb_anhSP1_4 = new JLabel("");
		lb_anhSP1_4.setBounds(10, 11, 56, 72);
		panel_SP_4.add(lb_anhSP1_4);
		
		JLabel lbl_tenSP1_4 = new JLabel("Cafe Đen");
		lbl_tenSP1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_4.setBounds(76, 11, 190, 22);
		panel_SP_4.add(lbl_tenSP1_4);
		
		JLabel lbl_giaSP1_4 = new JLabel("25000");
		lbl_giaSP1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_4.setBounds(76, 61, 66, 22);
		panel_SP_4.add(lbl_giaSP1_4);
		
		JPanel panel_SP_5 = new JPanel();
		panel_SP_5.setLayout(null);
		panel_SP_5.setBorder(createGrayBorder());
		panel_SP_5.setBounds(582, 218, 276, 94);
		panel_2.add(panel_SP_5);
		
		JLabel lb_anhSP1_5 = new JLabel("");
		lb_anhSP1_5.setBounds(10, 11, 56, 72);
		panel_SP_5.add(lb_anhSP1_5);
		
		JLabel lbl_tenSP1_5 = new JLabel("Cafe Đen");
		lbl_tenSP1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1_5.setBounds(76, 11, 190, 22);
		panel_SP_5.add(lbl_tenSP1_5);
		
		JLabel lbl_giaSP1_5 = new JLabel("25000");
		lbl_giaSP1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1_5.setBounds(76, 61, 66, 22);
		panel_SP_5.add(lbl_giaSP1_5);

	}

	private void applyBottomBorder(JTextField textField) {
		Border border = textField.getBorder();
		Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK); // Màu đen, độ dày là 1 pixel
		textField.setBorder(BorderFactory.createCompoundBorder(border, bottomBorder));
	}

	private Border createGrayBorder() {
		return BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY), // Viền màu xám
				BorderFactory.createEmptyBorder(5, 5, 5, 5) // Khoảng cách viền
		);
	}

	 public static void setScaledImage(JLabel label, String imagePath) {
	        ImageIcon imageIcon = new ImageIcon(imagePath);
	        Image image = imageIcon.getImage();
	        
	        // Lấy kích thước của JLabel
	        int labelWidth = label.getWidth();
	        int labelHeight = label.getHeight();
	        
	        // Tính toán tỷ lệ kích thước mới cho ảnh
	        double widthRatio = (double) labelWidth / imageIcon.getIconWidth();
	        double heightRatio = (double) labelHeight / imageIcon.getIconHeight();
	        double scaleRatio = Math.min(widthRatio, heightRatio);
	        
	        // Tạo ảnh đã điều chỉnh kích thước
	        int newWidth = (int) (imageIcon.getIconWidth() * scaleRatio);
	        int newHeight = (int) (imageIcon.getIconHeight() * scaleRatio);
	        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	        
	        // Thiết lập ảnh cho JLabel
	        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
	        label.setIcon(resizedImageIcon);
	    }
}
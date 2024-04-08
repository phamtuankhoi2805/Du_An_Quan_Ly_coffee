package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.github.sarxos.webcam.util.ImageUtils;

import Controller.NhanVienController;
import DAO.SanPhamDAO;
import Model.SanPhamModel;

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
	private ArrayList<SanPhamModel> listSP;
	private JPanel panel_DSSP;
	private JPanel panelCon;
	private JScrollPane scrollPane;
	private JLabel lbl_tongCong;
	private JLabel lbl_khuyenMai;
	private JLabel lbl_tongTien;

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

		listSP = SanPhamDAO.getInstance().selectAll();
		NhanVienController nvc = new NhanVienController(this, null);
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
		layeredPane.setBounds(0, 0, 1320, 679);
		contentPane.add(layeredPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 410, 669);
		layeredPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(createGrayBorder());

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

		 lbl_tongCong = new JLabel("0 VND");
		lbl_tongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tongCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongCong.setBounds(120, 497, 277, 26);
		panel.add(lbl_tongCong);

		 lbl_khuyenMai = new JLabel("0 VND");
		lbl_khuyenMai.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_khuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_khuyenMai.setBounds(117, 539, 283, 26);
		panel.add(lbl_khuyenMai);

		 lbl_tongTien = new JLabel("0 VND");
		lbl_tongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongTien.setBounds(117, 576, 283, 26);
		panel.add(lbl_tongTien);

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
		panel_3.setBounds(0, 0, 410, 59);
		panel.add(panel_3);
		panel_3.setLayout(null);
		JLabel lblNewLabel = new JLabel("Chi Tiết Đặt Hàng");
		lblNewLabel.setBounds(10, 11, 182, 20);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		scrollPane = new JScrollPane(panelCon);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 64, 390, 427);

		// Tạo một JPanel để chứa các panel con
		panelCon = new JPanel();
		panelCon.setLayout(new BoxLayout(panelCon, BoxLayout.Y_AXIS));

		// Đặt panelCon làm nội dung của scrollPane
		scrollPane.setViewportView(panelCon);

		panel.add(scrollPane);

		panel_DSSP = new JPanel();
		panel_DSSP.setBounds(430, 88, 874, 580);
		layeredPane.add(panel_DSSP);
		panel_DSSP.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_DSSP.setBorder(createGrayBorder());

		JLabel lblNewLabel_1 = new JLabel("Thể Loại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(434, 11, 96, 21);
		layeredPane.add(lblNewLabel_1);

		JButton btn_All = new JButton("ALL");
		btn_All.setForeground(Color.WHITE);
		btn_All.setBackground(new Color(0, 0, 160));
		btn_All.setBounds(430, 43, 111, 34);
		layeredPane.add(btn_All);

		JButton btn_Coffe = new JButton("Coffee");
		btn_Coffe.setForeground(Color.WHITE);
		btn_Coffe.setBackground(new Color(0, 0, 160));
		btn_Coffe.setBounds(551, 43, 111, 34);
		layeredPane.add(btn_Coffe);

		JButton btn_TraiCay = new JButton("Nước Trái Cây");
		btn_TraiCay.setForeground(Color.WHITE);
		btn_TraiCay.setBackground(new Color(0, 0, 160));
		btn_TraiCay.setBounds(672, 43, 122, 34);
		layeredPane.add(btn_TraiCay);

		JButton btn_tangLuc = new JButton("Tăng Lực");
		btn_tangLuc.setForeground(Color.WHITE);
		btn_tangLuc.setBackground(new Color(0, 0, 160));
		btn_tangLuc.setBounds(804, 43, 122, 34);
		layeredPane.add(btn_tangLuc);
		nvc.addSanPhamToPanel(listSP);

		btn_All.addActionListener(nvc);
		btn_Coffe.addActionListener(nvc);
		btn_TraiCay.addActionListener(nvc);
		btn_tangLuc.addActionListener(nvc);

	}

	public JPanel panel_DSSP() {
		return panel_DSSP;
	}

	public JPanel panelcon() {
		return panelCon;
	}
   public JLabel lbl_tongCong() {
	   return lbl_tongCong;
   }
   public JLabel lbl_khuyenMai() {
	   return lbl_khuyenMai;
   }
   public JLabel lbl_tongTien() {
	   return lbl_tongTien;
   }
//   public JScrollPane JScrollPane() {
//	   return scrollPane;
//   }
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

	public javax.swing.JScrollPane JScrollPane() {
		// TODO Auto-generated method stub
		return scrollPane;
	}
}
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.github.sarxos.webcam.util.ImageUtils;

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
	private PlaceholderTextField txt_timKiem;
    private ArrayList<SanPhamModel> listSP;
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
		panel_SP_6.setBounds(0, 84, 400, 94);
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

		JButton btn_xoaSP = new JButton("");
		btn_xoaSP.setBackground(new Color(255, 255, 255));
		btn_xoaSP.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\ThungRac.png"));
		btn_xoaSP.setBounds(345, 52, 46, 33);
		panel_SP_6.add(btn_xoaSP);

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

		JPanel panel_DSSP = new JPanel();
		panel_DSSP.setBounds(430, 131, 874, 539);
		layeredPane.add(panel_DSSP);
		panel_DSSP.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_DSSP.setBorder(createGrayBorder());

		listSP = SanPhamDAO.getInstance().selectAll();

		for (SanPhamModel sp : listSP) {
		    JPanel panel_SP = new JPanel();
		    panel_SP.setPreferredSize(new Dimension(276, 94));
		    panel_SP.setLayout(null);
		    panel_SP.setBorder(createGrayBorder());

		    JLabel lb_anhSP1 = new JLabel("");
		    lb_anhSP1.setBounds(10, 11, 56, 72);
		    panel_SP.add(lb_anhSP1);

		    // Ảnh
		    setScaledImage(lb_anhSP1, sp.getHinh()); // Đường dẫn ảnh từ đối tượng SanPham

		    JLabel lbl_tenSP1 = new JLabel(sp.getTenSP()); // Tên sản phẩm từ đối tượng SanPham
		    lbl_tenSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lbl_tenSP1.setBounds(76, 10, 190, 22);
		    panel_SP.add(lbl_tenSP1);

		    JLabel lbl_giaSP1 = new JLabel(String.valueOf(sp.getGiaBan())); // Giá sản phẩm từ đối tượng SanPham
		    lbl_giaSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    lbl_giaSP1.setBounds(76, 61, 66, 22);
		    panel_SP.add(lbl_giaSP1);

		    JSpinner spinner = new JSpinner();
		    spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		    spinner.setBounds(236, 63, 30, 20);
		    panel_SP.add(spinner);
		    panel_SP.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Lấy tên sản phẩm và giá và in ra màn hình
                    System.out.println("Tên sản phẩm: " + sp.getTenSP());
                    System.out.println("Giá: " + sp.getGiaBan());
                    
                }

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}   
                
                });
		    panel_DSSP.add(panel_SP);
		}

		JButton btn_tatCa = new JButton("Tất Cả");
		btn_tatCa.setBounds(430, 92, 102, 29);
		layeredPane.add(btn_tatCa);
		btn_tatCa.setBorder(new CompoundBorder());
		btn_tatCa.setForeground(new Color(255, 255, 255));
		btn_tatCa.setBackground(new Color(0, 0, 160));

		JButton btn_nuocNgot = new JButton("Nước Ngọt");
		btn_nuocNgot.setBounds(542, 92, 102, 29);
		layeredPane.add(btn_nuocNgot);
		btn_nuocNgot.setForeground(Color.WHITE);
		btn_nuocNgot.setBorder(new CompoundBorder());
		btn_nuocNgot.setBackground(new Color(0, 0, 160));

		JButton btn_nuocTraiCay = new JButton("Nước Trái Cây");
		btn_nuocTraiCay.setBounds(654, 92, 102, 29);
		layeredPane.add(btn_nuocTraiCay);
		btn_nuocTraiCay.setForeground(Color.WHITE);
		btn_nuocTraiCay.setBorder(new CompoundBorder());
		btn_nuocTraiCay.setBackground(new Color(0, 0, 160));

		JButton btn_cafe = new JButton("Cafe");
		btn_cafe.setBounds(766, 92, 102, 29);
		layeredPane.add(btn_cafe);
		btn_cafe.setForeground(Color.WHITE);
		btn_cafe.setBorder(new CompoundBorder());
		btn_cafe.setBackground(new Color(0, 0, 160));

		JLabel lblNewLabel_1 = new JLabel("Thể Loại");
		lblNewLabel_1.setBounds(430, 62, 82, 20);
		layeredPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

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
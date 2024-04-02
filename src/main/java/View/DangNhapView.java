package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DangNhapController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DangNhapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_userName;
	private JButton btn_login;
	private JButton btn_loginQR;
	private JPasswordField txt_passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
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
	 public DangNhapView() {
		 DangNhapController dnc = new DangNhapController(this, null);
	        setTitle("Quản Lý Cafe");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 668, 410);
	        setLocationRelativeTo(null);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel = new JLabel("User Login");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setBounds(371, 11, 162, 29);
	        contentPane.add(lblNewLabel);
	        
	        JPanel panel_anh = new JPanel();
	        panel_anh.setBounds(10, 11, 258, 349);
	        contentPane.add(panel_anh);

	        JLabel labelAnh = new JLabel();
	        ImageIcon icon = new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\Logo.png");

	        // Lấy kích thước mới cho ảnh
	        int width = 250;
	        int height = 300;
	        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        icon.setImage(image);

	        labelAnh.setIcon(icon);
	        panel_anh.add(labelAnh);
	        txt_userName = new JTextField();
	        txt_userName.setBackground(new Color(240, 255, 240));
	        txt_userName.setBounds(329, 86, 262, 35);
	        txt_userName.setUI(new javax.swing.plaf.basic.BasicTextFieldUI()); // Đặt UI mặc định cho JTextField
	        txt_userName.putClientProperty("JTextField.variant", "rounded"); // Áp dụng lớp CSS
	        txt_userName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        contentPane.add(txt_userName);
	        txt_userName.setColumns(30);
	        
	        JLabel lblNewLabel_1 = new JLabel("User Name");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_1.setBounds(329, 51, 98, 24);
	        contentPane.add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("Pass Word");
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lblNewLabel_1_1.setBounds(329, 132, 98, 24);
	        contentPane.add(lblNewLabel_1_1);
	        
	         btn_login = new JButton("Login");
	        btn_login.setForeground(new Color(255, 255, 255));
	        btn_login.setBackground(new Color(0, 128, 255));
	        btn_login.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        btn_login.setBounds(329, 227, 262, 35);
	        contentPane.add(btn_login);
	        btn_login.addActionListener(dnc);
	        
	         btn_loginQR = new JButton("Login QR");
	
	        btn_loginQR.setForeground(Color.WHITE);
	        btn_loginQR.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        btn_loginQR.setBackground(new Color(0, 128, 255));
	        btn_loginQR.setBounds(329, 273, 262, 35);
	        contentPane.add(btn_loginQR);
	        
	        txt_passWord = new JPasswordField();
	        txt_passWord.setBounds(329, 167, 262, 29);
	        contentPane.add(txt_passWord);
	        
	        JLabel lbl_quenMatKhau = new JLabel("Quên Mật Khẩu");
	        lbl_quenMatKhau.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        	QuenMatKhauView qmkv = new QuenMatKhauView();
	        	qmkv.setVisible(true);
	        	setVisible(false);
	        	}
	        });
	        lbl_quenMatKhau.setForeground(new Color(0, 128, 255));
	        lbl_quenMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl_quenMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        lbl_quenMatKhau.setBounds(485, 200, 106, 16);
	        contentPane.add(lbl_quenMatKhau);
	        btn_loginQR.addActionListener(dnc);
	    }
	 public JTextField txt_username() {
		 return txt_userName;
	 }
	 public JPasswordField txt_passWord() {
		 return txt_passWord;
	 }
	 public JButton btn_Login() {
		 return btn_login;
	 }
	 public JButton btn_LoginQR() {
		 return btn_loginQR;
	 }
}

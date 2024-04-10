package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.QuenMatKhauController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class QuenMatKhauView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_userName;
	private JTextField txt_matKhauMoi;
	private JTextField txt_email;
	private JTextField txt_maXacNhan;
	private JButton btn_gui;
	private JButton btn_doiMk;
	private JButton btn_huy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhauView frame = new QuenMatKhauView();
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
	public QuenMatKhauView() {
		QuenMatKhauController qmkc = new QuenMatKhauController(this, null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setBounds(100, 100, 519, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUÊN MẬT KHẨU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(122, 11, 282, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 87, 100, 20);
		contentPane.add(lblNewLabel_1);
		
		txt_userName = new JTextField();
		txt_userName.setColumns(10);
		txt_userName.setBounds(146, 90, 226, 20);
		contentPane.add(txt_userName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 127, 110, 20);
		contentPane.add(lblNewLabel_1_1);
		
		txt_matKhauMoi = new JTextField();
		txt_matKhauMoi.setColumns(10);
		txt_matKhauMoi.setBounds(146, 130, 226, 20);
		contentPane.add(txt_matKhauMoi);
		
		 btn_doiMk = new JButton("Đổi Mật Khẩu");
		btn_doiMk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_doiMk.setBounds(146, 226, 110, 28);
		contentPane.add(btn_doiMk);
		
		 btn_huy = new JButton("Hủy");
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_huy.setBounds(262, 226, 110, 28);
		contentPane.add(btn_huy);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(20, 161, 110, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(146, 164, 226, 20);
		contentPane.add(txt_email);
		
		 btn_gui = new JButton("Gửi");
		btn_gui.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_gui.setBounds(386, 158, 81, 28);
		contentPane.add(btn_gui);
		
		txt_maXacNhan = new JTextField();
		txt_maXacNhan.setColumns(10);
		txt_maXacNhan.setBounds(146, 195, 110, 20);
		contentPane.add(txt_maXacNhan);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã xác nhận");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(20, 198, 110, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		btn_gui.addActionListener(qmkc);
		btn_doiMk.addActionListener(qmkc);
		btn_huy.addActionListener(qmkc);
	}
	public JTextField txt_userName() {
		return txt_userName;
	}
	public JTextField txt_matKhauMoi() {
		return txt_matKhauMoi;
	}
	public JTextField txt_email() {
		return txt_email;
	}
	public JTextField txt_maXacNhan() {
		return txt_maXacNhan;
	}
	public JButton btn_gui() {
		return btn_gui;
	}
	public JButton btn_doiMk() {
		return btn_doiMk;
	}
	public JButton btn_huy() {
		return btn_huy;
	}
}

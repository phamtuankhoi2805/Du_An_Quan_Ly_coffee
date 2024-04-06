package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;

import Controller.QuanLyController;
import DAO.NhanVienDAO;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.time.YearMonth;
import java.util.Locale;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
public class QuanLyView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_qLNhanVien;
	private JButton btn_qLBanHang;
	private JButton btn_qLHangHoa;
	private JButton btn_Thoat;
	private JButton btn_trangChu;
	private JPanel panel_chu;
	private JLabel lbl_ten;
	private JLabel lbl_chucVu;
	private JButton btn_QlCaLam;
	private JTextField txt_id;
	private JTextField txt_ten;
	private JTextField txt_ngaySinh;
	private JTextField txt_sdt;
	private JTextField txt_email;
	private JTextField txt_TrangThaI;
	private JTextField txt_luongCb;
	private JTable tbl_nhanVien;
	private AbstractButton btn_ThongKe;
	private JRadioButton rdo_Nam;
	private JRadioButton rdo_nu;
	private JCheckBox cb_quanLy;
	private JCheckBox cb_nhanVien;
	private PlaceholderTextField txt_tim;
	private JButton btn_moi;
	private JComboBox cb_sapXep;
	private JButton btn_themNV;
	private JButton btn_sua;
	private JPanel buttonPanel;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JTextField txt_idSP;
	private JTextField txt_tenSP;
	private JTextField txt_giaSp;
	private JLabel lbl_anhSP;
	private JLabel lblNewLabel_3;
	private JTable tbl_SanPham;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txt_idKM;
	private JTextField txt_tenKM;
	private JTextField txt_dieuKienKM;
	private JButton btn_LamMoiKM;
	private JButton btn_themKM;
	private JButton btn_suaKM;
	private JTable tbl_KhuyenMai;
	private JLabel lblNewLabel_11;
	private JScrollPane scrollPane_3;
	private JComboBox cbo_tru;
	private JButton btn_doiAnh;
	private JButton btn_lamMoiSP;
	private JButton btn_themSP;
	private JButton btn_suaSP;
	private JLabel lblNewLabel_12_1_2;
	private JLabel lblNewLabel_12_4;
	private JTextField txt_idCaLam;
	private JTextField txt_tenCaLam;
	private JTable tbl_CaLam;
	private JLabel lblNewLabel_15;
	private JTable tbl_xepCa;
	private JComboBox cbo_trangThaiSP;
	private JLabel lblNewLabel_16;
	private JButton btn_XuatKho;
	private JLabel lblNewLabel_17;
	private JButton btn_themSPDat;
	private JButton btn_themSPKhoExcel;
	private JScrollPane scrollPane_6;
	private JTable tbl_kho;
	private JButton btn_nhapKho;
	private JComboBox cbo_ngayLam;
	private JTable tbl_DSNguyenLieuXuat;
	private JLabel lblNewLabel_20;
	private JTextField txt_idNLXuat;
	private JTextField txt_tenNLXuat;
	private JTextField txt_soLuongTonXuat;
	private JTextField txt_soLuongLayXuat;
	private JButton btn_DatHang;
	String idCaLam;

	private int clickCount = 0;
	private Timer timer;
	private JComboBox cbo_batDau;
	private JButton btn_themCaLam;
	private JButton btn_xuat;
	private JYearChooser yearChooser;
	private JComboBox<String> cbo_thangTK;
	private JComboBox<String> cbo_namTk;
	private JLabel lbl_tongDoanhThuThang;
	private JLabel lbl_doanhThuTien;
	private JLabel lbl_tongDonHangThang;
	private JLabel lbl_soDonHangThang;
	private DefaultCategoryDataset dataset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyView frame = new QuanLyView();
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
	public QuanLyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuanLyController qlc = new QuanLyController(this);
		setTitle("Hệ Thống Quản Lý Cafe");
		setBounds(100, 100, 1320, 718);

		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 270, 687);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_ten = new JLabel("Tên");
		lbl_ten.setForeground(new Color(255, 255, 255));
		lbl_ten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ten.setBounds(23, 11, 174, 20);
		panel.add(lbl_ten);

		btn_qLNhanVien = new JButton("Quản Lý Nhân Viên");
		btn_qLNhanVien.setHorizontalAlignment(SwingConstants.LEADING);
		btn_qLNhanVien.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\user group.png"));
		btn_qLNhanVien.setBorder(new CompoundBorder());
		btn_qLNhanVien.setForeground(new Color(255, 255, 255));
		btn_qLNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 2");
				btn_trangChu.setEnabled(true);
				btn_qLNhanVien.setEnabled(false);
				btn_qLBanHang.setEnabled(true);
				btn_qLHangHoa.setEnabled(true);
				btn_QlCaLam.setEnabled(true);
				btn_ThongKe.setEnabled(true);
			}
		});
		btn_qLNhanVien.setBackground(new Color(0, 0, 64));
		btn_qLNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_qLNhanVien.setBounds(32, 176, 191, 32);
		panel.add(btn_qLNhanVien);

		btn_qLBanHang = new JButton("Quản Lý Bán Hàng");
		btn_qLBanHang.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\Cart.png"));
		btn_qLBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		btn_qLBanHang.setBorder(new CompoundBorder());
		btn_qLBanHang.setForeground(new Color(255, 255, 255));
		btn_qLBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 3");
				qlc.fildTableQLSanPham();
				qlc.fileTabelkhuyenMai();
				btn_trangChu.setEnabled(true);
				btn_qLNhanVien.setEnabled(true);
				btn_qLBanHang.setEnabled(false);
				btn_qLHangHoa.setEnabled(true);
				btn_QlCaLam.setEnabled(true);
				btn_ThongKe.setEnabled(true);
			}
		});
		btn_qLBanHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_qLBanHang.setBackground(new Color(0, 0, 64));
		btn_qLBanHang.setBounds(32, 219, 191, 32);
		panel.add(btn_qLBanHang);

		btn_qLHangHoa = new JButton("Quản Lý Hàng Hóa");
		btn_qLHangHoa.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\Invoice.png"));
		btn_qLHangHoa.setHorizontalAlignment(SwingConstants.LEFT);
		btn_qLHangHoa.setBorder(new CompoundBorder());
		btn_qLHangHoa.setForeground(new Color(255, 255, 255));
		btn_qLHangHoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 4");
				btn_trangChu.setEnabled(true);
				btn_qLNhanVien.setEnabled(true);
				btn_qLBanHang.setEnabled(true);
				btn_qLHangHoa.setEnabled(false);
				btn_QlCaLam.setEnabled(true);
				btn_ThongKe.setEnabled(true);
			}
		});
		btn_qLHangHoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_qLHangHoa.setBackground(new Color(0, 0, 64));
		btn_qLHangHoa.setBounds(32, 262, 191, 32);
		panel.add(btn_qLHangHoa);

		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\login.png"));
		btn_Thoat.setBorder(new CompoundBorder());
		btn_Thoat.setForeground(new Color(255, 255, 255));
		btn_Thoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Thoat.setBackground(new Color(0, 0, 64));
		btn_Thoat.setBounds(15, 634, 236, 42);
		panel.add(btn_Thoat);

		btn_trangChu = new JButton("Trang Chủ");
		btn_trangChu.setHorizontalAlignment(SwingConstants.LEADING);
		btn_trangChu.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\Home.png"));
		btn_trangChu.setForeground(new Color(255, 255, 255));
		btn_trangChu.setBorder(new CompoundBorder());
		btn_trangChu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 1");
				btn_trangChu.setEnabled(false);
				btn_qLNhanVien.setEnabled(true);
				btn_qLBanHang.setEnabled(true);
				btn_qLHangHoa.setEnabled(true);
				btn_QlCaLam.setEnabled(true);
				btn_ThongKe.setEnabled(true);

			}
		});
		btn_trangChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_trangChu.setBackground(new Color(0, 0, 64));
		btn_trangChu.setBounds(32, 133, 191, 32);
		panel.add(btn_trangChu);

		btn_QlCaLam = new JButton("Quản Lý Ca Làm");
		btn_QlCaLam.setHorizontalAlignment(SwingConstants.LEFT);
		btn_QlCaLam.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\calendar.png"));
		btn_QlCaLam.setForeground(Color.WHITE);
		btn_QlCaLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_QlCaLam.setBorder(new CompoundBorder());
		btn_QlCaLam.setBackground(new Color(0, 0, 64));
		btn_QlCaLam.setBounds(32, 305, 191, 32);
		btn_QlCaLam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 5");
				qlc.fildTableCaLam();

				btn_trangChu.setEnabled(true);
				btn_qLNhanVien.setEnabled(true);
				btn_qLBanHang.setEnabled(true);
				btn_qLHangHoa.setEnabled(true);
				btn_QlCaLam.setEnabled(false);
				btn_ThongKe.setEnabled(true);
			}
		});
		panel.add(btn_QlCaLam);

		lbl_chucVu = new JLabel("Chức Vụ");
		lbl_chucVu.setBounds(23, 42, 174, 20);
		panel.add(lbl_chucVu);
		lbl_chucVu.setForeground(new Color(255, 255, 255));
		lbl_chucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btn_ThongKe = new JButton("Thống Kê");
		btn_ThongKe.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\device.png"));
		btn_ThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btn_ThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
				cardLayout.show(panel_chu, "Card 6");
				btn_trangChu.setEnabled(true);
				btn_qLNhanVien.setEnabled(true);
				btn_qLBanHang.setEnabled(true);
				btn_qLHangHoa.setEnabled(true);
				btn_QlCaLam.setEnabled(true);
				btn_ThongKe.setEnabled(false);
			}
		});
		btn_ThongKe.setForeground(Color.WHITE);
		btn_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_ThongKe.setBorder(new CompoundBorder());
		btn_ThongKe.setBackground(new Color(0, 0, 64));
		btn_ThongKe.setBounds(32, 348, 191, 32);
		panel.add(btn_ThongKe);

		panel_chu = new JPanel();
		panel_chu.setBackground(new Color(192, 192, 192));
		panel_chu.setBounds(269, 0, 1037, 687);
		contentPane.add(panel_chu);
		panel_chu.setLayout(new CardLayout(0, 0));

		// Tạo card thứ nhất
		JPanel card1 = new JPanel();
		card1.setBackground(new Color(255, 255, 255));
		panel_chu.add(card1, "Card 1");
		card1.setLayout(null);
		JLabel lbl_hinhChu = new JLabel("");
		lbl_hinhChu.setBounds(0, 0, 1070, 687);
		card1.add(lbl_hinhChu);
		// Tạo một đối tượng ImageIcon từ tệp hình ảnh
		ImageIcon imageIcon1 = new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\TrangChu.jpg");

		// Lấy kích thước gốc của hình ảnh
		int originalWidth1 = imageIcon1.getIconWidth();
		int originalHeight1 = imageIcon1.getIconHeight();

		// Tính toán kích thước mới dựa trên kích thước của lbl_hinhChu
		int desiredWidth1 = lbl_hinhChu.getWidth();
		int desiredHeight1 = lbl_hinhChu.getHeight();

		// Tạo một đối tượng Image từ ImageIcon và thay đổi kích thước
		Image image1 = imageIcon1.getImage().getScaledInstance(desiredWidth1, desiredHeight1, Image.SCALE_SMOOTH);

		// Tạo một ImageIcon mới từ đối tượng Image đã thay đổi kích thước
		ImageIcon resizedImageIcon1 = new ImageIcon(image1);

		// Đặt hình ảnh đã thay đổi kích thước vào lbl_hinhChu
		lbl_hinhChu.setIcon(resizedImageIcon1);

		// Tạo card thứ hai
		JPanel card2 = new JPanel();
		card2.setBorder(new CompoundBorder());
		card2.setBackground(new Color(255, 255, 255));
		panel_chu.add(card2, "Card 2");
		card2.setLayout(null);

		JPanel panel_thongTinNV = new JPanel();
		panel_thongTinNV.setBorder(new CompoundBorder());
		panel_thongTinNV.setBackground(new Color(255, 255, 255));
		panel_thongTinNV.setBounds(10, 48, 1017, 281);
		card2.add(panel_thongTinNV);
		panel_thongTinNV.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 58, 28);
		panel_thongTinNV.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên NV:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 50, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 89, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới Tính:");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 128, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("SDT:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 167, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 206, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Chức vụ");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 245, 86, 28);
		panel_thongTinNV.add(lblNewLabel_1_1_1_1_1_1_1);

		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_id.setForeground(new Color(0, 0, 0));
		txt_id.setBackground(new Color(255, 255, 255));
		txt_id.setBorder(new CompoundBorder());
		txt_id.setBounds(110, 17, 251, 20);
		panel_thongTinNV.add(txt_id);
		applyBottomBorder(txt_id);
		txt_id.setColumns(10);
		// Tạo gạch dưới

		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ten.setBackground(new Color(255, 255, 255));
		txt_ten.setForeground(new Color(0, 0, 0));
		txt_ten.setBorder(new CompoundBorder());
		txt_ten.setColumns(10);
		txt_ten.setBounds(110, 56, 251, 20);
		panel_thongTinNV.add(txt_ten);

		txt_ngaySinh = new JTextField();
		txt_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ngaySinh.setForeground(new Color(0, 0, 0));
		txt_ngaySinh.setBackground(new Color(255, 255, 255));
		txt_ngaySinh.setBorder(new CompoundBorder());
		txt_ngaySinh.setColumns(10);
		txt_ngaySinh.setBounds(110, 95, 251, 20);
		panel_thongTinNV.add(txt_ngaySinh);

		txt_sdt = new JTextField();
		txt_sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_sdt.setForeground(new Color(0, 0, 0));
		txt_sdt.setBackground(new Color(255, 255, 255));
		txt_sdt.setBorder(new CompoundBorder());
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(110, 173, 251, 20);
		panel_thongTinNV.add(txt_sdt);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_email.setForeground(new Color(0, 0, 0));
		txt_email.setBackground(new Color(255, 255, 255));
		txt_email.setBorder(new CompoundBorder());
		txt_email.setColumns(10);
		txt_email.setBounds(110, 212, 251, 20);
		panel_thongTinNV.add(txt_email);

		rdo_Nam = new JRadioButton("Nam");
		rdo_Nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdo_Nam.setForeground(new Color(0, 0, 0));
		rdo_Nam.setBackground(new Color(255, 255, 255));
		rdo_Nam.setBounds(110, 133, 69, 23);

		rdo_nu = new JRadioButton("Nữ");
		rdo_nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdo_nu.setForeground(new Color(0, 0, 0));
		rdo_nu.setBackground(new Color(255, 255, 255));
		rdo_nu.setBounds(193, 133, 69, 23);

		panel_thongTinNV.add(rdo_Nam);
		panel_thongTinNV.add(rdo_nu);
		ButtonGroup b = new ButtonGroup();
		b.add(rdo_Nam);
		b.add(rdo_nu);

		cb_quanLy = new JCheckBox("Quản Lý");
		cb_quanLy.setBackground(new Color(255, 255, 255));
		cb_quanLy.setForeground(new Color(0, 0, 0));
		cb_quanLy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_quanLy.setBounds(110, 250, 97, 23);
		panel_thongTinNV.add(cb_quanLy);

		cb_nhanVien = new JCheckBox("Nhân Viên");
		cb_nhanVien.setForeground(new Color(0, 0, 0));
		cb_nhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_nhanVien.setBackground(new Color(255, 255, 255));
		cb_nhanVien.setBounds(209, 250, 118, 23);
		panel_thongTinNV.add(cb_nhanVien);
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(cb_quanLy);
		buttonGroup1.add(cb_nhanVien);

		JLabel lblNewLabel_1_2 = new JLabel("Trạng Thái:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(384, 11, 102, 28);
		panel_thongTinNV.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Lương CB:");
		lblNewLabel_1_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(384, 50, 102, 28);
		panel_thongTinNV.add(lblNewLabel_1_2_1);

		txt_TrangThaI = new JTextField();
		txt_TrangThaI.setForeground(new Color(0, 0, 0));
		txt_TrangThaI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_TrangThaI.setColumns(10);
		txt_TrangThaI.setBorder(new CompoundBorder());
		txt_TrangThaI.setBackground(new Color(255, 255, 255));
		txt_TrangThaI.setBounds(496, 17, 251, 20);
		panel_thongTinNV.add(txt_TrangThaI);

		txt_luongCb = new JTextField();
		txt_luongCb.setForeground(new Color(0, 0, 0));
		txt_luongCb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_luongCb.setColumns(10);
		txt_luongCb.setBorder(new CompoundBorder());
		txt_luongCb.setBackground(new Color(255, 255, 255));
		txt_luongCb.setBounds(496, 56, 251, 20);
		panel_thongTinNV.add(txt_luongCb);

		btn_themNV = new JButton("Thêm");
		btn_themNV.setEnabled(false);
		btn_themNV.setForeground(new Color(255, 255, 255));
		btn_themNV.setBackground(new Color(0, 0, 64));
		btn_themNV.setBorder(new CompoundBorder());
		btn_themNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_themNV.setBounds(460, 248, 75, 23);
		panel_thongTinNV.add(btn_themNV);

		btn_sua = new JButton("Sửa");
		btn_sua.setForeground(Color.WHITE);
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_sua.setBorder(new CompoundBorder());
		btn_sua.setBackground(new Color(0, 0, 64));
		btn_sua.setBounds(538, 248, 75, 23);
		panel_thongTinNV.add(btn_sua);

		tbl_nhanVien = new JTable();
		tbl_nhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qlc.fillcontroll();
			}
		});
		tbl_nhanVien.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID NV", "H\u1ECD T\u00EAn", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "SDT", "Email",
						"Ch\u1EE9c V\u1EE5", "Tr\u1EA1ng Th\u00E1i", "L\u01B0\u01A1ng CB" }));
		tbl_nhanVien.setBounds(20, 341, 1007, 335);

		// Bỏ viền cho các cột và hàng
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setBorder(null);
		tbl_nhanVien.setDefaultRenderer(Object.class, renderer);

		JScrollPane scrollPane = new JScrollPane(tbl_nhanVien);
		scrollPane.setBounds(10, 362, 1017, 314);
		card2.add(scrollPane);

		JPanel card3 = new JPanel();
		card3.setBackground(new Color(255, 255, 255));
		panel_chu.add(card3, "Card 3");
		card3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 51, 503, 240);
		card3.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 11, 76, 20);
		panel_1.add(lblNewLabel_2);

		txt_idSP = new JTextField();
		txt_idSP.setBounds(96, 11, 158, 20);
		panel_1.add(txt_idSP);
		txt_idSP.setForeground(Color.BLACK);
		txt_idSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_idSP.setEditable(false);
		txt_idSP.setColumns(10);
		txt_idSP.setBorder(new CompoundBorder());
		txt_idSP.setBackground(Color.WHITE);

		JLabel lblNewLabel_2_1 = new JLabel("Tên SP");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 42, 76, 20);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Giá");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 73, 76, 20);
		panel_1.add(lblNewLabel_2_1_1);

		txt_tenSP = new JTextField();
		txt_tenSP.setForeground(Color.BLACK);
		txt_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tenSP.setColumns(10);
		txt_tenSP.setBorder(new CompoundBorder());
		txt_tenSP.setBackground(Color.WHITE);
		txt_tenSP.setBounds(96, 42, 158, 20);
		panel_1.add(txt_tenSP);

		txt_giaSp = new JTextField();
		txt_giaSp.setForeground(Color.BLACK);
		txt_giaSp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_giaSp.setColumns(10);
		txt_giaSp.setBorder(new CompoundBorder());
		txt_giaSp.setBackground(Color.WHITE);
		txt_giaSp.setBounds(96, 73, 158, 20);
		panel_1.add(txt_giaSp);

		JPanel card4 = new JPanel();
		card4.setBackground(new Color(255, 255, 255));
		panel_chu.add(card4, "Card 4");
		card4.setLayout(new CardLayout(0, 0));

		// Tạo card nhỏ 1
		JPanel smallCard1 = new JPanel();
		smallCard1.setBackground(new Color(255, 255, 255)); // Màu đỏ cho card nhỏ 1
		card4.add(smallCard1, "Small Card 1");
		smallCard1.setLayout(null);

		lblNewLabel_16 = new JLabel("Quản Lý Kho Hàng");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_16.setBounds(10, 11, 208, 21);
		smallCard1.add(lblNewLabel_16);

		btn_XuatKho = new JButton("Xuất Kho");
		btn_XuatKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) card4.getLayout();
				cardLayout.show(card4, "Small Card 2");
				qlc.fileTabelDSXuat();
				qlc.disPlayfromXuatHang(0);
				// Thiết lập các trạng thái nút nhập kho và xuất kho tại đây (nếu cần)
			}
		});
		btn_XuatKho.setForeground(Color.WHITE);
		btn_XuatKho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_XuatKho.setBackground(new Color(0, 0, 160));
		btn_XuatKho.setBounds(20, 47, 115, 23);
		smallCard1.add(btn_XuatKho);

		lblNewLabel_17 = new JLabel("Danh Sách Nguyên Liệu");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_17.setBounds(10, 128, 240, 23);
		smallCard1.add(lblNewLabel_17);

		btn_themSPDat = new JButton("Thêm SP Đặt Hàng");
		btn_themSPDat.setForeground(Color.WHITE);
		btn_themSPDat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_themSPDat.setBackground(new Color(0, 0, 160));
		btn_themSPDat.setBounds(739, 130, 139, 23);
		btn_themSPDat.addActionListener(qlc);
		smallCard1.add(btn_themSPDat);

		btn_themSPKhoExcel = new JButton("Thêm SP Qua Excel");
		btn_themSPKhoExcel.setForeground(Color.WHITE);
		btn_themSPKhoExcel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_themSPKhoExcel.setBackground(new Color(0, 0, 160));
		btn_themSPKhoExcel.setBounds(888, 130, 139, 23);
		smallCard1.add(btn_themSPKhoExcel);

		tbl_kho = new JTable();
		tbl_kho.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID Nguyên Liệu", "Tên Nguyên Liệu",
				"Số Lượng Tồn", "Số Lượng Cần Nhập", "Tên Nhà Cung Câp", "SDT" }));
		tbl_kho.setBounds(10, 174, 1017, 502);
		scrollPane_6 = new JScrollPane(tbl_kho);
		scrollPane_6.setBounds(10, 174, 1017, 502);
		smallCard1.add(scrollPane_6);

		btn_DatHang = new JButton("Đặt Hàng");

		btn_DatHang.setForeground(Color.WHITE);
		btn_DatHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_DatHang.setBackground(new Color(0, 0, 160));
		btn_DatHang.setBounds(590, 130, 139, 23);
		btn_DatHang.addActionListener(qlc);
		smallCard1.add(btn_DatHang);

		// Tạo card nhỏ 2
		JPanel smallCard2 = new JPanel();
		smallCard2.setBackground(new Color(255, 255, 255)); // Màu xanh lá cây cho card nhỏ 2
		card4.add(smallCard2, "Small Card 2");
		smallCard2.setLayout(null);

		btn_nhapKho = new JButton("Nhập Kho");
		btn_nhapKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) card4.getLayout();
				cardLayout.show(card4, "Small Card 1");
				// Thiết lập các trạng thái nút nhập kho và xuất kho tại đây (nếu cần)
			}
		});
		btn_nhapKho.setForeground(Color.WHITE);
		btn_nhapKho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_nhapKho.setBackground(new Color(0, 0, 160));
		btn_nhapKho.setBounds(10, 23, 115, 23);
		smallCard2.add(btn_nhapKho);

		tbl_DSNguyenLieuXuat = new JTable();
		tbl_DSNguyenLieuXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qlc.fillcontrollXuatKho();
			}
		});
		tbl_DSNguyenLieuXuat.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"ID Nguy\u00EAn Li\u1EC7u", "T\u00EAn Nguy\u00EAn Li\u1EC7u", "Số Lượng Tồn", "Đơn Vị Tính" }));
		tbl_DSNguyenLieuXuat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tbl_DSNguyenLieuXuat.setBounds(501, 75, 526, 260);
		JScrollPane scrollPane_7 = new JScrollPane(tbl_DSNguyenLieuXuat);
		scrollPane_7.setBounds(30, 403, 985, 260);
		smallCard2.add(scrollPane_7);

		JLabel lblNewLabel_19 = new JLabel("Danh Sách Nguyên Liệu");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(39, 370, 183, 23);
		smallCard2.add(lblNewLabel_19);

		lblNewLabel_20 = new JLabel("Thông Tin Nguyên Liệu");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20.setBounds(10, 56, 192, 29);
		smallCard2.add(lblNewLabel_20);

		txt_idNLXuat = new JTextField("");
		txt_idNLXuat.setBorder(new CompoundBorder());
		txt_idNLXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_idNLXuat.setBounds(243, 92, 349, 29);
		smallCard2.add(txt_idNLXuat);
		txt_idNLXuat.setColumns(10);
		;
		applyBottomBorder(txt_idNLXuat);

		txt_tenNLXuat = new JTextField("");
		txt_tenNLXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tenNLXuat.setColumns(10);
		txt_tenNLXuat.setBorder(new CompoundBorder());
		txt_tenNLXuat.setBounds(243, 128, 349, 29);
		smallCard2.add(txt_tenNLXuat);
		applyBottomBorder(txt_tenNLXuat);

		txt_soLuongTonXuat = new JTextField("");
		txt_soLuongTonXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_soLuongTonXuat.setColumns(10);
		txt_soLuongTonXuat.setBorder(new CompoundBorder());
		txt_soLuongTonXuat.setBounds(243, 167, 349, 29);
		applyBottomBorder(txt_soLuongTonXuat);
		smallCard2.add(txt_soLuongTonXuat);

		txt_soLuongLayXuat = new JTextField("");
		txt_soLuongLayXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_soLuongLayXuat.setColumns(10);
		txt_soLuongLayXuat.setBorder(new CompoundBorder());
		txt_soLuongLayXuat.setBounds(243, 206, 349, 29);
		smallCard2.add(txt_soLuongLayXuat);
		applyBottomBorder(txt_soLuongLayXuat);

		btn_xuat = new JButton("Xuất");
		btn_xuat.setForeground(Color.WHITE);
		btn_xuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_xuat.setBorder(new CompoundBorder());
		btn_xuat.setBackground(new Color(0, 0, 64));
		btn_xuat.setBounds(30, 268, 108, 23);
		smallCard2.add(btn_xuat);
		btn_xuat.addActionListener(qlc);
		JLabel lblNewLabel_21 = new JLabel("ID Nguyên Liệu");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_21.setBounds(20, 95, 213, 23);
		smallCard2.add(lblNewLabel_21);

		JLabel lblNewLabel_21_1 = new JLabel("Tên Nguyên Liệu");
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_21_1.setBounds(20, 134, 213, 23);
		smallCard2.add(lblNewLabel_21_1);

		JLabel lblNewLabel_21_1_1 = new JLabel("Số Lượng Tồn");
		lblNewLabel_21_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_21_1_1.setBounds(20, 173, 213, 23);
		smallCard2.add(lblNewLabel_21_1_1);

		JLabel lblNewLabel_21_1_1_1 = new JLabel("Số Lượng Lấy");
		lblNewLabel_21_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_21_1_1_1.setBounds(20, 212, 213, 23);
		smallCard2.add(lblNewLabel_21_1_1_1);
		JPanel card5 = new JPanel();
		card5.setBackground(new Color(255, 255, 255));
		panel_chu.add(card5, "Card 5");
		card5.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("Danh Sách Ca Làm");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(23, 11, 223, 36);
		card5.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("ID ca Làm");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_14.setBounds(23, 79, 144, 30);
		card5.add(lblNewLabel_14);

		JLabel lblNewLabel_14_1 = new JLabel("Tên ca Làm");
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_14_1.setBounds(23, 120, 144, 30);
		card5.add(lblNewLabel_14_1);

		JLabel lblNewLabel_14_1_1 = new JLabel("Thời Gian");
		lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_14_1_1.setBounds(23, 161, 144, 30);
		card5.add(lblNewLabel_14_1_1);

		txt_idCaLam = new JTextField();
		txt_idCaLam.setForeground(Color.BLACK);
		txt_idCaLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_idCaLam.setColumns(10);
		txt_idCaLam.setBorder(new CompoundBorder());
		txt_idCaLam.setBackground(Color.WHITE);
		txt_idCaLam.setBounds(133, 86, 158, 20);
		card5.add(txt_idCaLam);

		txt_tenCaLam = new JTextField();
		txt_tenCaLam.setForeground(Color.BLACK);
		txt_tenCaLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tenCaLam.setColumns(10);
		txt_tenCaLam.setBorder(new CompoundBorder());
		txt_tenCaLam.setBackground(Color.WHITE);
		txt_tenCaLam.setBounds(133, 120, 158, 20);
		card5.add(txt_tenCaLam);

		cbo_batDau = new JComboBox();
		cbo_batDau.setModel(new DefaultComboBoxModel(
				new String[] { "08:00 - 17:00", "09:00 - 18:00", "10:00 - 19:00", "07:00 - 16:00" }));
		cbo_batDau.setBounds(133, 167, 110, 22);
		card5.add(cbo_batDau);

		tbl_CaLam = new JTable();
		tbl_caLam().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = tbl_caLam().getSelectedRow();
				idCaLam = (String) tbl_caLam().getValueAt(rowIndex, 0);
				qlc.fildTableXepCa(idCaLam);

			}
		});
		tbl_CaLam.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "T\u00EAn Ca L\u00E0m", "Th\u1EDDi Gian", "Ng\u00E0y", "ID NV" }));
		tbl_CaLam.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl_CaLam.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbl_CaLam.getColumnModel().getColumn(2).setPreferredWidth(50);
		tbl_CaLam.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbl_CaLam.getColumnModel().getColumn(4).setPreferredWidth(80);
		tbl_CaLam.setBounds(319, 46, 708, 226);
		JScrollPane scrollPane_4 = new JScrollPane(tbl_CaLam);
		scrollPane_4.setBounds(319, 71, 708, 229);
		card5.add(scrollPane_4);

		lblNewLabel_15 = new JLabel("Xếp Ca");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_15.setBounds(23, 308, 116, 36);
		card5.add(lblNewLabel_15);

		btn_themCaLam = new JButton("Thêm Ca Làm");
		btn_themCaLam.setForeground(new Color(255, 255, 255));
		btn_themCaLam.setBackground(new Color(0, 0, 128));
		btn_themCaLam.setBounds(23, 202, 268, 23);
		card5.add(btn_themCaLam);
		btn_themCaLam.addActionListener(qlc);
		tbl_xepCa = new JTable();
		tbl_xepCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex1 = tbl_xepCa.getSelectedRow();
				String idNhanVien = (String) tbl_xepCa.getValueAt(rowIndex1, 0);
				System.out.println(idNhanVien);
				System.out.println(idCaLam);
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm nhân viên vào ca làm?", "Xác nhận",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					try {
						NhanVienDAO.getInstance().updateCaLam(idCaLam, idNhanVien);
						qlc.fildTableCaLam();
						qlc.fildTableXepCa(idCaLam);
						JOptionPane.showMessageDialog(null, "thành công");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else if (choice == JOptionPane.NO_OPTION) {
					System.out.println("huy");
				}
			}
		});
		tbl_xepCa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID NV", "T\u00EAn NV" }));
		tbl_xepCa.setBounds(22, 356, 1005, 320);

		JScrollPane scrollPane_5 = new JScrollPane(tbl_xepCa);
		scrollPane_5.setBounds(23, 355, 1004, 321);
		card5.add(scrollPane_5);

		JPanel card6 = new JPanel();
		card6.setBackground(new Color(255, 255, 255));
		panel_chu.add(card6, "Card 6");
		card6.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Thống Kê Và Báo Cáo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(20, 11, 213, 22);
		card6.add(lblNewLabel_6);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(0, 128, 192));
		panel_3.setBounds(20, 44, 310, 165);
		card6.add(panel_3);
		panel_3.setLayout(null);

		 lbl_tongDoanhThuThang = new JLabel("Tổng Doanh Thu");
		lbl_tongDoanhThuThang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDoanhThuThang.setBounds(10, 11, 290, 24);
		panel_3.add(lbl_tongDoanhThuThang);

		 lbl_doanhThuTien = new JLabel("0");
		lbl_doanhThuTien.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl_doanhThuTien.setBounds(10, 46, 147, 60);
		panel_3.add(lbl_doanhThuTien);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3_1.setBackground(new Color(255, 255, 128));
		panel_3_1.setBounds(374, 44, 310, 165);
		card6.add(panel_3_1);

		 lbl_tongDonHangThang = new JLabel("Tổng Số Đơn Hàng");
		lbl_tongDonHangThang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDonHangThang.setBounds(10, 11, 218, 24);
		panel_3_1.add(lbl_tongDonHangThang);

		 lbl_soDonHangThang = new JLabel("0");
		lbl_soDonHangThang.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl_soDonHangThang.setBounds(10, 46, 147, 60);
		panel_3_1.add(lbl_soDonHangThang);

		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBounds(20, 288, 996, 370);
		// Tạo dữ liệu cho biểu đồ đường
		 dataset = new DefaultCategoryDataset();
//		   dataset.addValue(200, "Doanh thu", "1");
//	        dataset.addValue(300, "Doanh thu", "2");
//	        dataset.addValue(400, "Doanh thu", "3");
//	        dataset.addValue(500, "Doanh thu", "4");
//	        dataset.addValue(600, "Doanh thu", "5");
//	        dataset.addValue(700, "Doanh thu", "6");
//	        dataset.addValue(800, "Doanh thu", "7");
//	        dataset.addValue(900, "Doanh thu", "8");
//	        dataset.addValue(1000, "Doanh thu", "9");
//	        dataset.addValue(1100, "Doanh thu", "10");
//	        dataset.addValue(1200, "Doanh thu", "11");
//	        dataset.addValue(1300, "Doanh thu", "12");

		// Tạo biểu đồ đường từ dữ liệu
		JFreeChart chart = ChartFactory.createLineChart("Biểu đồ doanh thu hàng tháng", "Tháng", "Doanh thu", dataset);

		// Thiết lập màu sắc và kiểu đường cho biểu đồ đường
		CategoryPlot plot = chart.getCategoryPlot();
		LineAndShapeRenderer renderer1 = (LineAndShapeRenderer) plot.getRenderer();
		renderer1.setSeriesPaint(0, Color.RED); // Đặt màu sắc cho chuỗi dữ liệu
		renderer1.setSeriesShapesVisible(0, true); // Hiển thị các điểm trên đường
		// Tạo một mảng chứa các màu sắc để sử dụng trong biểu đồ
		Color[] colors = new Color[] { new Color(31, 119, 180), // Màu xanh dương
				new Color(255, 127, 14), // Màu cam
				new Color(44, 160, 44), // Màu xanh lá cây
				new Color(214, 39, 40), // Màu đỏ
				new Color(148, 103, 189), // Màu tím
				new Color(140, 86, 75), // Màu nâu
				new Color(227, 119, 194), // Màu hồng
				new Color(127, 127, 127), // Màu xám
				new Color(188, 189, 34), // Màu vàng xanh lá
				new Color(23, 190, 207) // Màu xanh nước biển
		};

		// Thiết lập màu sắc cho các chuỗi dữ liệu trong biểu đồ
		LineAndShapeRenderer renderer11 = (LineAndShapeRenderer) plot.getRenderer();
		renderer11.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer11.setDefaultItemLabelsVisible(true);
		// Tạo một ChartPanel để chứa biểu đồ
		renderer11.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
		        TextAnchor.BASELINE_LEFT));
		ChartPanel chartPanel = new ChartPanel(chart);

		// Đặt kích thước và vị trí của chartPanel trong panel_ThongKe
		chartPanel.setBounds(0, 0, panel_ThongKe.getWidth(), panel_ThongKe.getHeight());
		chartPanel.setPreferredSize(new Dimension(panel_ThongKe.getWidth(), panel_ThongKe.getHeight()));

		// Xóa tất cả các thành phần đã có trong panel_ThongKe (nếu cần)
		panel_ThongKe.removeAll();

		// Thêm chartPanel vào panel_ThongKe
		panel_ThongKe.add(chartPanel);

		// Cập nhật lại panel_ThongKe để hiển thị biểu đồ
		panel_ThongKe.revalidate();
		panel_ThongKe.repaint();
		card6.add(panel_ThongKe);

    
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3_1_1.setBackground(new Color(0, 128, 128));
		panel_3_1_1.setBounds(706, 44, 310, 165);
		card6.add(panel_3_1_1);

		JLabel lbl_tongDonHangThang_1 = new JLabel("Xuất Báo Cáo");
		lbl_tongDonHangThang_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tongDonHangThang_1.setBounds(10, 11, 147, 24);
		panel_3_1_1.add(lbl_tongDonHangThang_1);

		JLabel lbl_soDonHangThang_1 = new JLabel("Excel");
		lbl_soDonHangThang_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl_soDonHangThang_1.setBounds(10, 46, 147, 60);
		panel_3_1_1.add(lbl_soDonHangThang_1);
		
	 cbo_namTk = new JComboBox();
	 cbo_namTk.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             qlc.thongKeDoanhThuThang(); 
             qlc.thongKeDoanhThuBieuDo1();
         }
     });
		cbo_namTk.setModel(new DefaultComboBoxModel(new String[] {"2024", "2023"}));
		cbo_namTk.setBounds(20, 263, 74, 22);
		card6.add(cbo_namTk);
		
		cbo_thangTK = new JComboBox();
	      cbo_thangTK.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                qlc.thongKeDoanhThuThang(); 
	            }
	        });
		cbo_thangTK.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbo_thangTK.setBounds(103, 263, 74, 22);
		card6.add(cbo_thangTK);
		
		// Hiển thị card đầu tiên

		txt_tim = new PlaceholderTextField("Tìm Kiếm");
		txt_tim.setBounds(665, 17, 251, 20);
		card2.add(txt_tim);

		txt_tim.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				qlc.timKiem1();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				qlc.timKiem1();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				qlc.timKiem1();
			}
		});

		txt_tim.setForeground(new Color(0, 0, 0));
		txt_tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tim.setColumns(10);
		txt_tim.setBorder(new CompoundBorder());
		txt_tim.setBackground(new Color(255, 255, 255));

		lbl_anhSP = new JLabel("");
		lbl_anhSP.setBackground(new Color(255, 255, 255));
		lbl_anhSP.setBounds(280, 32, 213, 133);
		panel_1.add(lbl_anhSP);

		btn_lamMoiSP = new JButton("Làm Mới");
		btn_lamMoiSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_lamMoiSP.setForeground(new Color(255, 255, 255));
		btn_lamMoiSP.setBackground(new Color(0, 0, 128));
		btn_lamMoiSP.setBounds(10, 207, 99, 23);
		panel_1.add(btn_lamMoiSP);

		btn_themSP = new JButton("Thêm SP");
		btn_themSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_themSP.setForeground(new Color(255, 255, 255));
		btn_themSP.setBackground(new Color(0, 0, 128));
		btn_themSP.setEnabled(false);
		btn_themSP.setBounds(109, 207, 118, 23);
		panel_1.add(btn_themSP);

		btn_suaSP = new JButton("Sửa SP");
		btn_suaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_suaSP.setForeground(new Color(255, 255, 255));
		btn_suaSP.setBackground(new Color(0, 0, 128));
		btn_suaSP.setBounds(226, 207, 105, 23);
		panel_1.add(btn_suaSP);

		btn_doiAnh = new JButton("Đổi Ảnh");
		btn_doiAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_doiAnh.setForeground(new Color(255, 255, 255));
		btn_doiAnh.setBackground(new Color(0, 0, 128));
		btn_doiAnh.setBounds(345, 177, 99, 23);
		panel_1.add(btn_doiAnh);

		lblNewLabel_3 = new JLabel("Thông Tin Sản Phẩm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(10, 11, 249, 29);
		card3.add(lblNewLabel_3);

		tbl_SanPham = new JTable();
		tbl_SanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qlc.fillcontrollSanPham();
			}
		});
		tbl_SanPham.setBackground(new Color(255, 255, 255));
		tbl_SanPham.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID S\u1EA3n Ph\u1EA9m",
				"T\u00EAn S\u1EA3n Ph\u1EA9m", "Gi\u00E1 B\u00E1n", "Trạng Thái" }));
		tbl_SanPham.setBounds(523, 51, 504, 240);
		JScrollPane scrollPane_2 = new JScrollPane(tbl_SanPham);
		scrollPane_2.setBounds(523, 51, 504, 240);
		card3.add(scrollPane_2);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 351, 503, 240);
		card3.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_4 = new JLabel("ID KM");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 11, 76, 20);
		panel_2.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Tên KM");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 42, 76, 20);
		panel_2.add(lblNewLabel_5);

		lblNewLabel_7 = new JLabel("Điều Kiện");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 75, 76, 20);
		panel_2.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("% Trừ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 106, 76, 20);
		panel_2.add(lblNewLabel_8);

		txt_idKM = new JTextField();
		txt_idKM.setForeground(Color.BLACK);
		txt_idKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_idKM.setEditable(false);
		txt_idKM.setColumns(10);
		txt_idKM.setBorder(new CompoundBorder());
		txt_idKM.setBackground(Color.WHITE);
		txt_idKM.setBounds(106, 11, 273, 20);
		panel_2.add(txt_idKM);

		txt_tenKM = new JTextField();
		txt_tenKM.setForeground(Color.BLACK);
		txt_tenKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tenKM.setColumns(10);
		txt_tenKM.setBorder(new CompoundBorder());
		txt_tenKM.setBackground(Color.WHITE);
		txt_tenKM.setBounds(106, 42, 273, 20);
		panel_2.add(txt_tenKM);

		txt_dieuKienKM = new JTextField();
		txt_dieuKienKM.setForeground(Color.BLACK);
		txt_dieuKienKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_dieuKienKM.setColumns(10);
		txt_dieuKienKM.setBorder(new CompoundBorder());
		txt_dieuKienKM.setBackground(Color.WHITE);
		txt_dieuKienKM.setBounds(106, 75, 273, 20);
		panel_2.add(txt_dieuKienKM);

		btn_LamMoiKM = new JButton("Làm Mới KM");

		btn_LamMoiKM.setForeground(Color.WHITE);
		btn_LamMoiKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_LamMoiKM.setBackground(new Color(0, 0, 128));
		btn_LamMoiKM.setBounds(10, 194, 127, 23);
		panel_2.add(btn_LamMoiKM);

		btn_themKM = new JButton("Thêm KM");

		btn_themKM.setForeground(Color.WHITE);
		btn_themKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_themKM.setEnabled(false);
		btn_themKM.setBackground(new Color(0, 0, 128));
		btn_themKM.setBounds(138, 194, 127, 23);
		panel_2.add(btn_themKM);

		btn_suaKM = new JButton("Sửa KM");
		btn_suaKM.setForeground(Color.WHITE);
		btn_suaKM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_suaKM.setBackground(new Color(0, 0, 128));
		btn_suaKM.setBounds(265, 194, 114, 23);
		panel_2.add(btn_suaKM);

		lblNewLabel_9 = new JLabel("Thông Tin Khuyến Mãi");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_9.setBounds(10, 311, 249, 29);
		card3.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("Bảng Sản Phẩm");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_10.setBounds(526, 11, 249, 29);
		card3.add(lblNewLabel_10);

		tbl_KhuyenMai = new JTable();
		tbl_KhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				qlc.fillcontrollKhuyenMai();
			}
		});
		tbl_KhuyenMai.setBackground(new Color(255, 255, 255));
		tbl_KhuyenMai.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID KM", "T\u00EAn KM", "\u0110i\u1EC1u Ki\u1EC7n KM", "T\u1ED5ng Tr\u1EEB" }));
		tbl_KhuyenMai.setBounds(399, 352, 628, 239);

		lblNewLabel_11 = new JLabel("Bảng Khuyến Mãi");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_11.setBounds(523, 311, 249, 29);
		card3.add(lblNewLabel_11);

		scrollPane_3 = new JScrollPane(tbl_KhuyenMai);
		scrollPane_3.setBounds(523, 351, 504, 240);
		card3.add(scrollPane_3);

		btn_moi = new JButton("Mới");
		btn_moi.setForeground(Color.WHITE);
		btn_moi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_moi.setBorder(new CompoundBorder());
		btn_moi.setBackground(new Color(0, 0, 64));
		btn_moi.setBounds(384, 248, 75, 23);
		panel_thongTinNV.add(btn_moi);

		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setBounds(10, 11, 204, 29);
		card2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		cb_sapXep = new JComboBox();
		cb_sapXep.setModel(new DefaultComboBoxModel(new String[] { "Lương Cơ Bản Tăng Dần", "Lương Cơ Bản Thấp Dần" }));
		cb_sapXep.setBounds(823, 340, 204, 20);
		card2.add(cb_sapXep);

		CardLayout cardLayout = (CardLayout) panel_chu.getLayout();
		cardLayout.show(panel_chu, "Card 1");

		applyBottomBorder(txt_ten);
		applyBottomBorder(txt_email);
		applyBottomBorder(txt_ngaySinh);
		applyBottomBorder(txt_sdt);
		applyBottomBorder(txt_TrangThaI);
		applyBottomBorder(txt_tim);
		applyBottomBorder(txt_luongCb);
		applyBottomBorder(txt_tenSP);
		applyBottomBorder(txt_giaSp);
		applyBottomBorder(txt_idSP);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 104, 99, 20);
		panel_1.add(lblNewLabel_2_1_1_1);

		cbo_trangThaiSP = new JComboBox();
		cbo_trangThaiSP.setModel(new DefaultComboBoxModel(new String[] { "Hoạt Động", "Không Hoạt Động" }));
		cbo_trangThaiSP.setBounds(119, 105, 135, 22);
		panel_1.add(cbo_trangThaiSP);
		applyBottomBorder(txt_idCaLam);
		applyBottomBorder(txt_tenCaLam);

		JLabel lblNewLabel_18 = new JLabel("Danh Sách Ca Làm ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_18.setBounds(319, 41, 166, 20);
		card5.add(lblNewLabel_18);

		cbo_ngayLam = new JComboBox();
		cbo_ngayLam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qlc.fildTableCaLam();
			}
		});
		cbo_ngayLam.setBounds(874, 40, 153, 21);
		card5.add(cbo_ngayLam);

		applyBottomBorder(txt_idKM);
		applyBottomBorder(txt_tenKM);
		applyBottomBorder(txt_dieuKienKM);

		cbo_tru = new JComboBox();
		cbo_tru.setModel(new DefaultComboBoxModel(new String[] { "10%", "20%", "15%", "30%" }));
		cbo_tru.setEditable(true);
		cbo_tru.setBounds(96, 108, 99, 21);
		panel_2.add(cbo_tru);
		btn_LamMoiKM.addActionListener(qlc);
		btn_themKM.addActionListener(qlc);
		btn_suaKM.addActionListener(qlc);
		btn_doiAnh.addActionListener(qlc);
		btn_themSP.addActionListener(qlc);
		btn_lamMoiSP.addActionListener(qlc);
		btn_suaKM.addActionListener(qlc);
		btn_suaSP().addActionListener(qlc);
		btn_Thoat.addActionListener(qlc);
		btn_moi.addActionListener(qlc);
		btn_themNV.addActionListener(qlc);
		btn_sua.addActionListener(qlc);
		qlc.fildTable();
		qlc.disPlayKhuyenMai(0);
		qlc.display(0);
		qlc.displaySanPham(0);
		cb_sapXep.addActionListener(qlc);
		qlc.loadNgay();
		qlc.fildTableNguyenLieu();
         qlc.setNamThangO();
qlc.thongKeDoanhThuThang();
qlc.thongKeDoanhThuBieuDo1();
	}

	public JLabel lbl_tenNV() {
		return lbl_ten;
	}

	public JLabel lbl_hinh() {
		return lbl_anhSP;
	}

	public JLabel lbl_chucVu() {
		return lbl_chucVu;
	}

	public JTable tbl_nhanVien() {
		return tbl_nhanVien;
	}

	public JTextField txt_id() {
		return txt_id;
	}

	public JTextField txt_ten() {
		return txt_ten;
	}

	public JRadioButton rdo_nam() {
		return rdo_Nam;
	}

	public JRadioButton rdo_nu() {
		return rdo_nu;
	}

	public JTextField txt_sdt() {
		return txt_sdt;
	}

	public JCheckBox cb_quanLy() {
		return cb_quanLy;
	}

	public JCheckBox cb_nhanVien() {
		return cb_nhanVien;
	}

	public JTextField txt_ngaySinh() {
		return txt_ngaySinh;
	}

	public JTextField txt_trangThai() {
		return txt_TrangThaI;
	}

	public JTextField txt_luongCB() {
		return txt_luongCb;
	}

	public JTextField txt_tim() {
		return txt_tim;
	}

	public JTextField txt_email() {
		return txt_email;
	}

	public JButton btn_them() {
		return btn_themNV;
	}

	public JButton btn_moi() {
		return btn_moi;
	}

	public JButton btn_doiAnh() {
		return btn_doiAnh;
	}

	public JButton btn_sua() {
		return btn_sua;
	}

	public JButton btn_themSP() {
		return btn_themSP;
	}

	public JButton btn_suaSp() {
		return btn_suaSP;
	}

	public JButton btn_LamMoiSP() {
		return btn_lamMoiSP;
	}

	public JButton btn_suaSP() {
		return btn_suaSP;
	}

	public JComboBox<String> cbo_sapXep() {
		return cb_sapXep;
	}

	public JTable tbl_SanPham() {
		return tbl_SanPham;
	}

	public JTable tbl_KhuyenMai() {
		return tbl_KhuyenMai;
	}

	public JTextField txt_idSP() {
		return txt_idSP;
	}

	public JTextField txt_tenSP() {
		return txt_tenSP;
	}

	public JTextField txt_gia() {
		return txt_giaSp;
	}

	public JComboBox<String> cbo_TrangThaiSP() {
		return cbo_trangThaiSP;
	}

	public JComboBox<String> cbo_ngayLam() {
		return cbo_ngayLam;
	}

	public JTable tbl_kho() {
		return tbl_kho;
	}

	public JTable tbl_caLam() {
		return tbl_CaLam;
	}

	public JTable tblXepCa() {
		return tbl_xepCa;
	}

	// ca lamm
	public JTextField txt_idCaLam() {
		return txt_idCaLam;
	}

	public JTextField txt_tenCaLam() {
		return txt_tenCaLam;
	}

	public JComboBox<String> cbo_batDau() {
		return cbo_batDau;
	}

	public JComboBox<String> cbo_ngay() {
		return cbo_ngayLam;
	}

	// khuyen Mai
	public JButton btn_LamMoiKM() {
		return btn_LamMoiKM;
	}

	public JButton btn_themKM() {
		return btn_themKM;
	}

	public JButton btn_suaKM() {
		return btn_suaKM;
	}

	public JTextField txt_idKM() {
		return txt_idKM;
	}

	public JTextField txt_tenKM() {
		return txt_tenKM;
	}

	public JTextField txt_dieuKienKM() {
		return txt_dieuKienKM;
	}

	public JComboBox<String> cbo_tru() {
		return cbo_tru;
	}

	// xuat kho
	public JTextField txt_idNguyenLieuXuat() {
		return txt_idNLXuat;
	}

	public JTextField txt_tenNLXuat() {
		return txt_tenNLXuat;
	}

	public JTextField txt_soLuongTonXuat() {
		return txt_soLuongTonXuat;
	}

	public JTextField txt_soLuongLayXuat() {
		return txt_soLuongLayXuat;
	}

	public JTable tbl_DSNguyenLieuXuat() {
		return tbl_DSNguyenLieuXuat;
	}

	// form thong ke



public JLabel lbl_tongDoanhThuThang() {
		
		return lbl_tongDoanhThuThang;
	}

public JLabel lbl_doanhThuTien() {
		
		return lbl_doanhThuTien;
	}

public JLabel lbl_tongDonHangThang() {
	
	return lbl_tongDonHangThang;
}
public JLabel lbl_tongSODon() {
	
	return lbl_soDonHangThang;
}
	public JComboBox<String> cbo_namTK() {
		return cbo_namTk;
	}
	public JComboBox<String> cbo_thangTK() {
		return cbo_thangTK;
	}
	public DefaultCategoryDataset dataset() {
		return dataset;
	}
	private void applyBottomBorder(JTextField textField) {
		Border border = textField.getBorder();
		Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK); // Màu đen, độ dày là 1 pixel
		textField.setBorder(BorderFactory.createCompoundBorder(border, bottomBorder));
	}
}

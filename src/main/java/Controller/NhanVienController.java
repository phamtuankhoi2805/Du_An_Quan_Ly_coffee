package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import DAO.SanPhamDAO;
import Model.SanPhamModel;
import View.NhanVienView;
import View.TestSP;

public class NhanVienController implements ActionListener {

	private NhanVienView nvv;
	private SanPhamModel spm;

	public NhanVienController(NhanVienView nvv, SanPhamModel spm) {

		this.nvv = nvv;
		this.spm = spm;
	}

	public NhanVienController() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút " + src);

		// thay đổi Login cho các phương thức
		if (src.equals("ALL")) {
			ArrayList<SanPhamModel> ListSP = SanPhamDAO.getInstance().selectAll();
			addSanPhamToPanel(ListSP);
		} else if (src.equals("Tăng Lực")) {
			ArrayList<SanPhamModel> ListSP = SanPhamDAO.getInstance().selectByCondition("LoaiSP = N'" + src + "'");
			addSanPhamToPanel(ListSP);

		} else if (src.equals("Coffee")) {
			ArrayList<SanPhamModel> ListSP = SanPhamDAO.getInstance().selectByCondition("LoaiSP = N'" + src + "'");
			addSanPhamToPanel(ListSP);

		} else if (src.equals("Nước Trái Cây")) {
			ArrayList<SanPhamModel> ListSP = SanPhamDAO.getInstance().selectByCondition("LoaiSP = N'" + src + "'");
			addSanPhamToPanel(ListSP);

		}
	}

	public void addSanPhamToPanel(ArrayList<SanPhamModel> listSP) {
		nvv.panel_DSSP().removeAll(); // Xóa các panel cũ trên panel chứa

		for (SanPhamModel sp : listSP) {
			JPanel panel_SP = createSanPhamPanel(sp);
			nvv.panel_DSSP().add(panel_SP); // Thêm panel mới vào panel chứa
		}

		nvv.panel_DSSP().revalidate(); // Cập nhật giao diện người dùng
		nvv.panel_DSSP().repaint();
	}

	public JPanel createSanPhamPanel(SanPhamModel sp) {
		JPanel panel_SP = new JPanel();
		panel_SP.setPreferredSize(new Dimension(276, 94));
		panel_SP.setLayout(null);
		panel_SP.setBorder(createGrayBorder());

		JLabel lb_anhSP1 = new JLabel("");
		lb_anhSP1.setBounds(10, 11, 56, 72);
		panel_SP.add(lb_anhSP1);

		// Ảnh
		setScaledImage(lb_anhSP1, sp.getHinh());

		JLabel lbl_tenSP1 = new JLabel(sp.getTenSP());
		lbl_tenSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_tenSP1.setBounds(76, 10, 190, 22);
		panel_SP.add(lbl_tenSP1);

		JLabel lbl_giaSP1 = new JLabel(String.valueOf(sp.getGiaBan()));
		lbl_giaSP1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_giaSP1.setBounds(76, 61, 66, 22);
		panel_SP.add(lbl_giaSP1);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setBounds(236, 63, 30, 20);
		panel_SP.add(spinner);

		panel_SP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Xử lý sự kiện khi nhấp chuột vào sản phẩm
				handleSanPhamClick(sp, spinner);
			}

		});

		return panel_SP;
	}

	public void handleSanPhamClick(SanPhamModel sp, JSpinner spinner) {
		// Xử lý sự kiện khi nhấp chuột vào sản phẩm
		System.out.println("Tên sản phẩm: " + sp.getTenSP());
		System.out.println("Giá: " + sp.getGiaBan());
		int spinnerValue = (int) spinner.getValue();
		System.out.println("Giá trị của Spinner: " + spinnerValue);
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

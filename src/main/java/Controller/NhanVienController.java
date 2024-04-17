package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import com.graphbuilder.math.DivNode;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.HoaDonDAO;
import DAO.KhuyenMaiDAO;
import DAO.SanPhamDAO;
import Model.DonHangChiTietModel;
import Model.DonHangModel;
import Model.HoaDonModel;
import Model.KhuyenMaiModel;
import Model.SanPhamHDModel;
import Model.SanPhamModel;
import View.NhanVienView;
import View.TestSP;

public class NhanVienController implements ActionListener {

	private NhanVienView nvv;
	private SanPhamModel spm;
	ArrayList<SanPhamHDModel> listSPHD = new ArrayList<SanPhamHDModel>();
	private double khuyenMaii = 0.0;
	private String idKM;

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

		} else if (src.equals("Thanh Toán")) {

	        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn in hóa đon?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	        
	        if (option == JOptionPane.YES_OPTION) {
	 
	        	ThanhToan();
	        } else if (option == JOptionPane.NO_OPTION) {
	        	ThanhToan();
	        }
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

		panel_SP.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				handleSanPhamClick(sp);
			}

		});

		return panel_SP;
	}

	public void handleSanPhamClick(SanPhamModel sp) {
		String tenSP = sp.getTenSP();
		String idSP = sp.getIdSanPham();
		double giaBan = sp.getGiaBan();
		String hinh = sp.getHinh();
		String loaiSP = sp.getLoaiSP();
		int soLuong = 1;
		SanPhamHDModel spmoi = new SanPhamHDModel(idSP, tenSP, giaBan, soLuong, hinh, loaiSP);

		// Kiểm tra xem sản phẩm đã có Id trong danh sách hay chưa
		boolean isExisting = false;
		for (SanPhamHDModel existingSP : listSPHD) {
			if (existingSP.getIdSanPham().equals(idSP)) {
				isExisting = true;
				break;
			}
		}

		if (!isExisting) {
			listSPHD.add(spmoi);
//			System.out.println(listSPHD.toString());
			String totalPrice = calculateTotalPrice(listSPHD);
			nvv.lbl_tongCong().setText(totalPrice + " VND");

			double tongCong = Double.parseDouble(totalPrice);
			setKhuyenMai(totalPrice);
			nvv.lbl_tongTien().setText(Double.toString(tongCong - khuyenMaii) + "00 VND");
			loadProductsToScrollPane(listSPHD);
			

		} else {
			JOptionPane.showMessageDialog(nvv, "sản phẩm đã tồn tại trong danh sách");
		}
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

	public void loadProductsToScrollPane(ArrayList<SanPhamHDModel> ListSPHD) {
		nvv.panelcon().removeAll();
		for (SanPhamHDModel sp : ListSPHD) {
			JPanel panel_SP = new JPanel();
			panel_SP.setLayout(null);
			panel_SP.setBorder(createGrayBorder());
			panel_SP.setPreferredSize(new Dimension(380, 84));
			nvv.panelcon().add(panel_SP);

			JLabel lb_anhSP = new JLabel("");
			lb_anhSP.setBounds(10, 11, 56, 72);
			panel_SP.add(lb_anhSP);
			setScaledImage(lb_anhSP, sp.getHinh());

			JLabel lbl_tenSP = new JLabel(sp.getTenSP());
			lbl_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbl_tenSP.setBounds(75, 11, 190, 22);
			panel_SP.add(lbl_tenSP);

			JLabel lbl_giaSP = new JLabel(String.valueOf(sp.getGiaBan()));
			lbl_giaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbl_giaSP.setBounds(76, 61, 66, 22);
			panel_SP.add(lbl_giaSP);

			JLabel lbl_soLuong = new JLabel("Số Lượng: ");
			lbl_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbl_soLuong.setBounds(170, 61, 100, 20);
			panel_SP.add(lbl_soLuong);

			SpinnerNumberModel spinnerModel = new SpinnerNumberModel(sp.getSoLuong(), 1, 100, 1);
			JSpinner spinner = new JSpinner(spinnerModel);
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spinner.setBounds(250, 58, 60, 26);
			panel_SP.add(spinner);
			spinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					JSpinner source = (JSpinner) e.getSource();
					SpinnerModel spinnerModel = source.getModel();
					int quantity = (int) spinnerModel.getValue();

					sp.setSoLuong(quantity);

					String totalPrice = calculateTotalPrice(ListSPHD);
					double tongCong = Double.parseDouble(totalPrice);

					setKhuyenMai(totalPrice);
					nvv.lbl_tongCong().setText(totalPrice + " VND");

					nvv.lbl_tongTien().setText(Double.toString(tongCong - khuyenMaii) + "00 VND");
                
					if (khuyenMaii == 0.0) {
						nvv.lbl_khuyenMai().setText("0 VND");
					} else {
						String t = Double.toString(khuyenMaii) + "00";
						nvv.lbl_khuyenMai().setText(t + " VND");
					}

					loadProductsToScrollPane(ListSPHD);
				}
			});

			JButton btn_xoaSP = new JButton("");
			btn_xoaSP.setBackground(new Color(255, 255, 255));
			btn_xoaSP.setIcon(new ImageIcon("C:\\javvaa\\DuAn1.2\\src\\main\\resources\\View\\ThungRac.png"));
			btn_xoaSP.setBounds(330, 52, 46, 33);
			panel_SP.add(btn_xoaSP);

			btn_xoaSP.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel parentPanel = (JPanel) btn_xoaSP.getParent();
					int index = nvv.panelcon().getComponentZOrder(parentPanel);
					ListSPHD.remove(index);

					if (ListSPHD.isEmpty()) {
						khuyenMaii = 0;
						nvv.lbl_khuyenMai().setText("0 VND");
					}

					String totalPrice = calculateTotalPrice(ListSPHD);
					double tongCong = Double.parseDouble(totalPrice);

					setKhuyenMai(totalPrice);
					nvv.lbl_tongCong().setText(totalPrice + " VND");

					nvv.lbl_tongTien().setText(Double.toString(tongCong - khuyenMaii) + "00 VND");

					if (khuyenMaii == 0.0) {
						nvv.lbl_khuyenMai().setText("0 VND");
					} else {
						String t = Double.toString(khuyenMaii) + "00";
						nvv.lbl_khuyenMai().setText(t + " VND");
					}

					loadProductsToScrollPane(ListSPHD);
				}
			});

			nvv.panelcon().add(panel_SP);
		}

		nvv.panelcon().revalidate();
		nvv.panelcon().repaint();
		nvv.JScrollPane().setViewportView(nvv.panelcon());
	}



	public String calculateTotalPrice(ArrayList<SanPhamHDModel> listDSHD) {
		double totalPrice = 0.0;

		for (SanPhamHDModel sp : listDSHD) {
			int quantity = sp.getSoLuong();
			double price = sp.getGiaBan();
			totalPrice += quantity * price;
		}

		long roundedTotalPrice = Math.round(totalPrice);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String formattedTotalPrice = decimalFormat.format(roundedTotalPrice);

		return formattedTotalPrice;
	}

	public void setKhuyenMai(String gia) {
		ArrayList<KhuyenMaiModel> listKM = KhuyenMaiDAO.getInstance().selectAll();
		double giaCanTru = Double.parseDouble(gia);
//        System.out.println(listKM.toString());
		double closestPrice = findClosestPrice(listKM, giaCanTru);
		boolean khuyenMaiUpdated = false;

		for (KhuyenMaiModel kmm : listKM) {
			String input = kmm.getDieuKienKM();
			String regex = "\\d+(\\.\\d+)?";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			while (matcher.find()) {
				String numberString = matcher.group();
				double number = Double.parseDouble(numberString);
				if (number == closestPrice) {
					double km = Math.floor(giaCanTru * kmm.getTongTru());
					khuyenMaii = km;

					String t = Double.toString(km) + "00";
					nvv.lbl_khuyenMai().setText(t + " VND");

					khuyenMaiUpdated = true;
					idKM = kmm.getIdKhuyenMai();
				}
			}
		}

		if (!khuyenMaiUpdated) {
			khuyenMaii = 0.0;
			nvv.lbl_khuyenMai().setText("0 VND");
		}
	}

	private String formatCurrency(double amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		return decimalFormat.format(amount);
	}

	private double findClosestPrice(ArrayList<KhuyenMaiModel> list, double targetPrice) {
		double closestPrice = Double.MAX_VALUE;
		double minDifference = Double.MAX_VALUE;

		for (KhuyenMaiModel kmm : list) {
			double price = extractNumber(kmm.getDieuKienKM());
			double difference = Math.abs(targetPrice - price);
			if (difference < minDifference) {
				closestPrice = price;
				minDifference = difference;
			}
		}

		return closestPrice;
	}

	private double extractNumber(String input) {
		String numberString = input.replaceAll("[^\\d.]", "");
		return Double.parseDouble(numberString);
	}

	public void ThanhToan() {
	    // insert Donhang
	    ArrayList<DonHangModel> listDH = DonHangDAO.getInstance().selectAll();
	    ArrayList<HoaDonModel> listHD = HoaDonDAO.getInstance().selectAll();
	    String idNhanVien = nvv.lbl_IDNhanVien().getText();
	    String IDDh = Integer.toString((listDH.size() + 1));
	    String IdDonHang = "DH" + IDDh;
	    long millis = System.currentTimeMillis();
	    Date ngayHienTai = new Date(millis);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String ngayThangNamString = formatter.format(ngayHienTai);
	    Date ngayMua = Date.valueOf(ngayThangNamString);
	    DonHangModel dh = new DonHangModel(IdDonHang, ngayMua, idNhanVien);
	    DonHangDAO.getInstance().insert(dh);
	    
	    // insert HoaDon Rỗng
	    String IDHD = Integer.toString(listHD.size()+1);
	    String IDHoaDon = "HD"+IDHD;
	    HoaDonModel hd = new HoaDonModel(IDHoaDon, 0, ngayMua, null);
	    HoaDonDAO.getInstance().insert(hd);
	    
	    // insert table chitietDonHang
	    for (SanPhamHDModel sphd : listSPHD) {
	        String idSP = sphd.getIdSanPham();
	        int soLuongMua = sphd.getSoLuong();
	        DonHangChiTietModel dhct = new DonHangChiTietModel(idSP, IdDonHang, soLuongMua, IDHoaDon);
	        // Thêm dhct vào cơ sở dữ liệu
	        ChiTietDonHangDAO.getInstance().insert(dhct);
	    }
	    
	    // update bảng HoaDon
	    String chuoi = nvv.lbl_tongTien().getText();
	    String[] parts = chuoi.split(" ");
	    String tong = parts[0].replaceAll("[^0-9]", "");
	    int tongTien = Integer.parseInt(tong);
	    HoaDonModel hdupdate = new HoaDonModel(IDHoaDon, tongTien, ngayMua, idKM);
	    HoaDonDAO.getInstance().update(hdupdate);
	    
	    // In bill
	    // Tạo tệp Word mới
      taoBill(listSPHD);
	}
	public void taoBill(ArrayList<SanPhamHDModel> listSPHD) {
	    // In bill
	    // Tạo tệp Word mới
	    XWPFDocument document = new XWPFDocument();
	    // Thêm tiêu đề "Hóa Đơn Bán Lẻ"
	    XWPFParagraph title = document.createParagraph();
	    title.setAlignment(ParagraphAlignment.CENTER);
	    XWPFRun titleRun = title.createRun();
	    titleRun.setText("Hóa Đơn Bán Lẻ");
	    titleRun.setBold(true);
	    titleRun.setFontSize(16);
	    titleRun.addBreak();
	    // Tạo đối tượng bảng
	    XWPFTable table = document.createTable();

	    // Thiết lập thông tin định dạng bảng
	    CTTblPr tblPr = table.getCTTbl().getTblPr();
	    tblPr.addNewTblW().setW(BigInteger.valueOf(8000)); // Định dạng chiều rộng bảng
	    tblPr.getTblW().setType(STTblWidth.PCT);
	    tblPr.getTblW().setW(BigInteger.valueOf(100));

	

	    // Thiết lập thông tin định dạng tiêu đề hàng đầu
	    XWPFTableRow titleRow = table.getRow(0);
	    titleRow.getCell(0).setText("Tên sản phẩm");
	    titleRow.addNewTableCell().setText("Đơn giá");
	    titleRow.addNewTableCell().setText("Số lượng");
	    titleRow.addNewTableCell().setText("Tổng cộng");
	    titleRow.addNewTableCell().setText("Khuyến mãi");
	    titleRow.addNewTableCell().setText("Tổng Tiền");

	    // Thiết lập thông tin định dạng tiêu đề hàng đầu
	    for (int i = 0; i < titleRow.getTableCells().size(); i++) {
	        XWPFTableCell cell = titleRow.getCell(i);
	        CTTcPr tcpr = cell.getCTTc().addNewTcPr();
	        CTTcBorders borders = tcpr.addNewTcBorders();
	        borders.addNewTop().setVal(STBorder.SINGLE);
	        borders.addNewBottom().setVal(STBorder.SINGLE);
	        borders.addNewLeft().setVal(STBorder.SINGLE);
	        borders.addNewRight().setVal(STBorder.SINGLE);
	        cell.setColor("B0C4DE"); // Màu nền tiêu đề
	        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER); // Căn giữa theo chiều dọc
	        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER); // Căn giữa theo chiều ngang
	        XWPFParagraph paragraph = cell.getParagraphs().get(0);
	        paragraph.setAlignment(ParagraphAlignment.CENTER); // Căn giữa theo chiều ngang
	        XWPFRun run = paragraph.createRun();
	        run.setBold(true); // Chữ in đậm
	    }

	    // Thêm dữ liệu từ danh sách listSPHD vào bảng
	    for (SanPhamHDModel sp : listSPHD) {
	        String tenSanPham = sp.getTenSP();
	        double donGia = sp.getGiaBan();
	        int soLuong = sp.getSoLuong();

	        // Tạo hàng dữ liệu
	        XWPFTableRow dataRow = table.createRow();
	        dataRow.getCell(0).setText(tenSanPham);
	        dataRow.getCell(1).setText(Double.toString(donGia));
	        dataRow.getCell(2).setText(Integer.toString(soLuong));
	    }

	    // Tạo hàng dữ liệu cho tổng cộng, khuyến mãi và tổng tiền
	    XWPFTableRow summaryRow = table.createRow();
	    summaryRow.getCell(3).setText(nvv.lbl_tongCong().getText());
	    summaryRow.getCell(4).setText(nvv.lbl_khuyenMai().getText());
	    summaryRow.getCell(5).setText(nvv.lbl_tongTien().getText());

	    // Lưu tệp Word
	    try (FileOutputStream out = new FileOutputStream("Bill.docX")) {
	        document.write(out);
	        System.out.println("Hóa đơn đã được lưu thành công vào tệp Bill.docx");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

public void reset() {
	listSPHD.clear();
	loadProductsToScrollPane(listSPHD);
	nvv.lbl_tongCong().setText("0 VND");
	nvv.lbl_khuyenMai().setText("0 VND");
	nvv.lbl_tongTien().setText("0 VND");
   khuyenMaii = 0.0;
   idKM =null;
}

}

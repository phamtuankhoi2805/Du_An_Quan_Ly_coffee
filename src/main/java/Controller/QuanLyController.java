package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import DAO.CaLamViecDao;
import DAO.KhuyenMaiDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DAO.TableNhapDAO;
import Model.CaLamViecModel;
import Model.KhuyenMaiModel;
import Model.NhanVienModel;
import Model.SanPhamModel;
import Model.tableNhapModel;
import View.QuanLyView;
import View.ThemChiTietView;

import java.util.Collections;
import java.util.Comparator;

public class QuanLyController implements ActionListener {
	private QuanLyView qlv;
	private static String tenNV;
	ArrayList<NhanVienModel> listNV = NhanVienDAO.getInstance().selectAll();
	ArrayList<SanPhamModel> listSP = SanPhamDAO.getInstance().selectAll();

	int i;
	int a;
//       ArrayList<CaLamViecModel> listCa =  CaLamViecDao.getInstance().selectByCondition((String) qlv.cbo_ngayLam().getSelectedItem());

	public QuanLyController(QuanLyView qlv) {

		this.qlv = qlv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút " + src);

		// thay đổi Login cho các phương thức
		if (src.equals("Thoát")) {
			qlv.setVisible(false);
			System.exit(0);
		} else if (src.equals("Mới")) {
			moi();

		} else if (src.equals("Thêm")) {
			them();

		} else if (src.equals("Sửa")) {
			sua();

		} else if (src.equals("comboBoxChanged")) {
			sapXep();

		} else if (src.equals("Làm Mới")) {
			lamMoiSanPham();

		} else if (src.equals("Đổi Ảnh")) {
			chooseImage();

		} else if (src.equals("Thêm SP")) {
			themSP();
			JOptionPane.showMessageDialog(qlv, "Mời Bạn Thêm Nguyên Liệu Sản Phẩm");
		} else if (src.equals("Sửa SP")) {
			suaSP();
		} else if (src.equals("Đặt Hàng")) {

			createWordTemplate();
		} else if (src.equals("Thêm SP Đặt Hàng")) {
			ThemChiTietView tctv = new ThemChiTietView();
			tctv.setVisible(true);
		} else if (src.equals("Thêm Ca Làm")) {
			themCalam();
		}
		 else if (src.equals("Làm Mới KM")) {
				lamMoiKM();
			}
		 else if (src.equals("Thêm KM")) {
				themKM();
			}
		 else if (src.equals("Sửa KM")) {
				suaKM();
			}

	}

	public void fildTable() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_nhanVien().getModel();
		model.setRowCount(0); // làm sạch dòng
		ArrayList<NhanVienModel> listNV = NhanVienDAO.getInstance().selectAll();
		String gioiTinh = "";
		for (NhanVienModel nv : listNV) {

			if (nv.isGioiTinh() == true) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			Object[] rowData = { nv.getIdNhanVien(), nv.getTenNV(), nv.getNgaySinh(), gioiTinh, nv.getSoDienThoai(),
					nv.getEmail(), nv.getChucVu(), nv.getTrangThai(), nv.getLuongCB() };
			model.addRow(rowData);

		}

	}

	public void fildTableQLSanPham() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_SanPham().getModel();
		model.setRowCount(0); // làm sạch dòng
		ArrayList<SanPhamModel> listSP = SanPhamDAO.getInstance().selectAll();

		for (SanPhamModel sp : listSP) {

			Object[] rowData = { sp.getIdSanPham(), sp.getTenSP(), sp.getGiaBan(), sp.getTrangThai() };
			model.addRow(rowData);

		}

	}

	public void displaySanPham(int i) {
		SanPhamModel sp = listSP.get(i);
		qlv.txt_idSP().setText(sp.getIdSanPham());
		qlv.txt_tenSP().setText(sp.getTenSP());
		qlv.txt_gia().setText(Double.toString(sp.getGiaBan()));
		qlv.cbo_TrangThaiSP().setSelectedItem(sp.getTrangThai());
		hienHinhSanPham(sp.getHinh());
	}

	public void hienHinhSanPham(String path) {
		ImageIcon icon = new ImageIcon("" + path);
		Image image = icon.getImage();
		int labelWidth = qlv.lbl_hinh().getWidth();
		int labelHeight = qlv.lbl_hinh().getHeight();
		Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		qlv.lbl_hinh().setIcon(resizedIcon);
	}

	public void display(int i) {
		NhanVienModel nv = listNV.get(i);
		qlv.txt_id().setText(nv.getIdNhanVien());
		qlv.txt_ten().setText(nv.getTenNV());
		Date ngaySinh = nv.getNgaySinh(); // Thay nv.getNgaySinh() bằng đối tượng Date của bạn

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinhString = sdf.format(ngaySinh);
		qlv.txt_ngaySinh().setText(ngaySinhString);

		if (nv.isGioiTinh() == true) {
			qlv.rdo_nam().setSelected(true);
		} else if (nv.isGioiTinh() == false) {
			qlv.rdo_nu().setSelected(true);
		}
		qlv.txt_sdt().setText(nv.getSoDienThoai());
		qlv.txt_email().setText(nv.getEmail());

		if (nv.getChucVu().equals("Quản lý")) {
			qlv.cb_quanLy().setSelected(true);
		} else if (nv.getChucVu().equals("Nhân viên")) {
			qlv.cb_nhanVien().setSelected(true);
		}
		qlv.txt_trangThai().setText(nv.getTrangThai());
		qlv.txt_luongCB().setText(Double.toString(nv.getLuongCB()));
	}

	public void fillcontroll() {
		try {

			i = qlv.tbl_nhanVien().getSelectedRow();

			display(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void fillcontrollSanPham() {
		try {

			i = qlv.tbl_SanPham().getSelectedRow();

			displaySanPham(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void moi() {
		qlv.txt_id().setEditable(true);
		qlv.txt_id().setText("");
		qlv.txt_ten().setText("");
		qlv.txt_ngaySinh().setText("");
		qlv.txt_sdt().setText("");
		qlv.txt_email().setText("");
		qlv.txt_trangThai().setText("");
		qlv.txt_luongCB().setText("");
		qlv.btn_them().setEnabled(true);
		qlv.btn_sua().setEnabled(false);

	}

	public void them() {
		try {
			String idNhanVien = qlv.txt_id().getText();
			String matKhau = generateRandomPassword(10);
			String tenNV = qlv.txt_ten().getText();
			String ngaySinhText = qlv.txt_ngaySinh().getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date ngaySinhUtil = dateFormat.parse(ngaySinhText);

			// Chuyển đổi java.util.Date thành java.sql.Date
			java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());
			boolean gioiTinh = false;
			if (qlv.rdo_nam().isSelected() == true) {
				gioiTinh = true;
			} else if (qlv.rdo_nu().isSelected() == true) {
				gioiTinh = false;
			}
			String SDT = qlv.txt_sdt().getText();
			String email = qlv.txt_email().getText();
			String chucVu = "";
			if (qlv.cb_quanLy().isSelected() == true) {
				chucVu = "Quản lý";
			} else if (qlv.cb_nhanVien().isSelected() == true) {
				chucVu = "Nhân viên";
			}
			String trangThai = qlv.txt_trangThai().getText();
			double luongCB = Double.parseDouble(qlv.txt_luongCB().getText());
			NhanVienModel nv = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinhSql, gioiTinh, SDT, email, chucVu,
					trangThai, luongCB, null);
			NhanVienDAO.getInstance().insert(nv);
			qlv.btn_them().setEnabled(false);
			qlv.btn_sua().setEnabled(true);
			qlv.txt_id().setEditable(false);
			fildTable();

			JOptionPane.showMessageDialog(qlv, "thêm Nhân viên thành công");

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(qlv, "thêm Nhân viên thất bại");
		}
	}

	private String generateRandomPassword(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
		Random random = new Random();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			password.append(characters.charAt(index));
		}

		return password.toString();
	}

	public void sua() {
		try {
			String idNhanVien = qlv.txt_id().getText();

			String tenNV = qlv.txt_ten().getText();
			String ngaySinhText = qlv.txt_ngaySinh().getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date ngaySinhUtil = dateFormat.parse(ngaySinhText);

			// Chuyển đổi java.util.Date thành java.sql.Date
			java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());
			boolean gioiTinh = false;
			if (qlv.rdo_nam().isSelected() == true) {
				gioiTinh = true;
			} else if (qlv.rdo_nu().isSelected() == true) {
				gioiTinh = false;
			}
			String SDT = qlv.txt_sdt().getText();
			String email = qlv.txt_email().getText();
			String chucVu = "";
			if (qlv.cb_quanLy().isSelected() == true) {
				chucVu = "Quản lý";
			} else if (qlv.cb_nhanVien().isSelected() == true) {
				chucVu = "Nhân viên";
			}
			String trangThai = qlv.txt_trangThai().getText();
			double luongCB = Double.parseDouble(qlv.txt_luongCB().getText());
			NhanVienModel nv = new NhanVienModel(idNhanVien, null, tenNV, ngaySinhSql, gioiTinh, SDT, email, chucVu,
					trangThai, luongCB, null);
			NhanVienDAO.getInstance().update(nv);
			fildTable();
			JOptionPane.showMessageDialog(qlv, "Sửa thông tin nhân viên thành công");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(qlv, "Sửa thông tin nhân viên thất bại");
		}
	}

	public void timKiem() {
		String tim = qlv.txt_tim().getText();
		NhanVienModel nvt = NhanVienDAO.getInstance().timkiem(tim);
		qlv.txt_id().setText(nvt.getIdNhanVien());
		qlv.txt_ten().setText(nvt.getTenNV());
		Date ngaySinh = nvt.getNgaySinh(); // Thay nv.getNgaySinh() bằng đối tượng Date của bạn

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinhString = sdf.format(ngaySinh);
		qlv.txt_ngaySinh().setText(ngaySinhString);

		if (nvt.isGioiTinh() == true) {
			qlv.rdo_nam().setSelected(true);
		} else if (nvt.isGioiTinh() == false) {
			qlv.rdo_nu().setSelected(true);
		}
		qlv.txt_sdt().setText(nvt.getSoDienThoai());
		qlv.txt_email().setText(nvt.getEmail());

		if (nvt.getChucVu().equals("Quản lý")) {
			qlv.cb_quanLy().setSelected(true);
		} else if (nvt.getChucVu().equals("Nhân viên")) {
			qlv.cb_nhanVien().setSelected(true);
		}
		qlv.txt_trangThai().setText(nvt.getTrangThai());
		qlv.txt_luongCB().setText(Double.toString(nvt.getLuongCB()));
	}

	public void timKiem1() {
		String timKiemText = qlv.txt_tim().getText(); // Lấy dữ liệu tìm kiếm từ trường nhập liệu
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_nhanVien().getModel();

		// Tạo một mẫu DefaultTableModel mới để cập nhật dữ liệu tìm kiếm
		DefaultTableModel searchModel = new DefaultTableModel();

		// Sao chép các cột từ model gốc sang model tìm kiếm
		for (int i = 0; i < model.getColumnCount(); i++) {
			searchModel.addColumn(model.getColumnName(i));
		}

		// Lặp qua danh sách nhân viên và tìm kiếm dựa trên từ khóa
		for (NhanVienModel nv : listNV) {
			// Kiểm tra xem thông tin nhân viên có chứa từ khóa tìm kiếm hay không
			if (nv.getIdNhanVien().contains(timKiemText) || nv.getTenNV().contains(timKiemText)
					|| nv.getSoDienThoai().contains(timKiemText) || nv.getEmail().contains(timKiemText)
					|| nv.getChucVu().contains(timKiemText) || nv.getTrangThai().contains(timKiemText)
					|| String.valueOf(nv.getLuongCB()).contains(timKiemText)) {

				// Kiểm tra giới tính và gán giá trị tương ứng
				String gioiTinh = "";
				if (nv.isGioiTinh()) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}

				// Tạo một mảng dữ liệu hàng mới chứa thông tin nhân viên tìm thấy
				Object[] rowData = { nv.getIdNhanVien(), nv.getTenNV(), nv.getNgaySinh(), gioiTinh, nv.getSoDienThoai(),
						nv.getEmail(), nv.getChucVu(), nv.getTrangThai(), nv.getLuongCB() };

				// Thêm hàng vào model tìm kiếm
				searchModel.addRow(rowData);
			}
		}

		// Cập nhật model của bảng nhân viên với model tìm kiếm
		qlv.tbl_nhanVien().setModel(searchModel);
	}

	public void sapXep() {
		String m = (String) qlv.cbo_sapXep().getSelectedItem();
		if (m.equals("Lương Cơ Bản Tăng Dần")) {
			sortByLuongTangDan(listNV);
			DefaultTableModel model = (DefaultTableModel) qlv.tbl_nhanVien().getModel();
			model.setRowCount(0); // làm sạch dòng
			String gioiTinh = "";
			for (NhanVienModel nv : listNV) {
				if (nv.isGioiTinh() == true) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}
				Object[] rowData = { nv.getIdNhanVien(), nv.getTenNV(), nv.getNgaySinh(), gioiTinh, nv.getSoDienThoai(),
						nv.getEmail(), nv.getChucVu(), nv.getTrangThai(), nv.getLuongCB() };
				model.addRow(rowData);

			}

		} else if (m.equals("Lương Cơ Bản Thấp Dần")) {
			sortByLuongGiamDan(listNV);
			DefaultTableModel model = (DefaultTableModel) qlv.tbl_nhanVien().getModel();
			model.setRowCount(0); // làm sạch dòng

			String gioiTinh = "";
			for (NhanVienModel nv : listNV) {
				if (nv.isGioiTinh() == true) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}
				Object[] rowData = { nv.getIdNhanVien(), nv.getTenNV(), nv.getNgaySinh(), gioiTinh, nv.getSoDienThoai(),
						nv.getEmail(), nv.getChucVu(), nv.getTrangThai(), nv.getLuongCB() };
				model.addRow(rowData);

			}

		}
	}

	public void sortByLuongTangDan(ArrayList<NhanVienModel> listNV) {
		Collections.sort(listNV, new Comparator<NhanVienModel>() {
			@Override
			public int compare(NhanVienModel nv1, NhanVienModel nv2) {
				if (nv1.getLuongCB() < nv2.getLuongCB()) {
					return -1;
				} else if (nv1.getLuongCB() > nv2.getLuongCB()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	public void sortByLuongGiamDan(ArrayList<NhanVienModel> listNV) {
		Collections.sort(listNV, new Comparator<NhanVienModel>() {
			@Override
			public int compare(NhanVienModel nv1, NhanVienModel nv2) {
				if (nv1.getLuongCB() > nv2.getLuongCB()) {
					return -1;
				} else if (nv1.getLuongCB() < nv2.getLuongCB()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
	}

	// Sản phẩm

	public void lamMoiSanPham() {
		qlv.btn_them().setEnabled(true);
		qlv.txt_idSP().setText("");
		qlv.txt_tenSP().setText("");
		qlv.txt_gia().setText("");
		qlv.lbl_hinh().setIcon(null);
		qlv.txt_idSP().setEditable(true);
		qlv.btn_themSP().setEnabled(true);
		qlv.btn_doiAnh().setEnabled(false);
		qlv.btn_suaSP().setEnabled(false);

	}

	public void themSP() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn ảnh");
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(imageFilter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			java.io.File selectedFile = fileChooser.getSelectedFile();
			try {
				String imagePath = selectedFile.getCanonicalPath();

				String idSanPham = qlv.txt_idSP().getText();
				String tenSP = qlv.txt_tenSP().getText();
				double giaBan = Double.parseDouble(qlv.txt_gia().getText());
				String hinh = imagePath;
				String TrangThai = (String) qlv.cbo_TrangThaiSP().getSelectedItem();
				SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, hinh, TrangThai);
				SanPhamDAO.getInstance().insert(sp);
				listSP = SanPhamDAO.getInstance().selectAll();
				displaySanPham(listSP.size() - 1);
				fildTableQLSanPham();
				qlv.btn_themSP().setEnabled(false);
				qlv.btn_doiAnh().setEnabled(true);
				qlv.btn_suaSP().setEnabled(true);

				JOptionPane.showMessageDialog(qlv, "Thêm thành công");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void suaSP() {
		try {
			String idSanPham = qlv.txt_idSP().getText();
			String tenSP = qlv.txt_tenSP().getText();
			double giaBan = Double.parseDouble(qlv.txt_gia().getText());
			String TrangThai = (String) qlv.cbo_TrangThaiSP().getSelectedItem();
			SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, null, TrangThai);
			SanPhamDAO.getInstance().updateNoImage(sp);
			fildTableQLSanPham();

			JOptionPane.showMessageDialog(qlv, "Sửa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chooseImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn ảnh");
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(imageFilter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			java.io.File selectedFile = fileChooser.getSelectedFile();
			try {
				String imagePath = selectedFile.getCanonicalPath();

				String idSanPham = qlv.txt_idSP().getText();
				String tenSP = qlv.txt_tenSP().getText();
				double giaBan = Double.parseDouble(qlv.txt_gia().getText());
				String hinh = imagePath;
				String TrangThai = (String) qlv.cbo_TrangThaiSP().getSelectedItem();
				SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, hinh, TrangThai);
				SanPhamDAO.getInstance().update(sp);
				listSP = SanPhamDAO.getInstance().selectAll();
				displaySanPham(i);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadNgay() {
		// Định dạng ngày tháng
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Ngày bắt đầu: 01/04/2024
		LocalDate startDate = LocalDate.of(2024, 4, 1);

		// Thêm ngày 01/04/2024 vào JComboBox
		qlv.cbo_ngayLam().addItem(startDate.format(formatter));

		// Thêm 7 ngày tiếp theo vào JComboBox
		for (int i = 1; i <= 7; i++) {
			LocalDate nextDate = startDate.plusDays(i);
			qlv.cbo_ngayLam().addItem(nextDate.format(formatter));
		}

	}
// Form Nhập Nguyên liệu -------------------------------------------------------------------------------------------

	public void fildTableNguyenLieu() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_kho().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng
		ArrayList<tableNhapModel> listSP = TableNhapDAO.getInstance().selectAll();

		for (tableNhapModel sp : listSP) {
			Object[] rowData = { sp.getIdNguyenLieu(), sp.getTenNguyenLieu(), sp.getSoLuongTon(), sp.getSoLuongNhap(),
					sp.getTenNhaCC(), sp.getSDT() };
			model.addRow(rowData);
		}

		// Thêm trình lắng nghe sự kiện cho bảng tbl_kho
		qlv.tbl_kho().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = qlv.tbl_kho().getSelectedRow();
				int selectedColumn = qlv.tbl_kho().getSelectedColumn();

				// Kiểm tra nếu người dùng nhấp chuột vào cột SoLuongNhap
				if (selectedColumn == 3) {
					String inputValue = JOptionPane.showInputDialog("Nhập giá trị SoLuongNhap mới:");

					// Kiểm tra nếu người dùng nhập giá trị
					if (inputValue != null && !inputValue.isEmpty()) {
						int newSoLuongNhap = Integer.parseInt(inputValue);

						// Cập nhật giá trị SoLuongNhap tại vị trí đã chọn
						model.setValueAt(newSoLuongNhap, selectedRow, selectedColumn);
					}
				}
			}
		});
	}

	public void createWordTemplate() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_kho().getModel();

		// Tạo tệp Word mới
		XWPFDocument document = new XWPFDocument();

		// Tạo một đoạn văn bản trong tài liệu Word
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.CENTER);

		// Tạo mẫu Word tùy chỉnh
		XWPFRun run = paragraph.createRun();
		run.setText("Báo Cáo Nhập Hàng");
		run.setBold(true);
		run.setFontSize(20);
		run.setColor("FF0000"); // Màu đỏ

		// Thêm ngày tháng hiện tại vào tài liệu Word
		XWPFParagraph dateParagraph = document.createParagraph();
		dateParagraph.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun dateRun = dateParagraph.createRun();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String currentDate = dateFormat.format(new Date(i));
		dateRun.setText("Ngày: " + currentDate);

		// Tạo một bảng trong tài liệu Word
		XWPFTable table = document.createTable();

		// Thêm tiêu đề cho bảng
		XWPFTableRow headerRow = table.getRow(0);
		headerRow.getCell(0).setText("ID Nguyên Liệu");
		headerRow.addNewTableCell().setText("Tên Nguyên Liệu");
		headerRow.addNewTableCell().setText("Số Lượng Nhập");
		headerRow.addNewTableCell().setText("Tên Nhà CC");
		headerRow.addNewTableCell().setText("Số Điện Thoại");

		for (int row = 0; row < model.getRowCount(); row++) {
			Object selectedSoLuongNhap = model.getValueAt(row, 3);
			if (selectedSoLuongNhap != null) {
				int soLuongNhap = Integer.parseInt(selectedSoLuongNhap.toString());
				if (soLuongNhap > 0) {
					Object idNguyenLieu = model.getValueAt(row, 0);
					Object tenNguyenLieu = model.getValueAt(row, 1);
					Object tenNhaCC = model.getValueAt(row, 4);
					Object sdt = model.getValueAt(row, 5);

					// Thêm dữ liệu vào bảng Word
					XWPFTableRow tableRow = table.createRow();
					tableRow.getCell(0).setText(idNguyenLieu.toString());
					tableRow.getCell(1).setText(tenNguyenLieu.toString());
					tableRow.getCell(2).setText(selectedSoLuongNhap.toString());
					tableRow.getCell(3).setText(tenNhaCC.toString());
					tableRow.getCell(4).setText(sdt.toString());
				}
			}
		}

		// Lưu tài liệu Word thành file
		try (FileOutputStream out = new FileOutputStream("data.docx")) {
			document.write(out);
			JOptionPane.showMessageDialog(qlv, "Tạo Thành Công Đơn Nhập Hàng");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// ca Làm Việc -------------------------------------------------------------------------------
	public void fildTableCaLam() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_caLam().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng

		ArrayList<CaLamViecModel> listCa = CaLamViecDao.getInstance()
				.selectByCondition((String) qlv.cbo_ngayLam().getSelectedItem());

		for (CaLamViecModel sp : listCa) {
			String idNhanVien = CaLamViecDao.getInstance().selectById(sp.getIdCaLam());
			Object[] rowData = { sp.getIdCaLam(), sp.getTenCaLam(), sp.getThoiGian(), sp.getNgay(), idNhanVien };
			model.addRow(rowData);

		}
	}

	public void fildTableXepCa(String idCaLamm) {
		DefaultTableModel model = (DefaultTableModel) qlv.tblXepCa().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng
		String condition = "IDCaLam <> '" + idCaLamm + "' OR IDCaLam IS NULL";
		ArrayList<NhanVienModel> listNVXepCa = NhanVienDAO.getInstance().selectByCondition(condition);

		for (NhanVienModel sp : listNVXepCa) {

			Object[] rowData = { sp.getIdNhanVien(), sp.getTenNV() };
			model.addRow(rowData);

		}
	}

	public void themCalam() {
		try {
			String idCaLamViec = qlv.txt_idCaLam().getText();
			String tenCaLam = qlv.txt_tenCaLam().getText();
			String ThoiGian = (String) qlv.cbo_batDau().getSelectedItem();
			String ngay = (String) qlv.cbo_ngay().getSelectedItem();
			CaLamViecModel clv = new CaLamViecModel(idCaLamViec, tenCaLam, ThoiGian, ngay);
			CaLamViecDao.getInstance().insert(clv);
			JOptionPane.showMessageDialog(qlv, "Thành Công");
			fildTableCaLam();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ca Làm
	public void fileTabelkhuyenMai() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_KhuyenMai().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng
		ArrayList<KhuyenMaiModel> listKM = KhuyenMaiDAO.getInstance().selectAll();

		for (KhuyenMaiModel sp : listKM) {
			double tongTru = sp.getTongTru();
			String tru = String.format("%.0f%%", tongTru * 100);
			Object[] rowData = { sp.getIdKhuyenMai(), sp.getTenKhuyenMai(), sp.getDieuKienKM(), tru };
			model.addRow(rowData);

		}

	}

	public void fillcontrollKhuyenMai() {
		try {

			a = qlv.tbl_KhuyenMai().getSelectedRow();

			disPlayKhuyenMai(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void disPlayKhuyenMai(int a) {
		ArrayList<KhuyenMaiModel> listKM = KhuyenMaiDAO.getInstance().selectAll();
		KhuyenMaiModel sp = listKM.get(a);
		qlv.txt_idKM().setText(sp.getIdKhuyenMai());
		qlv.txt_tenKM().setText(sp.getTenKhuyenMai());
		qlv.txt_dieuKienKM().setText(sp.getDieuKienKM());
		double tongTru = sp.getTongTru();
		String tru = String.format("%.0f%%", tongTru * 100);
		qlv.cbo_tru().setSelectedItem(tru);
	}

	public void lamMoiKM() {
	
		qlv.txt_idKM().setText("");
		qlv.txt_tenKM().setText("");
		qlv.txt_dieuKienKM().setText("");
		qlv.btn_themKM().setEnabled(true);
		qlv.txt_idKM().setEditable(true);
	
		qlv.btn_suaKM().setEnabled(false);

	}

	public void themKM() {
		try {
			String idKM = qlv.txt_idKM().getText();
			String tenKM = qlv.txt_tenKM().getText();
			String dieuKienKM = qlv.txt_dieuKienKM().getText();
			String selectedItem = qlv.cbo_tru().getSelectedItem().toString();
			int percentIndex = selectedItem.indexOf("%");
			String tachChuoi = selectedItem.substring(0, percentIndex);
			float t =  Float.parseFloat(tachChuoi);
			float tru  =  t/100;
			KhuyenMaiModel km = new KhuyenMaiModel(idKM, tenKM, dieuKienKM, tru);
			KhuyenMaiDAO.getInstance().insert(km);
			qlv.btn_themKM().setEnabled(false);
			qlv.txt_idKM().setEditable(false);
	
		
			fileTabelkhuyenMai();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void suaKM() {
		try {
			String idKM = qlv.txt_idKM().getText();
			String tenKM = qlv.txt_tenKM().getText();
			String dieuKienKM = qlv.txt_dieuKienKM().getText();
			String selectedItem = qlv.cbo_tru().getSelectedItem().toString();
			int percentIndex = selectedItem.indexOf("%");
			String tachChuoi = selectedItem.substring(0, percentIndex);
			float t =  Float.parseFloat(tachChuoi);
			float tru  =  t/100;
			KhuyenMaiModel km = new KhuyenMaiModel(idKM, tenKM, dieuKienKM, tru);
			KhuyenMaiDAO.getInstance().update(km);
			qlv.btn_themKM().setEnabled(false);
			fileTabelkhuyenMai();
			JOptionPane.showMessageDialog(qlv, "thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

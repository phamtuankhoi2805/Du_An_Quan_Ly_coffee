package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import DAO.CaLamViecDao;
import DAO.DoanhThuThangDAO;
import DAO.KhuyenMaiDAO;
import DAO.NguyenLieuDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DAO.PhieuGiaoHangChiTietDAO;
import DAO.PhieuGiaoHangDAO;
import DAO.SanPhamDAO;
import DAO.TableNhapDAO;
import Model.CaLamViecModel;
import Model.KhuyenMaiModel;
import Model.NguyenLieuModel;
import Model.NhaCungCapModel;
import Model.NhanVienModel;
import Model.PhieuGiaoHangChiTietModel;
import Model.PhieuGiaoHangModel;
import Model.RowData;
import Model.SanPhamModel;
import Model.ThongKeDoanhThuTheoThangModel;
import Model.TableNhapModel;
import View.QuanLyView;
import io.ous.jtoml.ParseException;

import java.util.Collections;
import java.util.Comparator;

public class QuanLyController implements ActionListener {
	private QuanLyView qlv;
	private static String tenNV;
	ArrayList<NhanVienModel> listNV = NhanVienDAO.getInstance().selectAll();
	ArrayList<SanPhamModel> listSP = SanPhamDAO.getInstance().selectAll();

	int i;
	int a;
	int b;
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

		} else if (src.equals("Sửa SP")) {
			suaSP();
		} else if (src.equals("Thêm Ca Làm")) {
			themCalam();
		} else if (src.equals("Làm Mới KM")) {
			lamMoiKM();
		} else if (src.equals("Thêm KM")) {
			themKM();
		} else if (src.equals("Sửa KM")) {
			suaKM();
		} else if (src.equals("Xuất")) {
			xuaHang();
		} else if (src.equals("Thêm SP Qua Excel")) {
			docExcel();
		}
	}

//  nhân viên
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

			Object[] rowData = { sp.getIdSanPham(), sp.getTenSP(), sp.getGiaBan(), sp.getLoaiSP() };
			model.addRow(rowData);

		}

	}

	public void displaySanPham(int i) {
	    SanPhamModel sp = listSP.get(i);
	    qlv.txt_idSP().setText(sp.getIdSanPham());
	    qlv.txt_tenSP().setText(sp.getTenSP());
	    qlv.txt_gia().setText(Double.toString(sp.getGiaBan()));
	    qlv.cbo_TrangThaiSP().setSelectedItem(sp.getLoaiSP());
	    hienHinhSanPham(sp.getHinh());
	}

	public void hienHinhSanPham(String path) {
	    String imagePath = "src/main/resources/" + path; // Đường dẫn tương đối
	    ImageIcon icon = new ImageIcon(imagePath);
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
	            String fileName = imagePath.substring(imagePath.lastIndexOf("\\") + 1);

	            String idSanPham = qlv.txt_idSP().getText();
	            String tenSP = qlv.txt_tenSP().getText();
	            double giaBan = Double.parseDouble(qlv.txt_gia().getText());
	            String hinh = fileName; 
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
// Form Nhập Nguyên liệu ------------------------------------------------------------------------------------------------------------------------------

	public void fildTableNguyenLieu() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_kho().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng
		ArrayList<TableNhapModel> listSP = TableNhapDAO.getInstance().selectAll();

		for (TableNhapModel sp : listSP) {
			Object[] rowData = { sp.getIdNguyenLieu(), sp.getTenNguyenLieu(), sp.getSoLuongTon(), sp.getTenNhaCC(),
					sp.getSDT() };
			model.addRow(rowData);
		}

	}

	public void docExcel() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			try {
				FileInputStream fis = new FileInputStream(new File(filePath));
				Workbook workbook = WorkbookFactory.create(fis);
				Sheet sheet = workbook.getSheetAt(0);
				DataFormatter dataFormatter = new DataFormatter();
				List<RowData> rowDataList = new ArrayList<>();

				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					Row row = sheet.getRow(rowIndex);
					RowData rowData = new RowData();

					Cell idNguyenLieuCell = row.getCell(0);
					rowData.setIdNguyenLieu(idNguyenLieuCell.toString());

					Cell tenNguyenLieuCell = row.getCell(1);
					rowData.setTenNguyenLieu(tenNguyenLieuCell.toString());

					Cell soLuongGiaoCell = row.getCell(2);
					rowData.setSoLuongGiao((int) soLuongGiaoCell.getNumericCellValue());

					Cell donGiaCell = row.getCell(3);
					rowData.setDonGia(donGiaCell.getNumericCellValue());

					Cell donViTinhCell = row.getCell(4);
					rowData.setDonViTinh(donViTinhCell.toString());

					Cell idNhaCCCell = row.getCell(5);
					rowData.setIdNhaCC(idNhaCCCell.toString());

					Cell tenNCCCell = row.getCell(6);
					rowData.setTenNCC(tenNCCCell.toString());

					Cell DiaChiCell = row.getCell(7);
					rowData.setDiaChi(DiaChiCell.toString());

					Cell sdtCell = row.getCell(8);
					if (sdtCell.getCellType() == CellType.NUMERIC) {
						rowData.setSdt(dataFormatter.formatCellValue(sdtCell));
					} else {
						rowData.setSdt(sdtCell.toString());
					}

					Cell ngayGiaoCell = row.getCell(9);
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					rowData.setNgayGiao(dateFormat.format(ngayGiaoCell.getDateCellValue()));

					Cell tongTienCell = row.getCell(10);
					rowData.setTongTien(tongTienCell.getNumericCellValue());

					rowDataList.add(rowData);
				}

				fis.close();
				workbook.close();
				ArrayList<NhaCungCapModel> ListNCC = NhaCungCapDAO.getInstance().selectAll();
				ArrayList<NguyenLieuModel> ListNL = NguyenLieuDAO.getInstance().selectAll();

				// Sử dụng danh sách rowDataList để truy cập dữ liệu theo hàng
				for (RowData rowData : rowDataList) {
					boolean kiemTraIDNCC = false;
					boolean kiemTraIDNguyenLieu = false;
					for (NguyenLieuModel NLM : ListNL) {

						if (NLM.getIdNguyenLieu().equals(rowData.getIdNguyenLieu()) == true) {
							kiemTraIDNguyenLieu = true;

							break;
						}
					}
					for (NhaCungCapModel NCC : ListNCC) {

						if (NCC.getIdNhaCC().equals(rowData.getIdNhaCC()) == true) {

							kiemTraIDNCC = true;

							break;
						}
					}
					if (kiemTraIDNCC == true && kiemTraIDNguyenLieu == true) {
						System.out.println("có cả 2");
						// insert Phiếu giao hàng
						String IDPhieuGiao = "PGH" + (ListNL.size() + 1);
						String ngayGiao = rowData.getNgayGiao();
						double tongTienGiaoHang = rowData.getTongTien();
						String idNCC = rowData.getIdNhaCC();
						PhieuGiaoHangModel PGH = new PhieuGiaoHangModel(IDPhieuGiao, ngayGiao, tongTienGiaoHang, idNCC);
						PhieuGiaoHangDAO.getInstance().insert(PGH);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert phiếu giao hàng chi tiết
						String idNguyenLieu = rowData.getIdNguyenLieu();
						int soLuongGiao = rowData.getSoLuongGiao();
						double donGiaNL = rowData.getDonGia();
						PhieuGiaoHangChiTietModel PGHCT = new PhieuGiaoHangChiTietModel(idNguyenLieu, IDPhieuGiao,soLuongGiao, donGiaNL);
						PhieuGiaoHangChiTietDAO.getInstance().insert(PGHCT);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						fildTableNguyenLieu();
					} else if (kiemTraIDNCC == false && kiemTraIDNguyenLieu == true) {
						// ínsert bản nhà cung cấp
						System.out.println("ko có Nhà cc");
						String idNhaCC = rowData.getIdNhaCC();
						String tenNhaCC = rowData.getTenNCC();
						String DiaChi = rowData.getDiaChi();
						String sdt = rowData.getSdt();
						NhaCungCapModel NCC = new NhaCungCapModel(idNhaCC, tenNhaCC, DiaChi, sdt);
						NhaCungCapDAO.getInstance().insert(NCC);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert nguyenlieu moi
						String IDNguyenLieu = "NL"+(ListNL.size()+1);
						String tenNguyenLieu = rowData.getTenNguyenLieu()+""+(ListNL.size()+1);
						String donViTinh = rowData.getDonViTinh();
						int soLuongGiao = rowData.getSoLuongGiao();
						NguyenLieuModel NguyenLieu = new NguyenLieuModel(IDNguyenLieu, tenNguyenLieu, 0, donViTinh);
						NguyenLieuDAO.getInstance().insert(NguyenLieu);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert Phiếu giao hàng
						String IDPhieuGiao = "PGH" + (ListNL.size() + 1);
						String ngayGiao = rowData.getNgayGiao();
						double tongTienGiaoHang = rowData.getTongTien();
						String idNCC = rowData.getIdNhaCC();
						PhieuGiaoHangModel PGH = new PhieuGiaoHangModel(IDPhieuGiao, ngayGiao, tongTienGiaoHang, idNCC);
						PhieuGiaoHangDAO.getInstance().insert(PGH);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert phiếu giao hàng chi tiết
						
					
						double donGiaNL = rowData.getDonGia();
						PhieuGiaoHangChiTietModel PGHCT = new PhieuGiaoHangChiTietModel(IDNguyenLieu, IDPhieuGiao,
								soLuongGiao, donGiaNL);
						PhieuGiaoHangChiTietDAO.getInstance().insert(PGHCT);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						fildTableNguyenLieu();
					} else if (kiemTraIDNCC == true && kiemTraIDNguyenLieu == false) {
						// insert bảng nguyenLieu
						System.out.println("ko có nguyen lieu");
						String IDNguyenLieu = rowData.getIdNguyenLieu();
						System.out.println(IDNguyenLieu);
						String tenNguyenLieu = rowData.getTenNguyenLieu();
						String donViTinh = rowData.getDonViTinh();
						int soLuongGiao = rowData.getSoLuongGiao();
						NguyenLieuModel NguyenLieu = new NguyenLieuModel(IDNguyenLieu, tenNguyenLieu, 0, donViTinh);
						NguyenLieuDAO.getInstance().insert(NguyenLieu);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert Phiếu giao hàng
						String IDPhieuGiao = "PGH" + (ListNL.size() + 1);
						String ngayGiao = rowData.getNgayGiao();
						double tongTienGiaoHang = rowData.getTongTien();
						String idNCC = rowData.getIdNhaCC();
						PhieuGiaoHangModel PGH = new PhieuGiaoHangModel(IDPhieuGiao, ngayGiao, tongTienGiaoHang, idNCC);
						PhieuGiaoHangDAO.getInstance().insert(PGH);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert phiếu giao hàng chi tiết
						String idNguyenLieu = rowData.getIdNguyenLieu();

						double donGiaNL = rowData.getDonGia();
						PhieuGiaoHangChiTietModel PGHCT = new PhieuGiaoHangChiTietModel(idNguyenLieu, IDPhieuGiao,
								soLuongGiao, donGiaNL);
						PhieuGiaoHangChiTietDAO.getInstance().insert(PGHCT);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						fildTableNguyenLieu();

					} else if (kiemTraIDNCC == false && kiemTraIDNguyenLieu == false) {
						// insert bảng nguyenLieu
						System.out.println("ko có cả 2");
						String IDNguyenLieu = rowData.getIdNguyenLieu();
						String tenNguyenLieu = rowData.getTenNguyenLieu();
						String donViTinh = rowData.getDonViTinh();
						int soLuongGiao = rowData.getSoLuongGiao();
						NguyenLieuModel NguyenLieu = new NguyenLieuModel(IDNguyenLieu, tenNguyenLieu, 0, donViTinh);
						NguyenLieuDAO.getInstance().insert(NguyenLieu);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// ínsert bản nhà cung cấp
						String idNhaCC = rowData.getIdNhaCC();
						String tenNhaCC = rowData.getTenNCC();
						String DiaChi = rowData.getDiaChi();
						String sdt = rowData.getSdt();
						NhaCungCapModel NCC = new NhaCungCapModel(idNhaCC, tenNhaCC, DiaChi, sdt);
						NhaCungCapDAO.getInstance().insert(NCC);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert Phiếu giao hàng
						
						String IDPhieuGiao = "PGH" + (ListNL.size() + 1);
						String ngayGiao = rowData.getNgayGiao();
						double tongTienGiaoHang = rowData.getTongTien();
						String idNCC = rowData.getIdNhaCC();
						PhieuGiaoHangModel PGH = new PhieuGiaoHangModel(IDPhieuGiao, ngayGiao, tongTienGiaoHang, idNCC);
						PhieuGiaoHangDAO.getInstance().insert(PGH);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						// insert phiếu giao hàng chi tiết
						String idNguyenLieu = rowData.getIdNguyenLieu();

						double donGiaNL = rowData.getDonGia();
						PhieuGiaoHangChiTietModel PGHCT = new PhieuGiaoHangChiTietModel(idNguyenLieu, IDPhieuGiao,
								soLuongGiao, donGiaNL);
						PhieuGiaoHangChiTietDAO.getInstance().insert(PGHCT);
						ListNL = NguyenLieuDAO.getInstance().selectAll();
						 ListNCC = NhaCungCapDAO.getInstance().selectAll();
						fildTableNguyenLieu();
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			float t = Float.parseFloat(tachChuoi);
			float tru = t / 100;
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
			float t = Float.parseFloat(tachChuoi);
			float tru = t / 100;
			KhuyenMaiModel km = new KhuyenMaiModel(idKM, tenKM, dieuKienKM, tru);
			KhuyenMaiDAO.getInstance().update(km);
			qlv.btn_themKM().setEnabled(false);
			fileTabelkhuyenMai();
			JOptionPane.showMessageDialog(qlv, "thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// from xuất kho
	// -------------------------------------------------------------------------------

	public void fileTabelDSXuat() {
		DefaultTableModel model = (DefaultTableModel) qlv.tbl_DSNguyenLieuXuat().getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng
		ArrayList<NguyenLieuModel> ListNL = NguyenLieuDAO.getInstance().selectAll();

		for (NguyenLieuModel sp : ListNL) {

			Object[] rowData = { sp.getIdNguyenLieu(), sp.getTenNguyenLieu(), sp.getSoLuongTon(), sp.getDonViTinh() };
			model.addRow(rowData);

		}

	}

	public void disPlayfromXuatHang(int b) {
		ArrayList<NguyenLieuModel> ListNL = NguyenLieuDAO.getInstance().selectAll();
		NguyenLieuModel sp = ListNL.get(b);
		qlv.txt_idNguyenLieuXuat().setText(sp.getIdNguyenLieu());
		qlv.txt_tenNLXuat().setText(sp.getTenNguyenLieu());
		qlv.txt_soLuongTonXuat().setText(Integer.toString(sp.getSoLuongTon()));

	}

	public void fillcontrollXuatKho() {
		try {

			b = qlv.tbl_DSNguyenLieuXuat().getSelectedRow();

			disPlayfromXuatHang(b);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void xuaHang() {
		try {
			String idNguyenLieuXuat = qlv.txt_idNguyenLieuXuat().getText();
			String tenNguyenLieuXuat = qlv.txt_tenNLXuat().getText();
			int SoLuongTon = Integer.parseInt(qlv.txt_soLuongTonXuat().getText());
			int soLuongLay = Integer.parseInt(qlv.txt_soLuongLayXuat().getText());
			int tru = SoLuongTon - soLuongLay;
			NguyenLieuModel nl = new NguyenLieuModel(idNguyenLieuXuat, tenNguyenLieuXuat, tru, null);
			NguyenLieuDAO.getInstance().updateSoLuongTon(nl);
			JOptionPane.showMessageDialog(qlv, "thành công");
			fileTabelDSXuat();
			disPlayfromXuatHang(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// from thống kê

	public void thongKeDoanhThuThang() {
		ArrayList<ThongKeDoanhThuTheoThangModel> listThang = DoanhThuThangDAO.getInstance().selectAll();
		String selectedMonth = (String) qlv.cbo_thangTK().getSelectedItem();
		String selectedYear = (String) qlv.cbo_namTK().getSelectedItem();

		for (ThongKeDoanhThuTheoThangModel dtm : listThang) {

			if (dtm.getThang().equals(selectedMonth) == true && dtm.getNam().equals(selectedYear) == true) {
				int doanhThuThangNam = dtm.getDoanhThu();
				qlv.lbl_tongDoanhThuThang().setText("Tổng Doanh Thu Tháng " + selectedMonth);
				qlv.lbl_doanhThuTien().setText(doanhThuThangNam + " VND");
				qlv.lbl_tongDonHangThang().setText("Tổng Số Đơn Hàng Tháng " + selectedMonth);
				qlv.lbl_tongSODon().setText(Integer.toString(dtm.getTongDon()));
			}
		}
	}

	public void thongKeDoanhThuThangBaoCao() {
		ArrayList<ThongKeDoanhThuTheoThangModel> listThang = DoanhThuThangDAO.getInstance().selectAll();
		String selectedMonth = (String) qlv.cbo_thangTK().getSelectedItem();
		String selectedYear = (String) qlv.cbo_namTK().getSelectedItem();

		for (ThongKeDoanhThuTheoThangModel dtm : listThang) {
			if (dtm.getThang().equals(selectedMonth) && dtm.getNam().equals(selectedYear)) {
				int doanhThuThangNam = dtm.getDoanhThu();
//	            qlv.lbl_tongDoanhThuThang().setText("Tổng Doanh Thu Tháng " + selectedMonth);
//	            qlv.lbl_doanhThuTien().setText(doanhThuThangNam + " VND");
//	            qlv.lbl_tongDonHangThang().setText("Tổng Số Đơn Hàng Tháng " + selectedMonth);
//	            qlv.lbl_tongSODon().setText(Integer.toString(dtm.getTongDon()));

				try {
					// Tạo tài liệu Word mới
					XWPFDocument document = new XWPFDocument();

					// Tạo tiêu đề
					XWPFParagraph title = document.createParagraph();
					XWPFRun titleRun = title.createRun();
					titleRun.setText("Báo cáo doanh thu tháng " + selectedMonth + " năm " + selectedYear);
					titleRun.setBold(true);
					titleRun.setFontSize(16);
					titleRun.addBreak();

					// Tạo nội dung báo cáo
					XWPFParagraph content = document.createParagraph();
					XWPFRun contentRun = content.createRun();
					contentRun.setText("Tổng doanh thu: " + doanhThuThangNam + " VND");
					contentRun.addBreak();
					contentRun.setText("Tổng số đơn hàng: " + dtm.getTongDon());
					contentRun.addBreak();

					// Lưu tệp Word
					String filePath = "BaoCaoDoanhThu.docx";
					FileOutputStream out = new FileOutputStream(filePath);
					document.write(out);
					out.close();
					document.close();

					JOptionPane.showMessageDialog(qlv, "Tạo Báo Cáo Thành Công");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(qlv, "không đủ dữ liệu để tạo báo cáo");
					e.printStackTrace();
				}
			}
		}
	}

	public void thongKeDoanhThuBieuDo1() {
		ArrayList<ThongKeDoanhThuTheoThangModel> listThang = DoanhThuThangDAO.getInstance().selectAll();
		String selectedMonth = (String) qlv.cbo_thangTK().getSelectedItem();
		String selectedYear = (String) qlv.cbo_namTK().getSelectedItem();
		boolean yearMatched = false;

		// Xóa tất cả các giá trị hiện có trong dataset
		qlv.dataset().clear();

		for (ThongKeDoanhThuTheoThangModel dtm : listThang) {
			if (dtm.getNam().equals(selectedYear)) {
				yearMatched = true;
				int doanhThuThangNam = dtm.getDoanhThu();
				qlv.dataset().addValue(doanhThuThangNam, "Doanh thu", dtm.getThang());
			}
		}

		if (!yearMatched) {
			System.out.println("không có");
		}

		// Cập nhật lại biểu đồ

	}

	public void setNamThangO() {
		YearMonth yearMonth = YearMonth.now();
		int currentYear = yearMonth.getYear();
		int currentMonth = yearMonth.getMonthValue();

		qlv.cbo_thangTK().setSelectedItem(Integer.toString(currentMonth));
		qlv.cbo_namTK().setSelectedItem(Integer.toString(currentYear));

	}

}
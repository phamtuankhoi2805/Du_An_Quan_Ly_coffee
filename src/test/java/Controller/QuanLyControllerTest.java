package Controller;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertThrows;

import java.sql.Date;

import javax.swing.JOptionPane;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DAO.NhanVienDAO;
import Model.NhanVienModel;
import View.QuanLyView;

public class QuanLyControllerTest {
	  private QuanLyView qlv;
	    private QuanLyController qlc;
	   @BeforeMethod
	    public void setup() {
	        qlv = new QuanLyView();
	        qlc = new QuanLyController(qlv);
	    }
	   //test thêm nhân viên dữ liệu hợp lệ 
	@Test
	public void testThemNhanVienThanhCong() {
		try {
			
			// Chuẩn bị dữ liệu đầu vào
			String idNhanVien = "NV0011";
			String tenNV = "Khôi Dzai";
			String ngaySinhText = "10/05/2003";
			boolean gioiTinh = true;
			String SDT = "0866786774";
			String email = "kscc020@gmail.com";
			String chucVu = "Quản lý";
			String trangThai = "Đang làm việc";
			String luongCB = "500000";
			NhanVienModel nvm = new NhanVienModel(idNhanVien, ngaySinhText, tenNV,null , gioiTinh, SDT, email, chucVu, trangThai, 500000, null);
			   qlv.txt_id().setText(idNhanVien);
			   qlv.txt_ten().setText(tenNV);
			   qlv.txt_ngaySinh().setText(ngaySinhText);
			  qlv.rdo_nam().setSelected(true);
			  qlv.txt_sdt().setText(SDT);
			  qlv.txt_email().setText(email);
			  qlv.txt_trangThai().setText(trangThai);
			  qlv.cb_quanLy().setSelected(true);
			  qlv.txt_luongCB().setText(luongCB);
			// Gọi hàm them()
			qlc.them();

			// Kiểm tra kết quả
			NhanVienModel nv = NhanVienDAO.getInstance().selectById(nvm);
			Assert.assertNotNull(nv);
			Assert.assertEquals(nv.getTenNV(), tenNV);
			
			Assert.assertEquals(nv.isGioiTinh(), gioiTinh);
			Assert.assertEquals(nv.getSoDienThoai(), SDT);
			Assert.assertEquals(nv.getEmail(), email);
			Assert.assertEquals(nv.getChucVu(), chucVu);
			Assert.assertEquals(nv.getTrangThai(), trangThai);
			Assert.assertEquals(nv.getLuongCB(),500000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   
//	    kiểm tra id nhân viên có bắt đầu bằng NV
	@Test
	public void testThemNhanVienThatBai() {
	    QuanLyView qlv = new QuanLyView();
	    QuanLyController qlc = new QuanLyController(qlv);
	    // Chuẩn bị dữ liệu đầu vào
	    String idNhanVien = "009";
	    String tenNV = "John Doe";
	    String ngaySinhText = "10/05/2003";
	    boolean gioiTinh = true;
	    String SDT = "0123456789";
	    String email = "johndoe@example.com";
	    String chucVu = "Quản lý";
	    String trangThai = "Đang làm";
	    String luongCB = "5000000.0";

	    // Gọi hàm them()
	    NhanVienModel nvm = new NhanVienModel(idNhanVien, ngaySinhText, tenNV, null, gioiTinh, SDT, email, chucVu, trangThai, 5000000, null);
	    qlv.txt_id().setText(idNhanVien);
	    qlv.txt_ten().setText(tenNV);
	    qlv.txt_ngaySinh().setText(ngaySinhText);
	    qlv.rdo_nam().setSelected(true);
	    qlv.txt_sdt().setText(SDT);
	    qlv.txt_email().setText(email);
	    qlv.txt_trangThai().setText(trangThai);
	    qlv.cb_quanLy().setSelected(true);
	    qlv.txt_luongCB().setText(luongCB);
	
	qlc.them();
	    // Kiểm tra kỳ vọng ngoại lệ được ném ra
	NhanVienModel nv = NhanVienDAO.getInstance().selectById(nvm);
	assertNull(nv);
	}
	
//	 test số điện thoại bị để chống 
	@Test
	public void testThemNhanVienThatBaiDeTrongSoDienThoai() {
	    QuanLyView qlv = new QuanLyView();
	    QuanLyController qlc = new QuanLyController(qlv);
	    // Chuẩn bị dữ liệu đầu vào
	    String idNhanVien = "NV012";
	    String tenNV = "Nguyễn Ngọc Đức";
	    String ngaySinhText = "13/02/2003";
	    boolean gioiTinh = true;
	    String SDT = "";
	    String email = "johndoe@example.com";
	    String chucVu = "Quản lý";
	    String trangThai = "Đang làm";
	    String luongCB = "5000000.0";

	    // Gọi hàm them()
	    NhanVienModel nvm = new NhanVienModel(idNhanVien, ngaySinhText, tenNV, null, gioiTinh, SDT, email, chucVu, trangThai, 5000000, null);
	    qlv.txt_id().setText(idNhanVien);
	    qlv.txt_ten().setText(tenNV);
	    qlv.txt_ngaySinh().setText(ngaySinhText);
	    qlv.rdo_nam().setSelected(true);
	    qlv.txt_sdt().setText(SDT);
	    qlv.txt_email().setText(email);
	    qlv.txt_trangThai().setText(trangThai);
	    qlv.cb_quanLy().setSelected(true);
	    qlv.txt_luongCB().setText(luongCB);
	
	qlc.them();
	    // Kiểm tra không được thêm vào Database
	NhanVienModel nv = NhanVienDAO.getInstance().selectById(nvm);
	assertNull(nv);
	}
	
	
	// update thông tin nhân viên dữ liệu hợp lệ 
	@Test
	public void testUpdateDuLieuHopLe() {
		try {
			
			// Chuẩn bị dữ liệu đầu vào
			String idNhanVien = "NV003";
			String tenNV = "Nguyễn Ngọc Đức";
			String ngaySinhText = "13/02/2003";
			boolean gioiTinh = true;
			String SDT = "0879384026";
			String email = "philongnguyen193@gmail.com";
			String chucVu = "Quản Lý";
			String trangThai = "Đang làm việc";
			String luongCB = "30.000";
			NhanVienModel nvm = new NhanVienModel("NV003", null, tenNV,null , gioiTinh, SDT, email, chucVu, trangThai, 30.000, null);
			
			   qlv.txt_id().setText(idNhanVien);
			   qlv.txt_ten().setText(tenNV);
			   qlv.txt_ngaySinh().setText(ngaySinhText);
			  qlv.rdo_nam().setSelected(true);
			  qlv.txt_sdt().setText(SDT);
			  qlv.txt_email().setText(email);
			  qlv.txt_trangThai().setText(trangThai);
			  qlv.cb_quanLy().setSelected(true);
			  qlv.txt_luongCB().setText(luongCB);
			// Gọi hàm them()
			qlc.sua();

			// Kiểm tra kết quả
			NhanVienModel nv = NhanVienDAO.getInstance().selectById(nvm);
			Assert.assertNotNull(nv);
			Assert.assertEquals(nv.getTenNV(), tenNV);
			
			Assert.assertEquals(nv.isGioiTinh(), gioiTinh);
			Assert.assertEquals(nv.getSoDienThoai(), SDT);
			Assert.assertEquals(nv.getEmail(), email);
	
			Assert.assertEquals(nv.getTrangThai(), trangThai);
			Assert.assertEquals(nv.getLuongCB(),30.000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// update thông tin nhân viên dữ liệu Để trống 
		@Test
		public void testUpdateDuLieuRong() {
			try {
				
				// Chuẩn bị dữ liệu đầu vào
				String idNhanVien = "NV003";
				String tenNV = "Nguyễn Ngọc Đức";
				String ngaySinhText = "13/02/2003";
				boolean gioiTinh = true;
				String SDT = "";
				String email = "philongnguyen193@gmail.com";
				String chucVu = "Quản Lý";
				String trangThai = "Đang làm việc";
				String luongCB = "30.000";
				NhanVienModel nvm = new NhanVienModel("NV003", null, tenNV,null , gioiTinh, SDT, email, chucVu, trangThai, 30.000, null);
				
				   qlv.txt_id().setText(idNhanVien);
				   qlv.txt_ten().setText(tenNV);
				   qlv.txt_ngaySinh().setText(ngaySinhText);
				  qlv.rdo_nam().setSelected(true);
				  qlv.txt_sdt().setText(SDT);
				  qlv.txt_email().setText(email);
				  qlv.txt_trangThai().setText(trangThai);
				  qlv.cb_quanLy().setSelected(true);
				  qlv.txt_luongCB().setText(luongCB);
				// Gọi hàm them()
				qlc.sua();


				 JOptionPane.showMessageDialog(qlv, "SDT không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// tesst up date lương nhỏ hơn 0 
		@Test
		public void testUpdateLuongNhoHon0() {
			try {
				
				// Chuẩn bị dữ liệu đầu vào
				String idNhanVien = "NV003";
				String tenNV = "Nguyễn Ngọc Đức";
				String ngaySinhText = "13/02/2003";
				boolean gioiTinh = true;
				String SDT = "";
				String email = "philongnguyen193@gmail.com";
				String chucVu = "Quản Lý";
				String trangThai = "Đang làm việc";
				String luongCB = "0";
				NhanVienModel nvm = new NhanVienModel("NV003", null, tenNV,null , gioiTinh, SDT, email, chucVu, trangThai, 30.000, null);
				
				   qlv.txt_id().setText(idNhanVien);
				   qlv.txt_ten().setText(tenNV);
				   qlv.txt_ngaySinh().setText(ngaySinhText);
				  qlv.rdo_nam().setSelected(true);
				  qlv.txt_sdt().setText(SDT);
				  qlv.txt_email().setText(email);
				  qlv.txt_trangThai().setText(trangThai);
				  qlv.cb_quanLy().setSelected(true);
				  qlv.txt_luongCB().setText(luongCB);
				// Gọi hàm them()
				qlc.sua();


				 JOptionPane.showMessageDialog(qlv, "Lương CB không được Nhỏ hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

package Controller;

import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DAO.NhanVienDAO;
import Model.NhanVienModel;
import View.DangNhapView;
import View.NhanVienView;
import View.QuanLyView;


public class DangNhapControllerTest {
	private QuanLyView qlv;
	 private DangNhapView dnv;
	 private DangNhapController dnc;
	 private NhanVienDAO nvd;
	 @BeforeMethod
	 public void setup() {
	     dnv = new DangNhapView();
	     qlv = new QuanLyView();
        dnc = new DangNhapController(dnv, nvd);
         nvd =  new NhanVienDAO();
	 }
	 // test đăng nhập với dữ liệu hợp lệ
	@Test
    public void testDangNhapVoiDuLieuHopLe() {
	
		dnv.txt_username().setText("NV001");
		dnv.txt_passWord().setText("quanly");
    
      dnc.DangNhap();
       

	}
//	 test với dữ liệu Không tồn tại
	@Test
    public void testDangNhapVoiDuLieuKhongTonTai() {
	
		dnv.txt_username().setText("user01");
		dnv.txt_passWord().setText("quanly");
    
      dnc.DangNhap();
      JOptionPane.showMessageDialog(dnv, "Đăng nhập thất bại, sai tài khoản hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);

	}
	// dữ liệu để Trống 
	@Test
    public void testDangNhapVoiDuLieuDeTrong() {
	
		dnv.txt_username().setText("");
		dnv.txt_passWord().setText("");
    
      dnc.DangNhap();
      JOptionPane.showMessageDialog(dnv, "Đăng nhập thất bại, sai tài khoản hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);

	}
}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.NhanVienDAO;
import Model.NhanVienModel;
import View.DangNhapView;
import View.NhanVienView;
import View.QuanLyView;

import View.viewQR;

public class DangNhapController implements ActionListener {
	private DangNhapView dnv;
	private NhanVienDAO nvd;
      private viewQR qr;
	public DangNhapController(DangNhapView dnv, NhanVienDAO nvd) {

		this.dnv = dnv;
		this.nvd = nvd;
	}

	public DangNhapController() {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút " + src);
		
		// thay đổi Login cho các phương thức 
		if (src.equals("Login")) {
			DangNhap();
		} else 	if (src.equals("Login QR")) {
		 qr = new viewQR();
		qr.setVisible(true);
		dnv.setVisible(false);
		
	    
		} 
	}

		public void DangNhap() {
			QuanLyView qlv = new QuanLyView();
		    try {
		    	// load dữ liệu từ database lên 
		        ArrayList<NhanVienModel> nhanvien = nvd.getInstance().selectAll();
		        String userName = dnv.txt_username().getText();
		        String passWord = String.valueOf(dnv.txt_passWord().getPassword());
		        boolean loggedIn = false;
	
		        if (userName.isEmpty() || passWord.isEmpty()) {
		        	  JOptionPane.showMessageDialog(dnv, "Vui lòng nhập tên đăng nhập và mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        } else {
		            for (NhanVienModel nhanVienModel : nhanvien) {
		                if (nhanVienModel.getIdNhanVien().equals(userName) && nhanVienModel.getMatKhau().equals(passWord)) {
		                	qlv.lbl_tenNV().setText(nhanVienModel.getTenNV());
		                    if (nhanVienModel.getChucVu().equals("Quản lý")) {
		                    	qlv.setVisible(true);
		                        qlv.lbl_chucVu().setText(nhanVienModel.getChucVu());
		                        dnv.setVisible(false);
		                    } else if (nhanVienModel.getChucVu().equals("Nhân viên")) {
		                    	 qlv.lbl_chucVu().setText(nhanVienModel.getChucVu());
		                        dnv.setVisible(false);
		                        NhanVienView nv = new NhanVienView();
		                        nv.setVisible(true);
		                        nv.lbl_tenNV().setText(nhanVienModel.getTenNV());
			                    nv.lbl_IDNhanVien().setText(nhanVienModel.getIdNhanVien());
		                    }
		                    loggedIn = true;
		          
		                    break;
		                }
		            }
	
		            if (!loggedIn) {
		            	   JOptionPane.showMessageDialog(dnv, "Đăng nhập thất bại, sai tài khoản hoặc mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            }
		            
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		}
	public boolean DangNhapQR(String taiKhoang, String matKhau) {
	
	    boolean loggedIn = false;
	    try {
	        ArrayList<NhanVienModel> nhanvien = NhanVienDAO.getInstance().selectAll();

	        for (NhanVienModel nhanVienModel : nhanvien) {
	            if (nhanVienModel.getIdNhanVien().equals(taiKhoang) && nhanVienModel.getMatKhau().equals(matKhau)) {
	           
	            	System.out.println();
	                if (nhanVienModel.getChucVu().equals("Quản lý")) {
	                	  
	                    loggedIn = true;
	                  QuanLyView ql =  new QuanLyView();
	                    ql.setVisible(true);
	                    ql.lbl_tenNV().setText("Tên: "+nhanVienModel.getTenNV());
	                    ql.lbl_chucVu().setText("Chức Vụ: "+nhanVienModel.getChucVu());
	                    break;
	                }else if (nhanVienModel.getChucVu().equals("Nhân viên")) {
	                  
	                    NhanVienView nvv = new NhanVienView();
	                    nvv.setVisible(true);
	                    nvv.lbl_tenNV().setText(nhanVienModel.getTenNV());
	                    nvv.lbl_IDNhanVien().setText(nhanVienModel.getIdNhanVien());
	                    loggedIn = true;
	                    break;
	                }
	            }
	        }

	        if (!loggedIn) {
	            JOptionPane.showMessageDialog(dnv, "Đăng nhập thất bại, sai tài khoản hoặc mật khẩu");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return loggedIn; // Return the loggedIn status
	}
}

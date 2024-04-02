package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;

import Model.NhanVienModel;
import java.util.Collections;
import java.util.Comparator;
public class NhanVienDAO implements DAOInterface<NhanVienModel> {
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(NhanVienModel t) {
			   int ketQua = 0;
		        try {
		            // Bước 1: Kết nối CSDL
		            Connection con = Database.JDBCUtil.getConnection();
	
		            // Bước 2: Tạo prepared statement
		            String sql="INSERT INTO NHANVIEN (IDNhanVien, MatKhau, TenNV,NgaySinh,GioiTinh,SDT,Email,ChucVu,TrangThai,LuongCB,IDCaLam) VALUES(?, ?, ?,?,?,?,?,?,?,?,?)";
		            PreparedStatement statement = con.prepareStatement(sql);
		            statement.setString(1, t.getIdNhanVien());
		            statement.setString(2, t.getMatKhau());
		            statement.setString(3, t.getTenNV());
		            statement.setDate(4, t.getNgaySinh());
		            statement.setBoolean(5, t.isGioiTinh());
		            statement.setString(6, t.getSoDienThoai());
		            statement.setString(7, t.getEmail());
		            statement.setString(8, t.getChucVu());
		            statement.setString(9, t.getTrangThai());
		            statement.setDouble(10, t.getLuongCB());
		            statement.setString(11, t.getIdCaLam());
		            // Bước 3: Thực thi truy vấn
		            ketQua = statement.executeUpdate();
	
		            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
	
		            // Bước 4: Đóng kết nối
		            JDBCUtil.closeConnection(con);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return ketQua;
	}

	@Override
	public int update(NhanVienModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE NHANVien SET  TenNV=?, NgaySinh=?,GioiTinh=? ,SDT=?,Email=?,ChucVu=?,TrangThai=?,LuongCB=? WHERE IDNhanVien=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setString(1, t.getTenNV());
	            statement.setDate(2, t.getNgaySinh());
	            statement.setBoolean(3, t.isGioiTinh());
	            statement.setString(4, t.getSoDienThoai());
	            statement.setString(5, t.getEmail());
	            statement.setString(6, t.getChucVu());
	            statement.setString(7, t.getTrangThai());
	            statement.setDouble(8, t.getLuongCB());
	            
	            statement.setString(9, t.getIdNhanVien());
	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}
	public void updatePass(String idNhanVien,String passWord) {
	
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE NHANVIEN SET MatKhau=? WHERE IDNhanVien=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1,passWord);
	           
	            statement.setString(2, idNhanVien);
	            // Bước 3: Thực thi truy vấn
	          statement.executeUpdate();

	          

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	}
	@Override
	public int delete(NhanVienModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="DELETE FROM NHANVIEN WHERE IDNhanVien=?";
	            PreparedStatement statement = con.prepareStatement(sql);

	            statement.setString(1, t.getIdNhanVien());

	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public ArrayList<NhanVienModel> selectAll() {
		  ArrayList<NhanVienModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM NHANVIEN";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idNhanVien = rs.getString("IDNhanVien");
		            String matKhau = rs.getString("MatKhau");
		            String tenNV = rs.getString("TenNV");
		            Date ngaySinh = rs.getDate("NgaySinh");
		            boolean gioiTinh = rs.getBoolean("GioiTinh");
		            String SDT = rs.getString("SDT");
		            String email = rs.getString("Email");
		            String chucVu = rs.getString("ChucVu");
		            String trangThai = rs.getString("TrangThai");
		            double luongCB = rs.getDouble("LuongCB");
		           String idCaLam = rs.getString("IDCaLam");
		        NhanVienModel nv = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinh, gioiTinh, SDT, email, chucVu, trangThai, luongCB, idCaLam);
		            ketQua.add(nv);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}
	public ArrayList<NhanVienModel> selectAllDangLamViec() {
		  ArrayList<NhanVienModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM NHANVIEN WHERE TrangThai = 'Đang làm việc';";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idNhanVien = rs.getString("IDNhanVien");
		            String matKhau = rs.getString("MatKhau");
		            String tenNV = rs.getString("TenNV");
		            Date ngaySinh = rs.getDate("NgaySinh");
		            boolean gioiTinh = rs.getBoolean("GioiTinh");
		            String SDT = rs.getString("SDT");
		            String email = rs.getString("Email");
		            String chucVu = rs.getString("ChucVu");
		            String trangThai = rs.getString("TrangThai");
		            double luongCB = rs.getDouble("LuongCB");
		           String idCaLam = rs.getString("IDCaLam");
		        NhanVienModel nv = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinh, gioiTinh, SDT, email, chucVu, trangThai, luongCB, idCaLam);
		            ketQua.add(nv);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}
	@Override
	public NhanVienModel selectById(NhanVienModel t) {
		NhanVienModel ketQua = null;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo prepared statement
            String sql = "SELECT * FROM NHANVIEN WHERE IDNhanVien = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, t.getIdNhanVien());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String idNhanVien = rs.getString("IDNhanVien");
	            String matKhau = rs.getString("MatKhau");
	            String tenNV = rs.getString("TenNV");
	            Date ngaySinh = rs.getDate("NgaySinh");
	            boolean gioiTinh = rs.getBoolean("GioiTinh");
	            String SDT = rs.getString("SDT");
	            String email = rs.getString("Email");
	            String chucVu = rs.getString("ChucVu");
	            String trangThai = rs.getString("TrangThai");
	            double luongCB = rs.getDouble("LuongCB");
	           String idCaLam = rs.getString("IDCaLam");
	        NhanVienModel nv = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinh, gioiTinh, SDT, email, chucVu, trangThai, luongCB, idCaLam);

                ketQua = nv;
            }

            // Bước 3: Đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
	}

	@Override
	public ArrayList<NhanVienModel> selectByCondition(String condition) {
		ArrayList<NhanVienModel> ketQua = new ArrayList<>();
		try {
			// Bước 1: Kết nối CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo prepared statement
			String sql = "SELECT * FROM NHANVIEN WHERE " + condition;
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				  String idNhanVien = rs.getString("IDNhanVien");
		            String matKhau = rs.getString("MatKhau");
		            String tenNV = rs.getString("TenNV");
		            Date ngaySinh = rs.getDate("NgaySinh");
		            boolean gioiTinh = rs.getBoolean("GioiTinh");
		            String SDT = rs.getString("SDT");
		            String email = rs.getString("Email");
		            String chucVu = rs.getString("ChucVu");
		            String trangThai = rs.getString("TrangThai");
		            double luongCB = rs.getDouble("LuongCB");
		           String idCaLam = rs.getString("IDCaLam");
		        NhanVienModel nv = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinh, gioiTinh, SDT, email, chucVu, trangThai, luongCB, idCaLam);
				ketQua.add(nv);
			}

			// Bước 3: Đóng kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	public NhanVienModel timkiem(String idNhanVien1) {
	    try {
	        // Bước 1: Kết nối CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Tạo prepared statement
	        String sql = "SELECT * FROM NHANVIEN WHERE IDNhanVien = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, idNhanVien1); // Thiết lập giá trị tham số

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            String idNhanVien = rs.getString("IDNhanVien");
	            String matKhau = rs.getString("MatKhau");
	            String tenNV = rs.getString("TenNV");
	            Date ngaySinh = rs.getDate("NgaySinh");
	            boolean gioiTinh = rs.getBoolean("GioiTinh");
	            String SDT = rs.getString("SDT");
	            String email = rs.getString("Email");
	            String chucVu = rs.getString("ChucVu");
	            String trangThai = rs.getString("TrangThai");
	            double luongCB = rs.getDouble("LuongCB");
	            String idCaLam = rs.getString("IDCaLam");
	            NhanVienModel nhanVien = new NhanVienModel(idNhanVien, matKhau, tenNV, ngaySinh, gioiTinh, SDT, email, chucVu, trangThai, luongCB, idCaLam);
	            return nhanVien;
	        }

	        // Bước 3: Đóng kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null; // Trả về null nếu không tìm thấy kết quả
	}
    
	
}

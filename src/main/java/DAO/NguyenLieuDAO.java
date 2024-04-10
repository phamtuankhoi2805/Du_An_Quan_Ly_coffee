package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.NguyenLieuModel;
import Model.NhanVienModel;

public class NguyenLieuDAO implements DAOInterface<NguyenLieuModel> {
	public static NguyenLieuDAO getInstance() {
		return new NguyenLieuDAO();
	}

	@Override
	public int insert(NguyenLieuModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO NGUYENLIEU (IDNguyenLieu, TenNguyenLieu, SoLuongTon,DonViTinh) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdNguyenLieu());
	            statement.setString(2, t.getTenNguyenLieu());
	            statement.setInt(3, t.getSoLuongTon());
	            statement.setString(4, t.getDonViTinh());
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
	public int update(NguyenLieuModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE NGUYENLIEU SET  TenNguyenLieu=?, SoLuongTon=?,DonViTinh = ? WHERE IDNguyenLieu=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setString(1, t.getTenNguyenLieu());
	            statement.setInt(2, t.getSoLuongTon());  
	            statement.setString(3, t.getDonViTinh());
	            statement.setString(4, t.getIdNguyenLieu());
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
	
	public int updateSoLuongTon(NguyenLieuModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE NGUYENLIEU SET  TenNguyenLieu=?, SoLuongTon=? WHERE IDNguyenLieu=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setString(1, t.getTenNguyenLieu());
	            statement.setInt(2, t.getSoLuongTon());  
	          
	            statement.setString(3, t.getIdNguyenLieu());
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
	public int delete(NguyenLieuModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NguyenLieuModel> selectAll() {
		  ArrayList<NguyenLieuModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM NGUYENLIEU";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idNguyenLieu = rs.getString("IDNguyenLieu");
		            String tenNL = rs.getString("TenNguyenLieu");
		            int soLuong = rs.getInt("SoLuongTon");
		            String donViTinh =  rs.getString("DonViTinh");
		          NguyenLieuModel nl = new NguyenLieuModel(idNguyenLieu, tenNL, soLuong,donViTinh);
		
		            ketQua.add(nl);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public NguyenLieuModel selectById(NguyenLieuModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NguyenLieuModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

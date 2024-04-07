package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;

import Model.SoLuongNguyenLieuModel;

public class SoLuongNguyenLieuDAO implements DAOInterface<SoLuongNguyenLieuModel> {
	public static SoLuongNguyenLieuDAO getInstance() {
		return new SoLuongNguyenLieuDAO();
	}
	
	@Override
	public int delete(SoLuongNguyenLieuModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="DELETE FROM SOLUONGNGUYENLIEU WHERE IDSanPham=?";
	            PreparedStatement statement = con.prepareStatement(sql);

	            statement.setString(1, t.getIdSanPham());

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
	public ArrayList<SoLuongNguyenLieuModel> selectAll() {
		  ArrayList<SoLuongNguyenLieuModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM SOLUONGNGUYENLIEU";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		           String idSanPham = rs.getString("IDSanPham");
		           String idNguyenLieu =  rs.getString("IDNguyenLieu");
		           int soLuongNguyenLieu =  rs.getInt("SoLuongNL");
		           SoLuongNguyenLieuModel nl = new SoLuongNguyenLieuModel(idSanPham, idNguyenLieu, soLuongNguyenLieu);
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
	public SoLuongNguyenLieuModel selectById(SoLuongNguyenLieuModel t) {
		SoLuongNguyenLieuModel ketQua = null;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo prepared statement
            String sql = "SELECT * FROM SOLUONGNGUYENLIEU WHERE IDSanPham = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, t.getIdSanPham());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            	   String idSanPham = rs.getString("IDSanPham");
		           String idNguyenLieu =  rs.getString("IDNguyenLieu");
		           int soLuongNguyenLieu =  rs.getInt("SoLuongNL");
		           SoLuongNguyenLieuModel nl = new SoLuongNguyenLieuModel(idSanPham, idNguyenLieu, soLuongNguyenLieu);

                ketQua = nl;
            }

            // Bước 3: Đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
	}

		 
	@Override
	public int insert(SoLuongNguyenLieuModel t) {
	    int ketQua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "INSERT INTO SOLUONGNGUYENLIEU (IDSanPham, IDNguyenLieu, SoLuongNL) VALUES (?, ?, ?)";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, t.getIdSanPham());
	        statement.setString(2, t.getIdNguyenLieu());
	        statement.setInt(3, t.getSoLuongNguyenLieu());
	        ketQua = statement.executeUpdate();
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	@Override
	public int update(SoLuongNguyenLieuModel t) {
	    int ketQua = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE SOLUONGNGUYENLIEU SET IDNguyenLieu=?, SoLuongNL=? WHERE IDSanPham=?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, t.getIdNguyenLieu());
	        statement.setInt(2, t.getSoLuongNguyenLieu());
	        statement.setString(3, t.getIdSanPham());
	        ketQua = statement.executeUpdate();
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	@Override
	public ArrayList<SoLuongNguyenLieuModel> selectByCondition(String condition) {
	    ArrayList<SoLuongNguyenLieuModel> ketQua = new ArrayList<>();
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "SELECT * FROM SOLUONGNGUYENLIEU WHERE " + condition;
	        PreparedStatement statement = con.prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            String idSanPham = rs.getString("IDSanPham");
	            String idNguyenLieu = rs.getString("IDNguyenLieu");
	            int soLuongNguyenLieu = rs.getInt("SoLuongNL");
	            SoLuongNguyenLieuModel nl = new SoLuongNguyenLieuModel(idSanPham, idNguyenLieu, soLuongNguyenLieu);
	            ketQua.add(nl);
	        }
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

}

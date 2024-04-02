package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.CaLamViecModel;
import Model.NhanVienModel;

public class CaLamViecDao implements DAOInterface<CaLamViecModel> {
	public static CaLamViecDao getInstance() {
		return new CaLamViecDao();
	}

	@Override
	public int insert(CaLamViecModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO CALAMVIEC (IDCaLam, TenCaLam, ThoiGian,Ngay) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdCaLam());
	            statement.setString(2, t.getTenCaLam());
	            statement.setString(3, t.getThoiGian());
	            statement.setString(4, t.getNgay());
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
	public int update(CaLamViecModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE CALAMVIEC SET  TenCaLam=?, ThoiGian=?,Ngay=?  WHERE IDCaLam=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setString(1, t.getTenCaLam());
	            statement.setString(2, t.getThoiGian());
	            statement.setString(3, t.getNgay());
	           
	            
	            statement.setString(4, t.getIdCaLam());
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
	public int delete(CaLamViecModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CaLamViecModel> selectAll() {
		  ArrayList<CaLamViecModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = " select * from CALAMVIEC ";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		      String idCalam = rs.getString("IDCaLam")   ;
		      String TenCaLam = rs.getString("TenCaLam");
		      String ThoiGian = rs.getString("ThoiGian");
		      String Ngay = rs.getString("Ngay");
		      CaLamViecModel clv = new CaLamViecModel(idCalam, TenCaLam, ThoiGian, Ngay);
		            ketQua.add(clv);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public CaLamViecModel selectById(CaLamViecModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CaLamViecModel> selectByCondition(String Ngaylm) {
		  ArrayList<CaLamViecModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = " select * from CALAMVIEC where Ngay = '"+Ngaylm+"'";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		      String idCalam = rs.getString("IDCaLam")   ;
		      String TenCaLam = rs.getString("TenCaLam");
		      String ThoiGian = rs.getString("ThoiGian");
		      String Ngay = rs.getString("Ngay");
		      CaLamViecModel clv = new CaLamViecModel(idCalam, TenCaLam, ThoiGian, Ngay);
		            ketQua.add(clv);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}



}

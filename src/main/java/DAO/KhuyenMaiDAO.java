package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.KhuyenMaiModel;
import Model.NhanVienModel;

public class KhuyenMaiDAO implements DAOInterface<KhuyenMaiModel> {
	public static KhuyenMaiDAO getInstance() {
		return new KhuyenMaiDAO();
	}
	@Override
	public int insert(KhuyenMaiModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO KHUYENMAI (IDKhuyenMai, TenKM, DieuKienKM,TongTru) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdKhuyenMai());
	            statement.setString(2, t.getTenKhuyenMai());
	            statement.setString(3, t.getDieuKienKM());
	            statement.setFloat(4, t.getTongTru());
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
	public int update(KhuyenMaiModel t) {
		int ketQua = 0;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo prepared statement
            String sql="UPDATE KHUYENMAI SET  TenKM=?, DieuKienKM=?,TongTru=? WHERE IDKhuyenMai=?";
            PreparedStatement statement = con.prepareStatement(sql);
           
            statement.setString(1, t.getTenKhuyenMai());
            statement.setString(2, t.getDieuKienKM());
            statement.setFloat(3, t.getTongTru());
            statement.setString(4, t.getIdKhuyenMai());
          
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
	public int delete(KhuyenMaiModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhuyenMaiModel> selectAll() {
		  ArrayList<KhuyenMaiModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM KHUYENMAI";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idKhuenMai = rs.getString("IDKhuyenMai");
		            String TenKM = rs.getString("TenKM");
		            String DieuKienKM = rs.getString("DieuKienKM");
		            float TongTru = rs.getFloat("TongTru");
		           
		        KhuyenMaiModel km = new KhuyenMaiModel(idKhuenMai, TenKM, DieuKienKM, TongTru);
		            ketQua.add(km);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public KhuyenMaiModel selectById(KhuyenMaiModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhuyenMaiModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

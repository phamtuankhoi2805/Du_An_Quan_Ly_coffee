package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.CaLamViecModel;
import Model.HoaDonModel;

public class HoaDonDAO implements DAOInterface<HoaDonModel> {
	public static HoaDonDAO getInstance() {
		return new HoaDonDAO();
	}

	@Override
	public int insert(HoaDonModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO HOADON (IDHoaDon, ThanhTien, ThoiGianMua,IDKhuyenMai) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIDHoaDon());
	            statement.setDouble(2, t.getThanhTien());
	            statement.setDate(3, t.getThoiGianMua());
	            statement.setString(4, t.getIDKhuyenMai());
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
	public int update(HoaDonModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE HOADON SET ThanhTien=?,IDKhuyenMai=? WHERE IDHoaDon=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setDouble(1, t.getThanhTien());

	            statement.setString(2, t.getIDKhuyenMai());
	         
	            
	            statement.setString(3, t.getIDHoaDon());
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
	public int delete(HoaDonModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<HoaDonModel> selectAll() {
	    ArrayList<HoaDonModel> ketQua = new ArrayList<>();
	    try {
	        // Bước 1: Kết nối CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Tạo prepared statement
	        String sql = "select * from HOADON";
	        PreparedStatement statement = con.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery();

	        while (rs.next()) {
	            String idHoaDon = rs.getString("IDHoaDon");
	            double thanhTien = rs.getDouble("ThanhTien");
	            Date thoiGian = rs.getDate("ThoiGianMua");
	            String idKhuyenMai = rs.getString("IDKhuyenMai");
	           HoaDonModel hd = new HoaDonModel(idHoaDon, thanhTien, thoiGian, idKhuyenMai);
	            ketQua.add(hd);
	        }

	        // Bước 3: Đóng kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	@Override
	public HoaDonModel selectById(HoaDonModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HoaDonModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

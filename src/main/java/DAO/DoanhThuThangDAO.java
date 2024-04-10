package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.KhuyenMaiModel;
import Model.ThongKeDoanhThuTheoThangModel;

public class DoanhThuThangDAO implements DAOInterface<ThongKeDoanhThuTheoThangModel> {
	public static DoanhThuThangDAO getInstance() {
		return new DoanhThuThangDAO();
	}
	@Override
	public int insert(ThongKeDoanhThuTheoThangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ThongKeDoanhThuTheoThangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ThongKeDoanhThuTheoThangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ThongKeDoanhThuTheoThangModel> selectAll() {
		  ArrayList<ThongKeDoanhThuTheoThangModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "EXEC ThongKeDoanhThuTheoThang";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		          String thang = rs.getString("Thang");
		          String nam = rs.getString("Nam");
		          int doanhThu = rs.getInt("DoanhThu");
		           int tongDon =  rs.getInt("TongDonHang");
		      ThongKeDoanhThuTheoThangModel tkt = new ThongKeDoanhThuTheoThangModel(nam, thang, doanhThu,tongDon);
		            ketQua.add(tkt);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public ThongKeDoanhThuTheoThangModel selectById(ThongKeDoanhThuTheoThangModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThongKeDoanhThuTheoThangModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

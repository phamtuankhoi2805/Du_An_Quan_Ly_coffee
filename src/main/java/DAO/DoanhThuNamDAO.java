package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.ThongKeDoanhThuTheoNamModel;
import Model.ThongKeDoanhThuTheoThangModel;

public class DoanhThuNamDAO implements DAOInterface<ThongKeDoanhThuTheoNamModel> {
	public static DoanhThuNamDAO getInstance() {
		return new DoanhThuNamDAO();
	}
	@Override
	public int insert(ThongKeDoanhThuTheoNamModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ThongKeDoanhThuTheoNamModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ThongKeDoanhThuTheoNamModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ThongKeDoanhThuTheoNamModel> selectAll() {
		  ArrayList<ThongKeDoanhThuTheoNamModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "EXEC ThongKeDoanhThuTheoNam";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		    
		          String nam = rs.getString("Nam");
		          int doanhThu = rs.getInt("DoanhThu");
		           
		    ThongKeDoanhThuTheoNamModel tkn = new ThongKeDoanhThuTheoNamModel(nam, doanhThu);
		            ketQua.add(tkn);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public ThongKeDoanhThuTheoNamModel selectById(ThongKeDoanhThuTheoNamModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThongKeDoanhThuTheoNamModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

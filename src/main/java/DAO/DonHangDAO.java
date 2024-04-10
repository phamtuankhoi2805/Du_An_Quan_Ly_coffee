package DAO;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.CaLamViecModel;
import Model.DonHangModel;

public class DonHangDAO implements DAOInterface<DonHangModel> {
	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}
	@Override
	public int insert(DonHangModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO DONHANG (IDDonHang, NgayMuaHang, IDNhanVien) VALUES(?, ?, ?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdDonHang());
	            statement.setDate(2, t.getNgayMua());
	            statement.setString(3, t.getIdNhanVien());
	    
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
	public int update(DonHangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DonHangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<DonHangModel> selectAll() {
		   ArrayList<DonHangModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "Select * From DonHang";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		          String idDonHang = rs.getString("IDDonHang");
		          Date ngayMuaHang =  rs.getDate("NgayMuaHang");
		          String idNhanVien =  rs.getString("IDNhanVien");
		         DonHangModel dh = new DonHangModel(idDonHang, ngayMuaHang, idNhanVien);
		            ketQua.add(dh);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public DonHangModel selectById(DonHangModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DonHangModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

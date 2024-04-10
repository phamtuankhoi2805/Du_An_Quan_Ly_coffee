package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.DonHangChiTietModel;
import Model.NhanVienModel;

public class ChiTietDonHangDAO implements DAOInterface<DonHangChiTietModel> {
	public static ChiTietDonHangDAO getInstance() {
		return new ChiTietDonHangDAO();
	}
	@Override
	public int insert(DonHangChiTietModel t) {
		   int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO CHITIETDONHANG (IDSanPham, IDDonHang, SoLuongMua,IDHoaDon) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIDSanPham());
	            statement.setString(2, t.getIDDonHang());
	            statement.setInt(3, t.getSoLuongMua());
	            statement.setString(4, t.getIDHoaDon());
	           
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
	public int update(DonHangChiTietModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DonHangChiTietModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<DonHangChiTietModel> selectAll() {
		  ArrayList<DonHangChiTietModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM CHITIETDONHANG";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idSanPham = rs.getString("IDSanPham");
		            String IDDonHang = rs.getString("IDDonHang");
		            int soLuongMua = rs.getInt("SoLuongMua");
		            String idHoaDon = rs.getString("IDHoaDon");
		         
		      DonHangChiTietModel dh = new DonHangChiTietModel(idSanPham, IDDonHang, soLuongMua, idHoaDon);
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
	public DonHangChiTietModel selectById(DonHangChiTietModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DonHangChiTietModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

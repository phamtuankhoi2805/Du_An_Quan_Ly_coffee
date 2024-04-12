package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.PhieuGiaoHangChiTietModel;
import Model.PhieuGiaoHangModel;

public class PhieuGiaoHangChiTietDAO implements DAOInterface<PhieuGiaoHangChiTietModel> {
	public static PhieuGiaoHangChiTietDAO getInstance() {
		return new PhieuGiaoHangChiTietDAO();
	}
	@Override
	public int insert(PhieuGiaoHangChiTietModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO PHIEUGIAOHANGCHITIET (IDNguyenLieu, IDPhieuGiao, SoLuongNLGiao,DonGiaNL) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdNguyenLieu());
	            statement.setString(2, t.getIdPhieuGiao());
	            statement.setInt(3, t.getSoLuongNlGiao());
	            statement.setDouble(4, t.getDonGiaNL());
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
	public int update(PhieuGiaoHangChiTietModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PhieuGiaoHangChiTietModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<PhieuGiaoHangChiTietModel> selectAll() {
	    ArrayList<PhieuGiaoHangChiTietModel> ketQua = new ArrayList<>();
	    try {
	        // Bước 1: Kết nối CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Tạo prepared statement
	        String sql = "SELECT IDNguyenLieu, IDPhieuGiao, SoLuongNlGiao, DonGiaNL FROM PHIEUGIAOHANGCHITIET";
	        PreparedStatement statement = con.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery();

	        while (rs.next()) {
	            String IDNguyenlieu = rs.getString("IDNguyenLieu");
	            String  IDPhieuGiao = rs.getString("IDPhieuGiao");
	            int SoLuongNLGiao = rs.getInt("SoLuongNlGiao");
	            Double DonGiaNL = rs.getDouble("DonGiaNL");
	            PhieuGiaoHangChiTietModel PGHCT = new PhieuGiaoHangChiTietModel(IDNguyenlieu, IDPhieuGiao, SoLuongNLGiao, SoLuongNLGiao);
	            ketQua.add(PGHCT);
	        }

	        // Bước 3: Đóng kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	@Override
	public PhieuGiaoHangChiTietModel selectById(PhieuGiaoHangChiTietModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuGiaoHangChiTietModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

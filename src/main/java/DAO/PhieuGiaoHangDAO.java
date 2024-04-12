package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.CaLamViecModel;
import Model.PhieuGiaoHangModel;

public class PhieuGiaoHangDAO implements DAOInterface<PhieuGiaoHangModel>{
	public static PhieuGiaoHangDAO getInstance() {
		return new PhieuGiaoHangDAO();
	}
	@Override
	public int insert(PhieuGiaoHangModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO PHIEUGIAOHANG (IDPhieuGiao, NgayGiaoHang, TongTienGiaoHang,IDNhaCC) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdPhieuGiao());
	            statement.setString(2, t.getNgayGiaoHang());
	            statement.setDouble(3, t.getTongTienGiaoHang());
	            statement.setString(4, t.getIdNhaCC());
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
	public int update(PhieuGiaoHangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PhieuGiaoHangModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<PhieuGiaoHangModel> selectAll() {
	    ArrayList<PhieuGiaoHangModel> ketQua = new ArrayList<>();
	    try {
	        // Bước 1: Kết nối CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Tạo prepared statement
	        String sql = "SELECT IDPhieuGiao, NgayGiaoHang, TongTienGiaoHang,IDNhaCC FROM PHIEUGIAOHANG";
	        PreparedStatement statement = con.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery();

	        while (rs.next()) {
	            String IDPhieuGiao = rs.getString("IDPhieuGiao");
	            String NgayGiaoHang = rs.getString("NgayGiaoHang");
	            String IDNhaCC = rs.getString("IDNhaCC");
	            Double TongTienGiao = rs.getDouble("TongTienGiaoHang");
	           PhieuGiaoHangModel PGH = new PhieuGiaoHangModel(IDPhieuGiao, NgayGiaoHang, TongTienGiao, IDNhaCC);
	            ketQua.add(PGH);
	        }

	        // Bước 3: Đóng kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ketQua;
	}

	@Override
	public PhieuGiaoHangModel selectById(PhieuGiaoHangModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuGiaoHangModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.NhaCungCapModel;
import Model.PhieuGiaoHangModel;

public class NhaCungCapDAO implements DAOInterface<NhaCungCapModel>{
	public static NhaCungCapDAO getInstance() {
		return new NhaCungCapDAO();
	}
	@Override
	public int insert(NhaCungCapModel t) {
		  int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO NHACUNGCAP (IDNhaCC, TenNhaCC, DiaChi,SDT) VALUES(?, ?, ?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdNhaCC());
	            statement.setString(2, t.getTenNhaCC());
	            statement.setString(3, t.getDiaChi());
	            statement.setString(4, t.getSoDienThoai());
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
	public int update(NhaCungCapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NhaCungCapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NhaCungCapModel> selectAll() {
		 ArrayList<NhaCungCapModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT IDNhaCC, TenNhaCC, DiaChi, SDT FROM NHACUNGCAP";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String IDNhaCC = rs.getString("IDNhaCC");
		            String TenNhaCC = rs.getString("TenNhaCC");
		            String DiaChi = rs.getString("DiaChi");
		            String SDT = rs.getString("SDT");
		           NhaCungCapModel ncc = new NhaCungCapModel(IDNhaCC, TenNhaCC, DiaChi, SDT);
		            ketQua.add(ncc);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public NhaCungCapModel selectById(NhaCungCapModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhaCungCapModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

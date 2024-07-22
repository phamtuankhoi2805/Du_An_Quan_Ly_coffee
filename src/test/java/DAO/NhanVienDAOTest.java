package DAO;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.testng.annotations.Test;

import Model.NhanVienModel;

public class NhanVienDAOTest {
	 private NhanVienDAO NhanVienDAO;

	    @Test
	    public void selectAllDangLamViecTest() {
	        // Arrange
	        NhanVienDAO = new NhanVienDAO();

	        // Act
	        ArrayList<NhanVienModel> nhanViens = NhanVienDAO.selectAllDangLamViec();
               
	        // Assert
	        
	        assert nhanViens !=null : "thành công";
	    }

	   
	    @Test
	    public void selectByIdTest() {
	        // Arrange
	        NhanVienDAO = new NhanVienDAO();
	        NhanVienModel nv = new NhanVienModel("NV002", null, null, null, false, null, null, null, null, 0, null);

	        // Act
	        NhanVienModel nhanVien = NhanVienDAO.selectById(nv);

	        // Assert
	          assertEquals("NV002", nhanVien.getIdNhanVien());
	    }

	    @Test
	    public void timkiemTest() {
	        // Arrange
	        NhanVienDAO = new NhanVienDAO();
	       

	        // Act
	        NhanVienModel nhanVien = NhanVienDAO.timkiem("NV002");
	        AssertJUnit.assertNotNull(nhanVien);
	        AssertJUnit.assertEquals(nhanVien.getIdNhanVien(), "NV002");
	       
	    }

	    @Test
	    public void updateTest() {
	  
	    	 NhanVienModel nv = new NhanVienModel("NV002", "01889792499vtV", "Nguyễn Thị B", Date.valueOf("1995-10-20"), true, "0123456789", "email1@gmail.com", "Nhân viên", "Đang làm việc", 10000.00, "CL7");
	    	 int kq =  NhanVienDAO.update(nv);
	     assertEquals(1, kq);
	    	
	    }

	

}

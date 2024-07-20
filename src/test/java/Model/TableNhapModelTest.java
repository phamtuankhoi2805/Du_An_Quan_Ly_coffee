package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TableNhapModelTest {

    @Test
    public void testGetIdNguyenLieu() {
        // Arrange
        TableNhapModel tableNhap = new TableNhapModel("NL001", "Nguyen Lieu A", 50, "Nha Cung Cap X", "0123456789");
        
        // Act
        String idNguyenLieu = tableNhap.getIdNguyenLieu();
        
        // Assert
        Assert.assertEquals(idNguyenLieu, "NL001");
    }

    @Test
    public void testGetTenNguyenLieu() {
        // Arrange
        TableNhapModel tableNhap = new TableNhapModel("NL001", "Nguyen Lieu A", 50, "Nha Cung Cap X", "0123456789");
        
        // Act
        String tenNguyenLieu = tableNhap.getTenNguyenLieu();
        
        // Assert
        Assert.assertEquals(tenNguyenLieu, "Nguyen Lieu A");
    }

    @Test
    public void testGetSoLuongTon() {
        // Arrange
        TableNhapModel tableNhap = new TableNhapModel("NL001", "Nguyen Lieu A", 50, "Nha Cung Cap X", "0123456789");
        
        // Act
        int soLuongTon = tableNhap.getSoLuongTon();
        
        // Assert
        Assert.assertEquals(soLuongTon, 50);
    }

  

    @Test
    public void testGetTenNhaCC() {
        // Arrange
    	  TableNhapModel tableNhap = new TableNhapModel("NL001", "Nguyen Lieu A", 50, "Nha Cung Cap X", "0123456789");
        
        // Act
        String tenNhaCC = tableNhap.getTenNhaCC();
        
        // Assert
        Assert.assertEquals(tenNhaCC, "Nha Cung Cap X");
    }

    @Test
    public void testGetSDT() {
        // Arrange
    	  TableNhapModel tableNhap = new TableNhapModel("NL001", "Nguyen Lieu A", 50, "Nha Cung Cap X", "0123456789");
        
        // Act
        String sdt = tableNhap.getSDT();
        
        // Assert
        Assert.assertEquals(sdt, "0123456789");
    }
}

package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoLuongNguyenLieuModelTest {

    @Test
    public void testGetIdSanPham() {
        // Arrange
        SoLuongNguyenLieuModel soLuongNguyenLieu = new SoLuongNguyenLieuModel("SP001", "NL001", 10);
        
        // Act
        String idSanPham = soLuongNguyenLieu.getIdSanPham();
        
        // Assert
        Assert.assertEquals(idSanPham, "SP001");
    }

    @Test
    public void testGetIdNguyenLieu() {
        // Arrange
        SoLuongNguyenLieuModel soLuongNguyenLieu = new SoLuongNguyenLieuModel("SP001", "NL001", 10);
        
        // Act
        String idNguyenLieu = soLuongNguyenLieu.getIdNguyenLieu();
        
        // Assert
        Assert.assertEquals(idNguyenLieu, "NL001");
    }

    @Test
    public void testGetSoLuongNguyenLieu() {
        // Arrange
        SoLuongNguyenLieuModel soLuongNguyenLieu = new SoLuongNguyenLieuModel("SP001", "NL001", 10);
        
        // Act
        int soLuong = soLuongNguyenLieu.getSoLuongNguyenLieu();
        
        // Assert
        Assert.assertEquals(soLuong, 10);
    }

    @Test
    public void testSetSoLuongNguyenLieu() {
        // Arrange
        SoLuongNguyenLieuModel soLuongNguyenLieu = new SoLuongNguyenLieuModel("SP001", "NL001", 10);
        
        // Act
        soLuongNguyenLieu.setSoLuongNguyenLieu(15);
        
        // Assert
        Assert.assertEquals(soLuongNguyenLieu.getSoLuongNguyenLieu(), 15);
    }
}

package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoaiNguyenLieuModelTest {
    
    @Test
    public void testGetIdNguyenLieu() {
        // Arrange
        LoaiNguyenLieuModel loaiNguyenLieu = new LoaiNguyenLieuModel("1", "Loai A");
        
        // Act
        String idNguyenLieu = loaiNguyenLieu.getIdNguyenLieu();
        
        // Assert
        Assert.assertEquals(idNguyenLieu, "1");
    }
    
    @Test
    public void testGetTenLoaiNguyenLieu() {
        // Arrange
        LoaiNguyenLieuModel loaiNguyenLieu = new LoaiNguyenLieuModel("1", "Loai A");
        
        // Act
        String tenLoaiNguyenLieu = loaiNguyenLieu.getTenLoaiNguyenLieu();
        
        // Assert
        Assert.assertEquals(tenLoaiNguyenLieu, "Loai A");
    }
    
    @Test
    public void testSetIdNguyenLieu() {
        // Arrange
        LoaiNguyenLieuModel loaiNguyenLieu = new LoaiNguyenLieuModel();
        
        // Act
        loaiNguyenLieu.setIdNguyenLieu("2");
        
        // Assert
        Assert.assertEquals(loaiNguyenLieu.getIdNguyenLieu(), "2");
    }
    
    @Test
    public void testSetTenLoaiNguyenLieu() {
        // Arrange
        LoaiNguyenLieuModel loaiNguyenLieu = new LoaiNguyenLieuModel();
        
        // Act
        loaiNguyenLieu.setTenLoaiNguyenLieu("Loai B");
        
        // Assert
        Assert.assertEquals(loaiNguyenLieu.getTenLoaiNguyenLieu(), "Loai B");
    }
}


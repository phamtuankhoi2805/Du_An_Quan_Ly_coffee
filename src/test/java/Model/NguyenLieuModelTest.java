package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NguyenLieuModelTest {

    @Test
    public void testGetIdNguyenLieu() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        String idNguyenLieu = nguyenLieu.getIdNguyenLieu();
        
        // Assert
        Assert.assertEquals(idNguyenLieu, "1");
    }

    @Test
    public void testGetTenNguyenLieu() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        String tenNguyenLieu = nguyenLieu.getTenNguyenLieu();
        
        // Assert
        Assert.assertEquals(tenNguyenLieu, "Nguyen Lieu A");
    }

    @Test
    public void testGetSoLuongTon() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        int soLuongTon = nguyenLieu.getSoLuongTon();
        
        // Assert
        Assert.assertEquals(soLuongTon, 100);
    }

    @Test
    public void testGetDonViTinh() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        String donViTinh = nguyenLieu.getDonViTinh();
        
        // Assert
        Assert.assertEquals(donViTinh, "Kg");
    }

    @Test
    public void testSetSoLuongTon() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        nguyenLieu.setSoLuongTon(200);
        
        // Assert
        Assert.assertEquals(nguyenLieu.getSoLuongTon(), 200);
    }

    @Test
    public void testSetDonViTinh() {
        // Arrange
        NguyenLieuModel nguyenLieu = new NguyenLieuModel("1", "Nguyen Lieu A", 100, "Kg");
        
        // Act
        nguyenLieu.setDonViTinh("Gram");
        
        // Assert
        Assert.assertEquals(nguyenLieu.getDonViTinh(), "Gram");
    }
}


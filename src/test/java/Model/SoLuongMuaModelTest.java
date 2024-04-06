package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoLuongMuaModelTest {

    @Test
    public void testGetIdSanPham() {
        // Arrange
        SoLuongMuaModel soLuongMua = new SoLuongMuaModel("SP001", "DH001", 5);
        
        // Act
        String idSanPham = soLuongMua.getIdSanPham();
        
        // Assert
        Assert.assertEquals(idSanPham, "SP001");
    }

    @Test
    public void testGetIdDonHang() {
        // Arrange
        SoLuongMuaModel soLuongMua = new SoLuongMuaModel("SP001", "DH001", 5);
        
        // Act
        String idDonHang = soLuongMua.getIdDonHang();
        
        // Assert
        Assert.assertEquals(idDonHang, "DH001");
    }

    @Test
    public void testGetSoLuongMua() {
        // Arrange
        SoLuongMuaModel soLuongMua = new SoLuongMuaModel("SP001", "DH001", 5);
        
        // Act
        int soLuong = soLuongMua.getSoLuongMua();
        
        // Assert
        Assert.assertEquals(soLuong, 5);
    }

    @Test
    public void testSetSoLuongMua() {
        // Arrange
        SoLuongMuaModel soLuongMua = new SoLuongMuaModel("SP001", "DH001", 5);
        
        // Act
        soLuongMua.setSoLuongMua(10);
        
        // Assert
        Assert.assertEquals(soLuongMua.getSoLuongMua(), 10);
    }
}


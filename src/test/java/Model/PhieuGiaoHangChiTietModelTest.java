package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhieuGiaoHangChiTietModelTest {

    @Test
    public void testGetIdNguyenLieu() {
        // Arrange
        PhieuGiaoHangChiTietModel phieuGiaoChiTiet = new PhieuGiaoHangChiTietModel("NL001", "PG001", 10);
        
        // Act
        String idNguyenLieu = phieuGiaoChiTiet.getIdNguyenLieu();
        
        // Assert
        Assert.assertEquals(idNguyenLieu, "NL001");
    }

    @Test
    public void testGetIdPhieuGiao() {
        // Arrange
        PhieuGiaoHangChiTietModel phieuGiaoChiTiet = new PhieuGiaoHangChiTietModel("NL001", "PG001", 10);
        
        // Act
        String idPhieuGiao = phieuGiaoChiTiet.getIdPhieuGiao();
        
        // Assert
        Assert.assertEquals(idPhieuGiao, "PG001");
    }

    @Test
    public void testGetSoLuongNlGiao() {
        // Arrange
        PhieuGiaoHangChiTietModel phieuGiaoChiTiet = new PhieuGiaoHangChiTietModel("NL001", "PG001", 10);
        
        // Act
        int soLuongNlGiao = phieuGiaoChiTiet.getSoLuongNlGiao();
        
        // Assert
        Assert.assertEquals(soLuongNlGiao, 10);
    }

    @Test
    public void testSetSoLuongNlGiao() {
        // Arrange
        PhieuGiaoHangChiTietModel phieuGiaoChiTiet = new PhieuGiaoHangChiTietModel("NL001", "PG001", 10);
        
        // Act
        phieuGiaoChiTiet.setSoLuongNlGiao(15);
        
        // Assert
        Assert.assertEquals(phieuGiaoChiTiet.getSoLuongNlGiao(), 15);
    }
}


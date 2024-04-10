package Model;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Date;

public class PhieuGiaoHangModelTest {

    @Test
    public void testGetIdPhieuGiao() {
        // Arrange
        PhieuGiaoHangModel phieuGiaoHang = new PhieuGiaoHangModel("PG001", Date.valueOf("2024-04-06"), "NCC001");

        // Act
        String idPhieuGiao = phieuGiaoHang.getIdPhieuGiao();

        // Assert
        Assert.assertEquals(idPhieuGiao, "PG001");
    }

    @Test
    public void testGetNgayGiaoHang() {
        // Arrange
        PhieuGiaoHangModel phieuGiaoHang = new PhieuGiaoHangModel("PG001", Date.valueOf("2024-04-06"), "NCC001");

        // Act
        Date ngayGiaoHang = phieuGiaoHang.getNgayGiaoHang();

        // Assert
        Assert.assertEquals(ngayGiaoHang, Date.valueOf("2024-04-06"));
    }

    @Test
    public void testGetIdNhaCC() {
        // Arrange
        PhieuGiaoHangModel phieuGiaoHang = new PhieuGiaoHangModel("PG001", Date.valueOf("2024-04-06"), "NCC001");

        // Act
        String idNhaCC = phieuGiaoHang.getIdNhaCC();

        // Assert
        Assert.assertEquals(idNhaCC, "NCC001");
    }

    @Test
    public void testSetNgayGiaoHang() {
        // Arrange
        PhieuGiaoHangModel phieuGiaoHang = new PhieuGiaoHangModel("PG001", Date.valueOf("2024-04-06"), "NCC001");

        // Act
        phieuGiaoHang.setNgayGiaoHang(Date.valueOf("2024-04-07"));

        // Assert
        Assert.assertEquals(phieuGiaoHang.getNgayGiaoHang(), Date.valueOf("2024-04-07"));
    }

    // Similarly, write test methods for other getters and setters...
}


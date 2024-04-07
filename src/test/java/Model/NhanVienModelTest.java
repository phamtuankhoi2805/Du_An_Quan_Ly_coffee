package Model;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Date;

public class NhanVienModelTest {

    @Test
    public void testGetIdNhanVien() {
        // Arrange
        NhanVienModel nhanVien = new NhanVienModel("NV001", "password123", "Nguyen Van A", Date.valueOf("1990-01-01"), true, "0123456789", "nvA@example.com", "Quan ly", "Hoat dong", 1000000.0, "CA001");

        // Act
        String idNhanVien = nhanVien.getIdNhanVien();

        // Assert
        Assert.assertEquals(idNhanVien, "NV001");
    }

    @Test
    public void testGetMatKhau() {
        // Arrange
        NhanVienModel nhanVien = new NhanVienModel("NV001", "password123", "Nguyen Van A", Date.valueOf("1990-01-01"), true, "0123456789", "nvA@example.com", "Quan ly", "Hoat dong", 1000000.0, "CA001");

        // Act
        String matKhau = nhanVien.getMatKhau();

        // Assert
        Assert.assertEquals(matKhau, "password123");
    }

    // Similarly, write test methods for other getters and setters...
}


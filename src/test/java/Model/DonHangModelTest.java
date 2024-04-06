package Model;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Date;

public class DonHangModelTest {

    @Test
    public void testConstructorAndGetters() {
        String idDonHang = "DH001";
        String tenDonHang = "Đơn hàng số 1";
        Date ngayMua = new Date(System.currentTimeMillis());
        String idNhanVien = "NV001";

        DonHangModel donHangModel = new DonHangModel(idDonHang, tenDonHang, ngayMua, idNhanVien);

        Assert.assertEquals(donHangModel.getIdDonHang(), idDonHang);
        Assert.assertEquals(donHangModel.getTenDonHang(), tenDonHang);
        Assert.assertEquals(donHangModel.getNgayMua(), ngayMua);
        Assert.assertEquals(donHangModel.getIdNhanVien(), idNhanVien);
    }

    @Test
    public void testSetters() {
        DonHangModel donHangModel = new DonHangModel();

        String idDonHang = "DH002";
        String tenDonHang = "Đơn hàng số 2";
        Date ngayMua = new Date(System.currentTimeMillis());
        String idNhanVien = "NV002";

        donHangModel.setIdDonHang(idDonHang);
        donHangModel.setTenDonHang(tenDonHang);
        donHangModel.setNgayMua(ngayMua);
        donHangModel.setIdNhanVien(idNhanVien);

        Assert.assertEquals(donHangModel.getIdDonHang(), idDonHang);
        Assert.assertEquals(donHangModel.getTenDonHang(), tenDonHang);
        Assert.assertEquals(donHangModel.getNgayMua(), ngayMua);
        Assert.assertEquals(donHangModel.getIdNhanVien(), idNhanVien);
    }
}


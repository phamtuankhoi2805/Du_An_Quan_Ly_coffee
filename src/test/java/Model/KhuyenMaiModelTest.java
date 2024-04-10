package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KhuyenMaiModelTest {

    @Test
    public void testConstructorAndGetters() {
        String idKhuyenMai = "KM001";
        String tenKhuyenMai = "Giảm giá 10%";
        String dieuKienKM = "Tổng hóa đơn trên 500.000đ";
        float tongTru = 10.0f;

        KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel(idKhuyenMai, tenKhuyenMai, dieuKienKM, tongTru);

        Assert.assertEquals(khuyenMaiModel.getIdKhuyenMai(), idKhuyenMai);
        Assert.assertEquals(khuyenMaiModel.getTenKhuyenMai(), tenKhuyenMai);
        Assert.assertEquals(khuyenMaiModel.getDieuKienKM(), dieuKienKM);
        Assert.assertEquals(khuyenMaiModel.getTongTru(), tongTru);
    }

    @Test
    public void testSetters() {
        KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel();

        String idKhuyenMai = "KM002";
        String tenKhuyenMai = "Giảm giá 20%";
        String dieuKienKM = "Tổng hóa đơn trên 1.000.000đ";
        float tongTru = 20.0f;

        khuyenMaiModel.setIdKhuyenMai(idKhuyenMai);
        khuyenMaiModel.setTenKhuyenMai(tenKhuyenMai);
        khuyenMaiModel.setDieuKienKM(dieuKienKM);
        khuyenMaiModel.setTongTru(tongTru);

        Assert.assertEquals(khuyenMaiModel.getIdKhuyenMai(), idKhuyenMai);
        Assert.assertEquals(khuyenMaiModel.getTenKhuyenMai(), tenKhuyenMai);
        Assert.assertEquals(khuyenMaiModel.getDieuKienKM(), dieuKienKM);
        Assert.assertEquals(khuyenMaiModel.getTongTru(), tongTru);
    }
}


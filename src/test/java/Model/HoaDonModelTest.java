package Model;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Date;

public class HoaDonModelTest {

    @Test
    public void testConstructorAndGetters() {
        String idHoaDon = "HD001";
        int soLuong = 2;
        double donGia = 100.0;
        String khuyenMai = "KM001";
        Date thoiGianMua = new Date(System.currentTimeMillis());
        double thanhTien = 200.0;
        String idSanPham = "SP001";
        String idDonHang = "DH001";
        String idKhuyenMai = "KM001";

        HoaDonModel hoaDonModel = new HoaDonModel(idHoaDon, soLuong, donGia, khuyenMai, thoiGianMua, thanhTien, idSanPham, idDonHang, idKhuyenMai);

        Assert.assertEquals(hoaDonModel.getIdHoaDon(), idHoaDon);
        Assert.assertEquals(hoaDonModel.getSoLuong(), soLuong);
        Assert.assertEquals(hoaDonModel.getDonGia(), donGia);
        Assert.assertEquals(hoaDonModel.getKhuyenMai(), khuyenMai);
        Assert.assertEquals(hoaDonModel.getThoiGianMua(), thoiGianMua);
        Assert.assertEquals(hoaDonModel.getThanhTien(), thanhTien);
        Assert.assertEquals(hoaDonModel.getIdSanPham(), idSanPham);
        Assert.assertEquals(hoaDonModel.getIdDonHang(), idDonHang);
        Assert.assertEquals(hoaDonModel.getIdKhuyenMai(), idKhuyenMai);
    }

    @Test
    public void testSetters() {
        HoaDonModel hoaDonModel = new HoaDonModel();

        String idHoaDon = "HD002";
        int soLuong = 1;
        double donGia = 150.0;
        String khuyenMai = "KM002";
        Date thoiGianMua = new Date(System.currentTimeMillis());
        double thanhTien = 150.0;
        String idSanPham = "SP002";
        String idDonHang = "DH002";
        String idKhuyenMai = "KM002";

        hoaDonModel.setIdHoaDon(idHoaDon);
        hoaDonModel.setSoLuong(soLuong);
        hoaDonModel.setDonGia(donGia);
        hoaDonModel.setKhuyenMai(khuyenMai);
        hoaDonModel.setThoiGianMua(thoiGianMua);
        hoaDonModel.setThanhTien(thanhTien);
        hoaDonModel.setIdSanPham(idSanPham);
        hoaDonModel.setIdDonHang(idDonHang);
        hoaDonModel.setIdKhuyenMai(idKhuyenMai);

        Assert.assertEquals(hoaDonModel.getIdHoaDon(), idHoaDon);
        Assert.assertEquals(hoaDonModel.getSoLuong(), soLuong);
        Assert.assertEquals(hoaDonModel.getDonGia(), donGia);
        Assert.assertEquals(hoaDonModel.getKhuyenMai(), khuyenMai);
        Assert.assertEquals(hoaDonModel.getThoiGianMua(), thoiGianMua);
        Assert.assertEquals(hoaDonModel.getThanhTien(), thanhTien);
        Assert.assertEquals(hoaDonModel.getIdSanPham(), idSanPham);
        Assert.assertEquals(hoaDonModel.getIdDonHang(), idDonHang);
        Assert.assertEquals(hoaDonModel.getIdKhuyenMai(), idKhuyenMai);
    }
}

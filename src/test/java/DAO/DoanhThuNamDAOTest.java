package DAO;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.ThongKeDoanhThuTheoNamModel;

import java.util.ArrayList;

public class DoanhThuNamDAOTest {
	public void getInstanceTest() {
        // Gọi phương thức getInstance() lần đầu tiên
        DoanhThuNamDAO instance1 = DoanhThuNamDAO.getInstance();

        // Kiểm tra xem đối tượng trả về không null
        Assert.assertNotNull(instance1, "Đối tượng không được null");

        // Gọi phương thức getInstance() lần thứ hai
        DoanhThuNamDAO instance2 = DoanhThuNamDAO.getInstance();

        // Kiểm tra xem hai đối tượng trả về có giống nhau không
        Assert.assertSame(instance1, instance2, "Hai đối tượng trả về phải giống nhau");
    }

    @Test
    public void selectAllTest() {
        // Tạo một đối tượng DAO để kiểm thử
        DoanhThuNamDAO doanhThuNamDAO = new DoanhThuNamDAO();

        // Gọi phương thức selectAll để lấy dữ liệu từ cơ sở dữ liệu
        ArrayList<ThongKeDoanhThuTheoNamModel> result = doanhThuNamDAO.selectAll();

        // Kiểm tra xem kết quả trả về có rỗng không
        Assert.assertNotNull(result, "Kết quả không được rỗng");

        // Kiểm tra xem dữ liệu có được trả về chính xác không
        Assert.assertNotEquals(result.size(), 0, "Danh sách kết quả không được rỗng");

        // In kết quả
        for (ThongKeDoanhThuTheoNamModel item : result) {
            System.out.println("Năm: " + item.getNam() + ", Doanh thu: " + item.getDoạnhThu());
        }
    }
}

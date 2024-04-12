package View;
import org.apache.poi.ss.usermodel.*;

import Model.RowData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
 
public class ExcelReader {
    public static void main(String[] args) {
        docExcel();
    }

    public static void docExcel() {
  
        String filePath = "C:\\javvaa\\DuAn1.2\\nhapHang.xlsx"; // Đường dẫn đến tệp Excel

        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            List<RowData> rowDataList = new ArrayList<>();

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                RowData rowData = new RowData();

                Cell idNguyenLieuCell = row.getCell(0);
                rowData.setIdNguyenLieu(idNguyenLieuCell.toString());

                Cell tenNguyenLieuCell = row.getCell(1);
                rowData.setTenNguyenLieu(tenNguyenLieuCell.toString());

                Cell soLuongGiaoCell = row.getCell(2);
                rowData.setSoLuongGiao((int) soLuongGiaoCell.getNumericCellValue());

                Cell donGiaCell = row.getCell(3);
                rowData.setDonGia(donGiaCell.getNumericCellValue());

                Cell donViTinhCell = row.getCell(4);
                rowData.setDonViTinh(donViTinhCell.toString());

                Cell idNhaCCCell = row.getCell(5);
                rowData.setIdNhaCC(idNhaCCCell.toString());

                Cell tenNCCCell = row.getCell(6);
                rowData.setTenNCC(tenNCCCell.toString());

                Cell sdtCell = row.getCell(7);
                rowData.setSdt(sdtCell.toString());

                Cell ngayGiaoCell = row.getCell(8);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                rowData.setNgayGiao(dateFormat.format(ngayGiaoCell.getDateCellValue()));

                Cell tongTienCell = row.getCell(9);
                rowData.setTongTien(tongTienCell.getNumericCellValue());

                rowDataList.add(rowData);
            }

            fis.close();
            workbook.close();

            // Sử dụng danh sách rowDataList để truy cập dữ liệu theo hàng
            for (RowData rowData : rowDataList) {
                System.out.println("ID Nguyên Liệu: " + rowData.getIdNguyenLieu());
                System.out.println("Tên Nguyên Liệu: " + rowData.getTenNguyenLieu());
                System.out.println("Số Lượng Giao: " + rowData.getSoLuongGiao());
                System.out.println("Đơn Giá: " + rowData.getDonGia());
                System.out.println("Đơn Vị Tính: " + rowData.getDonViTinh());
                System.out.println("ID Nhà CC: " + rowData.getIdNhaCC());
                System.out.println("Tên NCC: " + rowData.getTenNCC());
                System.out.println("SDT: " + rowData.getSdt());
                System.out.println("Ngày Giao: " + rowData.getNgayGiao());
                System.out.println("Tổng tiền: " + rowData.getTongTien());
             

       
             
                
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
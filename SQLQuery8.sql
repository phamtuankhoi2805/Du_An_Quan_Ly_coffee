CREATE DATABASE QLCafe
GO
USE QLCafe
GO
-- Bảng Nhân Viên
CREATE TABLE NHANVIEN(
IDNhanVien varchar(10) not null primary key,
MatKhau varchar(20),
TenNV nvarchar(50),
NgaySinh date,
GioiTinh bit,
SDT varchar(11),
Email nvarchar(30),
ChucVu nvarchar(20),
TrangThai nvarchar(20),
LuongCB money,
IDCaLam varchar(10) not null
)
GO
-- Bảng Ca Làm Việc
CREATE TABLE CALAMVIEC(
IDCaLam varchar(10) not null primary key,
TenCaLam nvarchar(20),
ThoiGian varchar(30),
Ngay varchar(30)
)
GO
/*-- Bảng Loại Nguyên Liệu
CREATE TABLE LOAINGUYENLIEU(
IDLoaiNguyenLieu varchar(10) not null primary key,
TenLoaiNguyenLieu nvarchar(20)
)
GO*/
--Bảng Nguyên Liệu
CREATE TABLE NGUYENLIEU(
IDNguyenLieu varchar(10) not null primary key,
TenNguyenLieu nvarchar(20),
SoLuongTon int,
DonViTinh nvarchar(20)
)
GO
-- Bảng Phiếu xuất hàng (Số lượng nguyên liệu lấy ra )
CREATE TABLE PHIEUXUATHANG(
IDPhieuXuat varchar(10) not null primary key,
SoLuongNLXuatRa int,
NgayXuat date,
IDNguyenLieu varchar(10) not null,
IDNhanVien varchar(10) not null
)
GO
--Bảng Đơn Hàng
CREATE TABLE DONHANG(
IDDonHang varchar(10) not null primary key,
NgayMuaHang date,
IDNhanVien varchar(10) not null
)
GO
-- Bảng Sản Phẩm
CREATE TABLE SANPHAM(
IDSanPham varchar(10) not null primary key,
TenSP nvarchar(30),
GiaBan money,
Hinh varchar(50),
LoaiSP nvarchar(50)
)
GO
-- Bảng Số Lượng Mua (Số lượng mua của các sản phẩm trong đơn hàng)
CREATE TABLE CHITIETDONHANG(
IDSanPham varchar(10) not null,
IDDonHang varchar(10) not null,
SoLuongMua int,
primary key(IDSanPham,IDDonHang)
)
GO
--Bảng Chi tiết hoá đơn
CREATE TABLE CHITIETHOADON(
IDSanPham varchar(10) not null,
IDDonHang varchar(10) not null,
IDHoaDon varchar(10) not null,
TongTienSP money,
primary key(IDSanPham,IDDonHang,IDHoaDon)
)
GO
-- Bảng Hoá Đơn
CREATE TABLE HOADON(
IDHoaDon varchar(10) not null primary key,
NgayLapHD date,
IDKhuyenMai varchar(10)
)
GO
-- Bảng Khuyến Mãi
CREATE TABLE KHUYENMAI(
IDKhuyenMai varchar(10) not null primary key,
TenKM nvarchar(50),
DieuKienKM nvarchar(125),
TongTru float
)
GO
-- Bảng Nhà Cung Cấp
CREATE TABLE NHACUNGCAP(
IDNhaCC varchar(10) not null primary key,
TenNhaCC nvarchar(30),
DiaChi nvarchar(125),
SDT varchar(11)
)
GO
-- Bảng Phiếu Giao Hàng
CREATE TABLE PHIEUGIAOHANG(
IDPhieuGiao varchar(10) not null primary key,
NgayGiaoHang date,
TongTienGiaoHang money,
IDNhaCC varchar(10) not null
)
GO
-- Bảng Phiếu Giao Hàng Chi Tiết
CREATE TABLE PHIEUGIAOHANGCHITIET(
IDNguyenLieu varchar(10) not null,
IDPhieuGiao varchar(10) not null,
SoLuongNLGiao int,
DonGiaNL money,
primary key(IDNguyenLieu,IDPhieuGiao)
)
GO
-- Bảng Phiếu đặt hàng
CREATE TABLE PHIEUDATHANG(
IDPhieuDatHang varchar(10) not null primary key,
NgayDatHang date,
IDNhaCC varchar(10),
IDNhanVien varchar(10)
)
GO
--Bảng Phiếu đặt hàng chi tiết
CREATE TABLE PHIEUDATHANGCHITIET(
IDPhieuDatHang varchar(10) not null,
IDNguyenLieu varchar(10) not null,
SoLuongDat int,
primary key(IDPhieuDatHang,IDNguyenLieu)
)
GO
-- Tạo khoá ngoại Bảng Nhân Viên
ALTER TABLE NHANVIEN
ADD CONSTRAINT FK_NhanVien_CaLam FOREIGN KEY (IDCaLam) REFERENCES CALAMVIEC(IDCaLam)
GO
-- Tạo khoá ngoại Bảng Đơn Hàng
ALTER TABLE DONHANG
ADD CONSTRAINT FK_DonHang_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien)
GO
-- Tạo khoá ngoại Chi tiết đơn hàng
ALTER TABLE CHITIETDONHANG
ADD CONSTRAINT FK_ChiTietDH_SanPham FOREIGN KEY (IDSanPham) REFERENCES SANPHAM(IDSanPham),
	CONSTRAINT FK_ChiTietDH_DonHang FOREIGN KEY (IDDonHang) REFERENCES DONHANG(IDDonHang)
GO
-- Tạo khoá ngoại Hoá Đơn
ALTER TABLE HOADON
ADD CONSTRAINT FK_HoaDon_KhuyenMai FOREIGN KEY (IDKhuyenMai) REFERENCES KHUYENMAI(IDKhuyenMai)
GO
-- Tạo khoá ngoại CHi tiết hoá đơn
ALTER TABLE CHITIETHOADON
ADD CONSTRAINT FK_HoaDonCT_SanPham FOREIGN KEY (IDSanPham) REFERENCES SANPHAM(IDSanPham),
	CONSTRAINT FK_HoaDonCT_DonHang FOREIGN KEY (IDDonHang) REFERENCES DONHANG(IDDonHang),
	CONSTRAINT FK_HoaDonCT_HoaDon FOREIGN KEY (IDHoaDon) REFERENCES HOADON(IDHoaDon)
GO
-- Tạo khoá ngoại Phiếu Xuất Hàng
ALTER TABLE PHIEUXUATHANG
ADD CONSTRAINT FK_PhieuXuat_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien),
	CONSTRAINT FK_PhieuXuat_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu)
GO
-- Tạo khoá ngoại Bảng Phiếu Giao Hàng
ALTER TABLE PHIEUGIAOHANG
ADD CONSTRAINT FK_PhieuGH_NhaCC FOREIGN KEY (IDNhaCC) REFERENCES NHACUNGCAP(IDNhaCC)
GO
-- Tạo khoá ngoại Phiếu Giao Hàng Chi Tiết
ALTER TABLE PHIEUGIAOHANGCHITIET
ADD CONSTRAINT FK_PhieuGHCT_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu),
	CONSTRAINT FK_PhieuGHCT_PhieuGH FOREIGN KEY (IDPhieuGiao) REFERENCES PHIEUGIAOHANG(IDPhieuGiao)
GO
-- Tạo khoá ngoại Phiếu Đặt Hàng
ALTER TABLE PHIEUDATHANG
ADD CONSTRAINT FK_PhieuDH_NhaCC FOREIGN KEY (IDNhaCC) REFERENCES NHACUNGCAP(IDNhaCC),
	CONSTRAINT FK_PhieuDH_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien)
GO
-- Tạo khoá ngoại Phiếu Đặt Hàng Chi Tiết
ALTER TABLE PHIEUDATHANGCHITIET
ADD CONSTRAINT FK_PhieuDHCT_PhieuDH FOREIGN KEY (IDPhieuDatHang) REFERENCES PHIEUDATHANG(IDPhieuDatHang),
	CONSTRAINT FK_PhieuDHCT_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu)
GO
-- Trigger update số lượng tồn trong bảng nguyên liệu (SoLuongTon = SoLuongTon + SoLuongNLGiao)
CREATE OR ALTER TRIGGER Update_SoLuongTon
ON PHIEUGIAOHANGCHITIET
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update SoLuongTon trong bảng NGUYENLIEU
    UPDATE NGUYENLIEU
    SET SoLuongTon = NGUYENLIEU.SoLuongTon + inserted.SoLuongNLGiao
    FROM NGUYENLIEU
    INNER JOIN inserted ON NGUYENLIEU.IDNguyenLieu = inserted.IDNguyenLieu;
END
GO
-- Trigger update số lượng tồn trong bảng nguyên liệu (SoLuongTon = SoLuongTon - SoLuongNLXuatRa)
CREATE OR ALTER TRIGGER Update_SoLuongTon_SLNLXuatRa
ON PHIEUXUATHANG
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update SoLuongTon trong bảng NGUYENLIEU
    UPDATE NGUYENLIEU
    SET SoLuongTon = NGUYENLIEU.SoLuongTon - inserted.SoLuongNLXuatRa
    FROM NGUYENLIEU
    INNER JOIN inserted ON NGUYENLIEU.IDNguyenLieu = inserted.IDNguyenLieu;
END
GO
-- Procedure thống kê doanh thu theo tháng
--Lệnh chạy: EXEC ThongKeDoanhThuTheoThang;

CREATE PROCEDURE ThongKeDoanhThuTheoThang
AS
BEGIN
    SET NOCOUNT ON;

    -- Tạo bảng tạm thời để lưu kết quả
    CREATE TABLE #DoanhThuTheoThang (
        ThangNam VARCHAR(7),
        TongDoanhThu MONEY
    );

    -- Chèn dữ liệu doanh thu vào bảng tạm thời
    INSERT INTO #DoanhThuTheoThang (ThangNam, TongDoanhThu)
    SELECT 
        CONVERT(VARCHAR(7), NgayLapHD, 120) AS ThangNam,
        SUM(CASE
                WHEN TongTienDH >= 1000000 THEN TongTienDH * 0.6
                WHEN TongTienDH >= 500000 THEN TongTienDH * 0.7
                WHEN TongTienDH >= 300000 THEN TongTienDH * 0.8
                WHEN TongTienDH >= 100000 THEN TongTienDH * 0.9
                ELSE TongTienDH
            END) AS TongDoanhThu
    FROM 
        HOADON
    JOIN 
        (SELECT IDHoaDon, SUM(TongTienSP) AS TongTienDH
         FROM CHITIETHOADON 
         GROUP BY IDHoaDon) CTHD ON HOADON.IDHoaDon = CTHD.IDHoaDon
    GROUP BY 
        CONVERT(VARCHAR(7), NgayLapHD, 120);

    -- Hiển thị kết quả
    SELECT * FROM #DoanhThuTheoThang;

    -- Bỏ bảng tạm thời
    DROP TABLE #DoanhThuTheoThang;
END;
GO
--Procedure thống kê doanh thu theo năm
--Lệnh chạy: EXEC ThongKeDoanhThuTheoNam
 CREATE PROCEDURE ThongKeDoanhThuTheoNam
AS
BEGIN
    SET NOCOUNT ON;

    -- Tạo bảng tạm thời để lưu kết quả
    CREATE TABLE #DoanhThuTheoNam (
        Nam INT,
        TongDoanhThu MONEY
    );

    -- Chèn dữ liệu doanh thu vào bảng tạm thời
    INSERT INTO #DoanhThuTheoNam (Nam, TongDoanhThu)
    SELECT 
        YEAR(NgayLapHD) AS Nam,
        SUM(CASE
                WHEN TongTienDH >= 1000000 THEN TongTienDH * 0.6
                WHEN TongTienDH >= 500000 THEN TongTienDH * 0.7
                WHEN TongTienDH >= 300000 THEN TongTienDH * 0.8
                WHEN TongTienDH >= 100000 THEN TongTienDH * 0.9
                ELSE TongTienDH
            END) AS TongDoanhThu
    FROM 
        HOADON
    JOIN 
        (SELECT IDHoaDon, SUM(TongTienSP) AS TongTienDH
         FROM CHITIETHOADON 
         GROUP BY IDHoaDon) CTHD ON HOADON.IDHoaDon = CTHD.IDHoaDon
    GROUP BY 
        YEAR(NgayLapHD);

    -- Hiển thị kết quả
    SELECT * FROM #DoanhThuTheoNam;

    -- Bỏ bảng tạm thời
    DROP TABLE #DoanhThuTheoNam;
END
GO
-- Chèn dữ liệu vào bảng CALAMVIEC
INSERT INTO CALAMVIEC (IDCaLam, TenCaLam, ThoiGian, Ngay)
VALUES 
('CL001', N'Ca sáng', '08:00 - 12:59','2023-01-01'),
('CL002', N'Ca chiều', '13:00 - 17:59','2023-01-01'),
('CL003', N'Ca tối', '18:00 - 21:59','2023-01-01'),
('CL004', N'Ca đêm', '22:00 - 7:59','2023-01-01'),
('CL005', N'Ca linh hoạt', NULL,'2023-01-01')
GO
-- Chèn dữ liệu vào bảng NHANVIEN
INSERT INTO NHANVIEN (IDNhanVien, MatKhau, TenNV, NgaySinh, GioiTinh, SDT, Email, ChucVu, TrangThai, LuongCB, IDCaLam)
VALUES 
('NV001', 'quanly', N'Trần Văn A', '1990-05-15', 1, '0987654321', 'avt@gmail.com', N'Quản lý', N'Đang làm việc', 100000, 'CL001'),
('NV002', 'nhanvien', N'Nguyễn Thị B', '1995-10-20', 0, '0123456789', 'bnt@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL002'),
('NV003', 'nhanvien', N'Lê Văn C', '1988-12-10', 1, '0999999999', 'clv@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL003'),
('NV004', 'nhanvien', N'Hồ Thị D', '1992-04-25', 0, '0977777777', 'dht@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL001'),
('NV005', 'nhanvien', N'Phạm Văn E', '1997-09-30', 1, '0966666666', 'epv@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL002')
GO
-- Chèn dữ liệu vào bảng NGUYENLIEU
INSERT INTO NGUYENLIEU (IDNguyenLieu, TenNguyenLieu, SoLuongTon, DonViTinh)
VALUES 
('NL001', N'Ca cao', 10, 'Kg'),
('NL002', N'Cam', 50, 'Kg'),
('NL003', N'Dưa hấu', 20, 'Kg'),
('NL004', N'Nước khoáng', 50, 'Chai'),
('NL005', N'Ly nhựa', 150, N'Cái')
GO
-- Chèn dữ liệu vào bảng SANPHAM
INSERT INTO SANPHAM (IDSanPham, TenSP, GiaBan, Hinh,LoaiSP)
VALUES 
('SP001', N'Cà phê đen', 25000, NULL, 'Coffee'),
('SP002', N'Cà phê sữa', 30000, NULL, 'Coffee'),
('SP003', 'Sting', 15000, NULL, N'Tăng lực'),
('SP004', N'Cam Ép', 10000, NULL, N'Nước Trái Cây'),
('SP005', N'Sinh Tố Dưa Hấu', 35000, NULL, N'Nước Trái Cây')
GO
-- Chèn dữ liệu vào bảng Phiếu xuất hàng
INSERT INTO PHIEUXUATHANG(IDPhieuXuat, SoLuongNLXuatRa, NgayXuat, IDNguyenLieu, IDNhanVien)
VALUES 
('PX001',10, '2023-01-01', 'NL001','NV001'),
('PX002',20, '2023-01-01', 'NL002','NV001'),
('PX003',15, '2023-03-01', 'NL001','NV002'),
('PX004',10, '2023-04-01', 'NL003','NV002'),
('PX005',10, '2023-05-01', 'NL004','NV003')
GO
-- Chèn dữ liệu vào bảng DONHANG
INSERT INTO DONHANG (IDDonHang, NgayMuaHang, IDNhanVien)
VALUES 
('DH001', '2022-01-02', 'NV001'),
('DH002', '2022-01-03', 'NV002'),
('DH003', '2022-01-04', 'NV003'),
('DH004', '2022-02-01', 'NV004'),
('DH005', '2022-02-02', 'NV005'),
('DH006', '2022-02-03', 'NV005'),
('DH007', '2022-02-03', 'NV005'),
('DH008', '2022-03-01', 'NV005'),
('DH009', '2022-03-01', 'NV005'),
('DH010', '2022-03-02', 'NV001'),
('DH011', '2022-04-01', 'NV001'),
('DH012', '2022-04-04', 'NV001'),
('DH013', '2022-04-05', 'NV003'),
('DH014', '2022-05-01', 'NV003'),
('DH015', '2022-05-02', 'NV003'),
('DH016', '2022-05-03', 'NV004'),
('DH017', '2022-06-01', 'NV004'),
('DH018', '2022-06-01', 'NV004'),
('DH019', '2022-06-02', 'NV002'),
('DH020', '2022-07-01', 'NV002'),
('DH021', '2022-07-02', 'NV001'),
('DH022', '2022-07-03', 'NV002'),
('DH023', '2022-08-04', 'NV003'),
('DH024', '2022-08-05', 'NV004'),
('DH025', '2022-08-06', 'NV005'),
('DH026', '2022-09-02', 'NV005'),
('DH027', '2022-09-03', 'NV005'),
('DH028', '2022-09-04', 'NV005'),
('DH029', '2022-10-01', 'NV005'),
('DH030', '2022-10-02', 'NV001'),
('DH031', '2022-10-03', 'NV001'),
('DH032', '2022-11-04', 'NV001'),
('DH033', '2022-11-05', 'NV003'),
('DH034', '2022-11-06', 'NV003'),
('DH035', '2022-12-02', 'NV003'),
('DH036', '2022-12-03', 'NV004'),
('DH037', '2022-12-04', 'NV004'),
('DH038', '2023-01-01', 'NV004'),
('DH039', '2023-01-02', 'NV002'),
('DH040', '2023-01-03', 'NV002'),
('DH041', '2023-02-02', 'NV001'),
('DH042', '2023-02-03', 'NV002'),
('DH043', '2023-02-04', 'NV003'),
('DH044', '2023-03-01', 'NV004'),
('DH045', '2023-03-01', 'NV005'),
('DH046', '2023-03-02', 'NV005'),
('DH047', '2023-04-03', 'NV005'),
('DH048', '2023-04-04', 'NV005'),
('DH049', '2023-04-05', 'NV005'),
('DH050', '2023-05-02', 'NV001'),
('DH051', '2023-05-03', 'NV001'),
('DH052', '2023-05-04', 'NV001'),
('DH053', '2023-06-01', 'NV003'),
('DH054', '2023-06-01', 'NV003'),
('DH055', '2023-06-02', 'NV003'),
('DH056', '2023-07-03', 'NV004'),
('DH057', '2023-07-04', 'NV004'),
('DH058', '2023-07-05', 'NV004'),
('DH059', '2023-08-02', 'NV002'),
('DH060', '2023-08-03', 'NV002'),
('DH061', '2023-08-04', 'NV001'),
('DH062', '2023-09-03', 'NV002'),
('DH063', '2023-09-04', 'NV003'),
('DH064', '2023-09-05', 'NV004'),
('DH065', '2023-10-01', 'NV005'),
('DH066', '2023-10-02', 'NV005'),
('DH067', '2023-10-03', 'NV005'),
('DH068', '2023-11-01', 'NV005'),
('DH069', '2023-11-01', 'NV005'),
('DH070', '2023-11-02', 'NV001'),
('DH071', '2023-12-03', 'NV001'),
('DH072', '2023-12-04', 'NV001'),
('DH073', '2023-12-05', 'NV003'),
('DH074', '2024-01-01', 'NV003'),
('DH075', '2024-01-02', 'NV003'),
('DH076', '2024-01-03', 'NV004'),
('DH077', '2024-02-01', 'NV004'),
('DH078', '2024-02-01', 'NV004'),
('DH079', '2024-02-02', 'NV002'),
('DH080', '2024-03-01', 'NV002'),
('DH081', '2024-03-02', 'NV001'),
('DH082', '2024-03-03', 'NV002'),
('DH083', '2024-04-01', 'NV003'),
('DH084', '2024-04-02', 'NV004'),
('DH085', '2024-04-03', 'NV005'),
('DH086', '2024-05-02', 'NV005'),
('DH087', '2024-05-03', 'NV005'),
('DH088', '2024-05-04', 'NV005'),
('DH089', '2024-06-01', 'NV005'),
('DH090', '2024-06-02', 'NV001'),
('DH091', '2024-06-03', 'NV001'),
('DH092', '2024-07-04', 'NV001'),
('DH093', '2024-07-05', 'NV003'),
('DH094', '2024-07-06', 'NV003'),
('DH095', '2024-08-02', 'NV003'),
('DH096', '2024-08-03', 'NV004'),
('DH097', '2024-08-04', 'NV004'),
('DH098', '2024-08-05', 'NV004'),
('DH099', '2024-09-02', 'NV002'),
('DH100', '2024-09-03', 'NV002'),
('DH101', '2024-09-04', 'NV001'),
('DH102', '2024-10-01', 'NV002'),
('DH103', '2024-10-02', 'NV003'),
('DH104', '2024-10-03', 'NV004'),
('DH105', '2024-11-01', 'NV005'),
('DH106', '2024-11-02', 'NV005'),
('DH107', '2024-11-03', 'NV005'),
('DH108', '2024-12-01', 'NV005'),
('DH109', '2024-12-02', 'NV005'),
('DH110', '2024-12-03', 'NV005')
GO
-- Chèn dữ liệu vào bảng CHITIETDONHANG
INSERT INTO CHITIETDONHANG (IDSanPham, IDDonHang, SoLuongMua)
VALUES 
('SP001', 'DH001', 3),
('SP002', 'DH002', 2),
('SP002', 'DH003', 1),
('SP003', 'DH004', 5),
('SP004', 'DH005', 1),
('SP003', 'DH005', 1),
('SP001', 'DH005', 1),
('SP002', 'DH006', 5),
('SP002', 'DH007', 1),
('SP004', 'DH007', 1),
('SP003', 'DH007', 1),
('SP003', 'DH008', 1),
('SP001', 'DH009', 2),
('SP003', 'DH010', 1),
('SP003', 'DH011', 1),
('SP005', 'DH011', 1),
('SP003', 'DH012', 2),
('SP003', 'DH013', 1),
('SP002', 'DH014', 1),
('SP003', 'DH015', 1),
('SP004', 'DH016', 1),
('SP001', 'DH017', 1),
('SP002', 'DH018', 1),
('SP003', 'DH019', 1),
('SP005', 'DH020', 1),
('SP002', 'DH021', 1),
('SP001', 'DH022', 1),
('SP002', 'DH023', 1),
('SP003', 'DH024', 1),
('SP004', 'DH025', 1),
('SP005', 'DH026', 1),
('SP001', 'DH027', 1),
('SP002', 'DH028', 1),
('SP003', 'DH029', 1),
('SP004', 'DH030', 1),
('SP005', 'DH031', 1),
('SP001', 'DH032', 1),
('SP002', 'DH033', 1),
('SP003', 'DH034', 1),
('SP004', 'DH035', 1),
('SP005', 'DH036', 1),
('SP001', 'DH037', 1),
('SP002', 'DH038', 1),
('SP003', 'DH039', 1),
('SP004', 'DH040', 1),
('SP002', 'DH041', 1),
('SP001', 'DH042', 1),
('SP002', 'DH043', 1),
('SP003', 'DH044', 1),
('SP004', 'DH045', 1),
('SP005', 'DH046', 1),
('SP001', 'DH047', 1),
('SP002', 'DH048', 1),
('SP003', 'DH049', 1),
('SP004', 'DH050', 1),
('SP005', 'DH051', 1),
('SP001', 'DH052', 1),
('SP002', 'DH053', 1),
('SP003', 'DH054', 1),
('SP004', 'DH055', 1),
('SP005', 'DH056', 1),
('SP001', 'DH057', 1),
('SP002', 'DH058', 1),
('SP003', 'DH059', 1),
('SP004', 'DH060', 1),
('SP002', 'DH061', 1),
('SP001', 'DH062', 1),
('SP002', 'DH063', 1),
('SP003', 'DH064', 1),
('SP004', 'DH065', 1),
('SP005', 'DH066', 1),
('SP001', 'DH067', 1),
('SP002', 'DH068', 1),
('SP003', 'DH069', 1),
('SP004', 'DH070', 1),
('SP005', 'DH071', 1),
('SP001', 'DH072', 1),
('SP002', 'DH073', 1),
('SP003', 'DH074', 1),
('SP004', 'DH075', 1),
('SP005', 'DH076', 1),
('SP001', 'DH077', 1),
('SP002', 'DH078', 1),
('SP003', 'DH079', 1),
('SP004', 'DH080', 1),
('SP002', 'DH081', 1),
('SP001', 'DH082', 1),
('SP002', 'DH083', 1),
('SP003', 'DH084', 1),
('SP004', 'DH085', 1),
('SP005', 'DH086', 1),
('SP001', 'DH087', 1),
('SP002', 'DH088', 1),
('SP003', 'DH089', 1),
('SP004', 'DH090', 1),
('SP005', 'DH091', 1),
('SP001', 'DH092', 1),
('SP002', 'DH093', 1),
('SP003', 'DH094', 1),
('SP004', 'DH095', 1),
('SP005', 'DH096', 1),
('SP001', 'DH097', 1),
('SP002', 'DH098', 1),
('SP003', 'DH099', 1),
('SP004', 'DH100', 1),
('SP001', 'DH101', 1),
('SP002', 'DH102', 1),
('SP003', 'DH103', 1),
('SP004', 'DH104', 1),
('SP005', 'DH105', 1),
('SP001', 'DH106', 1),
('SP002', 'DH107', 1),
('SP003', 'DH108', 1),
('SP004', 'DH109', 1),
('SP005', 'DH110', 1)
GO
-- Chèn dữ liệu vào bảng KHUYENMAI
INSERT INTO KHUYENMAI (IDKhuyenMai, TenKM ,DieuKienKM, TongTru)
VALUES 
('KM001', N'Giảm 10%', N'Trên đơn hàng có giá trị từ 100.000 đồng trở lên', 0.1),
('KM002', N'Giảm 20%', N'Trên đơn hàng có giá trị từ 300.000 đồng trở lên', 0.2),
('KM003', N'Giảm 30%', N'Trên đơn hàng có giá trị từ 500.000 đồng trở lên', 0.3),
('KM004', N'Giảm 40%', N'Trên đơn hàng có giá trị từ 1.000.000 đồng trở lên', 0.4)
GO
-- Chèn dữ liệu vào bảng HOADON
INSERT INTO HOADON (IDHoaDon, NgayLapHD, IDKhuyenMai)
VALUES 
('HD001', '2022-01-02', NULL),
('HD002', '2022-01-03', NULL),
('HD003', '2022-01-04', NULL),
('HD004', '2022-02-01', NULL),
('HD005', '2022-02-02', 'KM001'),
('HD006', '2022-02-03', 'KM001'),
('HD007', '2022-02-03', NULL),
('HD008', '2022-03-01', NULL),
('HD009', '2022-03-01', NULL),
('HD010', '2022-03-02', NULL),
('HD011', '2022-04-01', NULL),
('HD012', '2022-04-04', NULL),
('HD013', '2022-04-05', NULL),
('HD014', '2022-05-01', NULL),
('HD015', '2022-05-02', NULL),
('HD016', '2022-05-03', NULL),
('HD017', '2022-06-01', NULL),
('HD018', '2022-06-01', NULL),
('HD019', '2022-06-02', NULL),
('HD020', '2022-07-01', NULL),
('HD021', '2022-07-02', NULL),
('HD022', '2022-07-03', NULL),
('HD023', '2022-08-04', NULL),
('HD024', '2022-08-05', NULL),
('HD025', '2022-08-06', NULL),
('HD026', '2022-09-02', NULL),
('HD027', '2022-09-03', NULL),
('HD028', '2022-09-04', NULL),
('HD029', '2022-10-01', NULL),
('HD030', '2022-10-02', NULL),
('HD031', '2022-10-03', NULL),
('HD032', '2022-11-04', NULL),
('HD033', '2022-11-05', NULL),
('HD034', '2022-11-06', NULL),
('HD035', '2022-12-02', NULL),
('HD036', '2022-12-03', NULL),
('HD037', '2022-12-04', NULL),
('HD038', '2023-01-01', NULL),
('HD039', '2023-01-02', NULL),
('HD040', '2023-01-03', NULL),
('HD041', '2023-02-02', NULL),
('HD042', '2023-02-03', NULL),
('HD043', '2023-02-04', NULL),
('HD044', '2023-03-01', NULL),
('HD045', '2023-03-01', NULL),
('HD046', '2023-03-02', NULL),
('HD047', '2023-04-03', NULL),
('HD048', '2023-04-04', NULL),
('HD049', '2023-04-05', NULL),
('HD050', '2023-05-02', NULL),
('HD051', '2023-05-03', NULL),
('HD052', '2023-05-04', NULL),
('HD053', '2023-06-01', NULL),
('HD054', '2023-06-01', NULL),
('HD055', '2023-06-02', NULL),
('HD056', '2023-07-03', NULL),
('HD057', '2023-07-04', NULL),
('HD058', '2023-07-05', NULL),
('HD059', '2023-08-02', NULL),
('HD060', '2023-08-03', NULL),
('HD061', '2023-08-04', NULL),
('HD062', '2023-09-03', NULL),
('HD063', '2023-09-04', NULL),
('HD064', '2023-09-05', NULL),
('HD065', '2023-10-01', NULL),
('HD066', '2023-10-02', NULL),
('HD067', '2023-10-03', NULL),
('HD068', '2023-11-01', NULL),
('HD069', '2023-11-01', NULL),
('HD070', '2023-11-02', NULL),
('HD071', '2023-12-03', NULL),
('HD072', '2023-12-04', NULL),
('HD073', '2023-12-05', NULL),
('HD074', '2024-01-01', NULL),
('HD075', '2024-01-02', NULL),
('HD076', '2024-01-03', NULL),
('HD077', '2024-02-01', NULL),
('HD078', '2024-02-01', NULL),
('HD079', '2024-02-02', NULL),
('HD080', '2024-03-01', NULL),
('HD081', '2024-03-02', NULL),
('HD082', '2024-03-03', NULL),
('HD083', '2024-04-01', NULL),
('HD084', '2024-04-02', NULL),
('HD085', '2024-04-03', NULL),
('HD086', '2024-05-02', NULL),
('HD087', '2024-05-03', NULL),
('HD088', '2024-05-04', NULL),
('HD089', '2024-06-01', NULL),
('HD090', '2024-06-02', NULL),
('HD091', '2024-06-03', NULL),
('HD092', '2024-07-04', NULL),
('HD093', '2024-07-05', NULL),
('HD094', '2024-07-06', NULL),
('HD095', '2024-08-02', NULL),
('HD096', '2024-08-03', NULL),
('HD097', '2024-08-04', NULL),
('HD098', '2024-08-05', NULL),
('HD099', '2024-09-02', NULL),
('HD100', '2024-09-03', NULL),
('HD101', '2024-09-04', NULL),
('HD102', '2024-10-01', NULL),
('HD103', '2024-10-02', NULL),
('HD104', '2024-10-03', NULL),
('HD105', '2024-11-01', NULL),
('HD106', '2024-11-02', NULL),
('HD107', '2024-11-03', NULL),
('HD108', '2024-12-01', NULL),
('HD109', '2024-12-02', NULL),
('HD110', '2024-12-03', NULL)
GO
--Chèn dữ liệu vào bảng CHITIETHOADON
INSERT INTO CHITIETHOADON(IDSanPham, IDDonHang, IDHoaDon, TongTienSP) VALUES
('SP001', 'DH001', 'HD001', 75000),
('SP002', 'DH002', 'HD002', 60000),
('SP002', 'DH003', 'HD003', 30000),
('SP003', 'DH004', 'HD004',	75000),
('SP004', 'DH005', 'HD005', 10000),
('SP003', 'DH005', 'HD005', 150000),
('SP001', 'DH005', 'HD005', 25000),
('SP002', 'DH006', 'HD006', 150000),
('SP002', 'DH007', 'HD007', 30000),
('SP004', 'DH007', 'HD007', 10000),
('SP003', 'DH007', 'HD007', 15000),
('SP003', 'DH008', 'HD008', 15000),
('SP001', 'DH009', 'HD009', 50000),
('SP003', 'DH010', 'HD010', 15000),
('SP003', 'DH011', 'HD011', 15000),
('SP005', 'DH011', 'HD011', 35000),
('SP003', 'DH012', 'HD012', 30000),
('SP003', 'DH013', 'HD013', 15000),
('SP002', 'DH014', 'HD014', 30000),
('SP003', 'DH015', 'HD015', 15000),
('SP004', 'DH016', 'HD016', 10000),
('SP001', 'DH017', 'HD017', 25000),
('SP002', 'DH018', 'HD018', 30000),
('SP003', 'DH019', 'HD019', 15000),
('SP005', 'DH020', 'HD020', 35000),
('SP002', 'DH021', 'HD021', 30000),
('SP001', 'DH022', 'HD022', 25000),
('SP002', 'DH023', 'HD023', 30000),
('SP003', 'DH024', 'HD024', 15000),
('SP004', 'DH025', 'HD025', 10000),
('SP005', 'DH026', 'HD026', 35000),
('SP001', 'DH027', 'HD027', 25000),
('SP002', 'DH028', 'HD028', 30000),
('SP003', 'DH029', 'HD029', 15000),
('SP004', 'DH030', 'HD030', 10000),
('SP005', 'DH031', 'HD031', 35000),
('SP001', 'DH032', 'HD032', 25000),
('SP002', 'DH033', 'HD033', 30000),
('SP003', 'DH034', 'HD034', 15000),
('SP004', 'DH035', 'HD035', 10000),
('SP005', 'DH036', 'HD036', 35000),
('SP001', 'DH037', 'HD037', 25000),
('SP002', 'DH038', 'HD038', 30000),
('SP003', 'DH039', 'HD039', 15000),
('SP004', 'DH040', 'HD040', 10000),
('SP005', 'DH041', 'HD041', 35000),
('SP001', 'DH042', 'HD042', 25000),
('SP002', 'DH043', 'HD043', 30000),
('SP003', 'DH044', 'HD044', 15000),
('SP004', 'DH045', 'HD045', 10000),
('SP005', 'DH046', 'HD046', 35000),
('SP001', 'DH047', 'HD047', 25000),
('SP002', 'DH048', 'HD048', 30000),
('SP003', 'DH049', 'HD049', 15000),
('SP004', 'DH050', 'HD050', 10000),
('SP005', 'DH051', 'HD051', 35000),
('SP001', 'DH052', 'HD052', 25000),
('SP002', 'DH053', 'HD053', 30000),
('SP003', 'DH054', 'HD054', 15000),
('SP004', 'DH055', 'HD055', 10000),
('SP005', 'DH056', 'HD056', 35000),
('SP001', 'DH057', 'HD057', 25000),
('SP002', 'DH058', 'HD058', 30000),
('SP003', 'DH059', 'HD059', 15000),
('SP004', 'DH060', 'HD060', 10000),
('SP005', 'DH061', 'HD061', 35000),
('SP001', 'DH062', 'HD062', 25000),
('SP002', 'DH063', 'HD063', 30000),
('SP003', 'DH064', 'HD064', 15000),
('SP004', 'DH065', 'HD065', 10000),
('SP005', 'DH066', 'HD066', 35000),
('SP001', 'DH067', 'HD067', 25000),
('SP002', 'DH068', 'HD068', 30000),
('SP003', 'DH069', 'HD069', 15000),
('SP004', 'DH070', 'HD070', 10000),
('SP005', 'DH071', 'HD071', 35000),
('SP001', 'DH072', 'HD072', 25000),
('SP002', 'DH073', 'HD073', 30000),
('SP003', 'DH074', 'HD074', 15000),
('SP004', 'DH075', 'HD075', 10000),
('SP005', 'DH076', 'HD076', 35000),
('SP001', 'DH077', 'HD077', 25000),
('SP002', 'DH078', 'HD078', 30000),
('SP003', 'DH079', 'HD079', 15000),
('SP004', 'DH080', 'HD080', 10000),
('SP005', 'DH081', 'HD081', 35000),
('SP001', 'DH082', 'HD082', 25000),
('SP002', 'DH083', 'HD083', 30000),
('SP003', 'DH084', 'HD084', 15000),
('SP004', 'DH085', 'HD085', 10000),
('SP005', 'DH086', 'HD086', 35000),
('SP001', 'DH087', 'HD087', 25000),
('SP002', 'DH088', 'HD088', 30000),
('SP003', 'DH089', 'HD089', 15000),
('SP004', 'DH090', 'HD090', 10000),
('SP005', 'DH091', 'HD091', 35000),
('SP001', 'DH092', 'HD092', 25000),
('SP002', 'DH093', 'HD093', 30000),
('SP003', 'DH094', 'HD094', 15000),
('SP004', 'DH095', 'HD095', 10000),
('SP005', 'DH096', 'HD096', 35000),
('SP001', 'DH097', 'HD097', 25000),
('SP002', 'DH098', 'HD098', 30000),
('SP003', 'DH099', 'HD099', 15000),
('SP004', 'DH100', 'HD100', 10000),
('SP001', 'DH101', 'HD101', 25000),
('SP002', 'DH102', 'HD102', 30000),
('SP003', 'DH103', 'HD103', 15000),
('SP004', 'DH104', 'HD104', 10000),
('SP005', 'DH105', 'HD105', 35000),
('SP001', 'DH106', 'HD106', 25000),
('SP002', 'DH107', 'HD107', 30000),
('SP003', 'DH108', 'HD108', 15000),
('SP004', 'DH109', 'HD109', 10000),
('SP005', 'DH110', 'HD110', 35000);
GO
-- Chèn dữ liệu vào bảng NHACUNGCAP
INSERT INTO NHACUNGCAP (IDNhaCC, TenNhaCC, DiaChi, SDT)
VALUES 
('NCC001', N'Nhà cung cấp 1', N'123 Đường ABC, Quận 1, TP.HCM', '0987654321'),
('NCC002', N'Nhà cung cấp 2', N'456 Đường XYZ, Quận 2, TP.HCM', '0123456789'),
('NCC003', N'Nhà cung cấp 3', N'789 Đường DEF, Quận 3, TP.HCM', '0999999999'),
('NCC004', N'Nhà cung cấp 4', N'1011 Đường GHI, Quận 4, TP.HCM', '0977777777'),
('NCC005', N'Nhà cung cấp 5', N'1213 Đường JKL, Quận 5, TP.HCM', '0966666666')
GO
-- Chèn dữ liệu vào bảng PHIEUGIAOHANG
INSERT INTO PHIEUGIAOHANG (IDPhieuGiao, NgayGiaoHang, TongTienGiaoHang, IDNhaCC)
VALUES 
('PGH001', '2024-03-01', 200000, 'NCC001'),
('PGH002', '2024-03-01', 50000, 'NCC002'),
('PGH003', '2024-03-01', 240000, 'NCC003'),
('PGH004', '2024-03-01', 750000, 'NCC004' ),
('PGH005', '2024-03-01', 400000, 'NCC005')
GO
-- Chèn dữ liệu vào bảng PHIEUGIAOHANGCHITIET
INSERT INTO PHIEUGIAOHANGCHITIET (IDNguyenLieu, IDPhieuGiao, SoLuongNLGiao, DonGiaNL)
VALUES 
('NL001', 'PGH001', 10, 20000),
('NL002', 'PGH002', 5, 10000),
('NL003', 'PGH003', 8, 30000),
('NL004', 'PGH004', 15, 50000),
('NL005', 'PGH005', 20, 20000)
GO
-- Chèn dữ liệu vào bảng PHIEUDATHANG
INSERT INTO PHIEUDATHANG (IDPhieuDatHang, NgayDatHang, IDNhaCC, IDNhanVien)
VALUES 
('PDH001', '2024-03-02', 'NCC001', 'NV001'),
('PDH002', '2024-03-03', 'NCC002', 'NV002'),
('PDH003', '2024-03-04', 'NCC003', 'NV003'),
('PDH004', '2024-03-05', 'NCC004', 'NV004'),
('PDH005', '2024-03-06', 'NCC005', 'NV005');
GO
-- Chèn dữ liệu vào bảng PHIEUDATHANGCHITIET
INSERT INTO PHIEUDATHANGCHITIET (IDPhieuDatHang, IDNguyenLieu, SoLuongDat)
VALUES 
('PDH001', 'NL001', 20),
('PDH001', 'NL002', 15),
('PDH002', 'NL003', 25),
('PDH003', 'NL004', 30),
('PDH004', 'NL005', 35),
('PDH005', 'NL001', 40);
GO
--Procedure đếm số đơn hàng theo từng tháng
--Lệnh chạy EXEC DemSoDonHangTheoThang;
CREATE PROCEDURE DemSoDonHangTheoThang
AS
BEGIN
    SET NOCOUNT ON;

    -- Tạo bảng tạm thời để lưu kết quả
    CREATE TABLE #DonHangMoiThang (
        ThangNam VARCHAR(7),
        SoLuongDonHang INT
    );

    -- Chèn dữ liệu vào bảng tạm thời
    INSERT INTO #DonHangMoiThang (ThangNam, SoLuongDonHang)
    SELECT 
        CONVERT(VARCHAR(7), NgayMuaHang, 120) AS ThangNam,
        COUNT(*) AS SoLuongDonHang
    FROM 
        DONHANG
    GROUP BY 
        CONVERT(VARCHAR(7), NgayMuaHang, 120);

    -- Display the result
    SELECT * FROM #DonHangMoiThang;

    -- Drop the temporary table
    DROP TABLE #DonHangMoiThang;
END;
GO
-- Procedure đếm số đơn hàng từng năm
-- Lệnh chạy EXEC DemSoDonHangTheoNam;
CREATE PROCEDURE DemSoDonHangTheoNam
AS
BEGIN
    SET NOCOUNT ON;

    -- Tạo bảng tạm thời để lưu kết quả
    CREATE TABLE #SoDonHangTheoNam (
        Nam INT,
        SoDonHang INT
    );

    -- Chèn dữ liệu số đơn hàng vào bảng tạm thời
    INSERT INTO #SoDonHangTheoNam (Nam, SoDonHang)
    SELECT 
        YEAR(NgayMuaHang) AS Nam,
        COUNT(*) AS SoDonHang
    FROM 
        DONHANG
    GROUP BY 
        YEAR(NgayMuaHang);

    -- Hiển thị kết quả
    SELECT * FROM #SoDonHangTheoNam;

    -- Bỏ bảng tạm thời
    DROP TABLE #SoDonHangTheoNam;
END;
GO

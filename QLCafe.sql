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
-- Bảng Loại Nguyên Liệu
CREATE TABLE LOAINGUYENLIEU(
IDLoaiNguyenLieu varchar(10) not null primary key,
TenLoaiNguyenLieu nvarchar(20)
)
GO
--Bảng Nguyên Liệu
CREATE TABLE NGUYENLIEU(
IDNguyenLieu varchar(10) not null primary key,
TenNguyenLieu nvarchar(20),
SoLuongTon int,
DonViTinh nvarchar(20),
IDLoaiNguyenLieu varchar(10) not null
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
TenDonHang varchar(20),
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
TrangThai nvarchar(50)
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
-- Bảng Hoá Đơn
CREATE TABLE HOADON(
IDHoaDon varchar(10) not null primary key,
DonGia money,
TongTien money,
Giam money,
ThanhTien money,
ThoiGianMua date,
IDSanPham varchar(10) not null,
IDDonHang varchar(10) not null,
IDKhuyenMai varchar(10)
)
GO
-- Bảng Khuyến Mãi
CREATE TABLE KHUYENMAI(
IDKhuyenMai varchar(10) not null primary key,
LoaiKM float,
DieuKienKM nvarchar(50)
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
ADD CONSTRAINT FK_HoaDon_SanPham FOREIGN KEY (IDSanPham) REFERENCES SANPHAM(IDSanPham),
	CONSTRAINT FK_HoaDon_DonHang FOREIGN KEY (IDDonHang) REFERENCES DONHANG(IDDonHang),
	CONSTRAINT FK_HoaDon_KhuyenMai FOREIGN KEY (IDKhuyenMai) REFERENCES KHUYENMAI(IDKhuyenMai)
GO
-- Tạo khoá ngoại Bảng Nguyên Liệu
ALTER TABLE NGUYENLIEU
ADD CONSTRAINT FK_NguyenLieu_LoaiNguyenLieu FOREIGN KEY (IDLoaiNguyenLieu) REFERENCES LOAINGUYENLIEU(IDLoaiNguyenLieu)
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
CREATE OR ALTER TRIGGER Update_SoLuongTon_SLNL
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
--Lệnh chạy: EXEC ThongKeDoanhThuTheoThang
CREATE PROCEDURE ThongKeDoanhThuTheoThang
AS
BEGIN
    SELECT 
        MONTH(ThoiGianMua) AS Thang,
        YEAR(ThoiGianMua) AS Nam,
        SUM(ThanhTien) AS DoanhThu
    FROM HOADON
    GROUP BY YEAR(ThoiGianMua), MONTH(ThoiGianMua)
    ORDER BY Nam, Thang;
END
GO
--Procedure thống kê doanh thu theo năm
--Lệnh chạy: EXEC ThongKeDoanhThuTheoNam
CREATE PROCEDURE ThongKeDoanhThuTheoNam
AS
BEGIN
    SELECT 
        YEAR(ThoiGianMua) AS Nam,
        SUM(ThanhTien) AS DoanhThu
    FROM HOADON
    GROUP BY YEAR(ThoiGianMua)
    ORDER BY Nam;
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

-- Chèn dữ liệu vào bảng LOAINGUYENLIEU
INSERT INTO LOAINGUYENLIEU (IDLoaiNguyenLieu, TenLoaiNguyenLieu)
VALUES 
('NL001', N'Nguyên liệu thô'),
('NL002', N'Đồ uống'),
('NL003', N'Dinh dưỡng'),
('NL004', N'Vật liệu bao bì'),
('NL005', N'Phụ gia')
GO
-- Chèn dữ liệu vào bảng NGUYENLIEU
INSERT INTO NGUYENLIEU (IDNguyenLieu, TenNguyenLieu, SoLuongTon, IDLoaiNguyenLieu)
VALUES 
('NL001', N'Ca cao', 100, 'NL002'),
('NL002', N'Cam', 50, 'NL001'),
('NL003', N'Dưa hấu', 200, 'NL001'),
('NL004', N'Nước khoáng', 300, 'NL003'),
('NL005', N'Ly nhựa', 150, 'NL004')
GO
-- Chèn dữ liệu vào bảng SANPHAM
INSERT INTO SANPHAM (IDSanPham, TenSP, GiaBan, Hinh)
VALUES 
('SP001', N'Cà phê đen', 25000, NULL),
('SP002', N'Cà phê sữa', 30000, NULL),
('SP003', N'Nước ngọt lon', 15000, NULL),
('SP004', N'Nước suối', 10000, NULL),
('SP005', N'Sinh tố trái cây', 35000, NULL)
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
INSERT INTO DONHANG (IDDonHang, TenDonHang, NgayMuaHang, IDNhanVien)
VALUES 
('DH001', N'Đơn hàng 1', '2022-01-02', 'NV001'),
('DH002', N'Đơn hàng 2', '2022-01-03', 'NV002'),
('DH003', N'Đơn hàng 3', '2022-01-04', 'NV003'),
('DH004', N'Đơn hàng 4', '2022-02-01', 'NV004'),
('DH005', N'Đơn hàng 5', '2022-02-02', 'NV005'),
('DH006', N'Đơn hàng 6', '2022-02-03', 'NV005'),
('DH007', N'Đơn hàng 7', '2022-02-03', 'NV005'),
('DH008', N'Đơn hàng 8', '2022-03-01', 'NV005'),
('DH009', N'Đơn hàng 9', '2022-03-01', 'NV005'),
('DH010', N'Đơn hàng 10', '2022-03-02', 'NV001'),
('DH011', N'Đơn hàng 11', '2022-04-01', 'NV001'),
('DH012', N'Đơn hàng 12', '2022-04-04', 'NV001'),
('DH013', N'Đơn hàng 13', '2022-04-05', 'NV003'),
('DH014', N'Đơn hàng 14', '2022-05-01', 'NV003'),
('DH015', N'Đơn hàng 15', '2022-05-02', 'NV003'),
('DH016', N'Đơn hàng 16', '2022-05-03', 'NV004'),
('DH017', N'Đơn hàng 17', '2022-06-01', 'NV004'),
('DH018', N'Đơn hàng 18', '2022-06-01', 'NV004'),
('DH019', N'Đơn hàng 19', '2022-06-02', 'NV002'),
('DH020', N'Đơn hàng 20', '2022-07-01', 'NV002'),
('DH021', N'Đơn hàng 21', '2022-07-02', 'NV001'),
('DH022', N'Đơn hàng 22', '2022-07-03', 'NV002'),
('DH023', N'Đơn hàng 23', '2022-08-04', 'NV003'),
('DH024', N'Đơn hàng 24', '2022-08-05', 'NV004'),
('DH025', N'Đơn hàng 25', '2022-08-06', 'NV005'),
('DH026', N'Đơn hàng 26', '2022-09-02', 'NV005'),
('DH027', N'Đơn hàng 27', '2022-09-03', 'NV005'),
('DH028', N'Đơn hàng 28', '2022-09-04', 'NV005'),
('DH029', N'Đơn hàng 29', '2022-10-01', 'NV005'),
('DH030', N'Đơn hàng 30', '2022-10-02', 'NV001'),
('DH031', N'Đơn hàng 31', '2022-10-03', 'NV001'),
('DH032', N'Đơn hàng 32', '2022-11-04', 'NV001'),
('DH033', N'Đơn hàng 33', '2022-11-05', 'NV003'),
('DH034', N'Đơn hàng 34', '2022-11-06', 'NV003'),
('DH035', N'Đơn hàng 35', '2022-12-02', 'NV003'),
('DH036', N'Đơn hàng 36', '2022-12-03', 'NV004'),
('DH037', N'Đơn hàng 37', '2022-12-04', 'NV004'),
('DH038', N'Đơn hàng 38', '2023-01-01', 'NV004'),
('DH039', N'Đơn hàng 39', '2023-01-02', 'NV002'),
('DH040', N'Đơn hàng 40', '2023-01-03', 'NV002'),
('DH041', N'Đơn hàng 41', '2023-02-02', 'NV001'),
('DH042', N'Đơn hàng 42', '2023-02-03', 'NV002'),
('DH043', N'Đơn hàng 43', '2023-02-04', 'NV003'),
('DH044', N'Đơn hàng 44', '2023-03-01', 'NV004'),
('DH045', N'Đơn hàng 45', '2023-03-01', 'NV005'),
('DH046', N'Đơn hàng 46', '2023-03-02', 'NV005'),
('DH047', N'Đơn hàng 47', '2023-04-03', 'NV005'),
('DH048', N'Đơn hàng 48', '2023-04-04', 'NV005'),
('DH049', N'Đơn hàng 49', '2023-04-05', 'NV005'),
('DH050', N'Đơn hàng 50', '2023-05-02', 'NV001'),
('DH051', N'Đơn hàng 51', '2023-05-03', 'NV001'),
('DH052', N'Đơn hàng 52', '2023-05-04', 'NV001'),
('DH053', N'Đơn hàng 53', '2023-06-01', 'NV003'),
('DH054', N'Đơn hàng 54', '2023-06-01', 'NV003'),
('DH055', N'Đơn hàng 55', '2023-06-02', 'NV003'),
('DH056', N'Đơn hàng 56', '2023-07-03', 'NV004'),
('DH057', N'Đơn hàng 57', '2023-07-04', 'NV004'),
('DH058', N'Đơn hàng 58', '2023-07-05', 'NV004'),
('DH059', N'Đơn hàng 59', '2023-08-02', 'NV002'),
('DH060', N'Đơn hàng 60', '2023-08-03', 'NV002'),
('DH061', N'Đơn hàng 61', '2023-08-04', 'NV001'),
('DH062', N'Đơn hàng 62', '2023-09-03', 'NV002'),
('DH063', N'Đơn hàng 63', '2023-09-04', 'NV003'),
('DH064', N'Đơn hàng 64', '2023-09-05', 'NV004'),
('DH065', N'Đơn hàng 65', '2023-10-01', 'NV005'),
('DH066', N'Đơn hàng 66', '2023-10-02', 'NV005'),
('DH067', N'Đơn hàng 67', '2023-10-03', 'NV005'),
('DH068', N'Đơn hàng 68', '2023-11-01', 'NV005'),
('DH069', N'Đơn hàng 69', '2023-11-01', 'NV005'),
('DH070', N'Đơn hàng 70', '2023-11-02', 'NV001'),
('DH071', N'Đơn hàng 71', '2023-12-03', 'NV001'),
('DH072', N'Đơn hàng 72', '2023-12-04', 'NV001'),
('DH073', N'Đơn hàng 73', '2023-12-05', 'NV003'),
('DH074', N'Đơn hàng 74', '2024-01-01', 'NV003'),
('DH075', N'Đơn hàng 75', '2024-01-02', 'NV003'),
('DH076', N'Đơn hàng 76', '2024-01-03', 'NV004'),
('DH077', N'Đơn hàng 77', '2024-02-01', 'NV004'),
('DH078', N'Đơn hàng 78', '2024-02-01', 'NV004'),
('DH079', N'Đơn hàng 79', '2024-02-02', 'NV002'),
('DH080', N'Đơn hàng 80', '2024-03-01', 'NV002'),
('DH081', N'Đơn hàng 81', '2024-03-02', 'NV001'),
('DH082', N'Đơn hàng 82', '2024-03-03', 'NV002'),
('DH083', N'Đơn hàng 83', '2024-04-01', 'NV003'),
('DH084', N'Đơn hàng 84', '2024-04-02', 'NV004'),
('DH085', N'Đơn hàng 85', '2024-04-03', 'NV005'),
('DH086', N'Đơn hàng 86', '2024-05-02', 'NV005'),
('DH087', N'Đơn hàng 87', '2024-05-03', 'NV005'),
('DH088', N'Đơn hàng 88', '2024-05-04', 'NV005'),
('DH089', N'Đơn hàng 89', '2024-06-01', 'NV005'),
('DH090', N'Đơn hàng 90', '2024-06-02', 'NV001'),
('DH091', N'Đơn hàng 91', '2024-06-03', 'NV001'),
('DH092', N'Đơn hàng 92', '2024-07-04', 'NV001'),
('DH093', N'Đơn hàng 93', '2024-07-05', 'NV003'),
('DH094', N'Đơn hàng 94', '2024-07-06', 'NV003'),
('DH095', N'Đơn hàng 95', '2024-08-02', 'NV003'),
('DH096', N'Đơn hàng 96', '2024-08-03', 'NV004'),
('DH097', N'Đơn hàng 97', '2024-08-04', 'NV004'),
('DH098', N'Đơn hàng 98', '2024-08-05', 'NV004'),
('DH099', N'Đơn hàng 99', '2024-09-02', 'NV002'),
('DH100', N'Đơn hàng 100', '2024-09-03', 'NV002'),
('DH101', N'Đơn hàng 101', '2024-09-04', 'NV001'),
('DH102', N'Đơn hàng 102', '2024-10-01', 'NV002'),
('DH103', N'Đơn hàng 103', '2024-10-02', 'NV003'),
('DH104', N'Đơn hàng 104', '2024-10-03', 'NV004'),
('DH105', N'Đơn hàng 105', '2024-11-01', 'NV005'),
('DH106', N'Đơn hàng 106', '2024-11-02', 'NV005'),
('DH107', N'Đơn hàng 107', '2024-11-03', 'NV005'),
('DH108', N'Đơn hàng 108', '2024-12-01', 'NV005'),
('DH109', N'Đơn hàng 109', '2024-12-02', 'NV005'),
('DH110', N'Đơn hàng 110', '2024-12-03', 'NV005')
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
INSERT INTO KHUYENMAI (IDKhuyenMai, LoaiKM,DieuKienKM)
VALUES 
('KM001', 0.1, N'Trên đơn hàng có giá trị từ 100.000 đồng trở lên'),
('KM002', 0.2, N'Trên đơn hàng có giá trị từ 300.000 đồng trở lên'),
('KM003', 0.3, N'Trên đơn hàng có giá trị từ 500.000 đồng trở lên'),
('KM004', 0.4 , N'Trên đơn hàng có giá trị từ 1.000.000 đồng trở lên')
GO
-- Chèn dữ liệu vào bảng HOADON
INSERT INTO HOADON (IDHoaDon, DonGia, TongTien, Giam, ThanhTien, ThoiGianMua, IDSanPham, IDDonHang, IDKhuyenMai)
VALUES 
('HD001', 25000, 75000, 0, 75000, '2022-01-02', 'SP001', 'DH001', NULL),
('HD002', 30000, 60000, 0, 60000, '2022-01-03', 'SP002', 'DH002', NULL),
('HD003', 15000, 15000, 0, 15000, '2022-01-04', 'SP003', 'DH003', NULL),
('HD004', 10000, 50000, 0, 50000, '2022-02-01', 'SP004', 'DH004', NULL),
('HD005', 10000, 10000, 0, 10000, '2022-02-02', 'SP004', 'DH005', 'KM001'),
('HD006', 15000, 15000, 0, 15000, '2022-02-02', 'SP003', 'DH005', NULL),
('HD007', 25000, 25000, 0, 25000, '2022-02-02', 'SP001', 'DH005', NULL),
('HD008', 30000, 150000, 15000, 135000, '2022-02-03', 'SP002', 'DH006', 'KM001'),
('HD009', 30000, 30000, 0, 30000, '2022-02-03', 'SP002', 'DH007', NULL),
('HD010', 10000, 10000, 0, 10000, '2022-02-03', 'SP004', 'DH007', NULL),
('HD011', 15000, 15000, 0, 15000, '2022-02-03', 'SP003', 'DH007', NULL),
('HD012', 15000, 15000, 0, 15000, '2022-03-01', 'SP003', 'DH008', NULL),
('HD013', 25000, 50000, 0, 50000, '2022-03-01', 'SP001', 'DH009', NULL),
('HD014', 15000, 15000, 0, 15000, '2024-03-02', 'SP003', 'DH010', NULL),
('HD015', 15000, 15000, 0, 15000, '2022-04-01', 'SP003', 'DH011', NULL),
('HD016', 35000, 35000, 0, 35000, '2022-04-01', 'SP005', 'DH011', NULL),
('HD017', 15000, 30000, 0, 30000, '2022-04-04', 'SP003', 'DH012', NULL),
('HD018', 15000, 15000, 0, 15000, '2022-04-05', 'SP003', 'DH013', NULL),
('HD019', 30000, 30000, 0, 30000, '2022-05-01', 'SP002', 'DH014', NULL),
('HD020', 15000, 15000, 0, 15000, '2022-05-02', 'SP003', 'DH015', NULL),
('HD021', 10000, 10000, 0, 10000, '2022-05-03', 'SP004', 'DH016', NULL),
('HD022', 25000, 25000, 0, 25000, '2022-06-01', 'SP001', 'DH017', NULL),
('HD023', 30000, 30000, 0, 30000, '2022-06-01', 'SP002', 'DH018', NULL),
('HD024', 15000, 15000, 0, 15000, '2022-06-02', 'SP003', 'DH019', NULL),
('HD025', 35000, 35000, 0, 35000, '2022-07-01', 'SP005', 'DH020', NULL),
('HD026', 25000, 75000, 0, 75000, '2022-07-02', 'SP001', 'DH021', NULL),
('HD027', 30000, 60000, 0, 60000, '2022-07-03', 'SP002', 'DH022', NULL),
('HD028', 15000, 15000, 0, 15000, '2022-08-04', 'SP003', 'DH023', NULL),
('HD029', 10000, 50000, 0, 50000, '2022-08-05', 'SP004', 'DH024', NULL),
('HD030', 35000, 35000, 0, 35000, '2022-08-06', 'SP005', 'DH025', NULL),
('HD031', 25000, 75000, 0, 75000, '2022-09-02', 'SP001', 'DH026', NULL),
('HD032', 30000, 60000, 0, 60000, '2022-09-03', 'SP002', 'DH027', NULL),
('HD033', 15000, 15000, 0, 15000, '2022-09-04', 'SP003', 'DH028', NULL),
('HD034', 10000, 50000, 0, 50000, '2022-10-01', 'SP004', 'DH029', NULL),
('HD035', 35000, 35000, 0, 35000, '2022-10-02', 'SP005', 'DH030', NULL),
('HD036', 25000, 75000, 0, 75000, '2022-10-03', 'SP001', 'DH031', NULL),
('HD037', 30000, 60000, 0, 60000, '2022-11-04', 'SP002', 'DH032', NULL),
('HD038', 15000, 15000, 0, 15000, '2022-11-05', 'SP003', 'DH033', NULL),
('HD039', 10000, 50000, 0, 50000, '2022-11-06', 'SP004', 'DH034', NULL),
('HD040', 35000, 35000, 0, 35000, '2022-12-02', 'SP005', 'DH035', NULL),
('HD041', 25000, 75000, 0, 75000, '2022-12-03', 'SP001', 'DH036', NULL),
('HD042', 30000, 60000, 0, 60000, '2022-12-04', 'SP002', 'DH037', NULL),
('HD043', 15000, 15000, 0, 15000, '2023-01-01', 'SP003', 'DH038', NULL),
('HD044', 10000, 50000, 0, 50000, '2023-01-02', 'SP004', 'DH039', NULL),
('HD045', 35000, 35000, 0, 35000, '2023-01-03', 'SP005', 'DH040', NULL),
('HD046', 25000, 75000, 0, 75000, '2023-02-02', 'SP001', 'DH041', NULL),
('HD047', 30000, 60000, 0, 60000, '2023-02-03', 'SP002', 'DH042', NULL),
('HD048', 15000, 15000, 0, 15000, '2023-02-04', 'SP003', 'DH043', NULL),
('HD049', 10000, 50000, 0, 50000, '2023-03-01', 'SP004', 'DH044', NULL),
('HD050', 35000, 35000, 0, 35000, '2023-03-01', 'SP005', 'DH045', NULL),
('HD051', 25000, 75000, 0, 75000, '2023-03-02', 'SP001', 'DH046', NULL),
('HD052', 30000, 60000, 0, 60000, '2023-04-03', 'SP002', 'DH047', NULL),
('HD053', 15000, 15000, 0, 15000, '2023-04-04', 'SP003', 'DH048', NULL),
('HD054', 10000, 50000, 0, 50000, '2023-04-05', 'SP004', 'DH049', NULL),
('HD055', 35000, 35000, 0, 35000, '2023-05-02', 'SP005', 'DH050', NULL),
('HD056', 25000, 75000, 0, 75000, '2023-05-03', 'SP001', 'DH051', NULL),
('HD057', 30000, 60000, 0, 60000, '2023-05-04', 'SP002', 'DH052', NULL),
('HD058', 15000, 15000, 0, 15000, '2023-06-01', 'SP003', 'DH053', NULL),
('HD059', 10000, 50000, 0, 50000, '2023-06-01', 'SP004', 'DH054', NULL),
('HD060', 35000, 35000, 0, 35000, '2023-06-02', 'SP005', 'DH055', NULL),
('HD061', 25000, 75000, 0, 75000, '2023-07-03', 'SP001', 'DH056', NULL),
('HD062', 30000, 60000, 0, 60000, '2023-07-04', 'SP002', 'DH057', NULL),
('HD063', 15000, 15000, 0, 15000, '2023-07-05', 'SP003', 'DH058', NULL),
('HD064', 10000, 50000, 0, 50000, '2023-08-02', 'SP004', 'DH059', NULL),
('HD065', 35000, 35000, 0, 35000, '2023-08-03', 'SP005', 'DH060', NULL),
('HD066', 25000, 75000, 0, 75000, '2023-08-04', 'SP001', 'DH061', NULL),
('HD067', 30000, 60000, 0, 60000, '2023-09-03', 'SP002', 'DH062', NULL),
('HD068', 15000, 15000, 0, 15000, '2023-09-04', 'SP003', 'DH063', NULL),
('HD069', 10000, 50000, 0, 50000, '2023-09-05', 'SP004', 'DH064', NULL),
('HD070', 35000, 35000, 0, 35000, '2023-10-01', 'SP005', 'DH065', NULL),
('HD071', 25000, 75000, 0, 75000, '2023-10-02', 'SP001', 'DH066', NULL),
('HD072', 30000, 60000, 0, 60000, '2023-10-03', 'SP002', 'DH067', NULL),
('HD073', 15000, 15000, 0, 15000, '2023-11-01', 'SP003', 'DH068', NULL),
('HD074', 10000, 50000, 0, 50000, '2023-11-01', 'SP004', 'DH069', NULL),
('HD075', 35000, 35000, 0, 35000, '2023-11-02', 'SP005', 'DH070', NULL),
('HD076', 25000, 75000, 0, 75000, '2023-12-03', 'SP001', 'DH071', NULL),
('HD077', 30000, 60000, 0, 60000, '2023-12-04', 'SP002', 'DH072', NULL),
('HD078', 15000, 15000, 0, 15000, '2023-12-05', 'SP003', 'DH073', NULL),
('HD079', 10000, 50000, 0, 50000, '2024-01-01', 'SP004', 'DH074', NULL),
('HD080', 35000, 35000, 0, 35000, '2024-01-02', 'SP005', 'DH075', NULL),
('HD081', 25000, 75000, 0, 75000, '2024-01-03', 'SP001', 'DH076', NULL),
('HD082', 30000, 60000, 0, 60000, '2024-02-01', 'SP002', 'DH077', NULL),
('HD083', 15000, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH078', NULL),
('HD084', 10000, 50000, 0, 50000, '2024-02-02', 'SP004', 'DH079', NULL),
('HD085', 35000, 35000, 0, 35000, '2024-03-01', 'SP005', 'DH080', NULL),
('HD086', 25000, 75000, 0, 75000, '2024-03-02', 'SP001', 'DH081', NULL),
('HD087', 30000, 60000, 0, 60000, '2024-03-03', 'SP002', 'DH082', NULL),
('HD088', 15000, 15000, 0, 15000, '2024-04-01', 'SP003', 'DH083', NULL),
('HD089', 10000, 50000, 0, 50000, '2024-04-02', 'SP004', 'DH084', NULL),
('HD090', 35000, 35000, 0, 35000, '2024-04-03', 'SP005', 'DH085', NULL),
('HD091', 25000, 75000, 0, 75000, '2024-05-02', 'SP001', 'DH086', NULL),
('HD092', 30000, 60000, 0, 60000, '2024-05-03', 'SP002', 'DH087', NULL),
('HD093', 15000, 15000, 0, 15000, '2024-05-04', 'SP003', 'DH088', NULL),
('HD094', 10000, 50000, 0, 50000, '2024-06-01', 'SP004', 'DH089', NULL),
('HD095', 35000, 35000, 0, 35000, '2024-06-02', 'SP005', 'DH090', NULL),
('HD096', 25000, 75000, 0, 75000, '2024-06-03', 'SP001', 'DH091', NULL),
('HD097', 30000, 60000, 0, 60000, '2024-07-04', 'SP002', 'DH092', NULL),
('HD098', 15000, 15000, 0, 15000, '2024-07-05', 'SP003', 'DH093', NULL),
('HD099', 10000, 50000, 0, 50000, '2024-07-06', 'SP004', 'DH094', NULL),
('HD100', 35000, 35000, 0, 35000, '2024-08-02', 'SP005', 'DH095', NULL),
('HD101', 25000, 75000, 0, 75000, '2024-08-03', 'SP001', 'DH096', NULL),
('HD102', 30000, 60000, 0, 60000, '2024-08-04', 'SP002', 'DH097', NULL),
('HD103', 15000, 15000, 0, 15000, '2024-08-05', 'SP003', 'DH098', NULL),
('HD104', 10000, 50000, 0, 50000, '2024-09-02', 'SP004', 'DH099', NULL),
('HD105', 35000, 35000, 0, 35000, '2024-09-03', 'SP005', 'DH100', NULL),
('HD106', 25000, 75000, 0, 75000, '2024-09-04', 'SP001', 'DH101', NULL),
('HD107', 30000, 60000, 0, 60000, '2024-10-01', 'SP002', 'DH102', NULL),
('HD108', 15000, 15000, 0, 15000, '2024-10-02', 'SP003', 'DH103', NULL),
('HD109', 10000, 50000, 0, 50000, '2024-10-03', 'SP004', 'DH104', NULL),
('HD110', 35000, 35000, 0, 35000, '2024-11-01', 'SP005', 'DH105', NULL),
('HD111', 25000, 75000, 0, 75000, '2024-11-02', 'SP001', 'DH106', NULL),
('HD112', 30000, 60000, 0, 60000, '2024-11-03', 'SP002', 'DH107', NULL),
('HD113', 15000, 15000, 0, 15000, '2024-12-01', 'SP003', 'DH108', NULL),
('HD114', 10000, 50000, 0, 50000, '2024-12-02', 'SP004', 'DH109', NULL),
('HD115', 35000, 35000, 0, 35000, '2024-12-03', 'SP005', 'DH110', NULL)
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


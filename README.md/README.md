# Ứng dụng Quản lý Bảo dưỡng Xe máy

## 1. Giới thiệu
Xe máy sau một thời gian sử dụng cần được bảo dưỡng định kỳ (thay nhớt, kiểm tra phanh, lốp, bugi...). Nhiều người dùng quên lịch bảo dưỡng hoặc không lưu lại lịch sử sửa chữa, dẫn đến xe xuống cấp nhanh hoặc tốn kém sửa chữa lớn về sau. Ứng dụng giúp người dùng theo dõi và quản lý việc này một cách có hệ thống.

## 2. Mục tiêu
Xây dựng ứng dụng cho phép người dùng:
- Quản lý thông tin xe cá nhân
- Ghi nhận và tra cứu lịch sử bảo dưỡng
- Nhận nhắc nhở khi đến hạn bảo dưỡng tiếp theo
- Thống kê chi phí bảo dưỡng theo thời gian

## 3. Phạm vi

**Trong phạm vi:**
- Quản lý nhiều xe cho 1 người dùng
- Ghi nhận lần bảo dưỡng: loại dịch vụ, chi phí, ngày thực hiện, số km tại thời điểm đó
- Tính toán và cảnh báo lịch bảo dưỡng kế tiếp (theo km hoặc theo mốc thời gian)
- Xem thống kê chi phí theo tháng/năm

**Ngoài phạm vi:**
- Không tích hợp thanh toán online
- Không kết nối với tiệm sửa xe thật
- Không có định vị GPS tìm tiệm gần nhất

## 4. Actor

| Actor | Vai trò |
|---|---|
| Chủ xe | Đăng ký xe, ghi nhận bảo dưỡng, xem lịch sử, xem thống kê |

## 5. Danh sách Use Case

| Mã | Tên Use Case | Mô tả |
|---|---|---|
| UC01 | Đăng ký xe | Thêm xe mới (biển số, hãng, đời xe, số km hiện tại) |
| UC02 | Ghi nhận bảo dưỡng | Ghi lại 1 lần bảo dưỡng (dịch vụ, chi phí, ngày, số km) |
| UC03 | Tính lịch nhắc bảo dưỡng | Tính ngày/số km cho lần bảo dưỡng kế tiếp |
| UC04 | Xem lịch sử bảo dưỡng | Tra cứu các lần bảo dưỡng đã ghi nhận theo xe |
| UC05 | Xem thống kê chi phí | Tổng hợp chi phí bảo dưỡng theo tháng/năm |
| UC06 | Gửi thông báo nhắc lịch | Gửi cảnh báo khi gần đến hạn bảo dưỡng (mở rộng của UC03) |

## 6. Quan hệ giữa các Use Case

- **Association**: `Chủ xe` — tất cả các Use Case (UC01–UC05)
- **Include**: `UC02 Ghi nhận bảo dưỡng` include `UC03 Tính lịch nhắc bảo dưỡng`
  → Mỗi lần ghi nhận bảo dưỡng xong, hệ thống bắt buộc phải tính lại lịch nhắc kế tiếp.
- **Extend**: `UC06 Gửi thông báo nhắc lịch` extend `UC03 Tính lịch nhắc bảo dưỡng`
  → Chỉ kích hoạt gửi thông báo khi lịch nhắc đã đến hạn (điều kiện mở rộng).

## 7. Class chính dự kiến

- `Xe` (biển số, hãng, đời xe, số km hiện tại)
- `ChuXe` (tên, thông tin liên hệ, danh sách xe sở hữu)
- `LanBaoDuong` (ngày, loại dịch vụ, chi phí, số km tại thời điểm bảo dưỡng)
- `LoaiDichVu` (tên dịch vụ, chu kỳ khuyến nghị — ví dụ thay nhớt mỗi 3.000km)
- `NhacLich` (tính toán dựa trên `LanBaoDuong` gần nhất + chu kỳ của `LoaiDichVu`)

**Quan hệ:**
- 1 `ChuXe` – nhiều `Xe` (1-n)
- 1 `Xe` – nhiều `LanBaoDuong` (1-n)
- `LanBaoDuong` tham chiếu đến `LoaiDichVu` (n-1)
- `NhacLich` phụ thuộc vào `LanBaoDuong` gần nhất và `LoaiDichVu` tương ứng

## 8. Công nghệ dự kiến
- Ngôn ngữ: Java (OOP)
- Cơ sở dữ liệu: MySQL / SQLite
- Giao diện: (nhóm thống nhất — console / Swing / web)

## 9. Thành viên nhóm
- Trần Văn Anh Khoa
- Trần Công Hậu

## 10. Phân công công việc
- Trần Văn Anh Khoa : tìm hiểu thông tin, lên form , đưa ra ý kiến
- Trần Công Hậu : thực hành , kết nối dự án



# Activity Diagram — Hệ thống quản lý cửa hàng sửa xe máy

Nhóm chọn 2 use case có luồng xử lý rõ ràng (có vòng lặp / rẽ nhánh) để vẽ Activity Diagram:
- **UC02 — Ghi nhận dịch vụ bảo dưỡng**
- **UC08 — Nhắc khách bảo dưỡng định kỳ**

## 1. Ký hiệu sử dụng

| Ký hiệu | Tên | Ý nghĩa |
|---|---|---|
| ● | Initial Node | Điểm bắt đầu luồng |
| Hình chữ nhật bo góc | Action | Một bước xử lý |
| ◆ có điều kiện | Decision | Rẽ nhánh theo điều kiện (Có/Không) |
| ◆ không điều kiện | Merge | Gộp các nhánh về một luồng |
| ◎ | Final Node | Điểm kết thúc luồng |
| Mũi tên | Control Flow | Thứ tự thực hiện |

## 2. UC02 — Ghi nhận dịch vụ bảo dưỡng

![Activity Diagram UC02](images/activity_uc02.png)

**Mô tả luồng:**
1. Nhân viên chọn phiếu tiếp nhận đang xử lý (đã tạo ở UC01).
2. Chọn dịch vụ cần thêm, nhập số lượng / đơn giá → tạo một `ChiTietDichVu`.
3. Hệ thống hỏi **"Còn dịch vụ cần thêm?"**
   - **Có**: quay lại bước chọn dịch vụ (vòng lặp) — một phiếu có thể gồm nhiều dịch vụ.
   - **Không**: đi tiếp.
4. Tính tổng chi phí — gọi UC03 Lập hoá đơn (quan hệ **include**: luôn thực hiện).
5. Lưu phiếu tiếp nhận, kết thúc.

## 3. UC08 — Nhắc khách bảo dưỡng định kỳ

![Activity Diagram UC08](images/activity_uc08.png)

**Mô tả luồng:**
1. Sau khi UC02 hoàn tất, hệ thống kiểm tra chu kỳ khuyến nghị của dịch vụ vừa thực hiện (quan hệ **extend**: chỉ chạy khi có điều kiện).
2. Hệ thống xét **"Đã đến/gần đến hạn?"**
   - **Có**: thêm khách vào danh sách cần nhắc → nhân viên gọi/gửi thông báo cho khách.
   - **Không**: bỏ qua, không làm gì.
3. Hai nhánh gộp lại tại điểm Merge, rồi kết thúc.

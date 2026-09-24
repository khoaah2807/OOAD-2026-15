# Hệ thống Quản lý cửa hàng bảo dưỡng xe máy

1. Giới thiệu
Các cửa hàng sửa xe máy nhỏ thường quản lý khách hàng, lịch sử sửa chữa và doanh thu bằng sổ sách thủ công, dễ thất lạc thông tin, khó tổng hợp báo cáo. Hệ thống giúp cửa hàng số hoá quy trình tiếp nhận xe, ghi nhận dịch vụ, lập hoá đơn và theo dõi doanh thu.
2. Mục tiêu
Xây dựng hệ thống cho phép:
- Nhân viên tiếp nhận xe, ghi nhận dịch vụ bảo dưỡng/sửa chữa, lập hoá đơn
- Nhân viên tra cứu lịch sử sửa chữa theo khách hàng/xe
- Quản lý quản lý danh mục dịch vụ, bảng giá, nhân viên
- Quản lý xem báo cáo doanh thu theo ngày/tháng
3. Phạm vi
**Trong phạm vi:**
- Quản lý thông tin khách hàng và xe (không cần đăng nhập, do nhân viên nhập khi khách đến)
- Ghi nhận phiếu tiếp nhận, dịch vụ thực hiện, chi phí, lập hoá đơn
- Quản lý danh mục dịch vụ & bảng giá
- Quản lý danh sách nhân viên
- Thống kê doanh thu theo thời gian
- Nhắc khách bảo dưỡng định kỳ (dựa trên lịch sử)
**Ngoài phạm vi:**
- Không có tài khoản/đăng nhập cho khách hàng (khách không tự thao tác hệ thống)
- Không tích hợp thanh toán online
- Không quản lý nhiều chi nhánh (giả định 1 cửa hàng)
- Không có định vị GPS tìm khách hàng/cửa hàng gần nhất
## 4. Actor
| Actor | Vai trò |
|---|---|
| Nhân viên | Tiếp nhận xe, ghi nhận dịch vụ, lập hoá đơn, tra cứu lịch sử, nhắc khách |

## 5. Danh sách Use Case

| Mã | Tên Use Case | Actor | Mô tả |
|---|---|---|---|
| UC01 | Tiếp nhận xe | Nhân viên | Ghi nhận thông tin khách hàng + xe khi khách mang xe đến |
| UC02 | Ghi nhận dịch vụ bảo dưỡng | Nhân viên | Ghi các dịch vụ đã thực hiện cho xe, chi phí từng dịch vụ |
| UC03 | Lập hoá đơn | Nhân viên | Tự động tính tổng tiền từ các dịch vụ đã ghi nhận (include UC02) |
| UC04 | Tra cứu lịch sử sửa chữa | Nhân viên | Tra cứu các lần sửa chữa trước theo khách hàng/biển số xe |
| UC05 | Quản lý danh mục dịch vụ & giá | Quản lý | Thêm/sửa/xoá loại dịch vụ và đơn giá |
| UC06 | Quản lý nhân viên | Quản lý | Thêm/sửa/xoá tài khoản nhân viên |
| UC07 | Xem báo cáo doanh thu | Quản lý | Tổng hợp doanh thu theo ngày/tháng/năm |
| UC08 | Nhắc khách bảo dưỡng định kỳ | Nhân viên | Gợi ý danh sách khách cần gọi nhắc bảo dưỡng (extend UC02) |

## 5.1. Đặc tả một số Use Case chính

### UC01 — Tiếp nhận xe
- **Mã số**: UCSHOP01
- **Mô tả tóm tắt**: Nhân viên ghi nhận thông tin khách hàng và xe khi khách mang xe đến cửa hàng
- **Các bước thực hiện**:
  1. Nhân viên kiểm tra khách hàng đã có trong hệ thống chưa (theo SĐT)
  2. Nếu chưa có, tạo mới thông tin khách hàng
  3. Nhập/kiểm tra thông tin xe (biển số, hãng, số km)
  4. Tạo phiếu tiếp nhận
- **Điều kiện thoát**: Phiếu tiếp nhận được tạo thành công
- **Yêu cầu trước khi thực hiện**: Không có

### UC02 — Ghi nhận dịch vụ bảo dưỡng
- **Mã số**: UCSHOP02
- **Mô tả tóm tắt**: Nhân viên ghi nhận các dịch vụ đã thực hiện cho xe trong phiếu tiếp nhận
- **Các bước thực hiện**:
  1. Chọn phiếu tiếp nhận đang xử lý
  2. Thêm 1 hoặc nhiều dịch vụ (thay nhớt, kiểm tra phanh...)
  3. Hệ thống tự động gọi UC03 để lập hoá đơn (include)
- **Điều kiện thoát**: Dịch vụ được lưu vào phiếu
- **Yêu cầu trước khi thực hiện**: Đã có phiếu tiếp nhận (UC01)

### UC03 — Lập hoá đơn
- **Mã số**: UCSHOP03
- **Mô tả tóm tắt**: Tự động tính tổng chi phí từ các dịch vụ đã ghi nhận và xuất hoá đơn
- **Các bước thực hiện**: Tổng hợp chi phí từng dịch vụ → tính tổng tiền → tạo hoá đơn
- **Điều kiện thoát**: Hoá đơn được tạo

### UC04 — Tra cứu lịch sử sửa chữa
- **Mã số**: UCSHOP04
- **Mô tả tóm tắt**: Nhân viên tra cứu các lần sửa chữa trước đó theo khách hàng hoặc biển số xe
- **Các bước thực hiện**:
  1. Nhập số điện thoại khách hàng hoặc biển số xe
  2. Hệ thống hiển thị danh sách phiếu tiếp nhận trước đó của xe/khách
  3. Nhân viên xem chi tiết dịch vụ, chi phí từng lần
- **Điều kiện thoát**: Khi nhân viên đóng màn hình tra cứu
- **Yêu cầu trước khi thực hiện**: Khách hàng/xe đã từng được tiếp nhận (UC01)

### UC05 — Quản lý danh mục dịch vụ & giá
- **Mã số**: UCSHOP05
- **Mô tả tóm tắt**: Quản lý thêm, sửa, xoá các loại dịch vụ và đơn giá tương ứng
- **Các bước thực hiện**:
  1. Quản lý chọn thêm mới/sửa/xoá 1 dịch vụ
  2. Nhập tên dịch vụ, đơn giá, chu kỳ khuyến nghị (nếu có)
  3. Hệ thống lưu thay đổi vào danh mục dịch vụ
- **Điều kiện thoát**: Danh mục dịch vụ được cập nhật thành công
- **Yêu cầu đặc biệt**: Không được xoá dịch vụ đã có trong phiếu tiếp nhận cũ (chỉ ẩn/ngừng sử dụng)
- **Yêu cầu trước khi thực hiện**: Đăng nhập với quyền Quản lý

### UC06 — Quản lý nhân viên
- **Mã số**: UCSHOP06
- **Mô tả tóm tắt**: Quản lý thêm, sửa, xoá tài khoản nhân viên trong cửa hàng
- **Các bước thực hiện**:
  1. Quản lý chọn thêm mới/sửa/xoá 1 nhân viên
  2. Nhập/cập nhật thông tin nhân viên (mã, tên, tài khoản đăng nhập)
  3. Hệ thống lưu thay đổi
- **Điều kiện thoát**: Danh sách nhân viên được cập nhật thành công
- **Yêu cầu trước khi thực hiện**: Đăng nhập với quyền Quản lý
- **Điều kiện sau khi thực hiện**: Nhân viên mới có thể đăng nhập và sử dụng các use case UC01–UC04

### UC07 — Xem báo cáo doanh thu
- **Mã số**: UCSHOP07
- **Mô tả tóm tắt**: Quản lý xem tổng doanh thu theo khoảng thời gian
- **Các bước thực hiện**: Chọn khoảng thời gian → hệ thống tổng hợp từ các hoá đơn → hiển thị báo cáo
- **Yêu cầu trước khi thực hiện**: Có ít nhất 1 hoá đơn trong khoảng thời gian chọn

### UC08 — Nhắc khách bảo dưỡng định kỳ
- **Mã số**: UCSHOP08
- **Mô tả tóm tắt**: Gợi ý cho nhân viên danh sách khách hàng cần gọi nhắc bảo dưỡng định kỳ
- **Các bước thực hiện**:
  1. Sau khi ghi nhận dịch vụ (UC02), hệ thống kiểm tra chu kỳ khuyến nghị của dịch vụ vừa thực hiện
  2. Nếu đã đến/gần đến hạn của lần sau, hệ thống thêm khách vào danh sách cần nhắc
  3. Nhân viên xem danh sách và liên hệ khách hàng
- **Điều kiện thoát**: Danh sách nhắc được hiển thị/xử lý xong
- **Yêu cầu trước khi thực hiện**: Xe đã có lịch sử bảo dưỡng và dịch vụ có chu kỳ khuyến nghị (điều kiện mở rộng của UC02)

## 6. Quan hệ giữa các Use Case

- **Generalization**: `Quản lý` kế thừa từ `Nhân viên`
- **Association**: `Nhân viên` — UC01, UC02, UC04, UC08 | `Quản lý` — UC05, UC06, UC07 (+ kế thừa toàn bộ use case của Nhân viên)
- **Include**: `UC02 Ghi nhận dịch vụ` include `UC03 Lập hoá đơn`
  → Mỗi lần ghi nhận dịch vụ xong, hệ thống bắt buộc phải lập hoá đơn tương ứng.
- **Extend**: `UC08 Nhắc khách bảo dưỡng` extend `UC02 Ghi nhận dịch vụ`
  → Chỉ hiển thị gợi ý nhắc khách khi phát hiện xe đã đến hạn bảo dưỡng định kỳ.



## 7. Thành viên nhóm
- Trần Văn Anh Khoa
- Trần Công Hậu

## Hình ảnh sơ đồ use case

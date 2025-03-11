# English Center Management System

## Giới thiệu
English Center Management System là một nền tảng giúp quản lý trung tâm tiếng Anh hiệu quả. Hệ thống hỗ trợ quản lý học viên, giáo viên, khóa học, lịch học và báo cáo thống kê.

## Tính năng chính
- **Quản lý người dùng:**
  - Đăng nhập, phân quyền (Admin, Staff, Teacher, Student)
  - Quản lý hồ sơ học viên và giáo viên
- **Quản lý khóa học:**
  - Tạo, chỉnh sửa, xóa khóa học
  - Phân công giáo viên và học viên vào lớp học
- **Lịch học:**
  - Lập lịch học
  - Quản lý phòng học
- **Thống kê & Báo cáo:**
  - Báo cáo số lượng học viên, giáo viên, doanh thu
  - Xuất báo cáo dưới dạng Excel/PDF

## Công nghệ sử dụng
### Backend
- Java Spring Boot
- MySQL
- Spring Security
- JWT (JSON Web Token)

### Frontend
- HTML, CSS, JavaScript
- Node.js

### Database
- MySQL 8+

### Authentication
- JWT (JSON Web Token)

## Cài đặt và chạy dự án
### Yêu cầu hệ thống
- Java 17+
- Node.js 16+
- MySQL 8+

### Hướng dẫn cài đặt
#### Backend
1. Clone repository:
   ```sh
   git clone https://github.com/english_center/english-center-management.git
   cd english-center-management/backend
   ```
2. Cấu hình database trong `application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/english_center
       username: root
       password: yourpassword
   ```
3. Chạy ứng dụng:
   ```sh
   mvn spring-boot:run
   ```

#### Frontend
1. Chuyển vào thư mục frontend:
   ```sh
   cd english-center-management/frontend
   ```
2. Cài đặt dependencies:
   ```sh
   npm install
   ```
3. Chạy frontend:
   ```sh
   npm start
   ```

## API Documentation
Sử dụng Swagger để truy cập tài liệu API tại:

[Swagger UI](http://localhost:8080/swagger-ui.html)

## Đóng góp
Nếu bạn muốn đóng góp cho dự án:
1. Fork repository
2. Tạo một nhánh mới (`feature/your-feature-name`)
3. Commit thay đổi của bạn
4. Tạo Pull Request
5. Báo lỗi hoặc đề xuất tính năng mới qua Issues

Cảm ơn bạn đã đóng góp vào English Center Management System! 🚀





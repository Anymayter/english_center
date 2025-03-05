# English Center Management System

## Giới thiệu

**English Center Management System** là một nền tảng giúp quản lý trung tâm tiếng Anh một cách hiệu quả. Hệ thống hỗ trợ quản lý học viên, giáo viên, khóa học, lịch học, và báo cáo thống kê.

## Tính năng chính

- **Quản lý người dùng:**
  - Đăng ký, đăng nhập, phân quyền (Admin, Staff, Teacher, Student)
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

- **Backend:** Java Spring Boot, MySQL, Spring Security, JWT
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Authentication:** JWT (JSON Web Token)

## Cài đặt và chạy dự án

### Yêu cầu hệ thống
- Java 17+
- Node.js 16+
- MySQL 8+

### Hướng dẫn cài đặt
#### Backend
1. Clone repository:
   ```bash
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
   ```bash
   mvn spring-boot:run
   ```

#### Frontend
1. Chuyển vào thư mục frontend:
   ```bash
   cd english-center-management/frontend
   ```
2. Cài đặt dependencies:
   ```bash
   npm install
   ```
3. Chạy frontend:
   ```bash
   npm start
   ```

## API Documentation
Sử dụng Swagger để truy cập tài liệu API tại:
```
http://localhost:8080/swagger-ui.html
```

## Đóng góp
Nếu bạn muốn đóng góp cho dự án, vui lòng tạo Pull Request hoặc báo lỗi qua Issues.





# Sử dụng image Tomcat 9 chính thức từ Docker Hub
FROM tomcat:9.0

# Xóa các ứng dụng mặc định trong thư mục webapps (nếu bạn muốn clean)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war của bạn vào thư mục webapps và đổi tên nếu cần
COPY build/libs/song-upload-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Port mặc định của Tomcat là 8080
EXPOSE 8080

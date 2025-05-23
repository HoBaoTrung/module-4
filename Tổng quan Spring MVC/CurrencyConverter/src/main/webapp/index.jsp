<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Chuyển đổi USD sang VNĐ</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form action="convert" method="post">
    <label>Tỉ giá (VNĐ/USD):</label>
    <input type="number" name="rate" step="0.01" required /><br><br>

    <label>Số tiền USD:</label>
    <input type="number" name="usd" step="0.01" required /><br><br>

    <input type="submit" value="Chuyển đổi" />
</form>
</body>
</html>

$(document).ready(function () {
    loadSmartphones();

    $("#form-section").hide(); // ẩn form ban đầu
    $("#smartphoneList").hide(); 
    $("#display").on("click", function (e) {
        e.preventDefault();
        $("#smartphoneList").show(); 
        loadSmartphones();
    });

    $("#display-create").on("click", function (e) {
        e.preventDefault();
        resetForm();
        $("#form-section").show();
        $("#submit-button").val("Add");
        $("#smartphone-id").val(""); // clear id nếu có
    });

    $("#add-smartphone").on("submit", function (e) {
        e.preventDefault();

        const id = $('#smartphone-id').val();

        if (id) {
            // PATCH - cập nhật
            const updates = {
                producer: $('#producer').val(),
                model: $('#model').val(),
                price: $('#price').val()
            };

            $.ajax({
                type: "PATCH",
                url: `http://localhost:8080/api/smartphones/${id}`,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(updates),
                success: function () {
                    loadSmartphones();
                    $("#form-section").hide();
                    resetForm();
                }
            });
        } else {
            // POST - thêm mới
            const smartphone = {
                producer: $('#producer').val(),
                model: $('#model').val(),
                price: $('#price').val()
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/api/smartphones",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(smartphone),
                success: function () {
                    loadSmartphones();
                    $("#form-section").hide();
                    resetForm();
                }
            });
        }
    });

});

function loadSmartphones() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphones",
        success: function (data) {
            let content = `<table id="display-list" border="1"><tr>
                <th>${i18n.get('table.header.producer')}</th>
                <th>${i18n.get('table.header.model')}</th>
                <th>${i18n.get('table.header.price')}</th>
                <th>${i18n.get('table.header.actions')}</th></tr>`;
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                    <td>${data[i].producer}</td>
                    <td>${data[i].model}</td>
                    <td>${data[i].price}</td>
                    <td>
                        <button data-i18n="button.update" onclick="editSmartphone(${data[i].id})"></button>
                        <button data-i18n="button.delete" onclick="deleteSmartphone(${data[i].id})"></button>
                    </td></tr>`;
            }
            content += "</table>";
            $("#smartphoneList").html(content);

            // 👉 THÊM DÒNG NÀY
            if (typeof i18n !== 'undefined') {
                i18n.apply(); // cập nhật nội dung i18n cho các phần tử mới tạo
            }
        }
    });
}


function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: function () {
            loadSmartphones();
        }
    });
}

function editSmartphone(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: function (data) {
            $('#producer').val(data.producer);
            $('#model').val(data.model);
            $('#price').val(data.price);
            $('#smartphone-id').val(data.id);
            $('#submit-button').val("Update");
            $('#form-section').show();
        }
    });
}

function resetForm() {
    $('#producer').val('');
    $('#model').val('');
    $('#price').val('');
    $('#smartphone-id').val('');
}

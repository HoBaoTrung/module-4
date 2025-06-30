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
                <th>Producer</th><th>Model</th><th>Price</th><th>Actions</th></tr>`;
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                    <td>${data[i].producer}</td>
                    <td>${data[i].model}</td>
                    <td>${data[i].price}</td>
                    <td>
                        <button onclick="editSmartphone(${data[i].id})">Edit</button>
                        <button onclick="deleteSmartphone(${data[i].id})">Delete</button>
                    </td></tr>`;
            }
            content += "</table>";
            $("#smartphoneList").html(content);
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

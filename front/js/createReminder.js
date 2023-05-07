$(document).ready( function () {
    $("#create-reminder-form").validate({
        rules : {
            name: {
                required: true,
            },
            date : {
                required: true,
            }
        },
        submitHandler: function () {
            let data = {
                'name': $("#name").val(),
                'date': $("#date").val() + 'T03:00:00.000+00:00',
            }

            $.ajax({
                url: "http://localhost:8080/reminders",
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                crossDomain: true,
                dataType: "json",
                statusCode: {
                    400: function() {
                        alert("Erro");
                    },
                    201: function() {
                        document.location.reload(true);
                    }
                }
            });
        }
    });
});
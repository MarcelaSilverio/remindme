function deleteReminder(id) {
    $.ajax({
        url: "http://localhost:8080/reminders/" + id,
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        statusCode: {
            204: function() {
                document.location.reload(true);
            }
        }
    });
}

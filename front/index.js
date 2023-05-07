$(document).ready( function () {
    listAllReminders();

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
                dataType: "json"
            });
        }
    });
});

async function listAllReminders() {
    try {
        let remindersRequest = await fetch("http://localhost:8080/reminders");
        let remindersData = await remindersRequest.json();
        
        

    } catch (error) {
        console.log(error);
    }
}
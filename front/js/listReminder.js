$(document).ready( function () {
    listAllReminders();
});

async function listAllReminders() {
    
    try {
        let remindersRequest = await fetch("http://localhost:8080/reminders");
        let remindersData = await remindersRequest.json();
        let remidersGroupedByDate = {};

        remindersData.forEach(reminder => {
            if(!(reminder.date in remidersGroupedByDate)) {
                remidersGroupedByDate[reminder.date] = [];
            }

            remidersGroupedByDate[reminder.date].push(
                {
                    'id': reminder.id,
                    'name': reminder.name,
                }
            );
        });

        Object.keys(remidersGroupedByDate).forEach((date) => {
            let title = "<h2 class='date-title'>" + date + "</h2>";
            let remindersByDate = "";

            remidersGroupedByDate[date].forEach(reminder =>{
                remindersByDate += "<div class='reminder-content'>" + reminder.name +
                                        " <button class='delete-reminder-btn' onclick='deleteReminder(" + reminder.id + ")'>X</button>" +
                                    "</div>"
            });

            $("#reminder-content-wrapper").append(title + remindersByDate);
        });

    } catch (error) {
        console.log(error);
    }
}
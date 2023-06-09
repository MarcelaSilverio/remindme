$(document).ready( function () {
    listReminders();
});

async function listReminders() {
        const reminders = await getReminders();
        const content = reminders === false ? "<p>Sorry! Something unexpected happened.</p>" : getRemindersList(reminders);
        $("#reminder-content-wrapper").append(content);
}

async function getReminders() {
    try {
        const remindersRequest = await fetch("http://localhost:8080/reminders");
        
        return await remindersRequest.json();
    } catch (error) {
        console.log(error);
        
        return false;
    }
}

function getRemindersList(reminders) {
    remidersGroupedByDate = orderRemindersByDate(groupRemindersByDate(reminders));
    let remindersList = "";

    Object.keys(remidersGroupedByDate).forEach((date) => {
        const title = "<h2 class='date-title'>" + date + "</h2>";
        let remindersByDate = "";

        remidersGroupedByDate[date].forEach(reminder =>{
            remindersByDate += "<div class='reminder-content'>" + reminder.name +
                                    " <button class='delete-reminder-btn' onclick='deleteReminder(" + reminder.id + ")'>X</button>" +
                                "</div>"
        });

        remindersList += title + remindersByDate;
    });

    return remindersList;
}

function groupRemindersByDate(reminders) {
    remidersGroupedByDate = {};

    reminders.forEach(reminder => {
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

    return remidersGroupedByDate;
}

function orderRemindersByDate(reminders) {
    const sortedReminders = Object.keys(reminders)
    .sort()
    .reduce((accumulator, key) => {
        accumulator[key] = reminders[key];

        return accumulator;
    }, {});

    return sortedReminders;
}
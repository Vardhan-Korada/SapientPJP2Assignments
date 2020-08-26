document.getElementById("btnGetPeriod").onclick = function () {
        const startDate = document.getElementById("startDate").value;
        const endDate = document.getElementById("endDate").value;
        let start = Date.parse(startDate);
        let end = Date.parse(endDate);
        let elapsed = end - start;
        let {day,hour,minute,seconds} = convertMS(elapsed);
        alert(`Days: ${day} Hours: ${hour} Minutes: ${minute}`);
    };

function convertMS( milliseconds ) {
    let day, hour, minute, seconds;
    seconds = Math.floor(milliseconds / 1000);
    minute = Math.floor(seconds / 60);
    seconds = seconds % 60;
    hour = Math.floor(minute / 60);
    minute = minute % 60;
    day = Math.floor(hour / 24);
    hour = hour % 24;
    return {day,hour,minute};
}
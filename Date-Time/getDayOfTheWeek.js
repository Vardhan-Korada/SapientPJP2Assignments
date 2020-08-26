Date.prototype.getWeekDay = function() {
    var weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    return weekday[this.getDay()];
}
document.getElementById("btnGetDay").onclick = function () {
        const rwdate = document.getElementById("rawdate").value;
        let formattedDate = new Date(Date.parse(rwdate));
        let day = formattedDate.getWeekDay();
        alert(`Day: ${day}`);
    };
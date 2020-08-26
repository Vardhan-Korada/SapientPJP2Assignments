Date.prototype.getWeekNumber = function() { 
    const oneJan =  new Date(this.getFullYear(), 0, 1);
    let numberOfDays =  Math.floor((this - oneJan) / (24 * 60 * 60 * 1000)); 
    return Math.ceil((this.getDay() + 1 + numberOfDays) / 7); 
} 
document.getElementById("btnGetWeekNumber").onclick = function () {
        const rwdate = document.getElementById("rawdate").value;
        let formattedDate = new Date(Date.parse(rwdate));
        let num = formattedDate.getWeekNumber();
        alert(`Week Number: ${num}`);
};
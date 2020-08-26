document.getElementById("btnGetDate").onclick = function () {
        const rwdate = document.getElementById("rawdate").value;
        const years = document.getElementById("years").value;
        const months = document.getElementById("months").value;
        const weeks = document.getElementById("weeks").value;
        const days = document.getElementById("days").value;
        const oldDate = new Date(Date.parse(rwdate));
        const newDate = AddDate(AddDate(AddDate(AddDate(oldDate,parseInt(years),'Y'),parseInt(months),'M'),parseInt(weeks)*7,'D'),parseInt(days),'D');
        alert(newDate);
        
};
function AddDate(oldDate, offset, offsetType) {
	const year = parseInt(oldDate.getFullYear());
	const month = parseInt(oldDate.getMonth());
	const date = parseInt(oldDate.getDate());
	let newDate;
	switch (offsetType) {
		case "Y":
		case "y":
			newDate = new Date(year + offset, month, date);
			break;
		case "M":
		case "m":
			let yearOffset = 0;
			let monthOffset = 0;
			if (offset <12)
				{
					yearOffset = Math.floor((month + offset)/12);
					monthOffset = (month + offset)%12;
				}
			else
			{
				yearOffset = Math.floor(offset/12);
				monthOffset = month%12 + offset%12;
			}
			newDate = new Date(year + yearOffset, month + monthOffset, date);
			break;
		case "D":
		case "d":
			let o = oldDate.getTime();
			let n = o + offset * 24 * 3600 * 1000;
			newDate = new Date(n);
			break;
		default:
			newDate = new Date(year + offset, month, date);
		}
	return newDate;
}
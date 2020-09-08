using System;
using System.Collections.Generic;
using System.Globalization;

namespace Date_Time_Calculator
{
    public class GetWeekNumber : IOperation
    {
        public List<string> InputList { get; set; }
        public string Result { get; set; }
        public void PerformOperation()
        {
            var date = InputList[0];
            var dateValue = DateTime.ParseExact(date, "dd-MM-yyyy", System.Globalization.CultureInfo.InvariantCulture);
            var culture = CultureInfo.CurrentCulture;
            Result = Convert.ToString(culture.Calendar.GetWeekOfYear(dateValue, CalendarWeekRule.FirstFourDayWeek,
                DayOfWeek.Monday));
        }

        public void DisplayResult()
        {
            Console.WriteLine("Week Number is : {0}",Result);
        }
    }
}
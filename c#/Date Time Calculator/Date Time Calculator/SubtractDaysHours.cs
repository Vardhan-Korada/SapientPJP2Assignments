using System;
using System.Collections.Generic;
using System.Globalization;

namespace Date_Time_Calculator
{
    public class SubtractDaysHours : IOperation
    {
        public List<string> InputList { get; set; }
        public string Result { get; set; }
        public void PerformOperation()
        {
            var date = InputList[0];
            var dateValue = DateTime.ParseExact(date, "dd-MM-yyyy", System.Globalization.CultureInfo.InvariantCulture);
            Result = Convert.ToString(dateValue.AddDays(-Convert.ToDouble(InputList[1])).AddHours(-Convert.ToDouble(InputList[2])), CultureInfo.CurrentCulture);
        }

        public void DisplayResult()
        {
            Console.WriteLine("Resultant date is {0}", Result);
        }
    }
}
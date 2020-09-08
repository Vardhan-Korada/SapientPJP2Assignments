using System;
using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public class SubtractTwoDates : IOperation
    {
        public List<string> InputList { get; set; }
        public string Result { get; set; }
        public void PerformOperation()
        {
            var startDate = InputList[0];
            var endDate = InputList[1];
            var startDateValue = DateTime.ParseExact(startDate, "dd-MM-yyyy HH:mm", System.Globalization.CultureInfo.InvariantCulture);
            var endDateValue = DateTime.ParseExact(endDate, "dd-MM-yyyy HH:mm", System.Globalization.CultureInfo.InvariantCulture);
            Result = Convert.ToString((endDateValue - startDateValue).Days) + "::" +
                     Convert.ToString((endDateValue - startDateValue).Hours) + "::" +
                     Convert.ToString((endDateValue - startDateValue).Minutes);
        }

        public void DisplayResult()
        {
            var arr = Result.Split("::");
            Console.WriteLine("There are {0} days, {1} hours, {2} minutes between two timestamps",arr[0],arr[1],arr[2]);
        }
    }
}
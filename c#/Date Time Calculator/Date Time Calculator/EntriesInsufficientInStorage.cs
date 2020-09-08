using System;

namespace Date_Time_Calculator
{
    public class EntriesInsufficientInStorage : Exception
    {
        public EntriesInsufficientInStorage(string msg, in int n)
        {
            Console.WriteLine(msg, n);
        }
    }
}
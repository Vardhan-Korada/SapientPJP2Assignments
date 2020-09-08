using System;

namespace Date_Time_Calculator
{
    public class StorageIsFullException : Exception
    {
        public StorageIsFullException(string msg)
        {
            Console.WriteLine(msg);
        }
    }
}
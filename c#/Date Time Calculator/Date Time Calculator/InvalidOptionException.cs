using System;

namespace Date_Time_Calculator
{
    internal class InvalidOptionException : Exception
    {
        public InvalidOptionException(string msg)
        {
            Console.ForegroundColor = ConsoleColor.DarkRed;
            Console.WriteLine(msg);
            Console.ForegroundColor = ConsoleColor.White;
        }
    }
}
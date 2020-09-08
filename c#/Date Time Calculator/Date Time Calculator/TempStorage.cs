using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public class TempStorage
    {
        public static List<string> ResultList = new List<string>();

        public static void StoreResult(string result)
        {
            if (ResultList.Capacity == 100)
                ResultList.Add(result);
            else
                throw new StorageIsFullException("Storage is full; Can't store this result...");
        }

        public static void ClearLastNEntries(int n)
        {
            if (n < ResultList.Count)
                ResultList.RemoveRange(0, n);
            else
                throw new EntriesInsufficientInStorage("There are less than {0} entries in storage", n);
        }

        public static void ClearTheStorage()
        {
            ResultList.RemoveRange(0,ResultList.Count);
        }
    }
}
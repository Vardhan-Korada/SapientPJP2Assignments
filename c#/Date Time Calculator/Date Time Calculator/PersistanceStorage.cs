using System.IO;
namespace Date_Time_Calculator
{
    public class PersistanceStorage
    {
        public static string StoragePath = @"C:\results.txt";

        public static void StoreResult(string result)
        {
            using StreamWriter file =
                new StreamWriter(StoragePath, true);
            file.WriteLine(result);
        }

    }
}
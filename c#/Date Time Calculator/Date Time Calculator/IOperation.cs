using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public interface IOperation
    {
        public List<string> InputList { get; set; }
        public string Result { get; set; }

        public void PerformOperation();
        public void DisplayResult();
    }
}
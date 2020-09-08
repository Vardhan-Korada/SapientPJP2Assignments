using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public interface ISubMenu
    {
        public List<string> DisplayOptionsList { get; set; }
        public List<string> InputList { get; set; }
        public IOperation OperationToPerform { get; set; }

        public void DisplayOptionsAndGetValues();
        public void AddOption(string option);
    }
}
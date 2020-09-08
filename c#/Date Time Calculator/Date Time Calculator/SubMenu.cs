using System;
using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public class SubMenu : ISubMenu
    {
        public List<string> DisplayOptionsList { get; set; }
        public List<string> InputList { get; set; }
        public IOperation OperationToPerform { get; set; }

        public SubMenu()
        {
            DisplayOptionsList = new List<string>();
            InputList = new List<string>();
        }


        public void DisplayOptionsAndGetValues()
        {
            //Console.WriteLine("I am about to enter the loop...");
            foreach (var option in DisplayOptionsList)
            {
                Console.WriteLine(option);
                InputList.Add(Console.ReadLine());
            }

            this.OperationToPerform.InputList = this.InputList;
        }

        public void AddOption(string option)
        {
            this.DisplayOptionsList.Add(option);
        }

    }
}
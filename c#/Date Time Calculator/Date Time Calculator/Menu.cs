using System;
using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public class Menu : IMenu
    {
        public List<IMenuItem> MenuItems { get; }

        public Menu()
        {
            MenuItems = new List<IMenuItem>();
        }

        public void AddMenuItem(IMenuItem menuItem)
        {
            MenuItems.Add(menuItem);
        }

        public void DisplayMenu()
        {
            foreach (var menuItem in MenuItems)
                menuItem.DisplayOption();
            
        }
        public int GetUsersChoice()
        {
            Console.WriteLine("Enter your choice: ");
            return Convert.ToInt32(Console.ReadLine());
        }
    }
}
using System.Collections.Generic;

namespace Date_Time_Calculator
{
    public interface IMenu
    {
        public List<IMenuItem> MenuItems { get;}

        public void AddMenuItem(IMenuItem menuItem);
        public void DisplayMenu();
        public int GetUsersChoice();

    }
}
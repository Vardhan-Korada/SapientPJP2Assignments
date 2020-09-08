using System;
using System.Linq;

namespace Date_Time_Calculator
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var menu = MakeMenu();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("Select one of the following options: ");
            Console.ForegroundColor = ConsoleColor.Black;
            menu.DisplayMenu();
            var choice = menu.GetUsersChoice();
            if(choice > 5)
                throw new InvalidOptionException("The option entered is invalid... ");
            foreach (var menuItem in menu.MenuItems.Where(menuItem => choice == menuItem.MenuItemId))
            {
                menuItem.SubMenu.DisplayOptionsAndGetValues();
                menuItem.SubMenu.OperationToPerform.PerformOperation();
                menuItem.SubMenu.OperationToPerform.DisplayResult();
            }
        }

        private static IMenu MakeMenu()
        {
            var menu = new Menu();
            var subMenu1 = new SubMenu();
            subMenu1.AddOption("Enter the Date: ");
            subMenu1.OperationToPerform = new GetDayOfWeek();
            menu.AddMenuItem(new MenuItem("Get Day of the Week",1,subMenu1));
            var subMenu2 = new SubMenu();
            subMenu2.AddOption("Enter the Date: ");
            subMenu2.OperationToPerform = new GetWeekNumber();
            menu.AddMenuItem(new MenuItem("Get Week Number",2,subMenu2));
            var subMenu3 = new SubMenu();
            subMenu3.AddOption("Enter start date : ");
            subMenu3.AddOption("Enter end date : ");
            subMenu3.OperationToPerform = new SubtractTwoDates();
            menu.AddMenuItem(new MenuItem("Subtract Dates",3,subMenu3));
            var subMenu4 = new SubMenu();
            subMenu4.AddOption("Enter the date : ");
            subMenu4.AddOption("Enter days : ");
            subMenu4.AddOption("Enter hours : ");
            subMenu4.OperationToPerform = new AddDaysHours();
            menu.AddMenuItem(new MenuItem("Add Time to the date",4,subMenu4));
            var subMenu5 = new SubMenu();
            subMenu5.AddOption("Enter the date : ");
            subMenu5.AddOption("Enter days : ");
            subMenu5.AddOption("Enter hours : ");
            subMenu5.OperationToPerform = new SubtractDaysHours();
            menu.AddMenuItem(new MenuItem("Subtract Time from the date", 5, subMenu5));
            return menu;
        }
    }
}

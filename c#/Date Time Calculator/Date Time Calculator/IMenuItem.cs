namespace Date_Time_Calculator
{
    public interface IMenuItem
    {
        public string Option { get;}
        public int MenuItemId { get; }
        public ISubMenu SubMenu { get;}

        public void DisplaySubMenu();
        public void DisplayOption();
    }
}
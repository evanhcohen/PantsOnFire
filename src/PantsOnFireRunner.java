public class PantsOnFireRunner
{
    public static void main (String[] args)
    {
        MenuFrame m = new MenuFrame();
        GameFrame g = new GameFrame();
        InstructionsFrame i = new InstructionsFrame();
        WinFrame w = new WinFrame();
        MenuFrame.display(MenuFrame.getFrame());
    }
}

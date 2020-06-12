public class PantsOnFireRunner
{
    public static void main (String[] args)
    {
        // create the various frames that will be used
        MenuFrame m = new MenuFrame();
        GameFrame g = new GameFrame();
        InstructionsFrame i = new InstructionsFrame();
        WinFrame w = new WinFrame();

        // start the program by displaying the first screen, menu
        MenuFrame.display(MenuFrame.getFrame());
    }
}

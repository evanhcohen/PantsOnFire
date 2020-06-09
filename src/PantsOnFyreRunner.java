public class PantsOnFyreRunner
{
    public static void main (String[] args)
    {
        MenuFrame m = new MenuFrame();
        GameFrame g = new GameFrame();
        InstructionsFrame i = new InstructionsFrame();
        MenuFrame.display(MenuFrame.getFrame());
    }
}

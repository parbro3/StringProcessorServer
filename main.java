import proxy.StringProcessorCmdProxy;
import proxy.StringProcessorProxy;

public class main {

    public static void main(String[] args){

        /*
        StringProcessorProxy proxy = StringProcessorProxy.getInstance();
        System.out.print(proxy.trim("    byu    test   "));
        System.out.print(proxy.toLower("    bYu    teSt   "));
        System.out.print(proxy.parseDouble("10.21"));

        System.out.print("\n");
        StringProcessorCmdProxy cmdProxy = StringProcessorCmdProxy.getInstance();

        System.out.print(cmdProxy.trim("  byu   d   f   a    "));
        System.out.print(cmdProxy.toLower("  bYu   D   f   a    "));
        System.out.print(cmdProxy.parseDouble("$-10.21"));
        */

        System.out.print("playground started.");

        Playground pg = new Playground();
        pg.start();
    }

}

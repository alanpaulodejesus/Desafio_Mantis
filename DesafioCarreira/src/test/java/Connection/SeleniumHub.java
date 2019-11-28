package Connection;

import org.openqa.grid.selenium.GridLauncherV3;

public class SeleniumHub {


        public static void executaSeleniumGrid() throws Exception {
            String[] hub = {"-port", "4443",
                    "-host", "localhost",
                    "-role", "hub" };
            GridLauncherV3.main(hub);

            String[] node = {"-port", "5555",
                    "-host", "localhost",
                    "-role", "node",
                    "-hub", "http://localhost:4443/grid/register",
               //     "-servlets", "com.automation.remarks.remote.node.Video"
            };
            GridLauncherV3.main(node);
        }

/*
    public static void main(String []args) throws Exception {
        String[] hub = {"-port", "4443",
                "-host", "localhost",
                "-role", "hub" };
        GridLauncherV3.main(hub);

        String[] node = {"-port", "5555",
                "-host", "localhost",
                "-role", "node",
                "-hub", "http://localhost:4443/grid/register",
                "-servlets", "com.automation.remarks.remote.node.Video"};
        GridLauncherV3.main(node);
    }
    */
}






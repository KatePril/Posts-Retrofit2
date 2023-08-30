package utils;

import controller.AppController;
import model.AppModel;
import view.AppView;

public class AppStarter {

    public static void startApp() {
        AppModel model = new AppModel();
        AppView view = new AppView();
        AppController controller = new AppController(model,view);
        controller.runApp();
    }
}

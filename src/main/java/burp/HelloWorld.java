package burp;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import burp.api.montoya.ui.menu.BasicMenuItem;
import burp.api.montoya.ui.menu.Menu;
import burp.api.montoya.ui.menu.MenuItem;

public class HelloWorld implements BurpExtension {
    @Override
    public void initialize(MontoyaApi api)
    {
        // set extension name
        api.extension().setName("Burpext Dirsearch");
        Logging logging = api.logging();
        // write a message to our output stream
        logging.logToOutput("Hello output2.");
        //注册鼠标右键事件
        api.userInterface().registerContextMenuItemsProvider(new MyContextMenuItemsProvider(api));
        /*

        //顶部菜单 最顶部的
        BasicMenuItem alertEventItem = BasicMenuItem.basicMenuItem("Raise critical alert").withAction(
                () -> api.logging().raiseCriticalEvent("Alert from extension"));

        BasicMenuItem basicMenuItem = MenuItem.basicMenuItem("Unload extension");
        MenuItem unloadExtensionItem = basicMenuItem.withAction(() -> api.extension().unload());

        Menu menu = Menu.menu("Menu bar").withMenuItems(alertEventItem, unloadExtensionItem);

        api.userInterface().menuBar().registerMenu(menu);

        api.extension().registerUnloadingHandler(new MyExtensionUnloadingHandler(api));//注册卸载程序

         */
        //注册tab
        api.userInterface().registerHttpRequestEditorProvider(new MyHttpRequestEditorProvider(api));

    }
}

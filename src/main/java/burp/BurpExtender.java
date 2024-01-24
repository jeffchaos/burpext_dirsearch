package burp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BurpExtender implements IBurpExtender,IContextMenuFactory{

    private IBurpExtenderCallbacks callbacks;
    PrintWriter stdout = new PrintWriter(callbacks.getStdout(), true);
    PrintWriter stderr = new PrintWriter(callbacks.getStderr(), true);
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        // 设置扩展程序的名称和版本
        callbacks.setExtensionName("dirsearch");

        //打印到Burp的stdout和stderr
        stdout.println("dirsearch extension loaded");
        stderr.println("dirsearch extension error");
        callbacks.setExtensionName("dirsearch");
        callbacks.registerContextMenuFactory(this);
    }

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation iContextMenuInvocation) {
        // 创建一个菜单项，当右键点击一个请求时触发
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        JMenuItem menuItem = new JMenuItem("选项1");
        menuItem.addActionListener(new eventName(iContextMenuInvocation));
        return null;
    }

    public class eventName implements ActionListener{
        private IContextMenuInvocation invocation;
        public eventName(IContextMenuInvocation invocation){
            this.invocation = invocation;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // 处理菜单项点击事件
            // ...
            stdout.println("选项1被点击");
        }
    }
}

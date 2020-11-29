/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PortUtil
 * Author:   苏晨宇
 * Date:     2020/11/27 10:35
 * Description: 工具类 检查端口是否启动
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java.tmall.util;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 〈一句话功能简述〉<br>
 * 〈工具类 检查端口是否启动〉
 *
 * @author 苏晨宇
 * @create 2020/11/27
 * @since 1.0.0
 */
public class PortUtil {
    public static boolean testPort(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            ss.close();
            return false;
        } catch (java.net.BindException e) {
            return true;
        } catch (IOException e) {
            return true;
        }
    }

    public static void checkPort(int port, String server, boolean shutdown) {
        if (!testPort(port)) {
            if (shutdown) {
                String message = String.format("在端口 %d 未检查得到 %s 启动 %n", port, server);
                JOptionPane.showMessageDialog(null, message);
                System.exit(1);
            } else {
                String meassage = String.format("在端口 %d 未检查得到 %s 启动%n，是否继续？", port, server);
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(null, meassage))
                    System.exit(1);
            }
        }
    }
}
 

package com.costech.filter

import com.costech.controller.base.BaseController
import com.costech.plugin.websocketInstantMsg.ChatServer
import com.costech.plugin.websocketOnline.OnlineChatServer
import com.costech.plugin.websocketVideo.VideoServer
import com.costech.util.Const
import com.costech.util.DBUtil
import com.costech.util.Tools
import org.java_websocket.WebSocketImpl

import javax.servlet.*
import java.sql.SQLException

/**
 * @ClassName: StartFilter
 * @description: 启动tomcat时运行此类
 * @author: yangy
 * @create: 2018-09-17 13:23
 * */
class StartFilter extends BaseController implements Filter {

    /**
     * 初始化
     */
    void init(FilterConfig fc) throws ServletException {
        this.startWebsocketInstantMsg()
        this.startWebsocketOnline()
        this.startWebsocketVideo()
        this.reductionDbBackupQuartzState()
    }

    /**
     * 启动即时聊天服务
     */
    void startWebsocketInstantMsg() {
        WebSocketImpl.DEBUG = false
        ChatServer s
        try {
            String strWEBSOCKET = Tools.readTxtFile(Const.WEBSOCKET)//读取WEBSOCKET配置,获取端口配置
            if (strWEBSOCKET) {
                String[] strIW = strWEBSOCKET.split(";")
                if (strIW.length == 7) {
                    s = new ChatServer(Integer.parseInt(strIW[1]))
                    s.start()
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace()
        }
    }

    /**
     * 启动在线管理服务
     */
    void startWebsocketOnline() {
        WebSocketImpl.DEBUG = false
        OnlineChatServer s
        try {
            String strWEBSOCKET = Tools.readTxtFile(Const.WEBSOCKET)//读取WEBSOCKET配置,获取端口配置
            if (strWEBSOCKET) {
                String[] strIW = strWEBSOCKET.split(";")
                if (strIW.length == 7) {
                    s = new OnlineChatServer(Integer.parseInt(strIW[3]))
                    s.start()
                }
            }
            //System.out.println( "websocket服务器启动,端口" + s.getPort() )
        } catch (UnknownHostException e) {
            e.printStackTrace()
        }
    }

    /**
     * 启动视频弹幕服务
     */
    void startWebsocketVideo() {
        WebSocketImpl.DEBUG = false
        VideoServer s
        try {
            String strWEBSOCKET = Tools.readTxtFile(Const.WEBSOCKET);//读取WEBSOCKET配置,获取端口配置
            if (strWEBSOCKET) {
                String[] strIW = strWEBSOCKET.split(";")
                if (strIW.length == 7) {
                    s = new VideoServer(Integer.parseInt(strIW[6]))
                    s.start()
                }
            }
            //System.out.println( "websocket服务器启动,端口" + s.getPort() );
        } catch (UnknownHostException e) {
            e.printStackTrace()
        }
    }

    /**
     * web容器重启时，所有定时备份状态关闭
     */
    void reductionDbBackupQuartzState() {
        try {
            DBUtil.executeUpdate("UPDATE DB_TIMINGBACKUP SET STATUS = '2'")
        } catch (ClassNotFoundException e) {
            e.printStackTrace()
        } catch (SQLException e) {
            e.printStackTrace()
        }
    }


    void destroy() {
    }

    void doFilter(ServletRequest arg0, ServletResponse arg1,
                  FilterChain arg2) throws IOException, ServletException {
    }
}

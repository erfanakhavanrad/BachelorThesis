package com.tarazgroup.tws.socket;

import com.tarazgroup.tws.dao.crm.CrmVoipLogsRepository;
import org.asteriskjava.manager.*;
import org.asteriskjava.manager.action.StatusAction;
import org.asteriskjava.manager.event.CdrEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Aref Azizi
 * @date 11/23/22
 */
public class Logger implements ManagerEventListener {
    private final ManagerConnection managerConnection;
    @Value("${voip.ip}")
    private String ip;
//    @Value("admin")
    private String userName;
//    @Value("0938204386")
    private String pass;
    public Logger(String user,String pass)  {
        //  اینجا باید اطلاعاتی که برای کاربر در استریسک زده شده نوشته بشه
        //      ManagerConnectionFactory factory = new ManagerConnectionFactory("192.168.88.130", "admin", "F@np2ss")
        ManagerConnectionFactory factory = new ManagerConnectionFactory("172.16.10.1",5038, user,pass);
        this.managerConnection = factory.createManagerConnection();
        System.out.println("second level  : connecting to asterisk in twsAplication"  );

    }
    public void startVoip() throws AuthenticationFailedException, IOException, InterruptedException, TimeoutException {
        run();
    }
    public void run() throws IOException, AuthenticationFailedException,
            TimeoutException, InterruptedException {


        // register for events
        managerConnection.addEventListener(this);
        // connect to Asterisk and log in
        try {
            managerConnection.login();
        }
        catch (Exception e){
            System.out.println("logiiiiiiiin eroooor=======>" + e.getMessage());
        }
        // request channel state
        managerConnection.sendAction(new StatusAction());

        // wait 10 seconds for events to come in
        Thread.sleep(1000000000);

        // and finally log off and disconnect
        managerConnection.logoff();
    }

    public static void main(String[] args) throws Exception {
//        Logger logger;
//        logger = new Logger();
//        logger.run();
    }

    public void onManagerEvent(ManagerEvent event) {
        if (event instanceof CdrEvent) {
            CdrEvent ev = (CdrEvent) event;
            if (LogMessageDto.internalPhoneNum != null) {
                String callerId = ev.getCallerId();
                String destination = ev.getDestination();
                if ((callerId.contains(LogMessageDto.internalPhoneNum)) || destination.contains(LogMessageDto.internalPhoneNum)) {
//                    System.out.println("nullnullnull");
                    LogMessageDto.logMessage = null;
                }
            }
            LoggerThread loggerThread = new LoggerThread(ev);
            loggerThread.save();
        }
        String callerIdNum = event.getCallerIdNum();
        String connectedLineNum = event.getConnectedLineNum();

        if (LogMessageDto.internalPhoneNum != null) {
            if (Objects.equals(callerIdNum, LogMessageDto.internalPhoneNum) || Objects.equals(connectedLineNum, LogMessageDto.internalPhoneNum)) {
                if (event.getConnectedLineNum() == null && event.getConnectedLineName() == null || event.getChannelState() == null) {
                    LogMessageDto.logMessage = null;
                } else if (!event.getCallerIdName().contains("CID") || !event.getConnectedLineName().contains("CID")) {
                    LogMessageDto.logMessage = (" کاربر " + event.getConnectedLineName() + " با شماره  " + event.getConnectedLineNum() + " در حال تماس با  " + event.getCallerIdNum() + "/" + event.getCallerIdName() + " است");
                } else {
                    LogMessageDto.logMessage = (" کاربر " + event.getCallerIdNum() + " با شماره  " + event.getCallerIdName() + " در حال تماس با  " + event.getConnectedLineName() + "/" + event.getConnectedLineNum() + " است");
                }
            }
        }

    }

}

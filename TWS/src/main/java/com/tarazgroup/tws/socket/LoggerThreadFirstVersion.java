package com.tarazgroup.tws.socket;
//
//import com.tarazgroup.tws.model.crm.CrmVoipLogs;
//import org.asteriskjava.manager.event.ManagerEvent;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Objects;
//
///**
// * @author Aref Azizi
// * @date 12/17/22
// */
public class LoggerThreadFirstVersion {
//    package com.tarazgroup.tws.socket;
//
//
//import com.tarazgroup.tws.model.crm.CrmVoipLogs;
//import org.asteriskjava.manager.event.ManagerEvent;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Objects;
//
//    /**
//     * @author Aref Azizi
//     * @date 11/23/22
//     */
//    public class LoggerThread extends Thread {
//
//        ManagerEvent event;
//
//        LogMessageDto logMassageDTO = new LogMessageDto();
//
//
//        public LoggerThread(ManagerEvent event) {
//            this.event = event;
//        }
//
//        public void log() {
////        if (LogMessageDto.isHangUp ) {
////            LogMessageDto.logMessage = null;
////        }
////        if (event.getCallerIdName() != null && event.getCallerIdNum() != null )  {
////            System.out.println(event);
//
//            try {
//                String callerIdNum = event.getCallerIdNum();
//                String connectedLineNum = event.getConnectedLineNum();
////                if ( event.getConnectedLineNum() != null  ) {
//                if (event.getConnectedLineNum() == null && event.getConnectedLineName() == null || event.getChannelState() == null) {
//                    LogMessageDto.logMessage = null;
//                }
////            if (LogMessageDto.internalPhoneNum != null) {
////                if (Objects.equals(callerIdNum, LogMessageDto.internalPhoneNum) || Objects.equals(connectedLineNum, LogMessageDto.internalPhoneNum)) {
////                    logMassageDTO.setLogMessage(" کاربر " + event.getCallerIdName() + " با شماره  " + event.getCallerIdNum() + " در حال تماس یا  " + event.getConnectedLineName() + " است");
////                    System.out.println("test1");
////                    if (event.getChannelState() ==7 ){
////                        LogMessageDto.logMessage =null;
////                    }
////                }
////            }
//
//                if (event.getChannelState() != null) {
//                    // This insert busy calls data
//                    if (event.getChannelState() == 7) {
//                        System.out.println("before busy" + LogMessageDto.busyCall);
//                        if (!Objects.equals(LogMessageDto.busyCall, event.getCallerIdNum())) {
//                            LogMessageDto.busyCall = event.getCallerIdNum();
//                            System.out.println("After busy" + LogMessageDto.busyCall);
//                            CrmVoipLogs crmVoipLogs = mapEventToCrmVoipLogsBusyState(event);
//                            crmVoipLogs.setChannelStateDesc("ردشده/مشغول");
//                            CrmVoipLoggerService.crmInsVoipLogger(crmVoipLogs);
//                        }
//                    }
//                    // Insert every calls connected  or even phone rings
//                    if (!Objects.equals(LogMessageDto.name, event.getConnectedLineNum()) && event.getConnectedLineNum() != null && event.getChannelState() == 0) {
//                        CrmVoipLogs crmVoipLogs = mapEventToCrmVoipLogsDownState(event);
//                        ArrayList<CrmVoipLogs> crmVoipLogList = new ArrayList<>();
//                        crmVoipLogList.add(0, crmVoipLogs);
//                        CrmVoipLogs prevEvent = crmVoipLogList.get(0);
//                        LogMessageDto.name = event.getConnectedLineNum();
//                        crmVoipLogs.setChannelStateDesc("برقرار شده");
//                        CrmVoipLoggerService.crmInsVoipLogger(crmVoipLogs);
//                        if (LogMessageDto.internalPhoneNum != null) {
//                            if (Objects.equals(callerIdNum, LogMessageDto.internalPhoneNum) || Objects.equals(connectedLineNum, LogMessageDto.internalPhoneNum)) {
//                                logMassageDTO.setLogMessage(" کاربر " + event.getCallerIdName() + " با شماره  " + event.getCallerIdNum() + " در حال تماس یا  " + event.getConnectedLineName() + " است");
//                                System.out.println("test1");
////                            if (event.getChannelState() ==7 ){
////                                LogMessageDto.logMessage =null;
////                            }
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("EXCEPTION WAS " + e.getMessage());
//            }
//        }
////    }
//
//        // this method  insert caller name and num instead connectedLine name and num because we call it in Down state
//        public CrmVoipLogs mapEventToCrmVoipLogsDownState(ManagerEvent event) {
//            CrmVoipLogs model = new CrmVoipLogs();
//            model.setCallerName(event.getConnectedLineName());
//            model.setCallerNumber(event.getConnectedLineNum());
//            model.setConnectedLineName(event.getCallerIdName());
//            model.setConnectedLineNumber(event.getCallerIdNum());
//            model.setChannelState(BigDecimal.valueOf(event.getChannelState()));
//            model.setChannelStateDesc(event.getChannelStateDesc());
//            model.setDateReceived((event.getDateReceived()));
//            model.setPriority(BigDecimal.valueOf(event.getPriority()));
////        model.setSequenceNumber(BigDecimal.valueOf(event.getSequenceNumber()));
//            model.setSystemName(event.getSystemName());
//            model.setContext(event.getContext());
//            model.setExten(event.getExten());
//            model.setFile(event.getFile());
//            model.setFunc(event.getFunc());
////        model.setLine(BigDecimal.valueOf(event.getLine()));
//            model.setPrivilege(event.getPrivilege());
////        model.setTimeStamp(BigDecimal.valueOf(event.getTimestamp()));
//            return model;
//        }
//
//        public CrmVoipLogs mapEventToCrmVoipLogsBusyState(ManagerEvent event) {
//            CrmVoipLogs model = new CrmVoipLogs();
//            model.setCallerName(event.getCallerIdName());
//            model.setCallerNumber(event.getCallerIdNum());
//            model.setConnectedLineName(event.getConnectedLineName());
//            model.setConnectedLineNumber(event.getConnectedLineNum());
//            model.setChannelState(BigDecimal.valueOf(event.getChannelState()));
//            model.setChannelStateDesc(event.getChannelStateDesc());
//            model.setDateReceived((event.getDateReceived()));
//            model.setPriority(BigDecimal.valueOf(event.getPriority()));
////        model.setSequenceNumber(BigDecimal.valueOf(event.getSequenceNumber()));
//            model.setSystemName(event.getSystemName());
//            model.setContext(event.getContext());
//            model.setExten(event.getExten());
//            model.setFile(event.getFile());
//            model.setFunc(event.getFunc());
////        model.setLine(BigDecimal.valueOf(event.getLine()));
//            model.setPrivilege(event.getPrivilege());
////        model.setTimeStamp(BigDecimal.valueOf(event.getTimestamp()));
//            return model;
//        }
//
//    }
//
}

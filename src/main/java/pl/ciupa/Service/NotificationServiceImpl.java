package pl.ciupa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2017-08-23.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void addInfoMessage(String msg) {
        addNotificationMessage(NotificationMessageType.INFO,msg);
    }

    @Override
    public void addErrorMessage(String msg) {
        addNotificationMessage(NotificationMessageType.ERROR,msg);
    }

    public enum NotificationMessageType {
        INFO, ERROR
    }

    private void addNotificationMessage(NotificationMessageType type, String msg){
        List<NotificationMessage> notifyMessages = (List<NotificationMessage>)
                httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
        if(notifyMessages == null){
            notifyMessages = new ArrayList<NotificationMessage>();
        }

        notifyMessages.add(new NotificationMessage(type, msg));

        httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);
    }


    public class NotificationMessage{
        NotificationMessageType type;
        String text;

        public NotificationMessage(NotificationMessageType type, String text) {
            this.type = type;
            this.text = text;
        }

        public NotificationMessageType getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }


}

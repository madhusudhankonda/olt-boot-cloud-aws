package com.chocolateminds.sns;

import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.config.annotation.NotificationSubject;
import io.awspring.cloud.messaging.endpoint.NotificationStatus;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationMessageMapping;
import io.awspring.cloud.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class acts as a HTTP endpoint for the topic subscription.
 *
 * If you are running in a localhost and wish to attach the endpoint as an HTTP subscription,
 * use ngrok to expose your locahost url to the world
 */
@Controller
@RequestMapping("/bootcloudaws-topic")
public class SNSMessageReceiver {

    @NotificationSubscriptionMapping
    public void confirmSubscription(NotificationStatus status){
        System.out.println("Confirming notification..");
        status.confirmSubscription();
    }

    @NotificationMessageMapping
    public void receiveNotifications(@NotificationMessage String message, @NotificationSubject String subject){
        System.out.println("Notification Subject"+message);
        System.out.println("Notification Message:"+message);
    }

}

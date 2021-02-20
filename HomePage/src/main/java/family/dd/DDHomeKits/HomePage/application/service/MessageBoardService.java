package family.dd.DDHomeKits.HomePage.application.service;

import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.MessagePublisher;
import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.entity.Message;
import family.dd.DDHomeKits.HomePage.interfaces.dto.PublishedMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageBoardService {
    private MessagePublisher messagePublisher;

    @Autowired
    public void setMessagePublisher(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    public void publish(String title, String content){
        messagePublisher.publish(new Message(title, content, "Anonymous DD"));
    }

    public List<PublishedMessageDTO> listRecentTenMessages(){
        return messagePublisher.listRecents(10);
    }
}

package family.dd.DDHomeKits.HomePage.application.service;

import family.dd.DDHomeKits.HomePage.domain.MessageBoard.MessageBoard;
import family.dd.DDHomeKits.HomePage.domain.MessageBoard.entity.Message;
import family.dd.DDHomeKits.HomePage.interfaces.dto.PublishedMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageBoardService {
    MessageBoard messageBoard;

    @Autowired
    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public void publish(String title, String content, String author){
        messageBoard.publish(new Message(title, content, author));
    }

    public List<PublishedMessageDTO> listRecentTenMessages(){
        return messageBoard.listRecents(10);
    }
}

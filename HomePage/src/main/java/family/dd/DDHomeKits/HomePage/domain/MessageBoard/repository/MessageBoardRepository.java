package family.dd.DDHomeKits.HomePage.domain.MessageBoard.repository;

import family.dd.DDHomeKits.HomePage.domain.MessageBoard.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class MessageBoardRepository {
    private MessageBoardMapper mapper;

    @Autowired
    public void setMessageBoardMapper(MessageBoardMapper mapper) {
        this.mapper = mapper;
    }

    public List<MessageBoardPO> findRecentMessages(int limit) {
        return mapper.findRecentMessages(limit);
    }

    public void addMessage(Message message){
        MessageBoardPO newMessage = new MessageBoardPO();
        newMessage.setTitle(message.getTitle());
        newMessage.setContent(message.getContent());
        newMessage.setAuthor(message.getAuthor());

        mapper.add(newMessage);
    }
}

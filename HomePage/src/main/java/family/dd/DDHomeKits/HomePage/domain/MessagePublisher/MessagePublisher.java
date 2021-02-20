package family.dd.DDHomeKits.HomePage.domain.MessagePublisher;

import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.entity.Message;
import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.repository.MessageBoardPO;
import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.repository.MessageBoardRepository;
import family.dd.DDHomeKits.HomePage.interfaces.dto.PublishedMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessagePublisher {
    private MessageBoardRepository repository;

    @Autowired
    public void setRepository(MessageBoardRepository repository) {
        this.repository = repository;
    }

    public void publish(Message message){
        repository.addMessage(message);
    }

    public List<PublishedMessageDTO> listRecents(int limit) {
        List<MessageBoardPO> poList = repository.findRecentMessages(limit);
        List<PublishedMessageDTO> dtoList = poList.stream()
                .sorted(Comparator.comparing(MessageBoardPO::getPubDate).reversed())
                .map(po->new PublishedMessageDTO(po)).collect(Collectors.toList());
        return dtoList;
    }
}

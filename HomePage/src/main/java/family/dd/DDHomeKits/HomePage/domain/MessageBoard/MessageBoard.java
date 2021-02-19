package family.dd.DDHomeKits.HomePage.domain.MessageBoard;

import family.dd.DDHomeKits.HomePage.domain.MessageBoard.entity.Message;
import family.dd.DDHomeKits.HomePage.domain.MessageBoard.repository.MessageBoardPO;
import family.dd.DDHomeKits.HomePage.domain.MessageBoard.repository.MessageBoardRepository;
import family.dd.DDHomeKits.HomePage.interfaces.dto.PublishedMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class MessageBoard {
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
                .map(po->new PublishedMessageDTO(po.getTitle(),
                        po.getContent(),
                        po.getAuthor(),
                        po.getPubDate())).collect(Collectors.toList());
        return dtoList;
    }
}

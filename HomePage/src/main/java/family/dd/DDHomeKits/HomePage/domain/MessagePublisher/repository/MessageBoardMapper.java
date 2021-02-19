package family.dd.DDHomeKits.HomePage.domain.MessagePublisher.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageBoardMapper {
    @Select("Select msgId, " +
            "title, content, " +
            "author, " +
            "pubDate " +
            "from MessagePublisher " +
            "order by msgId desc " +
            "limit #{limit}")
    List<MessageBoardPO> findRecentMessages(int limit);

    @Insert("Insert into MessagePublisher(title, " +
            "content, " +
            "author) values (#{title}, " +
            "#{content}, " +
            "#{author})")
    void add(MessageBoardPO messageBoardPO);
}

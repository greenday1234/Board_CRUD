package gdsc.board.service;

import gdsc.board.domain.Data;
import gdsc.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final JpaBoardRepository boardRepository;

    public void submit(Data data){
        boardRepository.save(data);
    }

    public List<Data> findMembers(){
        return boardRepository.findAll();
    }

    public Optional<Data> findOne(Long memberId){
        return boardRepository.findById(memberId);
    }

    public void update(Long id,String content) {
        Data data = boardRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("존재안함"));
        data.setContent(content);
        boardRepository.save(data);
    }

    public List<Data> findAll() {
        return boardRepository.findAll();
    }
}

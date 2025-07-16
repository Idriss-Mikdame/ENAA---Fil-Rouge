package ma.enaa.enaafillrouge.Service;

import ma.enaa.enaafillrouge.Dto.CommentairDto;
import ma.enaa.enaafillrouge.Entity.Commentair;
import ma.enaa.enaafillrouge.Mapper.CommentairMapper;
import ma.enaa.enaafillrouge.Mapper.CommentairMapperImpl;
import ma.enaa.enaafillrouge.Repository.CpmmentairRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServices {

    private final CommentairMapper commentairMapper;
    private final CpmmentairRepository commentairRepository;

    public CommentaireServices(CommentairMapper commentairMapper, CpmmentairRepository commentairRepository) {
        this.commentairMapper = commentairMapper;
        this.commentairRepository = commentairRepository;
    }

    public CommentairDto AddCommentair(CommentairDto commentairDto){
        Commentair commentair = commentairMapper.toEntity(commentairDto);
        Commentair commentair1 = commentairRepository.save(commentair);
        return commentairMapper.toDto(commentair1);
    }

    public List<CommentairDto> AfficherCommenatair(){
        return commentairRepository.findAll().stream()
                .map(commentairMapper::toDto).toList();
    }

    public CommentairDto ModifierCommentair(CommentairDto commentairDto,Long id){
        Commentair commentair = commentairRepository.findById(id).orElse(null);
        commentair.setNote(commentairDto.getNote());
        commentair.setCommentair(commentairDto.getCommentair());
        return commentairMapper.toDto(commentairRepository.save(commentair));
    }
    public void SupprimerCommentair(Long id){
        commentairRepository.deleteById(id);
    }
}

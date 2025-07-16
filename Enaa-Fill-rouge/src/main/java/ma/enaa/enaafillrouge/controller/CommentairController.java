package ma.enaa.enaafillrouge.controller;

import ma.enaa.enaafillrouge.Dto.CommentairDto;
import ma.enaa.enaafillrouge.Dto.ProduitDto;
import ma.enaa.enaafillrouge.Service.CommentaireServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/commentair")
public class CommentairController {
    private final CommentaireServices commentaireServices;

    public CommentairController(CommentaireServices commentaireServices) {
        this.commentaireServices = commentaireServices;
    }
    @PostMapping
    public CommentairDto ADD(@RequestBody CommentairDto commentairDto){
        return commentaireServices.AddCommentair(commentairDto);
    }

    @GetMapping
    public List<CommentairDto> get(){
        return commentaireServices.AfficherCommenatair();
    }

//    @GetMapping("{id}")
//    public CommentairDto AfficherParid(@PathVariable Long id){
//        return commentaireServices.AfficheProduitByid(id);
//    }

    @PutMapping("{updateid}")
    public CommentairDto Updat(@PathVariable Long updateid, @RequestBody CommentairDto commentairDto) {
        return commentaireServices.ModifierCommentair(commentairDto, updateid);
    }
    @DeleteMapping("{id}")
    public void Supprimer(@PathVariable Long id){
        commentaireServices.SupprimerCommentair(id);
    }
}

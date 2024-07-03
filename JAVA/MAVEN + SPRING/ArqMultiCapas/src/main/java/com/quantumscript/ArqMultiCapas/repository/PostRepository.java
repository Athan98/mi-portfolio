package com.quantumscript.ArqMultiCapas.repository;

import com.quantumscript.ArqMultiCapas.models.Post;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements IPostRepository {

    @Override
    public List<Post> traerPosteos() {
        List<Post> posteos = new ArrayList<>();
        posteos.add(new Post(1L, "¿Como formatear una PC?", "Nicolas Roldan"));
        posteos.add(new Post(2L, "¿Como mantener la seguridad informatica?", "Nicolas Roldan"));
        
        return posteos;
    }

}

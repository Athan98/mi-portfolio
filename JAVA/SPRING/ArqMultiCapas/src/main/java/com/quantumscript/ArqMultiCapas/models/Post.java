package com.quantumscript.ArqMultiCapas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private Long idPost;
    private String titulo;
    private String autor;

    public Post(Long idPost, String titulo, String autor) {
        this.idPost = idPost;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Post() {
    }

}

package com.miracle.eva.web.jsf.controller.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.entity.user.User;
import com.miracle.eva.service.facade.post.PostFacade;
import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.web.jsf.controller.Controller;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Named
@SessionScoped
public class PostController extends Controller<Post, Long> {

    @Inject
    protected PostController(PostFacade facade) {
        super(facade);
    }

    @NotNull
    @Size(max = 5000)
    private String text;

    @PostConstruct
    @Override
    protected void init() {
        e = new Post();
        text = "";
    }

    public List<Post> findAllByOwnerId(Long s) {
        List<Post> posts = ((PostFacade)facade).findAllByOwnerId(s,new RangeResult(offset,limit));
        Collections.reverse(posts);
        return  posts;
    }


    @Override
    public List<Post> findAll() {
        List<Post> posts = super.findAll();
        Collections.reverse(posts);
        return  posts;
    }


    private void setFields(){
        e.setText(text);
        e.setDate(LocalDate.now());
        e.setUpdateDate(e.getDate());
        e.setLikesCount(0);
        e.setCommentsCount(0);
    }


    public void createPost(User user) {
        e.setUser(user);
        setFields();
        super.create();
    }

    @Override
    public void create() {
        setFields();
        super.create();
    }

    public void remove(Post post){
        facade.remove(post);
    }

}

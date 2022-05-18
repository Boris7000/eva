package com.miracle.eva.service.actions.remove.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.actions.read.post.PostReader;
import com.miracle.eva.service.actions.remove.EntityRemover;
import jakarta.inject.Inject;

public class PostRemover extends EntityRemover<Post, Long> {
    @Inject
    public PostRemover(PostReader finder) {
        super(Post.class, finder);
    }
}

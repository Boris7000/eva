package com.miracle.eva.service.actions.create.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.actions.create.EntityCreator;
import jakarta.ejb.Stateless;

@Stateless
public class PostCreator extends EntityCreator<Post> {
    @Override
    public Class<Post> getEntityClass() {
        return Post.class;
    }
}

package com.miracle.eva.service.actions.update.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.actions.update.EntityUpdater;
import jakarta.ejb.Stateless;

@Stateless
public class PostUpdater extends EntityUpdater<Post, Long> {

    public PostUpdater() {
        super(Post.class);
    }

    @Override
    protected Post getEditedEntity(Post source, Post target) {
        target.setText(source.getText());
        target.setUpdateDate(source.getUpdateDate());
        target.setLikesCount(source.getLikesCount());
        target.setCommentsCount(source.getCommentsCount());
        return target;
    }
}

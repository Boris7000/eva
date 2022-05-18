package com.miracle.eva.service.facade.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.actions.create.EntityCreator;
import com.miracle.eva.service.actions.read.EntityReader;
import com.miracle.eva.service.actions.read.post.PostReader;
import com.miracle.eva.service.actions.remove.EntityRemover;
import com.miracle.eva.service.actions.update.EntityUpdater;
import com.miracle.eva.service.facade.Facade;
import com.miracle.eva.service.util.RangeResult;

import java.io.Serializable;
import java.util.List;

public abstract class PostFacade  extends Facade<Post, Long> implements IPostService, Serializable {

    public PostFacade(EntityCreator<Post> creator,
                      EntityReader<Post, Long> finder,
                      EntityUpdater<Post, Long> updater,
                      EntityRemover<Post, Long> remover) {
        super(Post.class, creator, finder, updater, remover);
    }

    @Override
    public List<Post> findAllByOwnerId(String s, RangeResult rangeResult) {
        return ((PostReader) finder).findAllByOwnerId(s,rangeResult);
    }

    @Override
    public List<Post> findAllByOwnerId(Long s, RangeResult rangeResult) {
        return ((PostReader) finder).findAllByOwnerId(String.valueOf(s),rangeResult);
    }
}

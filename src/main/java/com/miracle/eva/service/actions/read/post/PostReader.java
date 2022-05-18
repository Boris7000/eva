package com.miracle.eva.service.actions.read.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.actions.read.EntityReader;
import com.miracle.eva.service.util.RangeResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PostReader extends EntityReader<Post, Long> implements IPostReader{

    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }

    @Override
    public List<Post> findAllByOwnerId(String id, RangeResult rangeResult) {
        return rankedQueryResults(
                getfindAllQuery(new String[]{
                                "user", "id"
                        }, id
                ), rangeResult);
    }

}

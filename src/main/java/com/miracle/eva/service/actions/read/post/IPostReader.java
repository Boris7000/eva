package com.miracle.eva.service.actions.read.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.util.RangeResult;

import java.util.List;

public interface IPostReader {
    List<Post> findAllByOwnerId(String s, RangeResult rangeResult);
}

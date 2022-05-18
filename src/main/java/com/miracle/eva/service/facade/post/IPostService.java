package com.miracle.eva.service.facade.post;

import com.miracle.eva.entity.post.Post;
import com.miracle.eva.service.util.RangeResult;

import java.util.List;

public interface IPostService {

    List<Post> findAllByOwnerId(String s, RangeResult rangeResult);

    List<Post> findAllByOwnerId(Long s, RangeResult rangeResult);
}

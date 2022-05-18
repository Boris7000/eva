package com.miracle.eva.service.facade.post;

import com.miracle.eva.service.actions.create.post.PostCreator;
import com.miracle.eva.service.actions.read.post.PostReader;
import com.miracle.eva.service.actions.remove.post.PostRemover;
import com.miracle.eva.service.actions.update.post.PostUpdater;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
public class PostFacadeImpl extends PostFacade{

    @Inject
    public PostFacadeImpl(PostCreator creator,
                          PostReader finder,
                          PostUpdater articleUpdater,
                          PostRemover articleRemover) {
        super(creator,finder,articleUpdater,articleRemover);
    }

}

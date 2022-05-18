package com.miracle.eva.service.facade.user;

import com.miracle.eva.service.actions.create.user.UserCreator;
import com.miracle.eva.service.actions.read.user.UserReader;
import com.miracle.eva.service.actions.remove.user.UserRemover;
import com.miracle.eva.service.actions.update.user.UserUpdater;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
public class UserFacadeImpl extends UserFacade {

    @Inject
    public UserFacadeImpl(UserCreator creator,
                          UserReader finder,
                          UserUpdater articleUpdater,
                          UserRemover articleRemover) {
        super(creator,finder,articleUpdater,articleRemover);
    }

}

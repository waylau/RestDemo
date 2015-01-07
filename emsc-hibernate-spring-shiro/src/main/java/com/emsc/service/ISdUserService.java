package com.emsc.service;

import com.emsc.entity.SdUser;
import com.waylau.service.base.IBaseService;

public interface ISdUserService extends IBaseService<SdUser, Integer> {

	SdUser findByName(String username);
}

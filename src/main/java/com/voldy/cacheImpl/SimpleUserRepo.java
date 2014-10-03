package com.voldy.cacheImpl;

import org.springframework.cache.annotation.Cacheable;

import com.voldy.apiImpl.WalletImpl;
import com.voldy.beans.User;
import com.voldy.cacheInteface.IUserRepo;

public class SimpleUserRepo implements IUserRepo{

	@Override
	//@Cacheable("users")
	public User getUserById(String id) {
		return WalletImpl.userMap.get(id);
	}

}

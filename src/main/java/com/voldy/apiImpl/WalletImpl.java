package com.voldy.apiImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.voldy.beans.BankAccount;
import com.voldy.beans.IDCard;
import com.voldy.beans.User;
import com.voldy.beans.WebLogin;

public class WalletImpl {
	public static Map<String, User> userMap = new HashMap<String, User>();
	public static List<IDCard> idCardList  = new ArrayList<IDCard>();
	public static List<WebLogin> webLoginList  = new ArrayList<WebLogin>();
	public static List<BankAccount> bankAccountList  = new ArrayList<BankAccount>();
	public void saveUsersToMap(User user){
		userMap.put(user.getId(), user);
	}
}


package com.voldy.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.voldy.apiImpl.WalletImpl;
import com.voldy.beans.BankAccount;
import com.voldy.beans.IDCard;
import com.voldy.beans.User;
import com.voldy.beans.WebLogin;
import com.voldy.cacheInteface.IUserRepo;
import com.voldy.exception.ErrorMessage;

@RestController
public class WalletController{
	@Autowired
    private IUserRepo uWallet;
	
    private final AtomicLong uidIncrement = new AtomicLong();
    private final AtomicLong idIncrement = new AtomicLong();
    private final AtomicLong widIncrement = new AtomicLong();
    private final AtomicLong bidIncrement = new AtomicLong();
    private final WalletImpl mainWallet = new WalletImpl();
    
    //-----------------------------Users API----------------------------
    @RequestMapping(value="api/v1//users",method = RequestMethod.POST)
     
    public User createUsers(@Valid @RequestBody User user) {
        System.out.println("user  "+user.getEmail() );
        user.setId("u-"+uidIncrement.incrementAndGet());
        user.setCreated_at(new Date().toString());
    	mainWallet.saveUsersToMap(user);
    	return user;
    }
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }
        return new ErrorMessage(errors);
    }

    @RequestMapping(value="api/v1//users/{user_id}",method = RequestMethod.GET)
    public User viewUser(@PathVariable("user_id") String id) {
    return uWallet.getUserById(id);
    }
    
   
    @RequestMapping(value="api/v1//users/{user_id}",method = RequestMethod.PUT)
     public User updateUser(@PathVariable("user_id") String id,@RequestBody User user) {
    	User userRemoved = WalletImpl.userMap.remove(id);
    	user.setCreated_at(userRemoved.getCreated_at());
    	user.setEmail(userRemoved.getEmail());
    	user.setId(id);
    	user.setUpdated_at(new Date().toString());
    	WalletImpl.userMap.put(id, user);
    	return user;
    }
    
  //-----------------------------Users End----------------------------
    
  //---------------------Id Cards API-------------------------------------
   
    @RequestMapping(value="api/v1//users/{user_id}/idcards",method = RequestMethod.POST)
    public IDCard   createIDCard(@RequestBody IDCard idCard, @PathVariable("user_id") String id) {
    	idCard.setCard_id("c-"+idIncrement.incrementAndGet());
    	idCard.setUser_id(id);
    	WalletImpl.idCardList.add(idCard);
    	return idCard;
    }
    
    @RequestMapping(value="api/v1//users/{user_id}/idcards",method = RequestMethod.GET)
    public List<IDCard> listIDCards(@PathVariable("user_id") String id) {
    	Iterator<IDCard> it = WalletImpl.idCardList.iterator();
    	List<IDCard> resultList = new ArrayList<IDCard>();
    	while(it.hasNext()){
    		IDCard idCard = it.next();
    		if(idCard.getUser_id()!=null && idCard.getUser_id().equals(id)){
    				resultList.add(idCard);
    		}
    	}
    	return resultList;
    }
    
    @RequestMapping(value="api/v1//users/{user_id}/idcards/{card_id}",method = RequestMethod.DELETE)
    public void deleteIDCard(@PathVariable("user_id") String id , @PathVariable("card_id") String cid) {
    	List<IDCard> itemsToRemoveList = new ArrayList<IDCard>();
        Iterator<IDCard> it = WalletImpl.idCardList.iterator(); 
        while(it.hasNext()){
        	IDCard idCard = it.next();
        	if(idCard.getUser_id().equals(id) && idCard.getCard_id().equals(cid)){
        		itemsToRemoveList.add(idCard);
        	}
        	
        }
        WalletImpl.idCardList.removeAll(itemsToRemoveList);
    }
  //---------------------Id Cards End-------------------------------------
    
  //---------------------Web Logins API--------------------------------
    
    @RequestMapping(value="api/v1//users/{user_id}/weblogins",method = RequestMethod.POST)
    public WebLogin createWebLogin(@RequestBody WebLogin webLogin, @PathVariable("user_id") String id) {
    	webLogin.setLogin_id("l-"+widIncrement.incrementAndGet());
    	webLogin.setUser_id(id);
    	WalletImpl.webLoginList.add(webLogin);
    	return webLogin;
    }
   
 
    @RequestMapping(value="api/v1//users/{user_id}/weblogins",method = RequestMethod.GET)
    public List<WebLogin> listWebLogins(@PathVariable("user_id") String id) {
    	Iterator<WebLogin> it = WalletImpl.webLoginList.iterator();
    	List<WebLogin> resultList = new ArrayList<WebLogin>();
    	while(it.hasNext()){
    		WebLogin webLogin = it.next();
    		if(webLogin.getUser_id()!=null && webLogin.getUser_id().equals(id)){
    				resultList.add(webLogin);
    		}
    	}
    	return resultList;
    }
   
     @RequestMapping(value="api/v1//users/{user_id}/weblogins/{login_id}",method = RequestMethod.DELETE)
    public void deleteWebLogin(@PathVariable("user_id") String id , @PathVariable("login_id") String lid) {
    	List<WebLogin> itemsToRemoveList = new ArrayList<WebLogin>();
        Iterator<WebLogin> it = WalletImpl.webLoginList.iterator(); 
        while(it.hasNext()){
        	WebLogin webLogin = it.next();
        	if(webLogin.getUser_id().equals(id) && webLogin.getLogin_id().equals(lid)){
        		itemsToRemoveList.add(webLogin);
        	}
        }
        WalletImpl.webLoginList.removeAll(itemsToRemoveList);
    }
    
     //---------------------Web Logins End--------------------------------  
  
    //---------------------Bank Accounts API------------------------------
    
      @RequestMapping(value="api/v1//users/{user_id}/bankaccounts",method = RequestMethod.POST)
    public BankAccount  createBankAccount(@RequestBody BankAccount bankAccount, @PathVariable("user_id") String id) {
    	bankAccount.setBa_id("b-"+bidIncrement.incrementAndGet());
    	bankAccount.setUser_id(id);
    	WalletImpl.bankAccountList.add(bankAccount);
    	return bankAccount;
    }
    
    @RequestMapping(value="api/v1//users/{user_id}/bankaccounts",method = RequestMethod.GET)
    public List<BankAccount> listBankAccount(@PathVariable("user_id") String id) {
    	Iterator<BankAccount> it = WalletImpl.bankAccountList.iterator();
    	List<BankAccount> resultList = new ArrayList<BankAccount>();
    	while(it.hasNext()){
    		BankAccount bankAccount = it.next();
    		if(bankAccount.getUser_id()!=null && bankAccount.getUser_id().equals(id)){
    				resultList.add(bankAccount);
    		}
    	}
    	return resultList;
    }
    
     @RequestMapping(value="api/v1//users/{user_id}/bankaccounts/{ba_id}",method = RequestMethod.DELETE)
        public void deleteBankAccount(@PathVariable("user_id") String id , @PathVariable("ba_id") String bid) {
    	List<BankAccount> itemsToRemoveList = new ArrayList<BankAccount>();
        Iterator<BankAccount> it = WalletImpl.bankAccountList.iterator(); 
        while(it.hasNext()){
        	BankAccount bankAccount = it.next();
        	if(bankAccount.getUser_id().equals(id) && bankAccount.getBa_id().equals(bid)){
        		itemsToRemoveList.add(bankAccount);
        	}
        }
        WalletImpl.bankAccountList.removeAll(itemsToRemoveList);
    }
  //---------------------Bank Accounts End------------------------------
}

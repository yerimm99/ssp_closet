package com.ssp.closet.controller;

import java.io.Serializable;
import org.springframework.beans.support.PagedListHolder;

///**
// * @author Juergen Hoeller
// * @since 30.11.2003
// */
import com.ssp.closet.dto.*;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private Account account;

	public UserSession(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}


}
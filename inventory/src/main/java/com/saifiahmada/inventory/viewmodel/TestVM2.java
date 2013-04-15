package com.saifiahmada.inventory.viewmodel;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;

/** @author Saifi Ahmada Feb 14, 2013 2:41:44 PM  **/

public class TestVM2 {
	@Command
	public void sendData() {
		Map args = new HashMap();
		args.put("myData", "please check");
		System.out.println("sendData");
		BindUtils.postGlobalCommand(null, null, "recieveData", args);
	}
}


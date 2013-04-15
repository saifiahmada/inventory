package com.saifiahmada.belajarzk.util;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

public class InterceptorAftLogin implements Initiator {

	public boolean doCatch(Throwable arg0) throws Exception {
		return false;
	}

	
	public void doFinally() throws Exception {

	}

	
	public void doInit(Page arg0, Map arg1) throws Exception {
	}

}

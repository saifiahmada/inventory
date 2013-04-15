package com.saifiahmada.inventory.viewmodel;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/** @author Saifi Ahmada Feb 14, 2013 2:38:40 PM  **/

public class TestVM1 {
	@Wire("#win")
	private Window win;

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	public void openWindow() {
		Executions.createComponents("mstMenu.zul", win, null);
	}

	@GlobalCommand
	public void recieveData(@BindingParam("myData") String myData) {
		System.out.println(myData);
	}
	
}


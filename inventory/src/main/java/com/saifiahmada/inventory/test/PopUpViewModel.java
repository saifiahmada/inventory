package com.saifiahmada.inventory.test;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;






public class PopUpViewModel {

	
	private int documentRSN;
	/**
	 * Automatically called after widow is loaded
	 * 
	 * @param view
	 * @param folderSubTabArgs
	 */
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("documentRSN") int documentRSN) {
		this.documentRSN = documentRSN;
		
	
	}
	
	
	
	/**
	 * On click of all button open people page to select a people
	 */
	@SuppressWarnings("unchecked")
	@Command
	public void doPickDocumentRSNasal(@ContextParam(ContextType.VIEW) Component comp) {

		Map maps = new HashMap();
		maps.put("PARENT_VIEW", comp);
		maps.put("peopleTabArg", new TabArguement(TabArguement.TabMode.PICK));
		
		UserInterfaceViewModel.addAnyTab(maps, "Tab2", "tab2.zul");
	}
	
	@Command
	public void doPickDocumentRSN(@ContextParam(ContextType.VIEW) Component comp) {
        Map maps = new HashMap();
        maps.put("PARENT_VIEW", comp);
        maps.put("peopleTabArg", new TabArguement(TabArguement.TabMode.PICK));

        UserInterfaceViewModel.addAnyTab(maps, "Tab2", "tab2.zul");
        comp.setVisible(false);
    }
	
	
	
	@Command
	@NotifyChange("documentRSN")
	public void acceptSelectedDocument(@BindingParam("documentRSN") int documentRSN) {
		this.documentRSN = documentRSN;
	}
	
	
	public void setDocumentRSN(int documentRSN) {
		this.documentRSN = documentRSN;
	}
	public int getDocumentRSN() {
		return documentRSN;
	}
	
}

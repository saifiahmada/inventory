package com.saifiahmada.inventory.popup;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstmenu;

/** @author Saifi Ahmada Feb 12, 2013 5:22:08 PM  **/

public class PopupMenuVM extends TrioBasePageVM {
	
	@Wire("popupMenu")
    private Window popupMenu;
	
	Component parentView;
	
	private TrioMstmenu current;
	
	private ListModelList<TrioMstmenu> listModel;
	
//	@AfterCompose
//	public void afterCompose(@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("PARENT_VIEW") Component parentView) {
//		this.parentView = parentView;
//	}
	
	public ListModelList<TrioMstmenu> getListModel(){
		
		if (listModel == null){
			listModel = new ListModelList<TrioMstmenu>();
			listModel.addAll(getMasterFacade().getTrioMstmenuDao().findAll());
			int size = getMasterFacade().getTrioMstmenuDao().findAll().size();
			System.out.println("ukuran "+size); 
		}
		return listModel;
	}

	public TrioMstmenu getCurrent() {
		if (current == null) current = new TrioMstmenu();
		return current;
	}

	public void setCurrent(TrioMstmenu current) {
		this.current = current;
	}
	
	@NotifyChange({"listModel","current"})
	@Command("save")
	public void save(){
		getMasterFacade().getTrioMstmenuDao().saveOrUpdate(current, "saifi");
		current = new TrioMstmenu();
		listModel = new ListModelList<TrioMstmenu>();
		listModel.addAll(getMasterFacade().getTrioMstmenuDao().findAll());
	}
	
	@NotifyChange({"current","listModel"})
	@Command("reset")
	public void reset(){
		current = new TrioMstmenu();
		listModel = new ListModelList<TrioMstmenu>();
		listModel.addAll(getMasterFacade().getTrioMstmenuDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		listModel = new ListModelList<TrioMstmenu>();
		listModel.addAll(getMasterFacade().getTrioMstmenuDao().findByCriteria(current));
	}
	
	@Command("pilih")
	public void pilih(@ContextParam(ContextType.VIEW) Component view) {
	    Map params = new HashMap();
	    params.put("menuParam", current);
	    Binder bind = (Binder)view.getParent().getAttribute("binder");
	    if (bind == null) return;
	    bind.postCommand("sendParamMenu", params);
	    view.detach();
	  }
}


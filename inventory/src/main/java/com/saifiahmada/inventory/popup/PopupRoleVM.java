package com.saifiahmada.inventory.popup;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModelList;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstrole;

/** @author Saifi Ahmada Feb 12, 2013 9:33:47 PM  **/

public class PopupRoleVM extends TrioBasePageVM {
	
	//data object
	private TrioMstrole current;
	
	//data component
	private ListModelList<TrioMstrole> listModel;

	public TrioMstrole getCurrent() {
		if (current == null) current = new TrioMstrole();
		return current;
	}

	public void setCurrent(TrioMstrole current) {
		this.current = current;
	}

	public ListModelList<TrioMstrole> getListModel() {
		if (listModel == null){
			listModel = new ListModelList<TrioMstrole>();
			listModel.addAll(getMasterFacade().getTrioMstroleDao().findAll());
		}
		return listModel;
	}

	public void setListModel(ListModelList<TrioMstrole> listModel) {
		this.listModel = listModel;
	}
	
	@NotifyChange({"listModel","current"})
	@Command("save")
	public void save(){
		getMasterFacade().getTrioMstroleDao().saveOrUpdate(current, "saifi");
		current = new TrioMstrole();
		listModel = new ListModelList<TrioMstrole>();
		listModel.addAll(getMasterFacade().getTrioMstroleDao().findAll());
	}
	
	@NotifyChange({"listModel","current"})
	@Command("reset")
	public void reset(){
		current = new TrioMstrole();
		listModel = new ListModelList<TrioMstrole>();
		listModel.addAll(getMasterFacade().getTrioMstroleDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		listModel = new ListModelList<TrioMstrole>();
		listModel.addAll(getMasterFacade().getTrioMstroleDao().findByCriteria(current));
	}
	
	@SuppressWarnings("rawtypes")
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("roleParam", current);
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		
		bind.postCommand("sendParamRole", param);
		view.detach();
	}

}


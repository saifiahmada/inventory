package com.saifiahmada.inventory.viewmodel.mst;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Popup;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstaccessrole;
import com.saifiahmada.inventory.bean.TrioMstmenu;
import com.saifiahmada.inventory.bean.TrioMstrole;

/** @author Saifi Ahmada Feb 12, 2013 11:25:36 PM  **/

public class MstAccessRoleVM extends TrioBasePageVM {
	
	//data object
	private TrioMstaccessrole current;
	private TrioMstrole current1;
	private TrioMstmenu current2;
	
	//data component
	private ListModelList<TrioMstaccessrole> listModel;
	private ListModelList<TrioMstrole> listModel1;
	private ListModelList<TrioMstmenu> listModel2;
	
	public TrioMstaccessrole getCurrent() {
		if (current == null) current = new TrioMstaccessrole();
		return current;
	}

	public void setCurrent(TrioMstaccessrole current) {
		this.current = current;
	}

	public ListModelList<TrioMstaccessrole> getListModel() {
		if (listModel == null){
			listModel = new ListModelList<TrioMstaccessrole>();
			listModel.addAll(getMasterFacade().getTrioMstaccessroleDao().findAll());
		}
		return listModel;
	}

	public void setListModel(ListModelList<TrioMstaccessrole> listModel) {
		this.listModel = listModel;
	}
	
	public TrioMstrole getCurrent1() {
		if (current1 == null) current1 = new TrioMstrole();
		return current1;
	}

	public void setCurrent1(TrioMstrole current1) {
		this.current1 = current1;
	}

	public ListModelList<TrioMstrole> getListModel1() {
		if (listModel1 == null){
			listModel1 = new ListModelList<TrioMstrole>();
			listModel1.addAll(getMasterFacade().getTrioMstroleDao().findAll());
		}
		return listModel1;
	}

	public void setListModel1(ListModelList<TrioMstrole> listModel1) {
		this.listModel1 = listModel1;
	}

	public TrioMstmenu getCurrent2() {
		if (current == null) current2 = new TrioMstmenu();
		return current2;
	}

	public void setCurrent2(TrioMstmenu current2) {
		this.current2 = current2;
	}

	public ListModelList<TrioMstmenu> getListModel2() {
		if (listModel2 == null){
			listModel2 = new ListModelList<TrioMstmenu>();
			listModel2.addAll(getMasterFacade().getTrioMstmenuDao().findAll());
		}
		return listModel2;
	}

	public void setListModel2(ListModelList<TrioMstmenu> listModel2) {
		this.listModel2 = listModel2;
	}
	
    @AfterCompose
    public void initSetup(@ExecutionArgParam("menuParam") TrioMstmenu menu) {
    	if (menu != null){
    		System.out.println("tidak null");
    	}
    }
    
    @Command
    @NotifyChange("current")
    public void sendParamMenu(@BindingParam("menuParam") TrioMstmenu menu) {
    	current.getTrioMstaccessrolePK().setVmenuid(menu.getTrioMstmenuPK().getVmenuid());
    }
    
    @Command
    @NotifyChange("current")
    public void sendParamRole(@BindingParam("roleParam") TrioMstrole role) {
    	current.getTrioMstaccessrolePK().setVroleid(role.getTrioMstrolePK().getVroleid());
    }
	
	@Init
	public void init(){
		System.out.println("exe init method");
	}

	@NotifyChange({"listModel","current"})
	@Command("save")
	public void save(){
		getMasterFacade().getTrioMstaccessroleDao().saveOrUpdate(current, "saifi");
		current = new TrioMstaccessrole();
		listModel = new ListModelList<TrioMstaccessrole>();
		listModel.addAll(getMasterFacade().getTrioMstaccessroleDao().findAll());
	}
	
	@NotifyChange({"listModel","current"})
	@Command("reset")
	public void reset(){
		current = new TrioMstaccessrole();
		listModel = new ListModelList<TrioMstaccessrole>();
		listModel.addAll(getMasterFacade().getTrioMstaccessroleDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		listModel = new ListModelList<TrioMstaccessrole>();
		listModel.addAll(getMasterFacade().getTrioMstaccessroleDao().findByCriteria(current));
	}
	
	@NotifyChange({"current","menuPopVisible"})
	@Command("selectMenu")
	public void selectMenu(){
		String vmenuid = getCurrent2().getTrioMstmenuPK().getVmenuid();
		current.getTrioMstaccessrolePK().setVmenuid(vmenuid);
		
	}
	
	@NotifyChange("current")
	@Command("selectRole")
	public void selectRole(){
		String vroleid = getCurrent1().getTrioMstrolePK().getVroleid();
		current.getTrioMstaccessrolePK().setVroleid(vroleid);
	}
	
//	@Command("openPopMenu")
//	public void openPopMenu(){
//		 final HashMap<String, Object> map = new HashMap<String, Object>();
//		 //Executions.createComponents(uri, parent, arg);
//	     Executions.createComponents("/popup/popupMenu.zul", null, map);
//	}
	
	@Command("openPopMenu")
	public void openPopMenu(@ContextParam(ContextType.VIEW) Component view ) {
		Map arguments = new HashMap();
		//arguments.put("documentRSN", documentRSN);
		Executions.getCurrent().createComponents("/popup/popupMenu.zul", view, arguments);
	}
	
	@Command("openPopRole") 
	public void openPopRole(@ContextParam (ContextType.VIEW) Component view){
		Executions.getCurrent().createComponents("/popup/popupRole.zul", view, null);
	}
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				String field = (String) ctx.getProperties("vroleid")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey1", "Role Id harus diisi");
				}
				field = (String) ctx.getProperties("vmenuid")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey2", "Menu Id harus diisi");
				}
				field = (String) ctx.getProperties("vstat")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey3", "Status harus diisi");
				}
			}
		};
	}
	
}


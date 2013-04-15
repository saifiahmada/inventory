package com.saifiahmada.belajarzk.viewmodel.mst;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import com.saifiahmada.belajarzk.base.TrioBasePageVM;
import com.saifiahmada.belajarzk.bean.TrioMstrole;
import com.saifiahmada.belajarzk.bean.TrioMstuser;
import com.saifiahmada.belajarzk.bean.TrioMstuserrole;

/** @author Saifi Ahmada Feb 12, 2013 10:20:18 PM  **/

public class MstUserRoleVM extends TrioBasePageVM {
	
	//data object
	private TrioMstuserrole current;
	
	//data component
	private ListModelList<TrioMstuserrole> listModel;

	public TrioMstuserrole getCurrent() {
		if (current == null) current = new TrioMstuserrole();
		return current;
	}

	public void setCurrent(TrioMstuserrole current) {
		this.current = current;
	}

	public ListModelList<TrioMstuserrole> getListModel() {
		if (listModel == null){
			listModel = new ListModelList<TrioMstuserrole>();
			listModel.addAll(getMasterFacade().getTrioMstuserroleDao().findAll());
		}
		return listModel;
	}

	@NotifyChange({"listModel","current"})
	@Command("save")
	public void save(){
		getMasterFacade().getTrioMstuserroleDao().saveOrUpdate(current, "saifi");
		current = new TrioMstuserrole();
		listModel = new ListModelList<TrioMstuserrole>();
		listModel.addAll(getMasterFacade().getTrioMstuserroleDao().findAll());
	}
	
	@NotifyChange({"listModel","current"})
	@Command("reset")
	public void reset(){
		current = new TrioMstuserrole();
		listModel = new ListModelList<TrioMstuserrole>();
		listModel.addAll(getMasterFacade().getTrioMstuserroleDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		listModel = new ListModelList<TrioMstuserrole>();
		listModel.addAll(getMasterFacade().getTrioMstuserroleDao().findByCriteria(current));
	}
	
	@Command("openPopRole")
	public void openPopRole(@ContextParam (ContextType.VIEW) Component view){
		Executions.getCurrent().createComponents("/popup/popupRole.zul", view, null);
	}
	
	@Command("openPopUser")
	public void openPopUser(@ContextParam (ContextType.VIEW) Component view){
		Executions.getCurrent().createComponents("/popup/popupUser.zul", view, null);
	}
	
	@Command
	@NotifyChange("current")
	public void sendParamUser(@BindingParam("userParam") TrioMstuser user){
		current.getTrioMstuserrolePK().setVusername(user.getTrioMstuserPK().getVusername());
	}
	
	@Command
	@NotifyChange("current")
	public void sendParamRole(@BindingParam("roleParam") TrioMstrole role){
		current.getTrioMstuserrolePK().setVroleid(role.getTrioMstrolePK().getVroleid());
	}
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				String field = (String) ctx.getProperties("vusername")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey1", "Username harus diisi");
				}
				field = (String) ctx.getProperties("vroleid")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey2", "Role Id harus diisi");
				}
				field = (String) ctx.getProperties("vstat")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey3", "Status harus diisi");
				}
			}
		};
	}

}


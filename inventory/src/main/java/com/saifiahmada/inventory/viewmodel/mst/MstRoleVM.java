package com.saifiahmada.inventory.viewmodel.mst;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zul.ListModelList;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstrole;

/** @author Saifi Ahmada Feb 12, 2013 9:33:47 PM  **/

public class MstRoleVM extends TrioBasePageVM {
	
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
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				String field = (String) ctx.getProperties("vroleid")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey1", "Role Id harus diisi");
				}
				field = (String) ctx.getProperties("vrolename")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey2", "Nama Role harus diisi");
				}
			}
		};
	}

}


package com.saifiahmada.inventory.viewmodel.mst;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zul.ListModelList;


import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstmenu;

/** @author Saifi Ahmada Feb 12, 2013 5:22:08 PM  **/

public class MstMenuVM extends TrioBasePageVM {
	
	private TrioMstmenu current;
	
	private ListModelList<TrioMstmenu> listModel;
	
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
		System.out.println("current search : "+current.getTrioMstmenuPK().getVmenuid());
		listModel = new ListModelList<TrioMstmenu>();
		listModel.addAll(getMasterFacade().getTrioMstmenuDao().findByCriteria(current));
	}
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				String field = (String) ctx.getProperties("vmenuid")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey1", "Id Menu harus diisi");
				}
				field = (String) ctx.getProperties("vtitle")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey2", "Title Menu harus diisi");
				}
				field = (String) ctx.getProperties("vparent")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey3", "Parent harus diisi");
				}
				field = (String) ctx.getProperties("vlocation")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey4", "Location harus diisi");
				}
				field = (String) ctx.getProperties("vimage")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey5", "Image harus diisi");
				}
				
			}
		};
	}
}


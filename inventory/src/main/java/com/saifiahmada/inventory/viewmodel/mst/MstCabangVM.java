package com.saifiahmada.inventory.viewmodel.mst;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zul.ListModelList;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstcabang;

/** @author Saifi Ahmada Feb 15, 2013 11:01:04 AM  **/

public class MstCabangVM extends TrioBasePageVM {
	
	//data object
	private TrioMstcabang current;
	
	//data component
	private ListModelList<TrioMstcabang> listModel;

	public TrioMstcabang getCurrent() {
		if (current == null) current = new TrioMstcabang();
		return current;
	}

	public void setCurrent(TrioMstcabang current) {
		this.current = current;
	}

	public ListModelList<TrioMstcabang> getListModel() {
		if (listModel == null){
			listModel = new ListModelList<TrioMstcabang>();
			listModel.addAll(getMasterFacade().getTrioMstcabangDao().findAll());
		}
		return listModel;
	}

	public void setListModel(ListModelList<TrioMstcabang> listModel) {
		this.listModel = listModel;
	}
	
	@NotifyChange({"listModel", "current"})
	@Command("save")
	public void save(){
		getMasterFacade().getTrioMstcabangDao().saveOrUpdate(current, "saifi");
		current = new TrioMstcabang();
		listModel = new ListModelList<TrioMstcabang>();
		listModel.addAll(getMasterFacade().getTrioMstcabangDao().findAll());
	}
	
	@NotifyChange({"listModel", "current"})
	@Command("reset")
	public void reset(){
		current = new TrioMstcabang();
		listModel = new ListModelList<TrioMstcabang>();
		listModel.addAll(getMasterFacade().getTrioMstcabangDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		listModel = new ListModelList<TrioMstcabang>();
		listModel.addAll(getMasterFacade().getTrioMstcabangDao().findByCriteria(current));
	}
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				String field = (String) ctx.getProperties("kdPrs")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey1", "Kode Prsh harus diisi");
				}
				field = (String) ctx.getProperties("nmPrs")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey2", "Nama Prsh harus diisi");
				}
				field = (String) ctx.getProperties("almPrs")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey3", "Alamat Prsh harus diisi");
				}
				field = (String) ctx.getProperties("telp1")[0].getValue();
				if (field == null || field.equalsIgnoreCase("")){
					addInvalidMessage(ctx, "fkey4", "Telp1 harus diisi");
				}
			}
		};
	}

}


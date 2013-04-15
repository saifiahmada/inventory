package com.saifiahmada.inventory.viewmodel.mst;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.config.SetFactoryBean;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstuser;
import com.saifiahmada.inventory.util.PasswdUtil;

/** @author Saifi Ahmada Feb 11, 2013 3:34:44 PM  **/

public class MstUserVM extends TrioBasePageVM {
	
	//date object
	private TrioMstuser current;
	
	//data component
	private ListModelList<TrioMstuser> listModel ;

	public TrioMstuser getCurrent() {
		if (current == null) current = new TrioMstuser();
		return current;
	}
	
	@NotifyChange({"listModel","current"})
	@Command("save")
	public void save() {
		
		String passwd = PasswdUtil.getMD5DigestFromString(current.getVpassword());
		current.setVpassword(passwd);
		getMasterFacade().getTrioMstuserDao().saveOrUpdate(current, "saifi");
		current = new TrioMstuser();
		
		listModel = new ListModelList<TrioMstuser>();
		listModel.addAll(getMasterFacade().getTrioMstuserDao().findAll());
				
	}
	
	@NotifyChange({"current", "listModel"})
	@Command("reset")
	public void reset(){
		current = new TrioMstuser();
		listModel = new ListModelList<TrioMstuser>();
		listModel.addAll(getMasterFacade().getTrioMstuserDao().findAll());
	}
	
	@NotifyChange("listModel")
	@Command("search")
	public void search(){
		System.out.println("current search : "+current.getTrioMstuserPK().getVusername()); 
		listModel = new ListModelList<TrioMstuser>();
		listModel.addAll(getMasterFacade().getTrioMstuserDao().findByCriteria(current));
	}

	public void setCurrent(TrioMstuser current) {
		this.current = current;
	}

	public ListModelList<TrioMstuser> getListModel() {
		if (listModel == null){
		listModel = new ListModelList<TrioMstuser>();	
		listModel.addAll(getMasterFacade().getTrioMstuserDao().findAll());
		}
		return listModel;
	}
	
	public Validator getFormValidator(){
		return new AbstractValidator() {
			
			public void validate(ValidationContext ctx) {
				// TODO , masbro
				
				String vusername = (String) ctx.getProperties("vusername")[0].getValue();
				if (vusername == null || vusername.equalsIgnoreCase("")) addInvalidMessage(ctx, "fkey1","Username tidak boleh kosong");
				
				String vpassword = (String) ctx.getProperties("vpassword")[0].getValue();
				if (vpassword == null || vpassword.equalsIgnoreCase("")) addInvalidMessage(ctx, "fkey2", "Password tidak boleh kosong");
				
				String vstat = (String) ctx.getProperties("vstat")[0].getValue();
				if (vstat == null || vstat.equalsIgnoreCase("")) addInvalidMessage(ctx, "fkey3", "Status tidak boleh kosong");
			}
		};
	}

}


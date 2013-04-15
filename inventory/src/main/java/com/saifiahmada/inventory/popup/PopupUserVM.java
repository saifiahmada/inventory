package com.saifiahmada.inventory.popup;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.SetFactoryBean;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import com.saifiahmada.inventory.base.TrioBasePageVM;
import com.saifiahmada.inventory.bean.TrioMstuser;
import com.saifiahmada.inventory.util.PasswdUtil;

/** @author Saifi Ahmada Feb 11, 2013 3:34:44 PM  **/

public class PopupUserVM extends TrioBasePageVM {
	
	//date object
	private TrioMstuser current;
	
	//data component
	private ListModelList<TrioMstuser> listModel ;
	private Textbox tbUsername; 

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
		tbUsername = new Textbox();
		tbUsername.setFocus(true);
		
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
	
	@SuppressWarnings("rawtypes")
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("userParam", current);
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParamUser", param);		
		view.detach();
	}

}


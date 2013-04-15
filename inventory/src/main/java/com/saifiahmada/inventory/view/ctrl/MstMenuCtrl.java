package com.saifiahmada.inventory.view.ctrl;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;


import com.saifiahmada.inventory.base.TrioBasePage;
import com.saifiahmada.inventory.bean.TrioMstmenu;


/** @author Saifi Ahmada Feb 9, 2013 3:02:33 PM  **/

public class MstMenuCtrl extends TrioBasePage {
	
	private static final long serialVersionUID = 1L;
	
	//component
	private AnnotateDataBinder binder;
	private Window win;
	private Listbox lbMenuList;
	private Combobox cbVparent;
	private Grid mygrid;
	
	//data object
	private TrioMstmenu trioMstmenu;
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);
		binder = (AnnotateDataBinder) page.getAttribute("binder");
		
		trioMstmenu = new TrioMstmenu();
		
		lbMenuList = new Listbox();
		lbMenuList.setModel(new ListModelList(
				getMasterFacade().getTrioMstmenuDao().findAll()));
		lbMenuList.setItemRenderer(new ListitemRenderer<TrioMstmenu>() {

			public void render(Listitem item, TrioMstmenu data, int arg2)
					throws Exception {
				
				item.setValue(data);
				new Listcell(data.getTrioMstmenuPK().getVmenuid()).setParent(item);
				new Listcell(data.getVtitle()).setParent(item);
				new Listcell(data.getVparent()).setParent(item);
				new Listcell(data.getVlocation()).setParent(item);
				new Listcell(data.getVimage()).setParent(item);
				new Listcell(String.valueOf(data.getNorderer())).setParent(item); 
			}
		});
	}
	
	public void onSelect$lbMenuList(){
		trioMstmenu = lbMenuList.getSelectedItem().getValue();
		TrioMstmenu baru = new TrioMstmenu();
		baru = lbMenuList.getSelectedItem().getValue();
		System.out.println("old = "+trioMstmenu.getTrioMstmenuPK().getVmenuid());
		System.out.println("old = "+trioMstmenu.getVparent());
		System.out.println("old = "+trioMstmenu.getVtitle());
		System.out.println("old = "+trioMstmenu.getVlocation());
		System.out.println("old = "+trioMstmenu.getNorderer());
		
		System.out.println("baru = "+baru.getTrioMstmenuPK().getVmenuid());
		System.out.println("baru = "+baru.getVparent());
		System.out.println("baru = "+baru.getVtitle());
		System.out.println("baru = "+baru.getVlocation());
		System.out.println("baru = "+baru.getNorderer());
		binder.loadComponent(mygrid);
		
	}

	public TrioMstmenu getTrioMstmenu() {
		return trioMstmenu;
	}

	public void setTrioMstmenu(TrioMstmenu trioMstmenu) {
		this.trioMstmenu = trioMstmenu;
	}
	
	

}


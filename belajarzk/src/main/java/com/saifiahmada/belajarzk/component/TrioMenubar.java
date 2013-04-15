package com.saifiahmada.belajarzk.component;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menubar;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Window;


import com.saifiahmada.belajarzk.base.TrioBasePage;
import com.saifiahmada.belajarzk.bean.TrioMstmenu;
import com.saifiahmada.belajarzk.util.LoginManager;



public class TrioMenubar extends TrioBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Window win;
	
	private Menubar menubar;
	private Menuitem item;
	private Menupopup menupopupMST, menupopupTRN, menupopupDSG, menupopupLAP, menupopupUTL, menupopupADM;  
	
	private Menu menuMST, menuTRN, menuDSG, menuLAP, menuUTL, menuADM; 
	
	private Menuitem menuKSG,menuHOM, menuLGT,menuHLP;
	
	private Iframe iframe;
	private String user;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		this.user = "..::  Selamat Datang :: "+getUserSession()+"  ::..";
		createMenu();
		iframe.setSrc("awal.zul");
		iframe.setParent(win);
		
	}
	
	public void createMenu(){
		
		List<TrioMstmenu> listMenu = new ArrayList<TrioMstmenu>(); 
		listMenu = getMasterFacade().getTrioMstmenuDao().getListMenuByUser(getUserSession());
		
		iframe = new Iframe();
		iframe.setHeight("900px");
		iframe.setWidth("100%");
		
		menubar = new Menubar();
		menubar.setSclass("green");
		menupopupTRN = new Menupopup();
		menupopupDSG = new Menupopup();
		menupopupLAP = new Menupopup();
		menupopupMST = new Menupopup();
		menupopupUTL = new Menupopup();
		menupopupADM = new Menupopup();
		
		menuMST = new Menu();
		menuMST.setSclass("mytombol orange bigrounded");
		menuMST.setLabel("Master");
		menuMST.setImage("/image/master.png");
		
		menuTRN = new Menu();
		menuTRN.setSclass("mytombol orange bigrounded");
		menuTRN.setLabel("Transaksi");
		menuTRN.setImage("/image/transaction.png");
		
		menuDSG = new Menu();
		menuDSG.setSclass("mytombol orange bigrounded");
		menuDSG.setLabel("Designer");
		menuDSG.setImage("/image/design.png");
		
		menuLAP = new Menu();
		menuLAP.setSclass("mytombol orange bigrounded");
		menuLAP.setLabel("Laporan");
		menuLAP.setImage("/image/laporan.png");
		
		menuUTL = new Menu();
		menuUTL.setSclass("mytombol orange bigrounded");
		menuUTL.setLabel("Utility");
		menuUTL.setImage("/image/utility.png");
		
		menuADM = new Menu();
		menuADM.setSclass("mytombol orange bigrounded");
		menuADM.setLabel("Admin");
		menuADM.setImage("/image/admin.png");
		
		menuHOM = new Menuitem();
		menuHOM.setSclass("mytombol orange bigrounded");
		menuHOM.setLabel("Home");
		menuHOM.setImage("/image/Home.png");
		
		menuLGT = new Menuitem();
		menuLGT.setSclass("mytombol orange bigrounded");
		menuLGT.setLabel("Logout");
		menuLGT.setImage("/image/logout.png");
		
		menuHLP = new Menuitem();
		menuHLP.setSclass("mytombol orange bigrounded");
		menuHLP.setLabel("Help");
		menuHLP.setImage("/image/Help.png");
		
		menuKSG = new Menuitem();
		
		menuHOM.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			public void onEvent(Event arg0) throws Exception {
				// TODO , masbro
				iframe.setSrc("awal.zul");
				iframe.setParent(win);
			}
		});
		
		menuHOM.setParent(menubar);
		
			for (final TrioMstmenu mt : listMenu){ 
				
				if (mt.getVparent().equalsIgnoreCase("M1MST")){
					
					item = new Menuitem();
					item.setSclass("mybutton");
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupMST);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						public void onEvent(Event arg0) throws Exception {
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
						}
						
					});
					menupopupMST.setParent(menuMST);
					menuMST.setParent(menubar);
				}
				
				if (mt.getVparent().equalsIgnoreCase("M2TRN")){
					
					item = new Menuitem();
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupTRN);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						public void onEvent(Event arg0) throws Exception {
							
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
							
						}
						
					});
					
					menupopupTRN.setParent(menuTRN);
					menuTRN.setParent(menubar);
				}
				
				if (mt.getVparent().equalsIgnoreCase("M3DSG")){
					
					item = new Menuitem();
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupDSG);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						public void onEvent(Event arg0) throws Exception {
							
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
							
						}
						
					});
					
					menupopupDSG.setParent(menuDSG);
					menuDSG.setParent(menubar);
				}
				
				if (mt.getVparent().equalsIgnoreCase("M4LAP")){
					
					item = new Menuitem();
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupLAP);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						public void onEvent(Event arg0) throws Exception {
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
						}
						
					});
					menupopupLAP.setParent(menuLAP);
					menuLAP.setParent(menubar);
				}
				
				if (mt.getVparent().equalsIgnoreCase("M5UTL")){
					
					item = new Menuitem();
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupUTL);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

						public void onEvent(Event arg0) throws Exception {
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
						}
						
					});
					menupopupUTL.setParent(menuUTL);
					menuUTL.setParent(menubar);
				}
				
				if (mt.getVparent().equalsIgnoreCase("M6ADM")){
					
					item = new Menuitem();
					item.setLabel(mt.getVtitle());
					item.setParent(menupopupADM);
					item.setImage(mt.getVimage());
					
					item.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
						
						public void onEvent(Event arg0) throws Exception {
							iframe.setSrc(mt.getVlocation());
							iframe.setParent(win);
						}
					});
					
					menupopupADM.setParent(menuADM);
					menuADM.setParent(menubar);
				}
			
		}
		
		menuLGT.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event arg0) throws Exception {
				logOut();
			}
		});
		menuLGT.setParent(menubar);
		
		menuHLP.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			public void onEvent(Event arg0) throws Exception {
				Sessions.getCurrent().setAttribute("helpdoc", getVmenuidByVlocation(iframe.getSrc())); 
				Executions.getCurrent().sendRedirect("triohelp.zul", "_blank");
			}
		});
		
		menuHLP.setParent(menubar);
		menubar.setParent(win);
		
	}
	
	public void logOut(){
		LoginManager lm = LoginManager.getIntance(Sessions.getCurrent());
		lm.logOff();
		Executions.sendRedirect("login.zul");
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getVmenuidByVlocation(String vlocation){
		String vmenuid = null;
		TrioMstmenu mm = new TrioMstmenu();
		mm.setVlocation(vlocation);
		List<TrioMstmenu> listMenu = getMasterFacade().getTrioMstmenuDao().findByCriteria(mm);
		if (listMenu.size() > 0){
			vmenuid = listMenu.get(0).getTrioMstmenuPK().getVmenuid();
		}
		return vmenuid;
	}

}

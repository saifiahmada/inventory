package com.saifiahmada.belajarzk.component;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Window;

/**
 * @author glassfish | Saipi Ramli
 *
 * Nov 6, 2012
 */
public class TrioHelp extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AnnotateDataBinder binder;
	
	private Window win;
	private Iframe iframe;
	private String helpPath;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		String help = (String) Sessions.getCurrent().getAttribute("helpdoc");
		if (help != null){
			helpPath = "/userguide/"+help+".pdf";
		}else{
			helpPath = "/userguide/about.pdf";
		}
		System.out.println("Helpdoc = "+helpPath);
	}
	
	public TrioHelp() {

	}
	
	public String getHelpPath() {
		return helpPath;
	}

	public void setHelpPath(String helpPath) {
		this.helpPath = helpPath;
	}
	
}

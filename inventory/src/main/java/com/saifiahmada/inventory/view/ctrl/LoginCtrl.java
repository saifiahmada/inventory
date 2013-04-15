package com.saifiahmada.inventory.view.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.saifiahmada.inventory.base.TrioBasePage;
import com.saifiahmada.inventory.util.EnkripsiPassword;
import com.saifiahmada.inventory.util.LoginManager;

public class LoginCtrl extends TrioBasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Textbox nameTxb, passwordTxb;
	
	Button confirmBtn, cancelBtn;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		nameTxb.setFocus(true);
		
	}
	
	public void onClick$confirmBtn() throws InterruptedException{ 
		/*
		 * validation empty 
		 */
		
		if (nameTxb.getValue().equalsIgnoreCase("") || nameTxb.getValue() == null){
			Messagebox.show("Username harus diisi");
			return;
		}
		if (passwordTxb.getValue().equalsIgnoreCase("") || passwordTxb.getValue() == null){
			Messagebox.show("Password harus diisi");
			return;
		}
		doLogin();
	}
	
	public void onClick$cancelBtn(){
		nameTxb.setValue(null);
		passwordTxb.setValue(null);
		nameTxb.setFocus(true);
	}

		
//	public void onOK(){
//		
//		doLogin();
//	}
	
	public void doLogin(){
		
		LoginManager lm = LoginManager.getIntance(Sessions.getCurrent());
		/*
		 * mendaftarkan username ke session
		 * @param username
		 * @return nameTxb.getValue()
		 */
		Sessions.getCurrent().setAttribute("username", nameTxb.getValue());
		lm.logIn(nameTxb.getValue(),enkripsi(nameTxb.getValue(), passwordTxb.getValue()));
		if(lm.isAuthenticated()){
			execution.sendRedirect("index.zul");
			
		}else {
			
				Messagebox.show("Username/Password anda salah", "Warning", Messagebox.OK,
						Messagebox.EXCLAMATION);
			
		}
	}
	
	public void onOK(){
		doLogin();
	}
	
	public String enkripsi(String userName, String password){
		EnkripsiPassword ep = new EnkripsiPassword();
		String hasil = ep.EnkripsiPass(userName, password);
		return hasil;
		
	}
	
}

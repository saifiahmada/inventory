package com.saifiahmada.belajarzk.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;




public class Tab2ViewModel {

	private ListModelList<Document> documentList;
	private Document selectedDocument;
	Component parentView;
	


	/**
	 * Automatically called after widow is loaded
	 * 
	 * @param view
	 * @param folderSubTabArgs
	 */
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view,@ExecutionArgParam("PARENT_VIEW") Component parentView) {
		this.parentView = parentView;
		loadDocumentList();
	}
	
	
	private void loadDocumentList() {
		documentList = new ListModelList<Document>();
		for (int row = 1; row <= 10; row++) {
		Document document = new Document();
				document.setDocumentRSN(row);
				document.setDocumentDesc("documentDesc"+row);
				document.setDocumentOrder(row);
				
				
				documentList.add(document);
			}

		}
	
	@Command
	public void acceptDocumentRSN(@ContextParam(ContextType.VIEW) Component view) {
		if(selectedDocument==null)
		Messagebox.show("Please select a document");
		else{
			Map arguments = new HashMap();
			
		arguments.put("documentRSN", selectedDocument.getDocumentRSN());
		Binder bind = (Binder) parentView.getAttribute("binder");
		if (bind == null)
			return;
		bind.postCommand("acceptSelectedDocument", arguments);
		UserInterfaceViewModel.closeSelectedParentTab();
		}
		
	}

	public ListModelList<Document> getDocumentList() {
		return documentList;
	}


	public void setDocumentList(ListModelList<Document> documentList) {
		this.documentList = documentList;
	}
	public void setSelectedDocument(Document selectedDocument) {
		this.selectedDocument = selectedDocument;
	}


	public Document getSelectedDocument() {
		return selectedDocument;
	}
	public class Document implements Serializable {
		private static final long serialVersionUID = 14545456347L;

		int documentRSN;
		String documentDesc;
		int documentOrder;
		
		public int getDocumentRSN() {
			return documentRSN;
		}

		public void setDocumentRSN(int documentRSN) {
			this.documentRSN = documentRSN;
		}

		public String getDocumentDesc() {
			return documentDesc;
		}

		public void setDocumentDesc(String documentDesc) {
			this.documentDesc = documentDesc;
		}

		public int getDocumentOrder() {
			return documentOrder;
		}

		public void setDocumentOrder(int documentOrder) {
			this.documentOrder = documentOrder;
		}
	}
		
}

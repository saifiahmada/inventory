package com.saifiahmada.inventory.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;




public class Tab1ViewModel {

	private ListModelList<Document> documentList;
	private Document selectedDocument;
	private int documentRSN;


	/**
	 * Automatically called after widow is loaded
	 * 
	 * @param view
	 * @param folderSubTabArgs
	 */
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		
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
	
	/**
	 * Handles double click of pick window row.
	 * 
	 * @param view
	 * @param infoValue
	 * @param infoCode
	 */
	@SuppressWarnings("unchecked")
	@Command
	public void doPickDocument(
			@ContextParam(ContextType.VIEW) Component view,
			@BindingParam("documentRSN") String documentRSN) {
		Map arguments = new HashMap();
		arguments.put("documentRSN", documentRSN);
		Executions.getCurrent().createComponents(
				"popup_window.zul", view, arguments);
		
		

	}
	/**
	 * On click of all button open people page to select a people
	 */
	@SuppressWarnings("unchecked")
	@Command
	public void doPickDocumentRSN(@ContextParam(ContextType.VIEW) Component comp) {

		Map maps = new HashMap();
		maps.put("PARENT_VIEW", comp);
		maps.put("peopleTabArg", new TabArguement(TabArguement.TabMode.PICK));
		
		UserInterfaceViewModel.addAnyTab(maps, "Tab2", "tab2.zul");
	}
	
	@Command
	@NotifyChange("documentRSN")
	public void acceptSelectedDocument(@BindingParam("documentRSN") int documentRSN) {
		this.setDocumentRSN(documentRSN);
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
	public void setDocumentRSN(int documentRSN) {
		this.documentRSN = documentRSN;
	}


	public int getDocumentRSN() {
		return documentRSN;
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

package com.saifiahmada.inventory.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;



public class UserInterfaceViewModel {
	
	
	@Wire("#mainTab")
	Tabbox mainTab;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		
	}
	
	public static void addAnyTab(Map<String, Object> parameters,
			String tabName, String tabPath) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parameters", parameters);
		map.put("tabName", tabName);
		map.put("tabPath", tabPath);
		BindUtils.postGlobalCommand(null, null, "loadAnyTab", map);
	}
	
	@SuppressWarnings("unchecked")
	@GlobalCommand
	public void loadAnyTab(
			@BindingParam("parameters") Map<String, Object> parameters,
			@BindingParam("tabName") String tabName,
			@BindingParam("tabPath") String tabPath) {

		mainTab.getSelectedTab().addEventListener(Events.ON_CLICK,
				new EventListener() {
					public void onEvent(Event e) throws Exception {
						Tab nextTab = (Tab) mainTab.getSelectedTab()
								.getNextSibling();
						if (nextTab != null) {
							Components.removeAllChildren(nextTab
									.getLinkedPanel());
							nextTab.close();
						}

					}

				});

		openNewTab(tabName, tabPath, mainTab, parameters);
	}
	
	public static void openNewTab(String title, String path, Tabbox mainTab,
			Map<String, Object> parameters) {
		Tab tab = new Tab(title);
		tab.setClosable(true);
		tab.setParent(mainTab.getTabs());
		Tabpanel tabpanel = new Tabpanel();
		Include include = new Include(path);
		include.setParent(tabpanel);
		if (parameters != null) {
			Set<Map.Entry<String, Object>> entry = parameters.entrySet();
			for (Map.Entry<String, Object> parameter : entry) {
				include.setDynamicProperty(parameter.getKey(), parameter
						.getValue());
			}
		}
		tabpanel.setParent(mainTab.getTabpanels());
		mainTab.setSelectedTab(tab);
	}

	@GlobalCommand
	public void closeSelectedTab() {
		
		closeSelectedTab(mainTab);

	}

	public static void closeSelectedParentTab() {
		BindUtils.postGlobalCommand(null, null, "closeSelectedTab", null);
	}
	public static void closeSelectedTab(Tabbox mainTab) {		 
		Components.removeAllChildren(mainTab.getSelectedTab().getLinkedPanel());
		mainTab.getSelectedTab().close();
	}
	
}


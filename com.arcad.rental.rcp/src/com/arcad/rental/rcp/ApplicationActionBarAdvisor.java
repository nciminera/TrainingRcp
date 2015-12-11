package com.arcad.rental.rcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.jface.action.Separator;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction preferencesAction;
	private IAction quitAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	{
    		preferencesAction = ActionFactory.PREFERENCES.create(window);
    		register(preferencesAction);
    	}
    	{
    		quitAction = ActionFactory.QUIT.create(window);
    		register(quitAction);
    	}
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	
    	MenuManager menuManagerFile = new MenuManager("New MenuManager");
    	menuManagerFile.setMenuText("File");
    	menuBar.add(menuManagerFile);
    	menuManagerFile.add(quitAction);
    	menuBar.add(new Separator());
    	
    	MenuManager menuManagerWindow = new MenuManager("New MenuManager");
    	menuManagerWindow.setMenuText("Window");
    	menuBar.add(menuManagerWindow);
    	menuManagerWindow.add(preferencesAction);
    }
    
}

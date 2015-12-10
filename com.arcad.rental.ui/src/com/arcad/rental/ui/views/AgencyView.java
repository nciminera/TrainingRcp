package com.arcad.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.arcad.rental.core.RentalCoreActivator;
import com.arcad.rental.ui.RentalUIActivator;
import com.opcoach.training.rental.RentalAgency;

public class AgencyView extends ViewPart implements IPropertyChangeListener {	
	
	
	private TreeViewer tv;

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		RentalUIActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		tv = new TreeViewer(parent);
		RentalProvider rp=new RentalProvider();
		tv.setContentProvider(rp);
		tv.setLabelProvider(rp);
		
		Collection<RentalAgency> agency = new ArrayList<RentalAgency>();
		agency.add(RentalCoreActivator.getAgency());
		tv.setInput(agency);
		tv.expandAll();
		getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		tv.refresh();
		
	}
	

}

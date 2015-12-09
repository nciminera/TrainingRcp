package com.arcad.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.arcad.rental.core.RentalCoreActivator;
import com.opcoach.training.rental.RentalAgency;

public class AgencyView extends ViewPart {

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		TreeViewer tv = new TreeViewer(parent);
		RentalProvider rp=new RentalProvider();
		tv.setContentProvider(rp);
		tv.setLabelProvider(rp);
		
		Collection<RentalAgency> agency = new ArrayList<RentalAgency>();
		agency.add(RentalCoreActivator.getAgency());
		tv.setInput(agency);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}

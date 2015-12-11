package com.arcad.rental.ui.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class CutomerView extends ViewPart implements ISelectionListener {

	Label LabelCutoName;

	public CutomerView() {
		// TODO Auto-generated constructor stub
	}

	public void setCustomer(Customer c) {
		LabelCutoName.setText(c.getDisplayName());
		// rentedObjectLabel.setText(r.getRentedObject().getName());
		// rentedPersonLabel.setText(r.getCustomer().getDisplayName());
		// startDate.setText(r.getStartDate().toString());
		// endDate.setText(r.getEndDate().toString());

	}

	@Override
	public void init(IViewSite site) throws PartInitException {

		super.init(site);
		site.getPage().addSelectionListener(this);
	}

	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Group grpIdentity = new Group(parent, SWT.NONE);
		GridData gd_grpIdentity = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		gd_grpIdentity.heightHint = 51;
		grpIdentity.setLayoutData(gd_grpIdentity);
		grpIdentity.setText("Identity");

		Label LabelCustomer = new Label(grpIdentity, SWT.NONE);
		LabelCustomer.setBounds(10, 10, 70, 17);
		LabelCustomer.setText("Customer");

		LabelCutoName = new Label(grpIdentity, SWT.NONE);
		LabelCutoName.setAlignment(SWT.CENTER);
		LabelCutoName.setBounds(98, 10, 280, 17);
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty()){
			return;
		}
		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();

			Customer c = (Customer) Platform.getAdapterManager().getAdapter(selected, Customer.class);
			
			if (c != null) {
				setCustomer(c);
			}

//			if (selected instanceof Customer) {
//				setCustomer(((Customer) selected));
//			}
		}
	}

}

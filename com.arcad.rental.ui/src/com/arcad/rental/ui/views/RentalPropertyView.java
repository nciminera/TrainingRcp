package com.arcad.rental.ui.views;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.arcad.rental.core.RentalCoreActivator;
import com.opcoach.training.rental.Rental;

public class RentalPropertyView extends ViewPart {

	private Label rentedObjectLabel;
	private Label rentedPersonLabel;
	private Group grpDatesDeLocation;
	private Label Label_StartDate;
	private Label startDate;
	private Label endDate;
	private Label lblNewLabel_1;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}
	
	public void setRental(Rental r){
		rentedObjectLabel.setText(r.getRentedObject().getName());
		rentedPersonLabel.setText(r.getCustomer().getDisplayName());
		startDate.setText(r.getStartDate().toString());
		endDate.setText(r.getEndDate().toString());
	
	}

	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1, false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		infoGroup.setText("Informations");
		infoGroup.setLayout(new GridLayout(3, false));
		new Label(infoGroup, SWT.NONE);
		
		rentedObjectLabel = new Label(infoGroup, SWT.BORDER);		
		
		lblNewLabel_1 = new Label(infoGroup, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_1.setText("Loué à");
		rentedPersonLabel = new Label(infoGroup, SWT.BORDER);
		rentedPersonLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan=2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		new Label(infoGroup, SWT.NONE);
		
		grpDatesDeLocation = new Group(parent, SWT.NONE);
		grpDatesDeLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		grpDatesDeLocation.setText("Dates de location");
		grpDatesDeLocation.setLayout(new GridLayout(2, false));
		
		Label_StartDate = new Label(grpDatesDeLocation, SWT.NONE);
		Label_StartDate.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		Label_StartDate.setText("du:");
		
		startDate = new Label(grpDatesDeLocation, SWT.NONE);
		startDate.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		
		Label Label_endDate = new Label(grpDatesDeLocation, SWT.NONE);
		Label_endDate.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		Label_endDate.setBounds(0, 0, 70, 17);
		Label_endDate.setText("au:");
		
		endDate = new Label(grpDatesDeLocation, SWT.NONE);
		endDate.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		endDate.setBounds(0, 0, 70, 17);
		
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}

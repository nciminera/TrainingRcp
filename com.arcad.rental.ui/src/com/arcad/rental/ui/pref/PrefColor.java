package com.arcad.rental.ui.pref;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.arcad.rental.ui.RentalUIActivator;

public class PrefColor extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor("PREF_CUSTOMER_COLOR", "Customer", getFieldEditorParent()));
		addField(new ColorFieldEditor("PREF_RRENTAL_COLOR", "Rental", getFieldEditorParent()));
		addField(new ColorFieldEditor("PREF_OBJECT_COLOR", "Object", getFieldEditorParent()));
	}
	
	public PrefColor() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("Color preference");
		
	}
	

}

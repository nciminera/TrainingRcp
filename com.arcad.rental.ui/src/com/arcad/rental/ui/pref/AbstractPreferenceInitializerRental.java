package com.arcad.rental.ui.pref;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

import com.arcad.rental.ui.RentalUIActivator;
import com.arcad.rental.ui.RentalUIConstant;

public class AbstractPreferenceInitializerRental extends AbstractPreferenceInitializer implements RentalUIConstant {

	public AbstractPreferenceInitializerRental() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store= RentalUIActivator.getDefault().getPreferenceStore();
		store.setDefault(PREF_CUSTOMER_COLOR, StringConverter.asString(new RGB(10,20,255)));
		store.setDefault(PREF_OBJECT_COLOR, StringConverter.asString(new RGB(10,230,30)));
		store.setDefault(PREF_RRENTAL_COLOR, StringConverter.asString(new RGB(130,20,30)));
	}

}

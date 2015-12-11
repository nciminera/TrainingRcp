package com.arcad.rental.ui.palette;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.arcad.rental.ui.RentalUIActivator;
import com.arcad.rental.ui.RentalUIConstant;
import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;

public class DefaultPaletteColorProvider implements IColorProvider,RentalUIConstant {

	public DefaultPaletteColorProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		Display d = Display.getCurrent();
		if (element instanceof RentalAgency) {				
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_RRENTAL_COLOR));			
		} else if (element instanceof Customer) {				
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_CUSTOMER_COLOR));
		} else if (element instanceof RentalObject) {			
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_OBJECT_COLOR));
		} else 
//			if (element instanceof Rental) {	
//			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_RRENTAL_COLOR));	
//		}
		return null;
	}

	private Color getAColor(String rgbKey) {
		ColorRegistry colorRegistry= JFaceResources.getColorRegistry();
		Color col = colorRegistry.get(rgbKey);
		if (col == null) {
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			col = colorRegistry.get(rgbKey);
		}
		return col;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}

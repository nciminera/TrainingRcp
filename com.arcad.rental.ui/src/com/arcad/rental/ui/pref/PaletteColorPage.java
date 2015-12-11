package com.arcad.rental.ui.pref;

import java.util.Map;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.arcad.rental.ui.Palette;
import com.arcad.rental.ui.RentalUIActivator;
import com.arcad.rental.ui.RentalUIConstant;

public class PaletteColorPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,RentalUIConstant {

	

	public PaletteColorPage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("Color preference");
	}


	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		Map<String, Palette> palettes =RentalUIActivator.getDefault().getPaletteManager();
		
		String[][] comboValues = new String[palettes.size()][2];
		int i =0;
		for (Palette p : palettes.values()) {
			comboValues[i][0]=p.getName();
			comboValues[i][1]=p.getId();
			i++;
		}
		addField(new ComboFieldEditor(PREF_PALETTE, "Palette :", comboValues, getFieldEditorParent()));
		
	}

}

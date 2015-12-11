package com.arcad.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin implements RentalUIConstant{
	
	private Map<String, Palette> paletteManager = new HashMap<String, Palette>();

	// The plug-in ID
	public static final String PLUGIN_ID = "com.arcad.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		readViewsExtensiond();
	}

	private void readViewsExtensiond() {
		IExtensionRegistry exReg = Platform.getExtensionRegistry();;
		for (IConfigurationElement e : exReg.getConfigurationElementsFor("com.arcad.rental.ui.palette")) {
			IColorProvider delegateICP;
			try {
				delegateICP = (IColorProvider) e.createExecutableExtension("paletteClass");
				
				Palette p = new Palette();
				p.setName(e.getAttribute("name"));
				p.setId(e.getAttribute("id"));
				p.setColorProvider(delegateICP);
				paletteManager.put(e.getAttribute("id"), p);			
				
				System.out.println("palette:  "+e.getAttribute("name"));
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			
		}
		
	}

	public Map<String, Palette> getPaletteManager() {
		return paletteManager;
	}

	public void setPaletteManager(Map<String, Palette> paletteManager) {
		this.paletteManager = paletteManager;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}

	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		Bundle b = FrameworkUtil.getBundle(this.getClass());
		
		reg.put(IMG_CUSTOMER, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMER)));
		reg.put(IMG_RENTAL, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL)));
		reg.put(IMG_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECT)));
		reg.put(IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCY)));
		
	}
}

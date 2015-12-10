package com.arcad.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.arcad.rental.ui.RentalUIActivator;
import com.arcad.rental.ui.RentalUIConstant;
import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, RentalUIConstant, IColorProvider {

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>)
			return ((Collection<?>) inputElement).toArray();
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof RentalAgency) {
			// return ((RentalAgency) parentElement).getCustomers().toArray();
			RentalAgency a = (RentalAgency) parentElement;
			return new Node[] { new Node(NODE_CUSTOMERS, a), new Node(NODE_RENTAL, a),
					new Node(NODE_RENTAL_OBJECT, a) };
		} else if (parentElement instanceof Node) {
			return ((Node) parentElement).getChildren();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {

		return element instanceof RentalAgency || element instanceof Node;
	}

	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		} else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		} else if (element instanceof RentalObject) {
			return ((RentalObject) element).getName();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof RentalAgency) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_AGENCY);
		} else if (element instanceof Customer) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_CUSTOMER);
		} else if (element instanceof RentalObject) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_OBJECT);
		}
		return super.getImage(element);
	}

	class Node {

		private String title;
		private RentalAgency a;

		@Override
		public String toString() {
			return title;
		}

		public Node(String title, RentalAgency a) {
			super();
			this.title = title;
			this.a = a;
			
			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}

		Object[] getChildren() {
			if (title == NODE_CUSTOMERS) {
				return a.getCustomers().toArray();
			} else if (title == NODE_RENTAL_OBJECT)
				return a.getObjectsToRent().toArray();
			else if (title == NODE_RENTAL) {
				return a.getRentals().toArray();
			}
			return null;
		}

		private RentalProvider getOuterType() {
			return RentalProvider.this;
		}

	}

	@Override
	public Color getForeground(Object element) {
		Display d = Display.getCurrent();
		if (element instanceof RentalAgency) {
			// return d.getSystemColor(SWT.COLOR_BLUE);			
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_RRENTAL_COLOR));
			
		} else if (element instanceof Customer) {
			// return d.getSystemColor(SWT.COLOR_RED);		
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_CUSTOMER_COLOR));
		} else if (element instanceof RentalObject) {
			// return d.getSystemColor(SWT.COLOR_GREEN)			
			return  getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(PREF_OBJECT_COLOR));
		} else if (element instanceof Node) {
			return d.getSystemColor(SWT.COLOR_DARK_MAGENTA);
		}
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

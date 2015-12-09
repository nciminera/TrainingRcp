package com.arcad.rental.ui.views;

import java.util.Collection;


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
//			return ((RentalAgency) parentElement).getCustomers().toArray();
			RentalAgency a = (RentalAgency) parentElement;
			return new Node[] {new Node(NODE_CUSTOMERS, a),new Node(NODE_RENTAL, a),new Node(NODE_RENTAL_OBJECT, a)};
		}else if (parentElement instanceof Node) {
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
		}else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		}else if (element instanceof RentalObject) {
			return ((RentalObject) element).getName();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof RentalAgency) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_AGENCY);
		}else if (element instanceof Customer) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_CUSTOMER);
		}else if (element instanceof RentalObject) {
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

		Object[] getChildren(){
			if (title == NODE_CUSTOMERS) {
				return a.getCustomers().toArray();
			}else if (title == NODE_RENTAL_OBJECT)
				return a.getObjectsToRent().toArray();
			else if (title == NODE_RENTAL) {	
				return a.getRentals().toArray();
			}
			return null;
		}

	}

	@Override
	public Color getForeground(Object element) {
		Display d = Display.getCurrent();
		if (element instanceof RentalAgency) {
			return d.getSystemColor(SWT.COLOR_BLUE);
		}else if (element instanceof Customer) {
			return d.getSystemColor(SWT.COLOR_RED);
		}else if (element instanceof RentalObject) {
			return d.getSystemColor(SWT.COLOR_GREEN);
		}else if (element instanceof Node) {
			return d.getSystemColor(SWT.COLOR_DARK_MAGENTA);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
}

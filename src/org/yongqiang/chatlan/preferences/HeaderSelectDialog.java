package org.yongqiang.chatlan.preferences;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.yongqiang.chatlan.ChatLanActivator;

public class HeaderSelectDialog extends Dialog {

	private int header_index;
	
	class BtnSelectionListener extends SelectionAdapter {
		
		private HeaderSelectDialog dlg;
		
		public BtnSelectionListener(HeaderSelectDialog dlg) {
			this.dlg = dlg;
		}
		
		public void widgetSelected(SelectionEvent e) {
			Button btn = (Button)e.getSource();
			if (btn != null) {
				Integer i = (Integer)btn.getData();
				dlg.setHeader_index(i);
			}
		}
	}
	
	protected HeaderSelectDialog(Shell parentShell, int index) {
		super(parentShell);
		header_index = index;
		// this.getShell().setText("Select...");
	}

	public int getHeader_index() {
		return header_index;
	}

	public void setHeader_index(int header_index) {
		this.header_index = header_index;
	}

	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite)super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout)comp.getLayout();
		layout.numColumns = 3;
		
		BtnSelectionListener listener = new BtnSelectionListener(this);
		
		for (int i = 1; i <= 10; ++i) {
			Button btn = new Button(comp, SWT.PUSH);
			btn.setImage(ChatLanActivator.getImageDescriptor("./icons/gs" + i + ".gif").createImage());
			btn.setData(i);
			btn.addSelectionListener(listener);
		}
		
		return comp;
	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		//createButton(parent, IDialogConstants.OK_ID, "OK", true);
		//createButton(parent, IDialogConstants.CANCEL_ID, "Cancel", false);
	}
	
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
	}
}

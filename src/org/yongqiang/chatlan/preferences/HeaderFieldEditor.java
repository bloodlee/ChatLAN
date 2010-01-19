package org.yongqiang.chatlan.preferences;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.yongqiang.chatlan.ChatLanActivator;

public class HeaderFieldEditor extends FieldEditor {

	private int header_index;
	
	public int getHeader_index() {
		return header_index;
	}

	public void setHeader_index(int header_index) {
		this.header_index = header_index;
	}

	private Label header_label;
	
	private Button change_btn;
	
	private int old_index;
	
	class ChangeHeaderSelectionListener extends SelectionAdapter {
		
		private final HeaderFieldEditor editor;
		
		public ChangeHeaderSelectionListener(HeaderFieldEditor editor) {
			this.editor = editor;
		}
		
		public void widgetSelected(SelectionEvent e) {
			HeaderSelectDialog dlg = new HeaderSelectDialog(editor.getPage().getShell(), editor.getHeader_index());
			if (dlg.open() == IDialogConstants.OK_ID)
			{
				if (dlg.getHeader_index() != editor.getHeader_index()) {
					editor.setHeader(dlg.getHeader_index());
				}
			}
		}
	}
	
	protected HeaderFieldEditor() {
	}
	
	public HeaderFieldEditor(String name, String labelText, Composite parent) {
		init(name, labelText);
		
		createControl(parent);
	}
	
	protected void createControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = this.getNumberOfControls();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 8;
		parent.setLayout(layout);
		this.doFillIntoGrid(parent, layout.numColumns);
	}
	
	@Override
	protected void adjustForNumColumns(int numColumns) {
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		this.getLabelControl(parent);
		
		header_label = new Label(parent, SWT.NONE);
		
		new Label(parent, SWT.NONE);
		
		change_btn = new Button(parent, SWT.PUSH);
		change_btn.setText("Change...");
		change_btn.addSelectionListener(new ChangeHeaderSelectionListener(this));
	}

	@Override
	protected void doLoad() {
		// TODO Auto-generated method stub
		if (header_label != null)
		{
			int index = getPreferenceStore().getInt(getPreferenceName());
			setHeader(index);
			old_index = index;
		}
	}

	@Override
	protected void doLoadDefault() {
		if (header_label != null)
		{
			int index = getPreferenceStore().getDefaultInt(getPreferenceName());
			setHeader(index);
		}
	}

	@Override
	protected void doStore() {
		getPreferenceStore().setValue(getPreferenceName(), this.getHeader_index());
	}

	@Override
	public int getNumberOfControls() {
		return 2;
	}
	
	protected void setHeader(int index) {
		if (header_label != null) {
			header_label.setImage(ChatLanActivator.getImageDescriptor("./icons/gs" + index + ".gif").createImage());
			this.header_index = index;
		}
	}

}

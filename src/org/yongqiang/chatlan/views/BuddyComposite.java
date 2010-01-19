package org.yongqiang.chatlan.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yongqiang.chatlan.ChatLanActivator;

public class BuddyComposite extends Composite {

	class BuddyCompositeMouseListener extends MouseAdapter {
		public void mouseDouble(MouseEvent e) {
			System.out.println("Double clicked!");
		}
	}
	
	private Label lAvatar = null;
	private Label lName = null;
	private Label lStatus = null;
	
	BuddyComposite(Composite parent) {
		super(parent, SWT.BORDER);
		
		createControls();
	}
	
	private void createControls() {
		GridLayout layout = new GridLayout(2, true);
		setLayout(layout);
		
		lAvatar = new Label(this, SWT.NONE);
		lAvatar.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		lAvatar.setImage(ChatLanActivator.getImageDescriptor("./icons/gs1.gif").createImage());
		
		Composite nameCompo = new Composite(this, SWT.NONE);
		GridLayout layout2 = new GridLayout(1, true);
		nameCompo.setLayout(layout2);
		
		lName = new Label(nameCompo, SWT.NONE);
		lName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		lName.setText("Yongqiang");
		
		lStatus = new Label(nameCompo, SWT.NONE);
		lStatus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		lStatus.setText("IP: Unknown");
		
		lAvatar.addMouseListener(new BuddyCompositeMouseListener());
	}
}

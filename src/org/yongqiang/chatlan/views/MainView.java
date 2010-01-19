package org.yongqiang.chatlan.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class MainView extends ViewPart {

	public static final String ID = "org.yongqiang.chatlan.views.mainView";
	
	public MainView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
//		Composite mainComposite = new Composite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
//		ScrollBar hBar = mainComposite.getHorizontalBar();
//		hBar.setThumb(10);
		
		GridLayout layout = new GridLayout(1, true);
		parent.setLayout(layout);
		
		BuddyComposite buddy;
		buddy = new BuddyComposite(parent);
		buddy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		buddy = new BuddyComposite(parent);
		buddy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}

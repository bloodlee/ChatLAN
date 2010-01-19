package org.yongqiang.chatlan.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import org.yongqiang.chatlan.ChatLanActivator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = ChatLanActivator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_NAME, "User1");
		store.setDefault(PreferenceConstants.P_HEADER, 1);
	}

}

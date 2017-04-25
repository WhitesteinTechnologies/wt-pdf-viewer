package com.whitestein.vaadin.widgets;

import org.vaadin.addonhelpers.AbstractTest;

import com.vaadin.ui.Component;
import com.whitestein.vaadin.widgets.wtpdfviewer.WTPdfViewer;

/**
 * Add many of these with different configurations,
 * combine with different components, for regressions
 * and also make them dynamic if needed.
 */
@SuppressWarnings("serial")
public class BasicMyComponentUsageUI extends AbstractTest {

	@Override
	public Component getTestComponent() {
		WTPdfViewer clearableTextBox = new WTPdfViewer();
		return clearableTextBox;
	}

}

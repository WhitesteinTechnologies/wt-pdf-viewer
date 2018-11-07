package com.whitestein.vaadin.widgets.wtpdfviewer.client;

import com.vaadin.shared.communication.ClientRpc;

// ClientRpc is used to pass events from server to client
// For sending information about the changes to component state, use State instead
public interface WTPdfViewerClientRpc extends ClientRpc {

	public void firstPage();

	public void lastPage();

	public void nextPage();

	public void previousPage();

	public void setPage(int page);

	public void setShowPreviousViewOnLoad(boolean showPreviousViewOnLoad);
}

package com.whitestein.vaadin.widgets.wtpdfviewer;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.StreamResource;
import com.whitestein.vaadin.widgets.wtpdfviewer.client.WTPdfViewerClientRpc;
import com.whitestein.vaadin.widgets.wtpdfviewer.client.WTPdfViewerServerRpc;
import com.whitestein.vaadin.widgets.wtpdfviewer.client.WTPdfViewerState;

// This is the server-side UI component that provides public API 
// for WTPdfViewer
@JavaScript({ "l10n.js", "pdf.worker.js", "pdf.js", "pdf.viewer.js" })
public class WTPdfViewer extends com.vaadin.ui.AbstractComponent {

	private static final long serialVersionUID = -8979560729307918782L;

	// To process events from the client, we implement and register ServerRpc
	private WTPdfViewerServerRpc rpc = new WTPdfViewerServerRpc() {

		private static final long serialVersionUID = 7777987530546614587L;
	};

	public WTPdfViewer() {
		registerRpc(rpc);
	}

	// We must override getState() to cast the state to WTPdfViewerState
	@Override
	protected WTPdfViewerState getState() {
		return (WTPdfViewerState) super.getState();
	}

	public void setResource(StreamResource sourceFile) {
		setResource("resourceFile", sourceFile);
	}

	public void firstPage() {
		WTPdfViewerClientRpc proxy = getRpcProxy(WTPdfViewerClientRpc.class);
		proxy.firstPage();
	}

	public void lastPage() {
		WTPdfViewerClientRpc proxy = getRpcProxy(WTPdfViewerClientRpc.class);
		proxy.lastPage();
	}

	public void previousPage() {
		WTPdfViewerClientRpc proxy = getRpcProxy(WTPdfViewerClientRpc.class);
		proxy.previousPage();
	}

	public void nextPage() {
		WTPdfViewerClientRpc proxy = getRpcProxy(WTPdfViewerClientRpc.class);
		proxy.nextPage();
	}

	public void setPage(int page) {
		WTPdfViewerClientRpc proxy = getRpcProxy(WTPdfViewerClientRpc.class);
		proxy.setPage(page);
	}
}

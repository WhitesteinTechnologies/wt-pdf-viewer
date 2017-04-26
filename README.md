# wt-pdf-viewer

Pdf viewer component for Vaadin applications based on [pdf.js](https://github.com/mozilla/pdf.js/) web viewer.

**Features:**
* Sidebar with thumbnails, document outline and attachments
* Text search in PDF text
* Previous page, next page and jump to arbitrary page
* Zooming out up to 10%, automatic zoom, zoom to actual size, fit page, full width
* Full-screen presentation Mode
* Document print
* Document download
* Rotation clockwise and counterclockwise
* Hand tool for comfortable scrolling
* Document properties

## Printing
Call the `wtPdfViewerPrintSupport` mixin from top level of your [styles.scss](https://github.com/WhitesteinTechnologies/wt-pdf-viewer-demo/blob/fe80d00e784443f4e975d8fd1dad64b4ff736a40/src/main/webapp/VAADIN/themes/pdfdemotheme/styles.scss) file. It _must_ be called from top level; otherwise printing won't work correctly.

````scss
@import "pdfdemotheme.scss";
@import "addons.scss";
// add import of pdf viewer styles
@import "../../../VAADIN/themes/wtpdfviewer/wtpdfviewer.scss";

.pdfdemotheme {
  @include addons;
  @include pdfdemotheme;
}
// add printing styles
@include wtPdfViewerPrintSupport
````


## Java API
Create component and show a PDF file in it:
````java
WTPdfViewer pdfViewer = new WTPdfViewer();

// get file stream
String filename = "some-pdf-file.pdf";
InputStream dataStream = getClass().getClassLoader().getResourceAsStream(filename);

// show file in pdf viewer
pdfViewer.setResource(new StreamResource(new InputStreamSource(dataStream), filename));

// boilerplate StreamSource implementation
class InputStreamSource implements StreamSource {

	private final InputStream data;

	public InputStreamSource(InputStream data) {
		super();
		this.data = data;
	}

	@Override
	public InputStream getStream() {
		return data;
	}

}
````

Change visible page from Java code:
````java
WTPdfViewer pdfViewer = new WTPdfViewer();

// basic paging
pdfViewer.firstPage();
pdfViewer.lastPage();
pdfViewer.previousPage();
pdfViewer.nextPage();

// jump to fifth page	
pdfViewer.setPage(5);
````

## Demo Project
Demo project is in the [wt-pdf-viewer-demo](https://github.com/WhitesteinTechnologies/wt-pdf-viewer-demo/) repository.

## Development Instructions
The JavaScript viewer is in `pdf.viewer.js` file. It is a copy of the `build/web/viewer.js` file generated from [wt-vaadin-pdf.js](https://github.com/WhitesteinTechnologies/wt-vaadin-pdf.js) using the 'gulp generic' command.

## GWT-Related Stuff

* To recompile the test widget set, run *mvn vaadin:compile*; if you think the widget-set changes were not picked up by the Vaadin plugin, run *mvn clean package* or try compiling with *mvn vaadin:compile -Dgwt.compiler.force=true*
* To use superdevmode, run "mvn vaadin:run-codeserver" and open superdevmode like any other project

## Creating Releases

1. Push your changes to e.g. Github.
2. Update pom.xml to contain proper SCM coordinates (first time only).
3. Use the Maven release plugin (mvn release:prepare; mvn release:perform).
4. Upload the generated ZIP file from the target/checkout/target directory to https://vaadin.com/directory service and optionally publish your add-on to Maven central.

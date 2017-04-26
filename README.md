# wt-pdf-viewer

Pdf viewer component for vaadin applications based on [pdf.js](https://github.com/mozilla/pdf.js/) web viewer. Features:
* Sidebar with Thumbnails, Document Outline and Attachments.
* Text search in pdf text.
* Previous page, next page and jump on arbitrary page.
* Zooming - zoom down and up by 10%, automatic zoom, actual size, fit page, full width.
* Full screen presentation Mode.
* Document print.
* Document download.
* Rotation clockwise and counterclockwise.
* Handtool for comfortable scrolling.
* Document properties.

## Printing
Call `wtPdfViewerPrintSupport` mixin from top level of your [styles.scss](https://github.com/WhitesteinTechnologies/wt-pdf-viewer-demo/blob/fe80d00e784443f4e975d8fd1dad64b4ff736a40/src/main/webapp/VAADIN/themes/pdfdemotheme/styles.scss) file. It _must_ be called from top level, printing wont work correctly otherwise.

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
Create component and show pdf file in it:
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

Change visible page from java code: 
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
Demo project is in [wt-pdf-viewer-demo](https://github.com/WhitesteinTechnologies/wt-pdf-viewer-demo/) repository.

## Development instructions 
Javascript viewer is in `pdf.viewer.js` file. It is a copy of `build/web/viewer.js` file generated from [wt-vaadin-pdf.js](https://github.com/WhitesteinTechnologies/wt-vaadin-pdf.js) using 'gulp generic' command. 

## GWT related stuff

* To recompile test widgetset, issue *mvn vaadin:compile*, if you think the widgetset changes are not picked up by Vaadin plugin, do a *mvn clean package* or try with parameter *mvn vaadin:compile -Dgwt.compiler.force=true*
* To use superdevmode, issue "mvn vaadin:run-codeserver" and then just open superdevmode like with any other project

## Creating releases

1. Push your changes to e.g. Github 
2. Update pom.xml to contain proper SCM coordinates (first time only)
3. Use Maven release plugin (mvn release:prepare; mvn release:perform)
4. Upload the ZIP file generated to target/checkout/target directory to https://vaadin.com/directory service (and/or optionally publish your add-on to Maven central)


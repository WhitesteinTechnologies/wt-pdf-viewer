package com.whitestein.vaadin.widgets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.vaadin.addonhelpers.AbstractTest;

import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.ui.Component;
import com.whitestein.vaadin.widgets.wtpdfviewer.WTPdfViewer;

/**
 * Add many of these with different configurations,
 * combine with different components, for regressions
 * and also make them dynamic if needed.
 */
@SuppressWarnings("serial")
public class NotAPdfUI extends AbstractTest {

  @Override
  public Component getTestComponent() {
    WTPdfViewer clearableTextBox = new TestWTPdfViewer();
    clearableTextBox.setHeight("600px");
    clearableTextBox.setWidth("600px");

    clearableTextBox.setResource(createPdfFileSource("src\\test\\resources\\pdf\\this-is-not-pdf.txt"));
    return clearableTextBox;
  }

  StreamResource createPdfFileSource(final String filename) {
    StreamSource source = new StreamSource() {

      @Override
      public InputStream getStream() {
        try {
          File initialFile = new File(filename);
          final InputStream targetStream = new FileInputStream(initialFile);

          return targetStream;
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        }
      }

    };

    return new StreamResource(source, "chacha");

  }
}

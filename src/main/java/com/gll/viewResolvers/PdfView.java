package com.gll.viewResolvers;


import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class PdfView extends AbstractView {

	public PdfView() {
		setContentType("application/pdf");
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ByteArrayOutputStream baos = createTemporaryOutputStream();
		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		writer.setViewerPreferences(PdfWriter.AllowPrinting);
	
		document.open();
		buildPdfDocument(model, document, writer, request, response);
		document.close();
		writeToResponse(response, baos);

	}

	protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
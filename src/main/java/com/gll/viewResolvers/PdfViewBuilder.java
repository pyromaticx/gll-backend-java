package com.gll.viewResolvers;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gll.bean.Address;
import com.gll.bean.Person;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfViewBuilder extends PdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Person person = (Person) model.get("person");

		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
	//	table.getDefaultCell().setBackgroundColor(Color.lightGray);

		table.addCell("Person Id");
		table.addCell("Person Name");
		table.addCell("Email");

		table.addCell(String.valueOf(person.getPersonId()));
		table.addCell(person.getPersonName());
		table.addCell(person.getEmail());
		
		Set<Address> addressList = new HashSet<Address>();
		for (Address i : addressList) {
			Address temp = new Address();
			temp=i;
			addressList.add(temp);
		}
		
		table.addCell(addressList.toString());
		document.add(table);


		
	}

}

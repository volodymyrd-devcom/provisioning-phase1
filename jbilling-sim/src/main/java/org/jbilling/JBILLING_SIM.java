package org.jbilling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JBILLING_SIM extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder requestBody = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				requestBody.append(line);
		} catch (Exception e) {
		}

		String pathInfo = request.getPathInfo();
		if (pathInfo != null && pathInfo.toLowerCase().indexOf("edigw") != -1) {
			if (requestBody.indexOf("491772000001") != -1) {
				// Do success response
				StringBuilder responseXml = new StringBuilder();
				responseXml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
				responseXml.append("<spResponse>");
				responseXml.append("	<Action>");
				responseXml.append("		<No>1</No>");
				responseXml.append("		<Tx>1</Tx>");
				responseXml.append("		<TxStatus>1</TxStatus>");
				responseXml.append("	</Action>");
				responseXml.append("</spResponse>");
				writeResponse(request, response, responseXml.toString());
			} else {
				// Do Error response
				StringBuilder responseXml = new StringBuilder();
				responseXml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
				responseXml.append("<spResponse>");
				responseXml.append("	<Action>");
				responseXml.append("		<No>1</No>");
				responseXml.append("		<Tx>1</Tx>");
				responseXml.append("		<TxStatus>1</TxStatus>");
				responseXml.append("		<ErrorNo>01</ErrorNo>");
				responseXml.append("		<ErrorMessage>INVALID MSDN</ErrorMessage>");
				responseXml.append("	</Action>");
				responseXml.append("</spResponse>");
				writeResponse(request, response, responseXml.toString());
			}
		} else if (pathInfo != null && pathInfo.toLowerCase().indexOf("jsnin") != -1) {
			response.getOutputStream().println("JSNIN");
		} else if (pathInfo != null && pathInfo.toLowerCase().indexOf("mmsc") != -1) {
			response.getOutputStream().println("MMSC");
		} else if (pathInfo != null && pathInfo.toLowerCase().indexOf("vsc") != -1) {
			if (requestBody.indexOf("491772000001") != -1) {
				// Do success response
				StringBuilder responseXml = new StringBuilder();
				responseXml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>");
				responseXml.append("<RESPONSE>");
				responseXml.append("	<REQUEST-ORIGIN host=\"host\" module=\"module\" id=\"1234\"/>");
				responseXml.append("	<RESPONSE-ORIGIN host=\"host\" module=\"BlCore\" id=\"4321\"/>");
				responseXml.append("	<RESULT>");
				responseXml.append("		<STATUS-CODE>0</STATUS-CODE>");
				responseXml.append("		<MESSAGE>O.K.</MESSAGE>");
				responseXml.append("	</RESULT>");
				responseXml.append("	<RECORD>");
				responseXml.append("		<ELEMENT1>Data</ELEMENT1>");
				responseXml.append("	</RECORD>");
				responseXml.append("	<INFO>");
				responseXml.append("		<CurrentQuota>105</CurrentQuota>");
				responseXml.append("	</INFO>");
				responseXml.append("</RESPONSE>");
				writeResponse(request, response, responseXml.toString());
			} else {
				// Do Error response
				StringBuilder responseXml = new StringBuilder();
				responseXml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>");
				responseXml.append("<RESPONSE>");
				responseXml.append("	<REQUEST-ORIGIN host=\"host\" module=\"module\" id=\"1234\"/>");
				responseXml.append("	<RESPONSE-ORIGIN host=\"host\" module=\"BlCore\" id=\"4321\"/>");
				responseXml.append("	<RESULT>");
				responseXml.append("		<STATUS-CODE>17</STATUS-CODE>");
				responseXml.append("		<MESSAGE>No permission to perform the desired operation.</MESSAGE>");
				responseXml.append("	</RESULT>");
				responseXml.append("</RESPONSE>");
				writeResponse(request, response, responseXml.toString());
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Request parameters.");
		}

	}

	private void writeResponse(HttpServletRequest request, HttpServletResponse response, String responseXml) throws IOException {
		response.setContentType("application/xml");
		PrintWriter writer = new PrintWriter(response.getWriter());
		writer.println(responseXml);
		writer.close();
	}
}

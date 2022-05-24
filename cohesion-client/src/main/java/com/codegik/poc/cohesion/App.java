package com.codegik.poc.cohesion;

import com.fidelityifs.webservices.CohesionConnect;
import com.fidelityifs.webservices.STran;
import com.fidelityinfoservices.schemas.webservices.miser.tpsl.MiserXMLInput;
import com.fidelityinfoservices.schemas.webservices.miser.vbtp.Transaction;
import com.fidelityinfoservices.schemas.webservices.miser.vbtp.VBTPRequest;

import java.net.MalformedURLException;
import java.net.URL;

public class App {

	public static void main(String[] args) throws MalformedURLException {
		final URL url = new URL("http://localhost:8080/employeeservice?wsdl");
		final CohesionConnect cohesionConnect = new CohesionConnect(url);
		final STran sTran = new STran();
		final MiserXMLInput miserXMLInput = new MiserXMLInput();
		final VBTPRequest vbtpRequest = new VBTPRequest();
		final Transaction transaction = new Transaction();

		vbtpRequest.setTransaction(transaction);
		sTran.setMiserXMLInput(miserXMLInput);
		sTran.setVBTPRequest(vbtpRequest);
		cohesionConnect.getCohesionConnectSoap().getHostReply(sTran);
	}

}

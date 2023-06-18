package io.swagger.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.nic.eoffice.esign.CreateEsignRequest;
import org.nic.eoffice.esign.esign_enum.AuthMode;
import org.nic.eoffice.esign.esign_enum.ResponseType;
import org.nic.eoffice.esign.model.EsignRequest;
import org.nic.eoffice.esign.model.EsignRequestResponse;
// import org.nic.eoffice.esign.CreateEsignRequest;
// import org.nic.eoffice.esign.esign_enum.AuthMode;
// import org.nic.eoffice.esign.esign_enum.ResponseType;
// import org.nic.eoffice.esign.model.EsignRequest;
// import org.nic.eoffice.esign.model.EsignRequestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.xmp.impl.Base64;

import io.swagger.utils.EsignClientUtil;

@Service
@PropertySource(value = "classpath:global.properties")
public class EsignClientServiceImp {

	@Value("${transaction_id}")
	String transaction_id;
	@Value("${aspId}")
	String aspId;

	@Value("${path.certFilePath}")
	String certFilePath;
	@Value("${certFilePwd}")
	String certFilePwd;

	@Value("${url.gatewayUrl}")
	String gatewayUrl;

	@Value("${path.fileDownloadPath}")
	String fileDownloadPath;

	private static final XPath xPath = XPathFactory.newInstance().newXPath();
	
	
	

	public String createESignGatewayRequest(String responseUrl, String baseUrl, String textInfo, String textData) throws Exception {
		EsignRequest esignReq = new EsignRequest();
		esignReq.setAspId(aspId);
		esignReq.setSignerConsent("Y");
		esignReq.setContentType("text");
		esignReq.setAuthMode(AuthMode.OTP);
		esignReq.setResponseUrl(responseUrl);
		esignReq.setEsignVersion("2.1");
		esignReq.setAspId(aspId);
		esignReq.setResponseType(ResponseType.PKCS7);

		String timestamp = EsignClientUtil.getCurrentDateTimeISOFormat();
		String pattern = "yyyy-MM-dd'T'HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String txnPattern = "yyyyMMdd-HHmmss";
		SimpleDateFormat txnSimpleDateFormat = new SimpleDateFormat(txnPattern);
		String txnTimeStamp = txnSimpleDateFormat.format(new Date());
		timestamp = simpleDateFormat.format(new Date());
		String txnCounter = getTxnCounter();
		esignReq.setTxn(transaction_id+ txnTimeStamp + "-" + txnCounter);
		
		

		esignReq.setUidToken("2F5468584E6B7A58777846646A514F4443726A6C6B6A4A6F");
		esignReq.setAddDeltaTime(true); // if opting to add delta time
		esignReq.setPfxFile(certFilePath); // if consuming application is working with multiple esign configuration
		esignReq.setPfxPassword(certFilePwd);
		esignReq.setDocInfo(new String[] { textInfo });
		esignReq.setContentsToSign(new String[] { textData });
		CreateEsignRequest createEsignReq = new CreateEsignRequest();
		EsignRequestResponse obj = createEsignReq.getRequestXml(esignReq);
		System.out.println("Esign request XML :: " + obj.getRequestXml());

		if (obj.getStatus()) {
			System.out.println("Esign request XML :: " + obj.getRequestXml());
		} else {
			System.out.println("Error Message :: " + obj.getErrorMessage());
		}
		return obj.getRequestXml();

	}

	public String createHash(String username, String userText,String textInfo,
			 String baseUrl,String responsePath) throws Exception {
		String txnCounter = getTxnCounter();
		baseUrl = "response?rs=" + baseUrl + responsePath;

		String generatedHash = EsignClientUtil.generateHash(userText.getBytes());

		String timestamp = EsignClientUtil.getCurrentDateTimeISOFormat();
		String pattern = "yyyy-MM-dd'T'HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String txnPattern = "yyyyMMdd-HHmmss";
		SimpleDateFormat txnSimpleDateFormat = new SimpleDateFormat(txnPattern);
		String txnTimeStamp = txnSimpleDateFormat.format(new Date());
		timestamp = simpleDateFormat.format(new Date());

		String st = "";

		st = "<Esign AuthMode=\"1\" ver=\"2.1\" sc=\"Y\"    ts=\"" + timestamp + "\"  txn =\"" + transaction_id
				+ txnTimeStamp + "-" + txnCounter + "\" ekycId=\"\"  aspId=\"" + aspId
				+ "\" ekycIdType=\"A\" responseSigType=\"pkcs7\"  responseUrl=\"" + gatewayUrl + baseUrl + "\" ><Docs>"
				+ "<InputHash id=\"1\" hashAlgorithm=\"SHA256\" docInfo=\""+ textInfo+ "\">" + generatedHash + "</InputHash>\n"
				+ "</Docs></Esign>";
		st = sign(st);
		System.out.println(st);

		return st;

	}

	public String getTxnCounter() {
		Random ran = new Random();
		int number = ran.nextInt(999999);
		return String.format("%06d", number);
	}

	public String sign(String xml) throws NoSuchProviderException, UnrecoverableEntryException, KeyStoreException {
		XMLSignatureFactory fac = null;
		Document doc = null;
		try {
			fac = XMLSignatureFactory.getInstance("DOM");
			Reference ref = fac
					.newReference("", fac.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", null),
							Collections.singletonList(fac.newTransform(
									"http://www.w3.org/2000/09/xmldsig#enveloped-signature", (XMLStructure) null)),
							null, null);
			SignedInfo si = fac.newSignedInfo(
					fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315",
							(XMLStructure) null),
					fac.newSignatureMethod("http://www.w3.org/2000/09/xmldsig#rsa-sha1", null),
					Collections.singletonList(ref));
			KeyStore ks = KeyStore.getInstance("JKS");
			System.out.println("certFilePath-" + certFilePath);
			InputStream is = new FileInputStream(certFilePath);
			System.out.println("certFilePwd-" + certFilePwd);
			ks.load(is, certFilePwd.toCharArray());

			Enumeration<String> enumAlias = ks.aliases();
			String aliase = null;
			while (enumAlias.hasMoreElements()) {
				aliase = (String) enumAlias.nextElement();
			}

			KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(aliase,
					new KeyStore.PasswordProtection(certFilePwd.toCharArray()));

			X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

			KeyInfoFactory kif = fac.getKeyInfoFactory();
			ArrayList<Serializable> x509Content = new ArrayList<Serializable>();
			x509Content.add(cert.getSubjectX500Principal().getName());
			x509Content.add(cert);
			X509Data xd = kif.newX509Data(x509Content);
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource ins = new InputSource();
			ins.setCharacterStream(new StringReader(xml));
			doc = db.parse(ins);

			DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());
			XMLSignature signature = fac.newXMLSignature(si, ki);
			signature.sign(dsc);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();

			OutputStream os = new ByteArrayOutputStream();
			trans.transform(new DOMSource(doc), new StreamResult(os));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String signedXML = EsignClientUtil.convertDocumentToString(doc);
		return signedXML;
	}

	

	public Map<String, Object> getSignedPdf(String eSignResponseXml, PdfSignatureAppearance appearance)
			throws Exception {
		int contentEstimated = 8192;
		Map<String, Object> res = new HashMap<>();

		try {

			Document doc = EsignClientUtil.convertStringToDocument(eSignResponseXml);
			String pkcs7response;
			String WsErrMsg = "";
			String RespStatus = EsignClientUtil.getXpathValue(xPath, "/EsignResp/@status", doc);
			System.out.println(RespStatus + "   RespStatus");

			String name = null;
			try {
				XPathExpression expr = xPath.compile("/EsignResp/Signatures/DocSignature[@id='1']/text()");
				name = (String) expr.evaluate(doc, XPathConstants.STRING);

				EsignClientUtil.signDocument(Base64.decode(name.getBytes("UTF8")), appearance);

			} catch (XPathExpressionException e) {
				System.out.println("Error message" + e.getMessage());
			}
			if (RespStatus.equals("1")) {
				System.out.println("if condition in Esign1");
				pkcs7response = "1-" + xPath.compile("/EsignResp/Signatures/DocSignature").evaluate(doc);
			} else {
				System.out.println("else condition in Esign1");
				String errcode = EsignClientUtil.getXpathValue(xPath, "/EsignResp/@errCode", doc);
				res.put("errcode", errcode);
				WsErrMsg = xPath.compile("/EsignResp/@errMsg").evaluate(doc);
				pkcs7response = "0-" + WsErrMsg;
				res.put("errorMessage", WsErrMsg);

			}

			String pkcsres = pkcs7response;
			System.out.println("pkcsres:  " + pkcsres);
			String[] result = pkcsres.split("-");
			String pkcsressuccessfailure = result[0];
			String returnedstring = result[1];
			byte[] PKCS7Response = Base64.decode(returnedstring.getBytes("UTF8"));

			if (!pkcsressuccessfailure.equals("0")) {
				System.out.println("pkcsressuccessfailure if condition");
				PKCS7Response = Base64.decode(returnedstring.getBytes("UTF8"));
				byte[] paddedSig = new byte[contentEstimated];
				System.arraycopy(PKCS7Response, 0, paddedSig, 0, PKCS7Response.length);
				PdfDictionary dic2 = new PdfDictionary();
				System.out.println("PdfName.CONTENTS:   " + PdfName.CONTENTS);
				System.out.println("paddedSig   :" + paddedSig);
				dic2.put(PdfName.CONTENTS, new PdfString(paddedSig).setHexWriting(true));

				res.put("status", true);
				res.put("errorMessage", "Pdf is signed successfully");
				return res;
			} else {
				System.out.println("pkcsressuccessfailure else condition");
				res.put("status", false);
				res.put("errorMessage", WsErrMsg);
				return res;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "  error in ex");
			res.put("status", false);
			res.put("exMessage", ex.toString());
			return res;
		}

	}

}

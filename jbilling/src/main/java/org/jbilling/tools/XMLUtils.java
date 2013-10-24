package org.jbilling.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Vector;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

	private Document document;
	private Element root;

	public XMLUtils() {
	}

	public XMLUtils(String filename) throws SAXException, IOException {
		init(new InputSource(new FileInputStream(filename)));
	}

	public XMLUtils(InputStream stream) throws SAXException, IOException {
		init(new InputSource(stream));
	}

	public void loadXML(String xml) throws SAXException, IOException {
		init(new InputSource((Reader) new StringReader(xml)));
	}

	private void init(InputSource source) throws SAXException, IOException {
		DOMParser parser = new DOMParser();
		setFeature(parser);
		parser.parse(source);
		document = parser.getDocument();
		setRoot();
	}

	private void setFeature(DOMParser parser) throws SAXException {
		parser.setFeature("http://xml.org/sax/features/validation", false);
		parser.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
		parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
	}

	public String[] getStringsAttributValue(String tag, String attrname) {
		Vector<String> vec_attr = new Vector<String>();
		NodeList nl = root.getElementsByTagNameNS("*", tag);
		for (int i = 0; i < nl.getLength(); i++) {
			String attrvalue = getStringAttributValue(nl.item(i), attrname);
			if (attrvalue != null)
				vec_attr.add(attrvalue);
		}
		return (String[]) vec_attr.toArray(new String[vec_attr.size()]);
	}

	public String getStringAttributValue(String tag, String attrname, String attrvalue, String attrsearch) {
		return getStringAttributValue(tag, new String[] { attrname }, new String[] { attrvalue }, attrsearch);
	}

	public int setRoot(boolean fromBeginning, String tag, String attrname, String attrvalue) {
		return setRoot(fromBeginning, tag, new String[] { attrname }, new String[] { attrvalue });
	}

	public String getStringTagValue(String tag) {
		return getStringTagValue(getNode(tag));
	}

	public String getStringTagValue(Node node) {
		if (node != null) {
			if (!node.hasChildNodes())
				return "";
			else {
				Node nChild = node.getChildNodes().item(0);
				if (nChild != null)
					return nChild.getNodeValue();
			}
		}
		return null;
	}

	private String getStringAttributValue(String tag, String[] attrnames, String[] attrvalues, String attrsearch) {
		return getStringAttributValue(getNode(tag, attrnames, attrvalues), attrsearch);
	}

	private String getStringAttributValue(Node node, String attrname) {
		if (node != null && attrname != null && node.hasAttributes()) {
			Node nodeAttr = node.getAttributes().getNamedItem(attrname);
			if (nodeAttr != null) {
				return nodeAttr.getNodeValue();
			}
		}
		return null;
	}

	private int setRoot() {
		this.root = this.document.getDocumentElement();
		return 0;
	}

	private int setRoot(boolean fromBeginning, String tag, String[] attrnames, String[] attrvalues) {
		return setRoot(fromBeginning, tag, attrnames, attrvalues, -1);
	}

	private int setRoot(boolean fromBeginning, String tag, String[] attrnames, String[] attrvalues, int attrs_number) {
		if (fromBeginning) {
			setRoot();
			return setRoot(false, tag, attrnames, attrvalues, attrs_number);
		} else {
			Node node = getNode(tag, attrnames, attrvalues, attrs_number);
			if (node != null) {
				this.root = (Element) node;
				return 0;
			} else {
				return -1;
			}
		}
	}

	private Node getNode(String tag) {
		if (tag == null)
			return null;
		if (root.getTagName().equalsIgnoreCase(tag))
			return root;
		NodeList nl = root.getElementsByTagNameNS("*", tag);
		if (nl == null || nl.getLength() == 0)
			return null;
		return nl.item(0);
	}

	private Node getNode(String tag, String[] attrnames, String[] attrvalues) {
		if (attrnames == null || attrvalues == null || attrnames.length == 0 || attrvalues.length == 0)
			return getNode(tag);
		return getNode(tag, attrnames, attrvalues, -1);
	}

	private Node getNode(String tag, String[] attrnames, String[] attrvalues, int attrs_number) {
		if (attrnames == null || attrvalues == null || attrnames.length == 0 || attrvalues.length == 0)
			return getNode(tag);
		if (tag == null || attrnames.length != attrvalues.length)
			return null;
		if (tag.equals(root.getTagName())) {
			if (root.hasAttributes()) {
				NamedNodeMap attributes = root.getAttributes();
				if (attrs_number == -1 || attrs_number == attributes.getLength()) {
					boolean allMatch = true;
					for (int j = 0; j < attrnames.length; j++) {
						Node nodeAttr = attributes.getNamedItem(attrnames[j]);
						if (nodeAttr == null || !nodeAttr.getNodeValue().equalsIgnoreCase(attrvalues[j]))
							allMatch = false;
					}
					if (allMatch)
						return root;
				}
			}
		}
		NodeList nl = root.getElementsByTagNameNS("*", tag);
		if (nl != null) {
			outer: for (int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if (node.hasAttributes()) {
					NamedNodeMap attributes = node.getAttributes();
					if (attrs_number != -1 && attrs_number != attributes.getLength())
						continue outer;
					for (int j = 0; j < attrnames.length; j++) {
						Node nodeAttr = attributes.getNamedItem(attrnames[j]);
						if (nodeAttr == null || !nodeAttr.getNodeValue().equalsIgnoreCase(attrvalues[j])) {
							continue outer;
						}
					}
					return node;
				}
			}
		}
		return null;
	}
}

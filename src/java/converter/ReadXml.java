/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import java.io.File;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author FOSSO
 */
public class ReadXml {
    public static void main(String[] args) throws Exception{
        XMLInputFactory xmlFile=XMLInputFactory.newInstance();
        XMLStreamReader xmlstr= xmlFile.createXMLStreamReader(new FileReader(".\\XML\\data.xml"));
        int type;
        boolean agains=xmlstr.hasNext();
        while(agains){
            type=xmlstr.next();
            if(type == XMLEvent.START_ELEMENT){
                if(xmlstr.getLocalName().startsWith("MARQUE_LAPTOP_")){
                    System.out.println(xmlstr.getLocalName().substring(14));
                }
            }
            if(!xmlstr.hasNext()){
                agains=false;
            }
        }
        //DocumentBuilderFactory docbuilfac = DocumentBuilderFactory.newInstance();
        
    }
}

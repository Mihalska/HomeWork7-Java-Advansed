package task3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

    public class City {

        public  static  void  main ( String [] args ) {
            creationXml ();
            sAXParserXml ();
        }
        public  static  void  creationXml () {
            try  {
                DocumentBuilderFactory  dbf = DocumentBuilderFactory . newInstance() ;
                DocumentBuilder  db = dbf . newDocumentBuilder ();
                Document  doc = db . newDocument () ;

                Element rootElement = doc . createElement ( "cities" );
                doc. appendChild ( rootElement );

                Element   cityTeg = doc . createElement ( "city" );
         //       cityTeg.setAttribute("size","big" );
                rootElement . appendChild ( cityTeg );

                Element  cityNameTag = doc . createElement ( "cityName" );
                cityNameTag . setTextContent ( "Kiev" );
               cityNameTag . setAttribute ( "size" , "big" );
                cityTeg . appendChild ( cityNameTag );

                Element  streetNameTag = doc . createElement ( "streetName" );
                streetNameTag . setTextContent ( "Vasylkivska" );
                cityTeg . appendChild ( streetNameTag );

                Element houseNumberTag = doc . createElement ( "houseNumber" );
                houseNumberTag . setTextContent ( "1" );
                cityTeg . appendChild ( houseNumberTag );

                Element  cityTeg2 = doc . createElement ( "city" );
                rootElement . appendChild ( cityTeg2 );

                Element  cityNameTag2 = doc . createElement ( "cityName" );
                cityNameTag2 . setTextContent ( "Kharkiv" );
                 cityNameTag2.setAttribute("size", "big");
                cityTeg2 . appendChild ( cityNameTag2 );

                Element  streetNameTag2 = doc . createElement ( "streetName" );
                streetNameTag2 . setTextContent ( "Shevchenkа" );
                cityTeg2 . appendChild ( streetNameTag2 );

                Element  houseNumberTag2 = doc . createElement ( "houseNumber" );
                houseNumberTag2 . setTextContent ( "2" );
                cityTeg2 . appendChild ( houseNumberTag2 );

                Element  cityTeg3 = doc . createElement ( "city" );
                rootElement . appendChild ( cityTeg3 );

                Element  cityNameTag3 = doc . createElement ( "cityName" );
                cityNameTag3 . setTextContent ( "Odesa" );
                cityNameTag3.setAttribute("size", "big");
                cityTeg3 . appendChild ( cityNameTag3 );

                Element  streetNameTag3 = doc . createElement ( "streetName" );
                streetNameTag3 . setTextContent ( "Shevchenkа" );
                cityTeg3 . appendChild ( streetNameTag3 );

                Element  houseNumberTag3 = doc . createElement ( "houseNumber" );
                houseNumberTag3 . setTextContent ( "3" );
                cityTeg3 . appendChild ( houseNumberTag3 );

                TransformerFactory  tf = TransformerFactory . newInstance () ;
                Transformer   t = tf . newTransformer () ;

                 DOMSource source = new DOMSource ( doc );

                StreamResult  sr = new  StreamResult ( new File ( "C:\\Users\\Public\\Homework4.7\\src\\task3\\cityDoc.xml" ) );

                t . transform( source  , sr ) ;
                } catch ( Exception  e ) {
                e . printStackTrace ();
            }
        }
        public  static  void  sAXParserXml () {
            final  String  fileName = "C:\\Users\\Public\\Homework4.7\\src\\task3\\cityDoc.xml" ;
            try  {
                 SAXParserFactory factory = SAXParserFactory . newInstance () ;
                 SAXParser  saxParser = factory  . newSAXParser ();
                 DefaultHandler  handler = new DefaultHandler()  {
                    boolean   cityName = false ;
                    boolean  streetName = false ;
                    boolean  houseNumber = false ;
                    boolean  cityNameSize = false ;
                    String attribString = "" ;
                    @ Override
                    public  void  startElement ( String  uri , String  localName , String  qName , Attributes  attributes )  {
                        if ( qName . equalsIgnoreCase ( "cityName" ) ) {

                            if (!attributes  . equals ( "" ) ){
                                attribString = ( attributes  . getValue ( "size" ));
                            }
                            cityName = true ;
                            cityNameSize  = true ;
                        }

                        if ( qName . equalsIgnoreCase ( "streetName" ) ) {
                            streetName = true ;
                        }
                        if ( qName . equalsIgnoreCase ( "houseNumber" ) ) {
                            houseNumber = true ;
                        }
                    }
                    @ Override
                    public  void  characters (char[] ch, int  start , int  length )  {
                        if ( cityName  ) {
                            System.out.println( "city name: " + new String ( ch , start  , length  ) );
                            cityName = false ;
                        }
                        if ( cityNameSize ){
                            System.out.println( "\tcity size: " + attribString );
                            cityNameSize = false ;
                            attribString = "" ;
                        }
                        if ( streetName ) {
                            System.out.println( "\tstreet: " + new String ( ch , start  , length  ) );
                            streetName = false ;
                        }
                        if ( houseNumber ) {
                            System.out.println("\thouse: " + new String ( ch , start  , length ));
                            houseNumber = false ;
                        }
                    }
                };
                saxParser . parse ( fileName  , handler  ) ;
            } catch ( Exception e ) {
                e . printStackTrace ();
            }
        }
}

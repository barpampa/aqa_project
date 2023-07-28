package ru.library.steps.utils;
import ru.library.models.authoridbooks.request.GetAllAuthorBooksXML;

import java.io.StringWriter;
import javax.xml.bind.JAXB;

public class XMLUtil {

        public static String toXML() {
            StringWriter sw = new StringWriter();
            JAXB.marshal(GetAllAuthorBooksXML.class, sw);
            return sw.toString();
        }
}

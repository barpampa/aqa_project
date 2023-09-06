package ru.library.steps.utils;

import ru.library.models.authoridbooks.request.GetAllAuthorBooksXML;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLUtil {

    public static String toXML(Long author_id) throws JAXBException {
        GetAllAuthorBooksXML booksXML = new GetAllAuthorBooksXML();
        booksXML.setAuthor_id(author_id);
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(GetAllAuthorBooksXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(booksXML, sw);
        String result = sw.toString();
        System.out.println(result);
        return result;
    }
}

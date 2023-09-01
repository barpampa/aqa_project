package ru.library.models.authoridbooks.request;

import lombok.AllArgsConstructor;
import javax.xml.bind.annotation.*;

@AllArgsConstructor
@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllAuthorBooksXML {

    @XmlElement(name = "author_id", required = true)
    private Long author_id;

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
}

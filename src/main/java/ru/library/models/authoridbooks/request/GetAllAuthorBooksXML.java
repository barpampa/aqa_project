package ru.library.models.authoridbooks.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.xml.bind.annotation.*;

@Getter
@NoArgsConstructor
@XmlRootElement(name = "author")
@XmlType(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllAuthorBooksXML {

    private Long author_id;

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
}

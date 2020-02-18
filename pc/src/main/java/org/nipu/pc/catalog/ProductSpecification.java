package org.nipu.pc.catalog;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProductSpecification {
    @Id
    private String id;
    private String name;
    private Long price;
}

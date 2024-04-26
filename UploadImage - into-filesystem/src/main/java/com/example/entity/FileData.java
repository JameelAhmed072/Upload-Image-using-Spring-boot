package com.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Document(collection = "image_data-file-system")
public class FileData {

    @Id
    private String _id;
    private String name;
    private String type;
    private String filePath;
}

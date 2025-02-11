package com.dms.document.search.model;

import com.dms.document.search.enums.DocumentStatus;
import com.dms.document.search.enums.DocumentType;
import com.dms.document.search.enums.SharingType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@Document(collection = "documents")
public class DocumentInformation {
    @Id
    private String id;

    @Field("filename")
    private String filename;

    @Field("file_path")
    private String filePath;

    @Field("thumbnail_path")
    private String thumbnailPath;

    @Field("file_size")
    private Long fileSize;

    @Field("mime_type")
    private String mimeType;

    @Field("status")
    private DocumentStatus status;

    @Field("content")
    private String content;

    @Field("language")
    private String language;

    @Field("summary")
    private String summary;

    @Indexed
    @Field("document_type")
    private DocumentType documentType;

    @Indexed
    @Field("major")
    private String major;

    @Indexed
    @Field("course_code")
    private String courseCode;

    @Indexed
    @Field("course_level")
    private String courseLevel;

    @Indexed
    @Field("category")
    private String category;

    @Indexed
    @Field("tags")
    private Set<String> tags;

    @Field("extracted_metadata")
    private Map<String, String> extractedMetadata;

    @Field("user_id")
    private String userId;

    @Field("sharing_type")
    private SharingType sharingType;

    @Field("shared_with")
    private Set<String> sharedWith;

    @Field("deleted")
    private boolean deleted;

    @Field("processing_error")
    private String processingError;

    @Field("current_version")
    private Integer currentVersion;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;

    @Field("created_by")
    private String createdBy;

    @Field("updated_by")
    private String updatedBy;
}
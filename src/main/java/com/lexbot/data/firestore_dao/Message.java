package com.lexbot.data.firestore_dao;

import com.google.cloud.firestore.annotation.DocumentId;
import com.lexbot.ia.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    public static final String PATH = "messages";

    @DocumentId
    private String id;
    private String text;
    private Role role;
    private Date date;

}

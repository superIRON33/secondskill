package com.zbw.secondskill.model.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPasswordDo {
    private Integer id;
    private String encrptPassword;
    private Integer userId;
    public UserPasswordDo(String encrptPassword, Integer userId) {
        this.encrptPassword = encrptPassword;
        this.userId = userId;
    }


}
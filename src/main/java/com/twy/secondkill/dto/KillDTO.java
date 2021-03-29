package com.twy.secondkill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author gongpeng
 * @date 2021/3/29 21:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KillDTO implements Serializable {

    @NonNull
    private Integer killid;
    @NonNull
    private Integer userid;

}

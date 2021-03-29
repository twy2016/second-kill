package com.twy.secondkill.controller;


import com.twy.secondkill.dto.KillDTO;
import com.twy.secondkill.entity.BaseResponse;
import com.twy.secondkill.entity.StatusCode;
import com.twy.secondkill.service.ItemKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 待秒杀商品表 前端控制器
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Controller
@RequestMapping("/kill")
public class ItemKillController {

    @Autowired
    private ItemKillService itemKillService;

    @PostMapping("/execute")
    @ResponseBody
    public BaseResponse execute(@RequestBody @Validated KillDTO killDTO) {
        try {
            Boolean res = itemKillService.KillItem(killDTO.getKillid(), killDTO.getUserid());
            if (!res) {
                return new BaseResponse(StatusCode.Fail.getCode(), "商品已经抢购完或您已抢购过该商品");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        return baseResponse;
    }

    @GetMapping(value = "/execute/success")
    public String killsuccess() {
        return "killsuccess";
    }

    @GetMapping(value = "/execute/fail")
    public String killfail() {
        return "killfail";
    }
}


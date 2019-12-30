package com.zuojie.coupon.advice;

import com.zuojie.coupon.exception.CouponException;
import com.zuojie.coupon.vo.CommonReponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>全局异常处理</h1>
 * author:zuojie
 */
@RestControllerAdvice
public class GlobalExceptionAdvice  {
    /**
     * <h2>对 couponException 进行统一的异常处理</h2>
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CouponException.class)
    public CommonReponse<String> handlerCouponException(
            HttpServletRequest req, CouponException ex
    ){
        CommonReponse<String>reponse=new CommonReponse<>(-1,"business error");
        reponse.setData(ex.getMessage());
        return reponse;


    }
}

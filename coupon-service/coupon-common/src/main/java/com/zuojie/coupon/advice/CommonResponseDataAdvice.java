package com.zuojie.coupon.advice;

import com.zuojie.coupon.annotation.IgoreResponseAdvice;
import com.zuojie.coupon.vo.CommonReponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    /**
     * <h2>判断是否需要对响应进行处理</h2>
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果当前方法所在类标志了@IgnoreResponseAdvice注解，不需要处理
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgoreResponseAdvice.class)){
            return false;
        }
        //如果当前方法标志了@IgnoreResponseAdvice注解，不需要处理
        if(methodParameter.getMethod().isAnnotationPresent(IgoreResponseAdvice.class)){
            return false;
        }
        //对响应进行处理执行beforeBodyWriter方法
        return true;
    }

    /**
     * <h1>响应返回之前的处理</h1>
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter
            , MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass
            , ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //定义最终的返回对象
        CommonReponse<Object> reponse=new CommonReponse<>(0,"");
        //如果0是null response不需要设置data
        if(null==o){
            return reponse;
            //如果o已经是CommonResponse 不需要再次处理
        }else if(o instanceof CommonReponse){
            reponse=(CommonReponse<Object>)o;
        }//否则把响应对象CommonResponse的data部分
        else {
            reponse.setData(o);
        }
        return reponse;
    }
}

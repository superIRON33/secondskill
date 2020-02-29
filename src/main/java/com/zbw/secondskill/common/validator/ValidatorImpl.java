package com.zbw.secondskill.common.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

/**
 * @ClassName ValidatorImpl.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月29日 16:18
 **/
//将该类指定为一个Spring的bean
@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    /**
     * @Param [Object bean]
     * @Return com.zbw.secondskill.common.validator.ValidationResult
     * @Description 实现校验方法并返回校验结果
     * @Author zbw
     * @Time 2020/2/29 16:27
     */
    public ValidationResult validate(Object bean) {
        final ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0) {
            //有错误的情况
            result.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation->{
                String errMsg = constraintViolation.getMessage();
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName,errMsg);
            });
        }
        return  result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //将hibernate validator通过工厂的初始化方式使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}

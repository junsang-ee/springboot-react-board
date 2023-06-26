package com.springboot.web.config.count;

import com.springboot.web.annotation.CountableApi;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class CountableApiInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        CountableApi annotation = method.getAnnotation(CountableApi.class);
        return invocation.proceed();
    }
}

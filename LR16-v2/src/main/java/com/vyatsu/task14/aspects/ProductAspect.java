package com.vyatsu.task14.aspects;

import com.vyatsu.task14.entities.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class ProductAspect {

//    @Pointcut("execution(* com.vyatsu.task14.services.impl.ProductServiceImpl.getById(..))")
//    private void showOneProduct(){
//    }
//
//    @Before("showOneProduct()")
//    public void logBefore(JoinPoint joinPoint){
//    }

    List<Integer> Id;
    HashMap<Long, Integer> IdAndNum = new HashMap<>();

    @Pointcut("execution(* com.vyatsu.task14.services.impl.ProductServiceImpl.getById(..)) && args(id,..))" )
    private void showOneProduct(Long id){
    }

    @Before("showOneProduct(id)")
    public void logBefore(Long id){
        System.out.println(id);
        add(id);
        firstThree();
    }

    private void add(Long id){
        if(!IdAndNum.containsKey(id)){
            IdAndNum.put(id, 1);
        }
        else{
            IdAndNum.put(id, IdAndNum.get(id) + 1);
        }
    }

    private void firstThree(){

        IdAndNum.entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(prod -> System.out.println(prod));

    }
}

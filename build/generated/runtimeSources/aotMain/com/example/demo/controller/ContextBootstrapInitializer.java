package com.example.demo.controller;

import com.example.demo.service.EstudianteService;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerEstudianteController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("estudianteController", EstudianteController.class)
        .instanceSupplier((instanceContext) -> {
          EstudianteController bean = new EstudianteController();
          instanceContext.field("estudianteService", EstudianteService.class)
              .invoke(beanFactory, (attributes) -> {
                Field estudianteServiceField = ReflectionUtils.findField(EstudianteController.class, "estudianteService", EstudianteService.class);
                ReflectionUtils.makeAccessible(estudianteServiceField);
                ReflectionUtils.setField(estudianteServiceField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }

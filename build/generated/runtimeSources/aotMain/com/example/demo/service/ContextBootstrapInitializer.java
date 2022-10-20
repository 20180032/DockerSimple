package com.example.demo.service;

import com.example.demo.repository.EstudianteRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerEstudianteService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("estudianteService", EstudianteService.class)
        .instanceSupplier((instanceContext) -> {
          EstudianteService bean = new EstudianteService();
          instanceContext.field("EstudianteRepository", EstudianteRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field EstudianteRepositoryField = ReflectionUtils.findField(EstudianteService.class, "EstudianteRepository", EstudianteRepository.class);
                ReflectionUtils.makeAccessible(EstudianteRepositoryField);
                ReflectionUtils.setField(EstudianteRepositoryField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }

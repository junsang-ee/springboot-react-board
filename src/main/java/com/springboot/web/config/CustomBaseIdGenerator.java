package com.springboot.web.config;

import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Properties;

@Getter
@MappedSuperclass
public abstract class CustomBaseIdGenerator extends UUIDGenerator {
    private String entityName;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        entityName = params.getProperty(ENTITY_NAME);
        super.configure(type, params, serviceRegistry);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Serializable id = session.getEntityPersister(entityName, object)
                .getIdentifier(object, session);
        if (id == null) {
            return super.generate(session, object);
        } else {
            return id;
        }
    }
}

package com.fpmislata.persistencia.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;


public class GenericIntegratorImpl implements Integrator {

    @Override
    public void integrate(Configuration c, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        final EventListenerRegistry eventListenerRegistry = sfsr.getService(EventListenerRegistry.class);

        prependListeners(eventListenerRegistry);

    }

    @Override
    public void integrate(MetadataImplementor mi, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        final EventListenerRegistry eventListenerRegistry = sfsr.getService(EventListenerRegistry.class);

        prependListeners(eventListenerRegistry);

    }

    @Override
    public void disintegrate(SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
    }

    private void prependListeners(EventListenerRegistry eventListenerRegistry) {
        eventListenerRegistry.prependListeners(EventType.PRE_INSERT, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.PRE_LOAD, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.PRE_UPDATE, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.PRE_DELETE, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.POST_INSERT, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.POST_LOAD, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.POST_UPDATE, new GenericEventListenerImpl());
        eventListenerRegistry.prependListeners(EventType.POST_DELETE, new GenericEventListenerImpl());
    }
}

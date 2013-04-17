package com.fpmislata.persistencia.hibernate.util;

import org.hibernate.event.spi.*;

public class GenericEventListenerImpl implements PreInsertEventListener,PreLoadEventListener,PreUpdateEventListener,PreDeleteEventListener,PostInsertEventListener,PostLoadEventListener,PostUpdateEventListener,PostDeleteEventListener {

    @Override
    public boolean onPreInsert(PreInsertEvent pie) {
        Object entity=pie.getEntity();
        if (entity instanceof PreInsertEventListener) {
            return ((PreInsertEventListener)entity).onPreInsert(pie);
        } else {
            return false;
        }
    }

    @Override
    public void onPreLoad(PreLoadEvent ple) {
        Object entity=ple.getEntity();
        if (entity instanceof PreLoadEventListener) {
            ((PreLoadEventListener)entity).onPreLoad(ple);
        }
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent pue) {
        Object entity=pue.getEntity();
        if (entity instanceof PreUpdateEventListener) {
            return ((PreUpdateEventListener)entity).onPreUpdate(pue);
        } else {
            return false;
        }
    }

    @Override
    public boolean onPreDelete(PreDeleteEvent pde) {
        Object entity=pde.getEntity();
        if (entity instanceof PreDeleteEventListener) {
            return ((PreDeleteEventListener)entity).onPreDelete(pde);
        } else {
            return false;
        }
    }

    @Override
    public void onPostInsert(PostInsertEvent pie) {
        Object entity=pie.getEntity();
        if (entity instanceof PostInsertEventListener) {
            ((PostInsertEventListener)entity).onPostInsert(pie);
        }
    }

    @Override
    public void onPostLoad(PostLoadEvent ple) {
        Object entity=ple.getEntity();
        if (entity instanceof PostLoadEventListener) {
            ((PostLoadEventListener)entity).onPostLoad(ple);
        }
    }

    @Override
    public void onPostUpdate(PostUpdateEvent pue) {
        Object entity=pue.getEntity();
        if (entity instanceof PostUpdateEventListener) {
            ((PostUpdateEventListener)entity).onPostUpdate(pue);
        }
    }

    @Override
    public void onPostDelete(PostDeleteEvent pde) {
        Object entity=pde.getEntity();
        if (entity instanceof PostDeleteEventListener) {
            ((PostDeleteEventListener)entity).onPostDelete(pde);
        } 
    }
    
}
